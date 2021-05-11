package com.contactbook.controller;

import java.util.Scanner;

public class InputUtil {
    private Scanner input;

    public InputUtil() {
        input = new Scanner(System.in);
    }

    public String[] getNextCommand() {
        return input.nextLine().split(" ");
    }
}
