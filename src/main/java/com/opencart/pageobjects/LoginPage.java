package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "input-email")
    private WebElement emailInputField;
    @FindBy(id = "input-password")
    private WebElement passwordInputField;
    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement loginButton;

    public void completeTheLoginForm(String email, String password) {
        emailInputField.sendKeys(email);
        passwordInputField.sendKeys(password);
    }

    public void clickTheLoginButton() {
        loginButton.click();
    }



}
