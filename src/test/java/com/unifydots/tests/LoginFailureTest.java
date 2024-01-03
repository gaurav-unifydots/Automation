package com.unifydots.tests;

import com.unifydots.base.WebBase;
import com.unifydots.listeners.TestExecutionListener;
import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners({TestExecutionListener.class})
public class LoginFailureTest extends WebBase {
    private static Logger logger = Logger.getLogger(LoginFailureTest.class);

    @Test(description = "Login Failure Test")
    public void PrintNumbers() throws Exception {
        logger.debug("base url value from property file ");
        loginPage.login("standard_user", "secret_sauce");
        loginPage.logOut();

    }

}
