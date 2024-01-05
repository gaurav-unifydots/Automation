package com.unifydots.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

    public static WebDriver getDriverObject(String browserName,String headless) {

        WebDriver driver = null;
        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            if(headless.equalsIgnoreCase("true")){
                chromeOptions.addArguments("--headless");
            }else{
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-dev-shm-usage");
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
            chromeOptions.addArguments("--disable-features=VizDisplayCompositor");
            chromeOptions.addArguments("window-size=1920,1080");
            chromeOptions.addArguments("--ignore-certifcate-errors");

            }
            WebDriverManager.chromedriver().clearDriverCache();
            WebDriverManager.chromedriver().clearResolutionCache();
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);

        } else if (browserName.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//src//main//resources//com.unifydots.driver//" + "geckodriver.exe");
            if(headless.equalsIgnoreCase("true")){
                options.setHeadless(true);
            }else{
                options.setHeadless(false);
            }
            driver = new FirefoxDriver(options);

        } else if (browserName.equalsIgnoreCase("edge")) {
            EdgeOptions edgeOptions = new EdgeOptions();

            if(headless.equalsIgnoreCase("true")){
                edgeOptions.setCapability("headless",true);
            }else{
                edgeOptions.setCapability("headless",false);

            }
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver(edgeOptions);
        }
        return driver;
    }
}
