package com.unifydots.pages;

import com.unifydots.base.WebBase;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
    public static WebDriver driver;
    private static Logger logger = Logger.getLogger(LoginPage.class);

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

    private By logout=By.xpath("//*[contains(text(),'Logout')]");

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
    }
    @Severity(SeverityLevel.BLOCKER)
    @Step("Logout from the Application")
    public void logOut(){
        logOutImage.click();
        logOutButton.click();
    }

    @Severity(SeverityLevel.BLOCKER)
    @Step("Check Title of the Application")
    public void verifyTitle(String title){
        Assert.assertEquals(driver.getTitle(), title);

    }
}
