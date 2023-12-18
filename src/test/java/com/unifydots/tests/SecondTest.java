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
    public static WebDriver driver;

    public SecondTest() {
        setDesiredBrowser("chrome");
        this.driver=BaseTest.getDriver();

    }

    @Test
    public void PrintNumbers(){

        System.out.println("SecondTest : "+2);
        //Assert.assertFalse(true);
      //  this.driver=BaseUtil.driver;
        driver.findElement(By.xpath("//[@email='email']")).sendKeys("gaurav");

    }

    @AfterMethod
    public  void shutDown(){

        driver.close();
    }
}
