package org.example.commands;

import java.io.IOException;
import org.example.Logger;

public class ExecuteCommand implements Command{
    private static String[] args;
    public static void execute(){
        if (!(args.length >= 1)){
            System.out.println("[ERROR]:You're missing an argument!\nUsage: execute <program>");
            Logger.log("[ERROR]:You're missing an argument!\nUsage: execute <program>");
        }
        try {
            //TODO: Use process builder instead
            Runtime.getRuntime().exec(args[1]); //Running binary
            System.out.println("[OK]:Program '" + args[1] +"' started");
            Logger.log("[OK]:Program '" + args[1] +"' started");
        } catch (IOException e){
            System.out.println("[FAILED]:Failed to start program " + args[1]);
            Logger.log("[FAILED]:Failed to start program " + args[1]);
        }
    }
    public static void setArgs(String[] passedArgs){
        args = passedArgs;
    }
}
