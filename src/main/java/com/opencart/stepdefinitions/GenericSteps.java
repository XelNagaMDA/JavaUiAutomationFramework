package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class GenericSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();

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
}
