package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static boolean filePresence;
    public static void log(String content){
        String filePath = "application.log";
        try{
            File file = new File(filePath);
            if (!file.exists()){
                setFilePresence(false);
                System.out.println("{Logger}[WARNING]:Log file not found, creating...");
                boolean created = file.createNewFile();
                if (created){
                    System.out.println("{Logger}[OK]:Log file crated successfully");
                    setFilePresence(true);
                } else {
                    System.out.println("{Logger}[FAILED]:Failed to create log file");
                    setFilePresence(false);
                }
            } else {
                setFilePresence(true);
            }
            if (!isLogFilePresent()){
                return;
            }
            FileWriter fw = new FileWriter(file, true);
            fw.write(content + System.lineSeparator()); //Appending to log the message
            fw.close();
        } catch (IOException e){
            System.out.println("{Logger}[FAILED]:Failed to access log file");
        }
    }
    private static void setFilePresence(boolean status){
        filePresence = status;
    }
    public static boolean isLogFilePresent(){
        return filePresence;
    }
}
