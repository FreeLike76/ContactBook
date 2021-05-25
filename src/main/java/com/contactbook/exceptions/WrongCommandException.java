package com.contactbook.exceptions;

public class WrongCommandException extends Exception {
    private final String customDetails;

    public WrongCommandException(String message, String inputed) {
        super(message);
        this.customDetails = "Inputed command: \"" + inputed + "\" is not recognized!";
    }

    public String getCustomDetails() {
        return this.customDetails;
    }
}
