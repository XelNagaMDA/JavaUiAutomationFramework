package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataGeneratorManager;
import com.opencart.pageobjects.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class RegisterPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);

    @When("the Register form is populated with valid random data")
    public void theRegisterFormIsPopulatedWithValidRandomData() throws InterruptedException {
        Thread.sleep(1000);

        // Generating and printing data for the field
        String email = RandomDataGeneratorManager.generateRandomEmail();
        System.out.println(email);

        // Generating and printing data for the field
        String password = RandomDataGeneratorManager.generateRandomPassword();
        System.out.println(password);

        registerPage.completeTheRegisterForm(RandomDataGeneratorManager.generateRandomFirstName(),
                RandomDataGeneratorManager.generateRandomLastName(), email, password, true);
        System.out.println("The Register form is populated with random data.");

    }

    @And("Continue button is clicked")
    public void continueButtonIsClicked() throws InterruptedException {
        Thread.sleep(1000);
        registerPage.clickTheContinueButton();
        System.out.println("The Continue button was clicked.");
    }
}
