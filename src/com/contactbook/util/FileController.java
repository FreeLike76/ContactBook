package com.contactbook.util;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import com.contactbook.model.Contact;
import com.google.gson.*;

public class FileController {
    public static Contact[] readContacts(String path) throws IOException {
        Gson gson = new Gson();
        try (final FileReader fileReader = new FileReader(path)) {
            return gson.fromJson(fileReader, Contact[].class);
        }
    }

    public static String writeContacts(Contact[] contacts) throws IOException {
        Gson gson = new Gson();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd HH.mm");
        String filename = "saved/" + dtf.format(LocalDateTime.now()) + ".json";
        File file = new File(filename);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        try (FileWriter fileWriter = new FileWriter(file)) {
            gson.toJson(contacts, fileWriter);
        }
        return "Saved successfully to \"" + filename + "\"";
    }
}
