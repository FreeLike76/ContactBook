package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ArrayList<Contact> ContactBook = new ArrayList<>(Arrays.asList(
                new Contact("", "Dmytro", "",
                        "Kiev, Vyborzka", 3, "+380612357608", "Author"),
                new Contact("", "Vadym", "",
                        "Rivne, Lypneva", 12, "+380671712309", "Student"),
                new Contact("", "Vasyl", "",
                        "Rivne, Naberegna", 2, "", "Friend"),
                new Contact("", "Ivan", "",
                        "Lviv, Pivnichna", 8, "+380681757608", "Friend"),
                new Contact("", "Michael", "Romanovych",
                        "Rivne, Central", 41, "+380671757606", "Teacher"),
                new Contact("Melnyk", "Stepan", "",
                        "Kiev, Orlova", 2, "+380444457605", "Student"),
                new Contact("", "Maxim", "",
                        "Odesa, Zahidna", 5, "+380612227603", "Student"),
                new Contact("Kaida", "Ann", "",
                        "Kiev, Vyborzka", 3, "", "Doctor"),
                new Contact("", "Sophia", "",
                        "Rivne, Central", 8, "+380671733308", "Student"),
                new Contact("", "Roman", "",
                        "Kiev, Malunova", 44, "+380688997609", "Doctor")));

        System.out.println("Contacts by char:");
        System.out.println(getContactByChar(ContactBook, 'D'));
        System.out.println(getContactByChar(ContactBook, 'R'));
        System.out.println("Contacts with phones:");
        System.out.println(getContactsWithPhones(ContactBook));
    }

    static ArrayList<Contact> getContactByChar(ArrayList<Contact> ContactBook, char ch) {
        ArrayList<Contact> result = new ArrayList<>();
        for (Contact con : ContactBook) {
            if(con.getFirstName().charAt(0)==ch) {
                result.add(con);
            }
        }
        return result;
    }
    static ArrayList<Contact> getContactsWithPhones(ArrayList<Contact> ContactBook) {
        ArrayList<Contact> result = new ArrayList<>();
        for (Contact con : ContactBook) {
            if(!(con.getPhoneNumber().isEmpty() || con.getPhoneNumber().isBlank())) {
                result.add(con);
            }
        }
        return result;
    }
}
