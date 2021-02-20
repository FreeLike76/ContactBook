package com.contactbook.model;

import com.contactbook.util.Generator;

import java.util.ArrayList;

public class ContactModel {
    private Contact[] contacts;

    public ContactModel() {
        // Empty constructor
    }

    public ContactModel(int size) {
        contacts = new Contact[size];
        for (int i = 0; i < contacts.length; i++) {
            contacts[i] = new Contact(
                    Generator.generateLastName(),
                    Generator.generateFirstName(),
                    Generator.generatePatronymic(),
                    Generator.generateAddressName(),
                    Generator.generateAddressNumber(),
                    Generator.generatePhoneNumber(),
                    Generator.generateInfo());
        }

    }

    public Contact[] getContacts()
    {
        return this.contacts;
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
            if(con.isMobilePhone()) {
                ++returnCounter;
            }
        }
        if (returnCounter != 0) {
            result = new Contact[returnCounter];
            returnCounter = 0;

            for (Contact con : this.contacts) {
                if(con.isMobilePhone()) {
                    result[returnCounter++] = con;
                }
            }
        } else {
            result = new Contact[0];
        }
        return result;
    }
}
