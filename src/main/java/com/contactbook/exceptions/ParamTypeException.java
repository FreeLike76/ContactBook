package com.contactbook.exceptions;

public class ParamTypeException extends Exception {
    private final String customDetails;

    public ParamTypeException(String message, String required, String inputed) {
        super(message);
        this.customDetails = "Command requires " + required + ", found: \"" + inputed + "\"";
    }

    public String getCustomDetails() {
        return this.customDetails;
    }
}
