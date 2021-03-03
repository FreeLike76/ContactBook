package com.contactbook.controller;


import com.contactbook.view.ContactView;
import com.contactbook.model.ContactModel;

public class ContactController {
    private ContactModel model;
    private ContactView view;

    public void exec() {
        view = new ContactView();
        model = new ContactModel(20);

        String[] command;

        view.start();
        while (true) {
            command = view.getNextCommand();

            switch (command[0]) {
                case "exit":
                    System.exit(0);
                case "help":
                    view.help();
                    break;
                case "printall":
                    view.contactTable(model.getContacts());
                    break;
                case "printbychar":
                    if (command.length > 1 && command[1].length() == 1) {
                        view.contactTable(model.getContactByChar(command[1].toUpperCase().charAt(0)));
                    } else {
                        view.commandError();
                    }
                    break;
                case "printmobile":
                    view.contactTable(model.getContactsWithMobPhone());
                    break;
                default:
                    view.commandError();
            }
        }
    }
}
