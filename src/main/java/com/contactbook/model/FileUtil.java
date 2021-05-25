package com.contactbook.model;

import java.io.*;

import com.google.gson.*;

class FileUtil {
    private final Gson gson;
    public static final String DATA_PATH = "saved/data.json";

    FileUtil() {
        gson = new Gson();
    }

    public Contact[] readContacts(String path) throws FileNotFoundException, IOException {
        try (final FileReader fileReader = new FileReader(path)) {
            return gson.fromJson(fileReader, Contact[].class);
        }
    }

    public void writeContactsTo(Contact[] contacts, String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        try (FileWriter fileWriter = new FileWriter(file)) {
            gson.toJson(contacts, fileWriter);
        }
    }
}
