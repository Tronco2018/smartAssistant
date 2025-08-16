package org.example.commands;

import org.example.RunHelper;
import org.example.Logger;

public class PoweroffCommand implements Command{
    public static void execute() {
        try {
            RunHelper.stop();
            System.out.println("[OK]:Shut down system");
            Logger.log("[OK]:Shut down system");

        } catch (Exception e){
            System.out.println("[FAILED]:Failed to shut down the system");
            Logger.log("[FAILED]:Failed to shut down the system");
        }
    }
}
