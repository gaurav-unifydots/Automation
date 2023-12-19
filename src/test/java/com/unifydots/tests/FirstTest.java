package com.unifydots.tests;

import com.aventstack.extentreports.ExtentReports;
import com.unifydots.pages.LoginPage;
import com.unifydots.utility.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test(description = "First Test")
    public void PrintNumbers() throws InterruptedException {
loginPage.login();



    }




}
