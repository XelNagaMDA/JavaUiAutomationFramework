package com.opencart.managers;

import com.opencart.context.CONTEXT;
import com.opencart.context.ScenarioContext;

public class DataSubstituteManager {
    public static String substituteString(String value) {
        switch (value.toUpperCase()) {
            case "RANDOMFIRSTNAME":
                return RandomDataGeneratorManager.generateRandomFirstName();
            case "RANDOMEMAIL":
                String email = RandomDataGeneratorManager.generateRandomEmail();
                ScenarioContext.getInstance().addToStorageContext(CONTEXT.EMAIL, email);
                return email;
            case "RANDOMLASTNAME":
                return RandomDataGeneratorManager.generateRandomLastName();
            case "RANDOMPASSWORD":
                String password = RandomDataGeneratorManager.generateRandomPassword();
                ScenarioContext.getInstance().addToStorageContext(CONTEXT.PASSWORD, password);
                return password;
        }
        return value;
    }
}
