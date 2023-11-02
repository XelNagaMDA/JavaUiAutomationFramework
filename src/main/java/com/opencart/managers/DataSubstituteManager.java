package com.opencart.managers;

public class DataSubstituteManager {
    public static String substituteString(String value) {
        switch (value.toUpperCase()) {
            case "RANDOMFIRSTNAME":
                return RandomDataGeneratorManager.generateRandomFirstName();
            case "RANDOMEMAIL":
                return RandomDataGeneratorManager.generateRandomEmail();
            case "RANDOMLASTNAME":
                return RandomDataGeneratorManager.generateRandomLastName();
            case "RANDOMPASSWORD":
                return RandomDataGeneratorManager.generateRandomPassword();
        }
        return value;
    }
}
