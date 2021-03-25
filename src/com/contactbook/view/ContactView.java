package com.contactbook.view;

import com.contactbook.model.Contact;

public class ContactView {

    public void startHelp() {
        System.out.println("Type \"help\" for command list.");
    }

    public void help() {
        System.out.println("exit\t\t\t- exit program.");
        System.out.println("help\t\t\t- show all commands.");
        System.out.println("printall\t\t- show all contacts.");
        System.out.println("printbychar -a\t- show contacts, which name starts with -a.");
        System.out.println("printmobile\t\t- show contacts, who has mobile phone.");
    }

    public void contactTable(Contact[] contacts) {
        if (contacts.length == 0) {
            System.out.println("No contact match the search!");
        } else {
            String format = "| %-16s | %-16s | %-16s | %-32s | %-4s | %-16s | %-16s |%n";
            String splitter = "+------------------+" +
                    "------------------+" +
                    "------------------+" +
                    "----------------------------------+" +
                    "------+------------------+" +
                    "------------------+%n";
            System.out.format(splitter);
            System.out.format(format,
                    "Last Name",
                    "First Name",
                    "Patronymic",
                    "Address",
                    "№",
                    "PhoneNumber",
                    "Info");
            System.out.format(splitter);
            for (Contact con : contacts) {
                System.out.format(format,
                        con.getLastName(),
                        con.getFirstName(),
                        con.getPatronymic(),
                        con.getAddressName(),
                        con.getAddressNumber(),
                        con.getPhoneNumber(),
                        con.getInfo());
                System.out.format(splitter);
            }
        }
    }

    public void printMessages(String... messages) {
        for (String msg : messages) {
            System.out.println(msg);
        }
    }
}
