package com.contactbook.controller;


import com.contactbook.exceptions.ParamCountException;
import com.contactbook.exceptions.ParamTypeException;
import com.contactbook.exceptions.WrongCommandException;
import com.contactbook.util.UserInput;
import com.contactbook.validators.ParamValidator;
import com.contactbook.view.ContactView;
import com.contactbook.model.ContactModel;
import com.contactbook.model.Contact;

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
                    case "print":
                        view.contactTable(listContacts(command));
                        break;
                    case "save":
                        //savefile
                        break;
                    case "namesavefile":
                        //set savefile name
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
    private Contact[] listContacts(String[] command) throws ParamCountException, ParamTypeException{
        ParamValidator.validateFilter(command);
        switch(command[1]){
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
