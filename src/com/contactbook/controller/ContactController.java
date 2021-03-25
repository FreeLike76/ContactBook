package com.contactbook.controller;


import com.contactbook.exceptions.ParamCountException;
import com.contactbook.exceptions.ParamTypeException;
import com.contactbook.exceptions.WrongCommandException;
import com.contactbook.util.UserInput;
import com.contactbook.validators.ParamValidator;
import com.contactbook.view.ContactView;
import com.contactbook.model.ContactModel;

public class ContactController {
    private ContactModel model;
    private ContactView view;
    private UserInput input;

    public void exec() {
        view = new ContactView();
        model = new ContactModel();
        input = new UserInput();
        String[] command;

        while (true) {
            view.startHelp();
            command = input.getNextCommand();
            try {
                switch (command[0]) {
                    case "exit":
                        System.exit(0);
                    case "help":
                        view.help();
                        break;
                    case "printall":
                        view.contactTable(model.getContacts());
                        break;
                    case "printmobile":
                        view.contactTable(model.getContactsWithMobPhone());
                        break;
                    case "printbychar":
                        ParamValidator.validatePrintByChar(command);
                        view.contactTable(model.getContactByChar(command[1].toUpperCase().charAt(0)));
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
}
