package com.contactbook.model;

import java.io.*;
import com.google.gson.*;

class FileUtil {
    public final String DATA_PATH = "saved/data.json";

    public Contact[] readContacts(String path) throws FileNotFoundException, IOException {
        Gson gson = new Gson();

        try (final FileReader fileReader = new FileReader(path)) {
            return gson.fromJson(fileReader, Contact[].class);
        }
    }

    public String writeContactsTo(Contact[] contacts, String path) throws IOException {
        Gson gson = new Gson();
        File file = new File(path);

        if (!file.exists()) {
            file.createNewFile();
        }

        try (FileWriter fileWriter = new FileWriter(file)) {
            gson.toJson(contacts, fileWriter);
        }
        return path;
    }
}
