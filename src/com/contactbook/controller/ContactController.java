package com.contactbook.controller;


import com.contactbook.exceptions.ParamCountException;
import com.contactbook.exceptions.WrongCommandException;
import com.contactbook.util.UserInput;
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

        while (true) {
            view.startHelp();
            input.getNextCommand();
            try {
                switch (input.paramAt(0)) {
                    case "exit":
                        if (input.paramCount() == 1) {
                            System.exit(0);
                        } else {
                            throw new ParamCountException("Error! Wrong command parameters", 0, input.paramCount() - 1);
                        }
                        break;
                    case "help":
                        if (input.paramCount() == 1) {
                            view.help();
                        } else {
                            throw new ParamCountException("Error! Wrong command parameters", 0, input.paramCount() - 1);
                        }
                        break;
                    case "printall":
                        if (input.paramCount() == 1) {
                            view.contactTable(model.getContacts());
                        } else {
                            throw new ParamCountException("Error! Wrong command parameters", 0, input.paramCount() - 1);
                        }
                        break;
                    case "printmobile":
                        if (input.paramCount() == 1) {
                            view.contactTable(model.getContactsWithMobPhone());
                        } else {
                            throw new ParamCountException("Error! Wrong command parameters", 0, input.paramCount() - 1);
                        }
                        break;
                    case "printbychar":
                        if (input.paramCount() == 2 && input.paramIsCharAt(1)) {
                            view.contactTable(model.getContactByChar(input.paramAt(1).toUpperCase().charAt(0)));
                        } else {
                            throw new ParamCountException("Error! Wrong command parameters", 1, input.paramCount() - 1);
                        }
                        break;
                    default:
                        throw new WrongCommandException("Error! Wrong command!", input.paramAt(0));
                }
            } catch (ParamCountException e) {
                view.printMessages(e.getMessage(), e.getCustomDetails());
            } catch (WrongCommandException e) {
                view.printMessages(e.getMessage(), e.getCustomDetails());
            }
        }
    }
}
