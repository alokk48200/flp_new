package jobscheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InfoLog extends Logger{
    private HashMap<String, List<String>>logs;

    public InfoLog(LogLevel level) {
        super(level);
        this.logs = new HashMap<>();
    }



    @Override
    public void log(LogLevel logLevel, String message, String command) {
        if(this.getLevel() != logLevel){
            next.log(logLevel, message, command);
            return;
        }
        System.out.println("this message is in info");
        logs.computeIfAbsent(command, k->(new ArrayList<>())).add(message);
    }


}
