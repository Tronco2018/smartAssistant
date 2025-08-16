package org.example.commands;

import org.example.RunHelper;
import org.example.Logger;


public class RebootCommand implements Command{
    public static void execute(){
        try {
            RunHelper.stop();
            System.out.println("[OK]:Shut down system");
            Logger.log("[OK]:Shut down system");
            RunHelper.start();
            System.out.println("[OK]:Reloaded system");
            Logger.log("[OK]:Reloaded system");
        } catch (Exception e){
            System.out.println("[FAILED]:System reload failed");
            Logger.log("[FAILED]:System reload failed");
        }

    }
}
