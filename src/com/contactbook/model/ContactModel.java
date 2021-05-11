package com.contactbook.model;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ContactModel {
    private Contact[] contacts;
    private FileUtil Files;

    public ContactModel() throws FileNotFoundException, IOException {
        Files = new FileUtil();
        this.contacts = Files.readContacts(Files.DATA_PATH);
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

    public String loadContacts(String path) {
        try {
            this.contacts = Files.readContacts(path);
        } catch (FileNotFoundException e) {
            return "Loading failed! File \"" + path + "\" not found!";
        } catch (IOException e) {
            return "Loading failed! Input error!";
        }
        return "Loading successful! Loaded " + this.contacts.length + " from \"" + path + "\".";
    }

    public String saveContacts() {
        try {
            Files.writeContactsTo(this.getContacts(), Files.DATA_PATH);
        } catch (IOException e) {
            return "Saving failed! Output exception.";
        }
        return "Saved " + this.contacts.length + " to \"" + Files.DATA_PATH + "\".";
    }

    public String saveContactsTemp(Contact[] contacts) {
        String filename = "saved/"
                + DateTimeFormatter.ofPattern("yyyy.MM.dd_HH.mm.ss").format(LocalDateTime.now())
                + ".json";
        try {
            Files.writeContactsTo(contacts, filename);
        } catch (IOException e) {
            return "Saving failed!";
        }
        return "Saved " + contacts.length + " to \"" + filename + "\".";
    }
}