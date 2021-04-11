package com.contactbook.validators;

import com.contactbook.exceptions.ParamCountException;
import com.contactbook.exceptions.ParamTypeException;

public class ParamValidator {

    public static void validateFilter(String[] command) throws ParamCountException, ParamTypeException {
        if (command.length < 2) {
            throw new ParamCountException("Error! Wrong command parameters!", 1, 0);
        }
        if (!command[1].equals("all") && !command[1].equals("mobile") && !command[1].equals("bychar")) {
            throw new ParamTypeException("Error! Wrong command parameters!", "[all/mobile/bychar]", command[1]);
        }
        if (command[1].equals("bychar")) {
            if (command.length != 3) {
                throw new ParamCountException("Error! Wrong command parameters!", 2, command.length - 1);
            }
            if (command[2].length() != 1 || !Character.isAlphabetic(command[1].charAt(0))) {
                throw new ParamTypeException("Error! Wrong command parameters!", "alphabetic char", command[1]);
            }
        }
    }
}
