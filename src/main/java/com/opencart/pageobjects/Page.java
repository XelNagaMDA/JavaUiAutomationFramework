package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {
    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy (xpath = "//i[@class='fa-solid fa-user']")
    protected WebElement myAccountIcon;
    @FindBy (xpath = "//a[normalize-space()='Register']")
    protected WebElement registerButton;
    @FindBy(xpath = "//a[normalize-space()='Login']")
    protected WebElement loginButton;
    @FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Logout']")
    protected WebElement logoutButton;


    public void navigateToRegisterPageFromHeader() {
        myAccountIcon.click();
        registerButton.click();
    }
    public  void navigateToLoginPageFromHeader() {
        myAccountIcon.click();
        loginButton.click();
    }

    public void navigateToLogOutFromHeader() {
        myAccountIcon.click();
        logoutButton.click();

    }


}
