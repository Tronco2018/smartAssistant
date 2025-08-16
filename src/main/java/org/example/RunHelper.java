package org.example;

public class RunHelper {
    private static boolean isRunning = false;
    public static void init(){
        InputHandler handler = new InputHandler();
        String[] command = {"start", "stop", "reboot", "execute", "datetime","volume"};
        int maxDistance = 2;
        Logger.log("------------Start of log------------");
        Logger.log("[INFO]: Current date " + DateProvider.getCurrentFormattedDate());
        System.out.println("Enter a command");


        while (isRunning) {
            String[] input = handler.handle();
            String recognized = CommandIdentifier.recognizeCommand(input[0], command, maxDistance);
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
}
