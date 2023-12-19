package com.unifydots.pages;

import com.unifydots.utility.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

public class LoginPage {
WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    public void login() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@type='email']")).sendKeys("gaurav");

    }

    public void login1(){

        System.out.println("SecondTest : "+2);
        //Assert.assertFalse(true);
        //  this.driver=BaseUtil.driver;
        driver.findElement(By.xpath("//[@email='email']")).sendKeys("gaurav");
    }

    public  void shutDown(){

        driver.close();
    }
}
