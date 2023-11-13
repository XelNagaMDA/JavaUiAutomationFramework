package com.opencart.stepdefinitions;

import com.opencart.context.ScenarioContext;
import com.opencart.managers.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hooks {

    private static final Logger logger = LogManager.getLogger(Hooks.class);

    @BeforeAll
    public static void implementTheseStepsBeforeExecutingTests() {
        logger.log(Level.INFO, "The test execution starts.");
    }

    @Before
    public void implementTheseStepsBeforeEachTestCase() {
        logger.log(Level.INFO, "These actions happen before each test case.");
    }

    @After
    public void implementTheseStepsAfterEachTestCase() {
        DriverManager.getInstance().deleteCookies();
        ScenarioContext.getInstance().cleanUpTheContextStorage();
        logger.log(Level.INFO, "These actions happen after each test case.");
    }

    @AfterAll
    public static void implementTheseStepsAfterExecutingTests() {
        DriverManager.getInstance().tearDown();
        logger.log(Level.INFO, "The test execution finished.");
    }
}
