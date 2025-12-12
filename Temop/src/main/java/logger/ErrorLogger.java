package logger;

import splitwise.User;

import java.util.ArrayList;

public class ErrorLogger extends Logger{
    public ErrorLogger(ArrayList<LogObserver> users) {
        super(users);
    }

    @Override
    public void canHandle(LogLevel level, String message) {

        if(level.equals(LogLevel.ERROR)){
            for(LogObserver user : users){
                user.notify(message);
            }
            System.out.println("handled by error logger" + message);
        }
        if(next != null){
            next.canHandle(level, message);
        }
    }
}
