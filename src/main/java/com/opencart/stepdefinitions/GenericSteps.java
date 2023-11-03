package com.opencart.stepdefinitions;

import com.opencart.managers.ConfigReaderManager;
import com.opencart.managers.DataSubstituteManager;
import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

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
        driver.get(ConfigReaderManager.getPropertyValue("url") + endpointValue);
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

    @Then("the following list of error messages is displayed:")
    public void theFollowingListOfErrorMessagesIsDisplayed(List<String> errorMessagesList) throws InterruptedException {
        Thread.sleep(1000);
        errorMessagesList.forEach(errorMessage -> {
            boolean errorMessageIsDisplayed = driver.findElement(By.xpath("//*[contains(text(),'" + errorMessage + "')]")).isDisplayed();
            Assertions.assertTrue(errorMessageIsDisplayed, "The error message: " + errorMessage + " is displayed");
        });

    }

    @And("the {string} from {string} is clicked")
    public void theElementFromPageNameIsClicked(String elementName, String pageName) {
        try {
            Class classInstance = Class.forName("com.opencart.pageobjects." + pageName);
            Field classField = classInstance.getDeclaredField(elementName);
            classField.setAccessible(true);
            WebElement elementToBeClicked = (WebElement) classField.get(classInstance.getConstructor(WebDriver.class).newInstance(driver));
            // maybe scroll?
            elementToBeClicked.click();
            System.out.println("The element: " + elementName + " is clicked.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("the following form from {string} is populated as follows:")
    public void theFollowingFormFromPageNameIsPopulatedAsFollows(String pageName, Map<String, String> fieldAndValueMap) {
        fieldAndValueMap.forEach((fieldName, fieldValue) -> {
            try {
                Class classInstance = Class.forName("com.opencart.pageobjects." + pageName);
                Field classField = classInstance.getDeclaredField(fieldName);
                classField.setAccessible(true);
                WebElement inputElement = (WebElement) classField.get(classInstance.getConstructor(WebDriver.class).newInstance(driver));
                fieldValue = DataSubstituteManager.substituteString(fieldValue);
                inputElement.sendKeys(fieldValue);
                System.out.println("The field [ " + fieldName + " ] is populated with [ " + fieldValue + " ]");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        });
    }
}
