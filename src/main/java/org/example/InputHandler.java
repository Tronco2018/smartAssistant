package org.example;

import java.util.Scanner;

public class InputHandler {

    public String[] handle(){
        Scanner scanner = new Scanner(System.in);
        System.out.print(">");
        return scanner.nextLine().split(" ");
    }
}

