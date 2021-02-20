package com.company;


import java.util.Random;

public class ContactGenerator {
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
            "Dad", "Doctor", "Сolleague", ""};

    public static String generateFirstName() {
        return firstName[new Random().nextInt(firstName.length)];
    }

    public static String generatePatronymic() {
        return patronymic[new Random().nextInt(patronymic.length)];
    }

    public static String generateAddressName() {
        return city[new Random().nextInt(city.length)] +", "+ street[new Random().nextInt(street.length)];
    }

    public static int generateAddressNumber() {
        return new Random().nextInt(100);
    }

    public static String generatePhoneNumber() {
        StringBuilder number = new StringBuilder(13);
        number.append("+380");

        Random r = new Random();

        for (int i = 0; i < 9; i++) {
            number.append(r.nextInt(10));
        }
        return number.toString();
    }

    public static String generateInfo() {
        return info[(int) (Math.random() * info.length)];
    }
}
