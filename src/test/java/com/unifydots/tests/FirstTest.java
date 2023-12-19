package com.unifydots.tests;

import com.aventstack.extentreports.ExtentReports;
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
    public static WebDriver driver;
    public ExtentReports extent = new ExtentReports();


    @Test(description = "First Test")
    public void PrintNumbers() throws InterruptedException {
        this.driver=BaseTest.getDriver();

        Thread.sleep(5000);
driver.findElement(By.xpath("//*[@type='email']")).sendKeys("gaurav");


    }

    @AfterMethod
    public  void shutDown(){

        driver.close();
    }


}
