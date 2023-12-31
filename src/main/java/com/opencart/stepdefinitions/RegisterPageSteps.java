package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataGeneratorManager;
import com.opencart.pageobjects.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class RegisterPageSteps {
    private static final Logger logger = LogManager.getLogger(RegisterPageSteps.class);

    WebDriver driver = DriverManager.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);

    @When("the Register form is populated with valid random data")
    public void theRegisterFormIsPopulatedWithValidRandomData() throws InterruptedException {
        Thread.sleep(1000);

        // Generating and printing data for the field
        String email = RandomDataGeneratorManager.generateRandomEmail();
        logger.log(Level.INFO, email);

        // Generating and printing data for the field
        String password = RandomDataGeneratorManager.generateRandomPassword();
        logger.log(Level.INFO, password);


        registerPage.completeTheRegisterForm(RandomDataGeneratorManager.generateRandomFirstName(),
                RandomDataGeneratorManager.generateRandomLastName(), email, password, true);
        logger.log(Level.INFO, "The Register form is populated with random data.");
    }

//    @And("Continue button is clicked")
//    public void continueButtonIsClicked() throws InterruptedException {
//        Thread.sleep(1000);
//        registerPage.clickTheContinueButton();
//        System.out.println("The Continue button was clicked.");
//    }

    @When("the Register form is populated with the following data:")
    public void theRegisterFormIsPopulatedWithTheFollowingData(Map<String, String> formDataMap) {
        String firstNameValue = formDataMap.get("firstName");
        if (firstNameValue != null && firstNameValue.equalsIgnoreCase("RANDOM")) {
            firstNameValue = RandomDataGeneratorManager.generateRandomFirstName();
        }

        String lastNameValue = formDataMap.get("lastName");
        if (lastNameValue != null && lastNameValue.equalsIgnoreCase("RANDOM")) {
            lastNameValue = RandomDataGeneratorManager.generateRandomLastName();
        }

        String emailValue = formDataMap.get("email");
        if (emailValue != null && emailValue.equalsIgnoreCase("RANDOM")) {
            emailValue = RandomDataGeneratorManager.generateRandomEmail();
        }

        String passwordValue = formDataMap.get("password");
        if (passwordValue != null && passwordValue.equalsIgnoreCase("RANDOM")) {
            passwordValue = RandomDataGeneratorManager.generateRandomPassword();
        }

        registerPage.completeTheRegisterForm(firstNameValue, lastNameValue, emailValue, passwordValue, true);

    }
}
