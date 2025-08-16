package org.example.commands;

import org.example.Logger;
import org.example.RunHelper;

public class HelpCommand implements Command{
    public static void execute(){
        String[] commandList = RunHelper.getCommandList();
        StringBuilder builder = new StringBuilder();
        builder.append("The list of available commands is: ");
        for (int i = 0; i < commandList.length; i++){
            if (i == commandList.length-1){ //Checks for the last element in the list to append without divider
                builder.append(commandList[i]);
            } else {
                builder.append(commandList[i]);
                builder.append(", ");
            }
        }
        System.out.println("[OK]:" + builder.toString());
        Logger.log("[OK]:" + builder.toString());

    }
}
