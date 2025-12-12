package logger;

import splitwise.User;

import java.util.ArrayList;

public class InfoLogger extends Logger{

    public InfoLogger(ArrayList<LogObserver> users) {
        super(users);
    }

    @Override
    public void canHandle(LogLevel level, String message) {

        if(level.equals(LogLevel.INFO)){
            for(LogObserver user : users){
                user.notify(message);
            }
            System.out.println(" this is handler for info level and the message " + message) ;
        }
        if(next != null){
            next.canHandle(level, message);
        }
    }
}
