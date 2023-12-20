package com.unifydots.pages;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public static WebDriver driver;

    @FindBy(xpath = "//*[@name='username']")
    private WebElement userName ;

    @FindBy(xpath = "//*[@name='password']")
    private WebElement password ;

    @FindBy(xpath = "//*[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@class='oxd-userdropdown-name']")
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

    }

    @Step
    public void logOut() {
        logOutImage.click();
        logOutButton.click();
    }



}
