package com.opencart.pageobjects;

import com.opencart.managers.ScrollManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "input-firstname")
    private WebElement firstNameInputField;
    @FindBy(id = "input-lastname")
    private WebElement lastNameInputField;
    @FindBy(id = "input-email")
    private WebElement emailInputField;
    @FindBy(id = "input-password")
    private WebElement passwordInputField;
    @FindBy(xpath = "//input[@name='agree']")
    private WebElement policyButtonOption;
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    private WebElement continueButton;

    public  void completeTheRegisterForm(String firstName, String lastName, String email, String password, boolean toggleButton) {
        firstNameInputField.sendKeys(firstName);
        lastNameInputField.sendKeys(lastName);
        emailInputField.sendKeys(email);
        passwordInputField.sendKeys(password);

        if (toggleButton) {
            //ScrollManager.scrollToTheElement(continueButton);
            policyButtonOption.click();
        }

    }
    public void clickTheContinueButton(){
        continueButton.click();
    }
}
