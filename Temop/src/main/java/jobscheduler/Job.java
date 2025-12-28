package jobscheduler;



public class Job implements Comparable<Job> , Runnable {
    private String command;
    private Long epochs;
    private JobStatus jobStatus;
    private  JobPriority jobPriority;


    public Job(String command, Long epochs, JobPriority jobPriority) {
        this.command = command;
        this.epochs = epochs;
        this.jobStatus = JobStatus.WAIT;
        this.jobPriority = jobPriority;
    }

    public JobPriority getJobPriority() {
        return jobPriority;
    }

    public void setJobPriority(JobPriority jobPriority) {
        this.jobPriority = jobPriority;
    }

    public JobStatus getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(JobStatus jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Long getEpochs() {
        return epochs;
    }

    public void setEpochs(Long epochs) {
        this.epochs = epochs;
    }


    @Override
    public int compareTo(Job o) {
        return Long.compare((this.epochs), o.getEpochs());
    }

    @Override
    public void run() {
        jobStatus = JobStatus.PROCESSING;
        System.out.println("Executing job " + command);

        try {
            Thread.sleep(1000); // simulate execution
            jobStatus = JobStatus.COMPLETED;
            System.out.println("this job is completed " + command);
        } catch (InterruptedException e) {
            jobStatus = JobStatus.BLOCKED;
            Thread.currentThread().interrupt();
        }
    }
    static class Builder{
        private String command;
        private Long epochs;
        private JobStatus jobStatus;

        public Builder setCommand(String command){
            this.command = command;
            return this;
        }

        public Builder setEpochs(Long epochs){
            this.epochs = epochs;
            return this;
        }

        public Builder setStatus(JobStatus status){
            this.jobStatus = status;
            return this;
        }

        public Job build(){

            Job job = new Job(this.command, this.epochs, JobPriority.LOW);
            job.setJobStatus(this.jobStatus);
            return job;

        }

    }
}
