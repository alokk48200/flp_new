package logger;

import splitwise.User;

import java.util.ArrayList;

public abstract class Logger {
    protected  Logger next = null;
    protected final ArrayList<LogObserver>users;


    public void addUser(LogObserver user){
        users.add(user);
    }
    public ArrayList<LogObserver> getUsers() {
        return users;
    }

    public Logger(ArrayList<LogObserver> users) {
        this.users = users;
        next = null;
    }

    public Logger setNext(Logger logger){
        next = logger;
        return next;
    }
    public abstract void canHandle(LogLevel level, String message);
}
