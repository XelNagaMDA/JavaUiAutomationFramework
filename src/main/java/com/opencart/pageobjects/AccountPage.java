package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends Page {
    public AccountPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "aside[id='column-right'] a:nth-child(1)")
    private WebElement logoutButton;

    public void logoutFromAccount() {
        logoutButton.click();
    }

}
