package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateProvider {
    public static String getCurrentFormattedDate(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return now.format(formatter);
    }
}
