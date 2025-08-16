package org.example;

public class RunHelper {
    private static boolean isRunning = false;
    private static final String[] command = {"start", "stop", "reboot", "execute", "datetime", "volume", "help"};
    public static void init(){
        InputHandler handler = new InputHandler();
         //Valid commands list
        int maxDistance = 2; //Levenshtein distance for string matching
        Logger.log("------------Start of log------------");
        Logger.log("[INFO]: Current date " + DateProvider.getCurrentFormattedDate());
        System.out.println("Enter a command");


        while (isRunning) { //Main loop
            String[] input = handler.handle();
            String recognized = CommandIdentifier.recognizeCommand(input[0], command, maxDistance); //String fuzzy matching for commands
            Logger.log("{RunHelper}: User issued command '" + input[0] + "'");
            if (recognized != null) {
                Invoker.handle(recognized, input);
            } else {
                System.out.println("Unrecognized command");
            }
        }
    }
    public static void start(){
        isRunning = true;
    }
    public static void stop(){
        isRunning = false;
    }
    public static String[] getCommandList(){
        return command;
    }
}
