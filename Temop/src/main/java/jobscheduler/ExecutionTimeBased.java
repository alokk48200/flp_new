package jobscheduler;

public class ExecutionTimeBased implements SortingStrategy{

    @Override
    public int compare(Job job1, Job job2) {
        int compare = Long.compare(job1.getEpochs(), job2.getEpochs());
        return compare;
    }

}
