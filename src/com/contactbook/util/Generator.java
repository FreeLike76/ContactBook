package com.contactbook.util;

import com.contactbook.model.Contact;

import java.util.Random;

public class Generator {
    private static final Random seed = new Random();

    private static final String[] lastName = {
            "Geleshko", "Orlovsky", "Melnyk",
            "Migirov", "Samoliuk", "Zlaman",
            "Gulchak", "Mamontov", "Bulba",
            "Koval", "Forsen", "Miroshny"};
    private static final String[] firstName = {
            "Dmytro", "Roman", "Maks",
            "Vlad", "Vadym", "Julia",
            "Igor", "Volodumur", "Anna",
            "Sebastian", "Victor", "Anastasia"};
    private static final String[] patronymic = {
            "Romanovych", "Sergiyovych", "Stepanovych",
            "Dmytrovych", "Vadymovych", "Ivanovych",
            "Anatoliovych", "Zaharovych", "Vadymovych",
            "Igorovych", "Maksymovych", "Abramovych"};
    private static final String[] city = {
            "Rivne", "Kyiv", "Lviv",
            "Odesa", "Harkiv", "Dnipro"};
    private static final String[] street = {
            "Topoleva", "Zelena", "Centralna",
            "Pivnichna", "Makarova", "Orlova",
            "Sonyachna", "Politehnichna", "Vyborzka"};
    private static final String[] info = {
            "Teacher", "Friend", "Neighbour",
            "Brother", "Sister", "Mom",
            "Dad", "Doctor", "Colleague", ""};

    public static String generateLastName() {
        return lastName[seed.nextInt(lastName.length)];
    }

    public static String generateFirstName() {
        return firstName[seed.nextInt(firstName.length)];
    }

    public static String generatePatronymic() {
        return patronymic[seed.nextInt(patronymic.length)];
    }

    public static String generateAddressName() {
        return city[seed.nextInt(city.length)] + ", " + street[seed.nextInt(street.length)];
    }

    public static int generateAddressNumber() {
        return seed.nextInt(100);
    }

    public static String generatePhoneNumber() {
        StringBuilder number = new StringBuilder();

        if (seed.nextBoolean()) {
            number.append("+380");
            number.append(seed.nextInt(10));
        }

        for (int i = 0; i < 8; i++) {
            number.append(seed.nextInt(10));
        }
        return number.toString();
    }

    public static String generateInfo() {
        return info[new Random().nextInt(info.length)];
    }

    public static Contact[] generateBookOf(int size) {
        Contact[] contacts = new Contact[size];
        for (int i = 0; i < contacts.length; i++) {
            contacts[i] = new Contact(
                    generateLastName(),
                    generateFirstName(),
                    generatePatronymic(),
                    generateAddressName(),
                    generateAddressNumber(),
                    generatePhoneNumber(),
                    generateInfo());
        }
        return contacts;
    }
}
