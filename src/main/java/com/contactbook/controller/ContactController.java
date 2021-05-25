package com.contactbook.controller;


import com.contactbook.exceptions.ParamCountException;
import com.contactbook.exceptions.ParamTypeException;
import com.contactbook.exceptions.WrongCommandException;
import com.contactbook.validators.ParamValidator;
import com.contactbook.view.ContactView;
import com.contactbook.model.ContactModel;
import com.contactbook.model.Contact;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ContactController {
    private ContactModel model;
    private ContactView view;
    private InputUtil input;
    String[] command;

    public void exec() {
        view = new ContactView();
        input = new InputUtil();
        try {
            model = new ContactModel();
        } catch (FileNotFoundException e) {
            view.printMessages("Can't load \"data.json\"! File not found!", "Details: " + e.getMessage());
            System.exit(-1);
        } catch (IOException e) {
            view.printMessages("Can't load \"data.json\"! Input Error!", "Details: " + e.getMessage());
            System.exit(-1);
        }

        while (true) {
            view.startHelp();
            command = input.getNextCommand();
            try {
                switch (command[0]) {
                    case "exit":
                        if (command.length < 2 || !command[1].equalsIgnoreCase("nosave")) {
                            view.printMessages(model.saveContacts());
                        }
                        System.exit(0);
                    case "help":
                        view.help();
                        break;
                    case "print":
                        view.contactTable(requestContactsByFilter());
                        break;
                    case "save":
                        view.printMessages(model.saveContactsTemp(requestContactsByFilter()));
                        break;
                    case "load":
                        ParamValidator.validateLoad(command);
                        view.printMessages(model.loadContacts(command[1]));
                        break;
                    default:
                        throw new WrongCommandException("Error! Wrong command!", command[0]);
                }
            } catch (ParamTypeException e) {
                view.printMessages(e.getMessage(), e.getCustomDetails());
            } catch (ParamCountException e) {
                view.printMessages(e.getMessage(), e.getCustomDetails());
            } catch (WrongCommandException e) {
                view.printMessages(e.getMessage(), e.getCustomDetails());
            }
        }
    }

    private Contact[] requestContactsByFilter() throws ParamCountException, ParamTypeException {
        ParamValidator.validateFilter(command);
        switch (command[1]) {
            case "all":
                return model.getContacts();
            case "mobile":
                return model.getContactsWithMobPhone();
            case "bychar":
                return model.getContactByChar(command[2].toUpperCase().charAt(0));
            default:
                return new Contact[0];
        }
    }
}
