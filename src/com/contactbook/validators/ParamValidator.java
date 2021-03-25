package com.contactbook.validators;

import com.contactbook.exceptions.ParamCountException;
import com.contactbook.exceptions.ParamTypeException;

public class ParamValidator {
    public static void validatePrintByChar(String[] command) throws ParamCountException, ParamTypeException{
        if (command.length != 2) {
            throw new ParamCountException("Error! Wrong command parameters!", 1, command.length - 1);
        }
        if(command[1].length() != 1 || !Character.isAlphabetic(command[1].charAt(0))){
            throw new ParamTypeException("Error! Wrong parameter type!", "alphabetic char", command[1]);
        }
    }
}
