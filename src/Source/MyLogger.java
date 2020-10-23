package Source;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyLogger {
    private String className;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public MyLogger(String className){
        this.className = className;
    }

    public void info(String msg){
        LocalDateTime rightNow = LocalDateTime.now();
        String formatDateTime = rightNow.format(formatter);
        System.out.println(formatDateTime + " [INFO] : " + msg + " (" + this.className + ")");
    }
}
