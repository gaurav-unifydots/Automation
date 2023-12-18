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

    public FirstTest() {

       // this.driver
        setDesiredBrowser("chrome");

        this.driver=BaseTest.getDriver();
    }

    @BeforeMethod
    public   void setUp1(){


    }
    @Test
    public void PrintNumbers() throws InterruptedException {
Thread.sleep(5000);
driver.findElement(By.xpath("//*[@type='email']")).sendKeys("gaurav");
        System.out.println("i"+2);
        //Assert.assertFalse(true);

    }

    @AfterMethod
    public  void shutDown(){

        driver.close();
    }
    /*@AfterSuite
    public void afterSuite(){ //executed after all the tests have ran

        extent.flush();
    }
*/
}
