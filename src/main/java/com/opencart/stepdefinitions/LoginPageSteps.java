package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.LoginPage;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;

public class LoginPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @And("{string} data is entered in the username input")
    public void dataIsEnteredInTheUsernameInput(String email) {
        loginPage.inputDataInEmailField(email);

    }

    @And("{string} data is entered into the password field")
    public void dataIsEnteredIntoThePasswordField(String password) {
        loginPage.inputDataInPasswordField(password);

    }

    @And("the Login button is clicked")
    public void theLoginButtonIsClicked() throws InterruptedException {
        Thread.sleep(1000);
        loginPage.clickTheLoginButton();

    }
}
