package com.opencart.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {
    private static String webDriverType = "Chrome";
    private static DriverManager instance;
    private WebDriver driver;

    private DriverManager() {
        switch (webDriverType.toUpperCase()) {
            case "CHROME":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("ignore-certificate-errors");
                options.addArguments("--incognito");
                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);
                System.out.println("The Chrome driver is initiated.");
                break;
            case "FIREFOX":
                driver = new FirefoxDriver();
                System.out.println("The Firefox driver is initiated.");
                break;
            case "EDGE":
                driver = new EdgeDriver();
                System.out.println("The Edge driver is initiated.");
                break;
            case "SAFARI":
                driver = new SafariDriver();
                System.out.println("The Safari driver is initiated.");
                break;
            default:
                System.out.println("There is no such browser: " + webDriverType);

        }

    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void tearDown(){
        driver.close();
        driver.quit();
        instance = null;
        driver = null;
    }

    public void deleteCookies() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.manage().deleteAllCookies();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
