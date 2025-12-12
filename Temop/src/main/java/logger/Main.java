package logger;

import splitwise.User;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Logger logger = new DebugLogger(new ArrayList<>());
        logger.setNext(new InfoLogger(new ArrayList<>())).setNext(new ErrorLogger(new ArrayList<>()));
        logger.addUser(new ConsoleObserver());
        logger.canHandle(LogLevel.ERROR, " Alok yadav error");
        logger.canHandle(LogLevel.INFO, " Rahul yadav info ");
        logger.canHandle(LogLevel.DEBUG, " Rohit yadav debug");
        logger.canHandle(LogLevel.ERROR, " RAmesh yadav error ");

    }
}
