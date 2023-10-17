package com.opencart.managers;

import com.github.javafaker.Faker;

public class RandomDataGeneratorManager {

    private static Faker fakerObject = new Faker();

    public static String generateRandomFirstName() {
        return fakerObject.name().firstName();
    }

    public static String generateRandomLastName() {
        return fakerObject.name().lastName();
    }

    public static String generateRandomEmail() {
        return fakerObject.internet().emailAddress();
    }

    public static String generateRandomPassword() {
        return fakerObject.internet().password();
    }
}
