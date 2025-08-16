package org.example;

import org.example.commands.*;

public class Invoker {
    public static void handle(String command, String[] args){
        switch (command){
            case "stop":
                PoweroffCommand.execute();
                break;
            case "reboot":
                RebootCommand.execute();
                break;
            case "execute":
                ExecuteCommand.setArgs(args);
                ExecuteCommand.execute();
                break;
            case "datetime":
                DateTimeCommand.execute();
                break;
            case "volume":
                /*VolumeCommand.setArgs(args);
                VolumeCommand.execute();*/
                System.out.println("[INFO]:WIP command");
                Logger.log("[INFO]:WIP command");
                break;
            case "help":
                HelpCommand.execute();
                break;
        }
    }
}
