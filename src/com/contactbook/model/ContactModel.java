package com.contactbook.model;


import com.contactbook.util.FileController;
import com.contactbook.util.Generator;

import java.io.IOException;
import java.util.Arrays;


public class ContactModel {
    private Contact[] contacts;

    public ContactModel() {
        this.contacts = new Contact[0];
    }

    public ContactModel(int size) {
        this.contacts = Generator.generateBookOf(size);
    }

    public ContactModel(String path) throws IOException {
        this.contacts = FileController.readContacts(path);
    }

    public Contact[] getContacts() {
        return this.contacts.clone();
    }

    public void setContacts(Contact[] contacts) {
        this.contacts = contacts;
    }

    public Contact[] getContactByChar(char ch) {
        int returnCounter = 0;
        Contact[] result;
        for (Contact con : this.contacts) {
            if (con.getFirstName().charAt(0) == ch) {
                ++returnCounter;
            }
        }
        if (returnCounter != 0) {
            result = new Contact[returnCounter];
            returnCounter = 0;

            for (Contact con : this.contacts) {
                if (con.getFirstName().charAt(0) == ch) {
                    result[returnCounter++] = con;
                }
            }
        } else {
            result = new Contact[0];
        }
        return result;
    }

    public Contact[] getContactsWithMobPhone() {
        int returnCounter = 0;
        Contact[] result;

        for (Contact con : this.contacts) {
            if (con.isMobilePhone()) {
                ++returnCounter;
            }
        }
        if (returnCounter != 0) {
            result = new Contact[returnCounter];
            returnCounter = 0;

            for (Contact con : this.contacts) {
                if (con.isMobilePhone()) {
                    result[returnCounter++] = con;
                }
            }
        } else {
            result = new Contact[0];
        }
        return result;
    }
}
