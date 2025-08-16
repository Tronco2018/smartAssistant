package org.example.commands;

import org.example.DateProvider;
import org.example.Logger;

public class DateTimeCommand implements Command{
    public static void execute(){
        System.out.println(DateProvider.getCurrentFormattedDate());
        System.out.println("[OK]:Successfully retrieved date and time");
        Logger.log("[OK]:Successfully retrieved date and time");
    }
}
