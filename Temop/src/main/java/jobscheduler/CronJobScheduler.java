package jobscheduler;

import java.util.PriorityQueue;
import java.util.concurrent.*;

public class CronJobScheduler implements Scheduler{
    private SortingStrategy sortingStrategy;
    private static BlockingQueue<Job> priorityQueue = new PriorityBlockingQueue<>();
    private Object lock = new Object();
    private static ExecutorService executorService = Executors.newFixedThreadPool(1);

    public CronJobScheduler(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
        priorityQueue = new PriorityBlockingQueue<>(100, sortingStrategy);
    }

    @Override
    public void schedule() {
        Thread schedulerThread = new Thread(() -> {
            while (true) {
                try {
                    synchronized (lock) {
                        while (priorityQueue.size() == 0) {
                            lock.wait();
                        }
                        Job job = priorityQueue.poll();
                        executorService.submit(job);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        schedulerThread.start();
    }

    @Override
    public void addJob(Job job) {
        synchronized (lock){
            System.out.println("this job is being addded " +job.getCommand());
            priorityQueue.add(job);
            lock.notifyAll();
        }
    }
}
