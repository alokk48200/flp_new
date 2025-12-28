package jobscheduler;

public abstract class Logger {
    protected Logger next;
    private LogLevel level;

    public Logger(LogLevel level) {
        this.level = level;
    }

    public abstract void log(LogLevel logLevel, String message, String command);
    public  Logger setNext(Logger logger){
        this.next = logger;
        return this;
    }

    public LogLevel getLevel() {
        return level;
    }
}
