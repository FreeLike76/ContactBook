package com.contactbook.exceptions;

public class WrongCommandException extends Exception {
    private final String inputed;

    public WrongCommandException(String message, String inputed) {
        super(message);
        this.inputed = inputed;
    }

    public String getCustomDetails() {
        return "Inputed command: \"" + inputed + "\" is not recognized!";
    }
}
