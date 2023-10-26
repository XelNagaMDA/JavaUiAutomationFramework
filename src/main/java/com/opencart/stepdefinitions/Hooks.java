package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hooks {
    @BeforeAll
    public static void implementTheseStepsBeforeExecutingTests() {
        System.out.println("The test execution starts.");
    }

    @Before
    public void implementTheseStepsBeforeEachTestCase() {
        System.out.println("These actions happen before each test case.");
    }

    @After
    public void implementTheseStepsAfterEachTestCase() {
        DriverManager.getInstance().tearDown();
        System.out.println("These actions happen after each test case.");
    }

    @AfterAll
    public static void implementTheseStepsAfterExecutingTests() {
        System.out.println("The test execution finished.");
    }
}
