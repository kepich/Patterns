package Source;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyLogger {
    private String className;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private boolean isEnabled = true;

    public MyLogger(String className) {
        this.className = className;
    }

    public void info(String msg) {
        if(this.isEnabled){
            LocalDateTime rightNow = LocalDateTime.now();
            String formatDateTime = rightNow.format(formatter);
            System.out.println(formatDateTime + " [INFO] : " + msg + " (" + this.className + ")");
        }
    }

    public void disable(){
        this.info(className + " logger DISABLED");
        this.isEnabled = false;
    }

    public void enable(){
        this.isEnabled = true;
        this.info(className + " logger ENABLED");
    }
}
