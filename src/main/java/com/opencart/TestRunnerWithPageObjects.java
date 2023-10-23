package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataGeneratorManager;
import com.opencart.pageobjects.AccountPage;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.pageobjects.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class TestRunnerWithPageObjects {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();

        // new window code
        driver.get("https://andreisecuqa.host/");
        //Thread.sleep(5000);

        HomePage homePage = new HomePage(driver);
        homePage.navigateToRegisterPageFromHeader();

        RegisterPage registerPage = new RegisterPage(driver);

        // Printing the current page
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);



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
        Thread.sleep(2000);

        // Clicking on Logout button from header
        homePage.navigateToLogOutFromHeader();
        Thread.sleep(2000);



        homePage.navigateToLoginPageFromHeader();
        LoginPage loginPage = new LoginPage(driver);
        Thread.sleep(2000);


        loginPage.completeTheLoginForm(email, password);
        Thread.sleep(2000);
        loginPage.clickTheLoginButton();

        AccountPage accountPage = new AccountPage(driver);
        Thread.sleep(2000);
        accountPage.logoutFromAccount();

        Thread.sleep(3000);

        System.out.println(driver.getTitle());

        DriverManager.getInstance().tearDown();

        System.out.println("Homework is done.");
    }
}
