package com.unifydots.tests;

import com.unifydots.base.WebBase;
import com.unifydots.listeners.TestExecutionListener;
import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners({TestExecutionListener.class})
public class LoginLogoutTest extends WebBase {
    private static Logger logger = Logger.getLogger(LoginLogoutTest.class);

    @Test(description = "Login Success Test")
    public void loginSuccessTest() throws IOException {
        loginPage.openApplication();
        loginPage.login("standard_user", "secret_sauce");
        loginPage.verifyTitle("Swag Labs");
        loginPage.logOut();
    }

    @Test(description = "Login Failure Test")
    public void loginFailureTest() throws IOException {
        loginPage.openApplication();
        loginPage.login("standard_user", "secret_sauce123");
        loginPage.verifyTitle("Swag Labs123");

    }

}
