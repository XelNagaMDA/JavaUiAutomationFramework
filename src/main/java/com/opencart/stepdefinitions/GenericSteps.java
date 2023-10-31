package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class GenericSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();

    HomePage homePage = new HomePage(driver);

    @Then("the current url  contains {string} keyword")
    public void theCurrentUrlContainsKeyword(String keywordFromUrl) throws InterruptedException {
        Thread.sleep(1000);
        String currentUrl = driver.getCurrentUrl();
        boolean currentUrlContainsKeyword = currentUrl.contains(keywordFromUrl);

        Assertions.assertTrue(currentUrlContainsKeyword, "The keyword:" + keywordFromUrl + " is present in " + currentUrl);
    }

    @Given("{string} is accessed")
    public void isAccessed(String endpointValue) {
        driver.get("https://andreisecuqa.host" + endpointValue);
    }

    @When("User navigates to MyAccount button from Header menu")
    public void userNavigatesToMyAccountButtonFromHeaderMenu() throws InterruptedException {
        Thread.sleep(1000);
        homePage.navigateToMyAccountButtonFromHeader();
    }

    @And("the Logout button is clicked")
    public void theLogoutButtonIsClicked() throws InterruptedException {
        Thread.sleep(1000);
        homePage.navigateToLogOutOptionFromHeader();
        Thread.sleep(1000);
    }
}
