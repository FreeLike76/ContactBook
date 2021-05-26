package com.contactbook.model;


import com.contactbook.controller.ContactController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.io.FileNotFoundException;
import java.io.IOException;


public class ContactModel {
    private static final Logger logger = LogManager.getLogger(ContactModel.class.getName());
    private Contact[] contacts;
    private final FileUtil Files;

    public ContactModel() throws FileNotFoundException, IOException {
        logger.debug("creating FileUtil");
        Files = new FileUtil();
        logger.debug("reading data");
        this.contacts = Files.readContacts(Files.DATA_PATH);
    }

    public Contact[] getContacts() {
        return this.contacts.clone();
    }

    public void setContacts(Contact[] contacts) {
        this.contacts = contacts;
    }

    public Contact[] getContactByChar(char ch) {
        logger.info("searching contacts by:" + ch);
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
        logger.info("found: "+result.length);
        return result;
    }

    public Contact[] getContactsWithMobPhone() {
        logger.info("searching contacts with mobile phones");
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
        logger.info("found: "+result.length);
        return result;
    }

    public String loadContacts(String path) {
        logger.info("loading contacts from file");
        try {
            this.contacts = Files.readContacts(path);
        } catch (FileNotFoundException e) {
            logger.warn("cannot load from specified file, not found");
            return "Loading failed! File \"" + path + "\" not found!";
        } catch (IOException e) {
            logger.warn("cannot load from specified file");
            return "Loading failed! Input error!";
        }
        logger.info("loaded: "+this.contacts.length);
        return "Loading successful! Loaded " + this.contacts.length + " from \"" + path + "\".";
    }

    public String saveContacts() {
        logger.info("saving contacts");
        try {
            Files.writeContactsTo(this.getContacts(), Files.DATA_PATH);
        } catch (IOException e) {
            logger.warn("saving failed");
            return "Saving failed! Output exception.";
        }
        logger.info("saving successful");
        return "Saved " + this.contacts.length + " to \"" + Files.DATA_PATH + "\".";
    }

    public String saveContactsTemp(Contact[] contacts) {
        logger.info("temp saving contacts");
        String filename = "saved/"
                + DateTimeFormatter.ofPattern("yyyy.MM.dd_HH.mm.ss").format(LocalDateTime.now())
                + ".json";
        try {
            Files.writeContactsTo(contacts, filename);
        } catch (IOException e) {
            logger.warn("saving failed");
            return "Saving failed!";
        }
        logger.info("temp saving successful");
        return "Saved " + contacts.length + " to \"" + filename + "\".";
    }
}