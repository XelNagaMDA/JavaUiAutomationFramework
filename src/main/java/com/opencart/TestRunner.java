package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataGeneratorManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();

        String currentWindowName = driver.getWindowHandle();

        // new window code
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://andreisecuqa.host/");
        Thread.sleep(5000);

        // Finding and clicking on accounts icon
        WebElement myAccountIcon = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        myAccountIcon.click();

        // Finding and clicking on Register option
        WebElement registerOption = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        registerOption.click();

        // Printing the current page
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);

        // Finding and completing elements on registration page
        // Finding the first name input field and writing the first name using a generator
        WebElement firstNameInputField = driver.findElement(By.id("input-firstname"));
        String firstName = RandomDataGeneratorManager.generateRandomFirstName();
        firstNameInputField.sendKeys(firstName);
        System.out.println(firstName);


        // Finding the last name input field and writing the last name using a generator
        WebElement lastNameInputField = driver.findElement(By.id("input-lastname"));
        String lastName = RandomDataGeneratorManager.generateRandomLastName();
        lastNameInputField.sendKeys(lastName);
        System.out.println(lastName);

        // Finding the e-mail input field and writing the e-mail using a generator
        WebElement emailInputField = driver.findElement(By.id("input-email"));
        String email = RandomDataGeneratorManager.generateRandomEmail();
        emailInputField.sendKeys(email);
        System.out.println(email);

        // Finding the password input field and writing the first password using a generator
        WebElement passwordInputField = driver.findElement(By.id("input-password"));
        String password = RandomDataGeneratorManager.generateRandomPassword();
        passwordInputField.sendKeys(password);
        System.out.println(password);

        // Finding and clicking on the policy button
        WebElement policyButtonOption = driver.findElement(By.cssSelector("input[value='1'][name='agree']"));
        policyButtonOption.click();

        // Finding and clicking on Continue button to finish registration
        WebElement continueButton = driver.findElement(By.cssSelector("button[type='submit']"));
        continueButton.click();

        Thread.sleep(7000);

        System.out.println(driver.getTitle());
        driver.close();
        driver.quit();

        System.out.println("Homework is done.");
    }
}
