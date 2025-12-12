package logger;

import splitwise.User;

import java.util.ArrayList;

public class DebugLogger extends Logger{

    public DebugLogger(ArrayList<LogObserver> users) {
        super(users);
    }

    @Override
    public void canHandle(LogLevel level, String message) {

        if(level.equals(LogLevel.DEBUG)){
            for(LogObserver user : users){
                user.notify(message);
            }
            System.out.println("this meaagege is handle by debugger " + message);
        }
        if(next != null){
            next.canHandle(level, message);
        }
    }
}
