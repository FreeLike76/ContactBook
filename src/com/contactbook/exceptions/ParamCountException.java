package com.contactbook.exceptions;

public class ParamCountException extends Exception {
    private final int required;
    private final int inputed;

    public ParamCountException(String message, int required, int inputed) {
        super(message);
        this.required = required;
        this.inputed = inputed;
    }

    public String getCustomDetails() {
        return "Command requires " + required + " parameters, found: " + inputed;
    }
}
