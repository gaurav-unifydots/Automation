package com.unifydots.tests;

import com.unifydots.base.BaseTest;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class FirstTest extends BaseTest {
    private static Logger logger = Logger.getLogger(FirstTest.class);

    @Test(description = "First Test")
    public void PrintNumbers() throws IOException {
        logger.debug("base url value from property file ");

        loginPage.login("Admin","admin123");
        loginPage.logOut();
    }

}
