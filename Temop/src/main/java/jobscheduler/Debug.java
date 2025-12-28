package jobscheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Debug extends Logger {
    HashMap<String, List<String>> logs;

    public Debug(LogLevel level) {
        super(level);

        this.logs = new HashMap<>();
    }

    @Override
    public void log(LogLevel logLevel, String message, String command) {

            if(this.getLevel() != logLevel){
                next.log(logLevel, message, command);
                return;
            }
        System.out.println("this message is in debug " +message);
            logs.computeIfAbsent(command, k->(new ArrayList<>())).add(message);

    }
}
