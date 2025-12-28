package jobscheduler;

public class HybridSorting implements SortingStrategy{
    @Override
    public int compare(Job o1, Job o2) {
        if(o1.getJobPriority().getRank() != o2.getJobPriority().getRank()){
            return Integer.compare(o1.getJobPriority().getRank(), o2.getJobPriority().getRank());
        }
        return Long.compare(o1.getEpochs(), o2.getEpochs());
    }
}
