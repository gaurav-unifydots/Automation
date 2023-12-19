package com.unifydots.tests;

import com.relevantcodes.extentreports.LogStatus;
import com.unifydots.utility.BaseTest;
import com.unifydots.utility.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SecondTest extends BaseTest {

    @Test(description = "Second Test")
    public void PrintNumbers(){

        loginPage.login1();
loginPage.shutDown();

    }


}
