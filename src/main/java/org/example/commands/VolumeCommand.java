package org.example.commands;

import org.example.Logger;

import java.io.IOException;

public class VolumeCommand implements Command{
    private static String[] args;
    public static void execute() {
        if (!(args.length > 2)){
            System.out.println("[INFO]:This commands needs at least 2 parameters\nUsage: volume <set> <value>");
            Logger.log("[INFO]:This commands needs at least 2 parameters\nUsage: volume <set> <value>");
            return;
        }
        switch (args[1]){
            case "set":
                try {
                    Runtime.getRuntime().exec("pactl set-sink-volume @DEFAULT_SINK@ " + args[2] + "%");
                    System.out.println("[OK]:Successfully set volume to " + args[2] + "%");
                    Logger.log("[OK]:Successfully set volume to " + args[2] + "%");
                } catch (IOException e){
                    try {
                        Runtime.getRuntime().exec("amixer sset Master " + args[2] + "%");
                        System.out.println("[OK]:Successfully set volume to " + args[2] + "%");
                        Logger.log("[OK]:Successfully set volume to " + args[2] + "%");
                    } catch (IOException ee) {
                        System.out.println("[ERROR]:Cannot set the volume");
                        Logger.log("[ERROR]:Cannot set the volume");
                    }
                }
        }
    }
    public static void setArgs(String[] passedArgs){
        args = passedArgs;
    }
}
