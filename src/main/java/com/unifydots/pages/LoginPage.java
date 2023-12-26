package com.unifydots.pages;

import com.unifydots.base.WebBase;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
    public static WebDriver driver;

    @FindBy(xpath = "//*[@name='user-name']")
    private WebElement userName;

    @FindBy(xpath = "//*[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//*[@id='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//*[contains(text(),'Open Menu')]")
    private WebElement logOutImage;

    @FindBy(xpath = "//*[contains(text(),'Logout')]")
    private WebElement logOutButton;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Severity(SeverityLevel.BLOCKER)
    @Step("Login to the Application")
    public void login(String UserName, String PassWord) {
        userName.sendKeys(UserName);
        password.sendKeys(PassWord);
        loginButton.click();

       // try {
            Assert.assertEquals(WebBase.getDriver().getTitle(), "123");
       // } catch (AssertionError e) {
           // Assert.fail();
       // }

    }

    @Severity(SeverityLevel.BLOCKER)
    @Step("Logout from the Application")
    public void logOut() {
        logOutImage.click();
        logOutButton.click();
    }


}
