package com.contactbook.controller;

import java.util.Scanner;

public class InputUtil {
    private Scanner input;
    private String InputString;

    public InputUtil() {
        input = new Scanner(System.in);
    }

    public String[] getNextCommand() {
        InputString = input.nextLine();
        return InputString.split(" ");
    }

    public String getInputString(){
        return InputString;
    }
}
