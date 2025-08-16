package org.example.commands;

import org.example.RunHelper;
import org.example.Logger;

public class PoweroffCommand implements Command{
    public static void execute() {
        RunHelper.stop();
        System.out.println("[OK]:Shut down system");
        Logger.log("[OK]:Shut down system");
    }
}
