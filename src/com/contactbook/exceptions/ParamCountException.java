package com.contactbook.exceptions;

public class ParamCountException extends Exception {
    private final String customDetails;

    public ParamCountException(String message, int required, int inputed) {
        super(message);
        this.customDetails ="Command requires " + required + " parameters, found: " + inputed;
    }

    public String getCustomDetails() {
        return this.customDetails;
    }
}
