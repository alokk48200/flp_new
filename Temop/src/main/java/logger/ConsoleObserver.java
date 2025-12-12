package logger;

public class ConsoleObserver implements LogObserver{
    @Override
    public void notify(String message) {
        System.out.println("this messages i sread in console observer");
    }
}
