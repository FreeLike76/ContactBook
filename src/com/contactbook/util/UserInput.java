package com.contactbook.util;

import java.util.Scanner;

public class UserInput {
    private Scanner input;
    private String[] lastCommand;

    public UserInput() {
        input = new Scanner(System.in);
    }

    public void getNextCommand() {
        lastCommand = input.nextLine().split(" ");
    }

    public String paramAt(int index) {
        return lastCommand[index];
    }

    public boolean paramIsCharAt(int index) {
        return lastCommand[index].length() == 1;
    }

    public int paramCount() {
        return lastCommand.length;
    }
}
