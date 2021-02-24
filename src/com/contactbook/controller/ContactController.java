package com.contactbook.controller;

import com.contactbook.util.Generator;
import com.contactbook.view.ContactView;
import com.contactbook.model.ContactModel;

import java.awt.*;
import java.util.Scanner;

public class ContactController {
    private ContactModel model;
    private ContactView view;

    public void exec() {
        view = new ContactView();
        model = new ContactModel(Generator.generateBookOf(20));

        String[] command;

        view.START();
        while (true) {
            command = view.NEXT_COMMAND();

            switch (command[0]) {
                case "exit":
                    System.exit(0);
                    break;
                case "help":
                    view.HELP();
                    break;
                case "printall":
                    view.CONTACT_TABLE(model.getContacts());
                    break;
                case "printbychar":
                    if (command.length > 1 && command[1].length() == 1) {
                        view.CONTACT_TABLE(model.getContactByChar(command[1].toUpperCase().charAt(0)));
                    } else {
                        view.COMMAND_ERROR();
                    }
                    break;
                case "printmobile":
                    view.CONTACT_TABLE(model.getContactsWithMobPhone());
                    break;
                default:
                    view.COMMAND_ERROR();
                    break;
            }
        }
    }
}
