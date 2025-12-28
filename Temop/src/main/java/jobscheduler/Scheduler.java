package jobscheduler;

public interface Scheduler {
    void schedule();
    void addJob(Job job);
}
