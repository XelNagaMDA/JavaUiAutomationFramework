package com.opencart;

import com.opencart.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();

        String currentWindowName = driver.getWindowHandle();

        // new window code
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.reddit.com/");
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        driver.close();

        driver.switchTo().window(currentWindowName);
        driver.get("https://www.python.org/");
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        driver.quit();

        System.out.println("Homework is done.");
    }
}
