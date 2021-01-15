package Source;

import java.util.HashMap;
import java.util.Map;

public abstract class MyLoggerFactory {
    private static Map<String, MyLogger> loggers = new HashMap<>();
    private static MyLogger logger = new MyLogger(MyLoggerFactory.class.getName());


    public static MyLogger getLogger(String className){
        MyLogger res;
        if(loggers.containsKey(className)){
            res = loggers.get(className);
        } else {
            res = new MyLogger(className);
            loggers.put(className, res);
        }

        return res;
    }
}
