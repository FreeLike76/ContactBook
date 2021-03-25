package com.contactbook.util;

import java.util.Scanner;

public class UserInput {
    private Scanner input;

    public UserInput() {
        input = new Scanner(System.in);
    }

    public String[] getNextCommand() {
        return input.nextLine().split(" ");
    }
}
