package jobscheduler;

public class Demo {
    public static void main(String[] args) {
        long now = System.currentTimeMillis()/1000;

        Job job1 = new Job("run1", (long)1000, JobPriority.LOW);
        Job job2 = new Job("run2", (long)6000, JobPriority.LOW);
        Job job3 = new Job("run3", (long)30990, JobPriority.HIGH);
        Job job4 = new Job("run4", (long)500, JobPriority.MEDIUM);
        Job job5 = new Job("run5", (long)5000, JobPriority.MEDIUM);
        Scheduler scheduler = new CronJobScheduler(new HybridSorting());
        scheduler.addJob(job1);
        scheduler.addJob(job2);
        scheduler.addJob(job3);
        scheduler.addJob(job4);
        scheduler.addJob(job5);
        scheduler.schedule();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Job job6 = new Job("run6", (long)50000, JobPriority.LOW);
        Job job7 = new Job("run7", (long)5000, JobPriority.HIGH);
        scheduler.addJob(job6);
        scheduler.addJob(job7);
        Logger logger = new InfoLog(LogLevel.INFO);
        logger.setNext(new Debug(LogLevel.DEBUG));

        logger.log(LogLevel.INFO, "run1", "this job is in process state");
        logger.log(LogLevel.DEBUG, "run1", "this job is in completed state");
    }
}
