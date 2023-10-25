package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataGeneratorManager;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.RegisterPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestRegistrationFlowWithJUnit {

    WebDriver driver;
    HomePage homePage;
    RegisterPage registerPage;

    @BeforeAll
    public static void implementTheseStepsBeforeExecutingTests() {
        System.out.println("The execution of test suite starts after this message.");
    }

    @BeforeEach
    public void implementTheseStepsBeforeEachTestCase() {
        System.out.println("This is executed before each testcase");

        driver = DriverManager.getInstance().getDriver();
        driver.get("https://andreisecuqa.host/");
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        homePage.navigateToRegisterPageFromHeader();
    }

    @Test
    @DisplayName("User is registered with valid credentials")
    public void registerWithValidCredentialsTest() throws InterruptedException {
        System.out.println("This is test1");

        Thread.sleep(1000);

        // Generating and printing data for the field
        String email = RandomDataGeneratorManager.generateRandomEmail();
        System.out.println(email);

        // Generating and printing data for the field
        String password = RandomDataGeneratorManager.generateRandomPassword();
        System.out.println(password);

        registerPage.completeTheRegisterForm(RandomDataGeneratorManager.generateRandomFirstName(),
                RandomDataGeneratorManager.generateRandomLastName(), email, password, true);


        // Clicking on Continue button to finish registration
        registerPage.clickTheContinueButton();
        Thread.sleep(1000);

        // Assertion for test validation
        String currentUrl = driver.getCurrentUrl();
        boolean doesTheUrlContainSuccess = currentUrl.contains("route=account/success");
        Assertions.assertTrue(doesTheUrlContainSuccess, "The current url: " + currentUrl + " contains: route=account/success");
    }

    @Test
    @DisplayName("User is not registered with invalid password")
    public void registerWithInvalidPasswordTest() throws InterruptedException {
        System.out.println("This is test2");

        Thread.sleep(1000);

        // Generating and printing data for the field
        String email = RandomDataGeneratorManager.generateRandomEmail();
        System.out.println(email);

        registerPage.completeTheRegisterForm(RandomDataGeneratorManager.generateRandomFirstName(),
                RandomDataGeneratorManager.generateRandomLastName(), email, "123", true);


        // Clicking on Continue button to finish registration
        registerPage.clickTheContinueButton();
        Thread.sleep(1000);

        // Assertion for test validation
        String actualUrl = driver.getCurrentUrl();
        ;
        String expectedUrl = "https://andreisecuqa.host/index.php?route=account/register&language=en-gb";
        Assertions.assertEquals(expectedUrl, actualUrl, "The urls must match.");
    }

    @Test
    @DisplayName("Error is displayed for invalid password")
    public void errorDisplayedForInvalidPasswordTest() throws InterruptedException {
        System.out.println("This is test3");

        Thread.sleep(1000);

        // Generating and printing data for the field
        String email = RandomDataGeneratorManager.generateRandomEmail();
        System.out.println(email);

        registerPage.completeTheRegisterForm(RandomDataGeneratorManager.generateRandomFirstName(),
                RandomDataGeneratorManager.generateRandomLastName(), email, "123", true);


        // Clicking on Continue button to finish registration
        registerPage.clickTheContinueButton();
        Thread.sleep(1000);

        // Assertion for test validation
        String actualPasswordError = driver.findElement(By.id("error-password")).getText();
        String expectedPasswordError = "Password must be between 4 and 20 characters!";
        Assertions.assertEquals(expectedPasswordError, actualPasswordError);
    }

    @Test
    @DisplayName("Error is displayed for invalid First Name")
    public void errorDisplayedForInvalidFirstNameTest() throws InterruptedException {
        System.out.println("This is test4");

        Thread.sleep(1000);

        // Generating and printing data for the field
        String email = RandomDataGeneratorManager.generateRandomEmail();
        System.out.println(email);

        // Generating data for the field
        String password = RandomDataGeneratorManager.generateRandomPassword();

        registerPage.completeTheRegisterForm(" ",
                RandomDataGeneratorManager.generateRandomLastName(), email, password, true);


        // Clicking on Continue button to finish registration
        registerPage.clickTheContinueButton();
        Thread.sleep(1000);

        // Assertion for test validation
        String actualPasswordError = driver.findElement(By.id("error-firstname")).getText();
        String expectedPasswordError = "First Name must be between 1 and 32 characters!";
        Assertions.assertEquals(expectedPasswordError, actualPasswordError);
    }

    @Test
    @DisplayName("Error is displayed for invalid Last Name")
    public void errorDisplayedForInvalidLastNameTest() throws InterruptedException {
        System.out.println("This is test5");

        Thread.sleep(1000);

        // Generating and printing data for the field
        String email = RandomDataGeneratorManager.generateRandomEmail();
        System.out.println(email);

        // Generating data for the field
        String password = RandomDataGeneratorManager.generateRandomPassword();

        registerPage.completeTheRegisterForm(RandomDataGeneratorManager.generateRandomFirstName(),
                " ", email, password, true);


        // Clicking on Continue button to finish registration
        registerPage.clickTheContinueButton();
        Thread.sleep(1000);

        // Assertion for test validation
        String actualPasswordError = driver.findElement(By.id("error-lastname")).getText();
        String expectedPasswordError = "Last Name must be between 1 and 32 characters!";
        Assertions.assertEquals(expectedPasswordError, actualPasswordError);
    }

    @AfterEach
    public void implementTheseStepsAfterEachTestCase() {

        DriverManager.getInstance().tearDown();
        System.out.println("This is executed after each testcase");
    }

    @AfterAll
    public static void implementTheseStepsAfterAllTestCases() {
        System.out.println("This is displayed after the test run is done");
    }
}
