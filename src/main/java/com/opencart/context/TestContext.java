package com.opencart.context;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class TestContext {

    private static final Logger logger = LogManager.getLogger(TestContext.class);

    private static TestContext testContextInstance;
    private Map<String, String> testContextStorageMap;

    private TestContext() {
        testContextStorageMap = new HashMap<>();
    }

    public static TestContext getInstance() {
        if (testContextInstance == null) {
            testContextInstance = new TestContext();
        } return testContextInstance;
    }

    public void addToStorageContext(String contextKey, String contextValue) {

        testContextStorageMap.put(contextKey, contextValue);
        logger.log(Level.INFO, "The  Test context was populated with [" + contextValue + "] for the key [" + contextKey + "]");

    }

    public String getStoredValueFromContext(String contextKey) {
        return testContextStorageMap.get(contextKey);
    }
}
