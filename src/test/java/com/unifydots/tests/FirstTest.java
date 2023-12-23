package com.unifydots.tests;

import com.unifydots.base.WebBase;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class FirstTest extends WebBase {
    private static Logger logger = Logger.getLogger(FirstTest.class);

    @Test(description = "First Test")
    public void PrintNumbers() throws IOException {
        logger.debug("base url value from property file ");
        loginPage.login("standard_user", "secret_sauce123");
        loginPage.logOut();

    }

}
