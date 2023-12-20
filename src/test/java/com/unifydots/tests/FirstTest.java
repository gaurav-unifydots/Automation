package com.unifydots.tests;

import com.unifydots.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class FirstTest extends BaseTest {

    @Test(description = "First Test")
    public void PrintNumbers() throws IOException {
        loginPage.login("Admin","admin123");
    }

}
