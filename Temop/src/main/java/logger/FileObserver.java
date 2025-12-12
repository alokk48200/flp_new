package logger;

public class FileObserver implements LogObserver{
    @Override
    public void notify(String message) {
        System.out.println("this message is found in file observer");
    }
}
