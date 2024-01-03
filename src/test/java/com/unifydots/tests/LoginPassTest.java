package com.unifydots.tests;

import com.unifydots.base.WebBase;
import com.unifydots.listeners.TestExecutionListener;
import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners({TestExecutionListener.class})
public class LoginPassTest extends WebBase {
    private static Logger logger = Logger.getLogger(LoginPassTest.class);

    @Test(description = "Login Success Test")
    public void login(){
        loginPage.loginPass("standard_user", "secret_sauce");
        loginPage.logOut();
    }

}
