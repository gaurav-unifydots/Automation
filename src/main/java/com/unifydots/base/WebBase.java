package com.unifydots.base;

import com.google.common.base.Function;
import com.unifydots.pages.LoginPage;
import com.unifydots.utility.SeleniumConstant;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Optional;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * BaseTest class for environment setting, and all common util methods which are
 * used by across all modules.
 */
public class WebBase {
    public static final Logger log = Logger.getLogger(WebBase.class);

    /**
     * Object to hold RemoteWebDriver value.
     */
    public static WebDriver driver;
    public static LoginPage loginPage;

    /**
     * Initialize Actions class reference
     */
    public Actions action;
    public static
    ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();


    @BeforeMethod
    @Parameters({"browser","headless"})
    public static void openBrowser(@Optional("chrome") String browser,@Optional("false") String headless) throws IOException {
        WebDriver driver = DriverManager.getDriverObject(browser,headless);
        //set driver
        threadLocalDriver.set(driver);
        System.out.println("Before Test Thread ID: " + Thread.currentThread().getId());
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(SeleniumConstant.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(SeleniumConstant.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(SeleniumConstant.SETSCRIPT_TIMEOUT, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
    }

    public static WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    @AfterMethod
    public static void shutDown() {
        getDriver().quit();
        System.out.println("After Test Thread ID: " + Thread.currentThread().getId());
        threadLocalDriver.remove();
    }

    /**
     * Method to get the title of current page
     */
    public String getTitle() {
        return driver.getTitle();
    }

    /**
     * Method to get the current url of the application
     */
    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    /**
     * Method to check element is present or not.
     *
     * @param eId
     * @return
     */
    public boolean existsElement(String eId) {

        try {
            driver.findElement(By.id(eId));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Method to enter value in input field
     *
     * @param elementLoc
     * @param stringVal
     */
    public void setText(By elementLoc, String stringVal) {

        driver.findElement(elementLoc).clear();
        driver.findElement(elementLoc).sendKeys(stringVal);
    }

    /**
     * Method to wait for an element till it's not display .
     *
     * @param
     */
    public void waitForElementDisplayed(By by) {

        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementDisplayed(WebElement element) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Method to wait for an element till it's not clickable.
     *
     * @param by
     */
    public static void waitForElementToBeClickable(By by) {

        new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(by));
    }

    /**
     * Method to click on element.
     *
     * @param by
     */
    public void clickElement(By by) {

        waitForElementToBeClickable(by);
        driver.findElement(by).click();
    }

    /**
     * Method to find out element by text.
     *
     * @param by
     * @param expectedString
     */
    public void verifyElementText(By by, String expectedString) {

        Assert.assertTrue(driver.findElement(by).getText().trim().replace("\n", "").replace("\r", "")
                .equalsIgnoreCase(expectedString.trim()));
    }


    /**
     * Method to verify if element is present
     *
     * @param by
     * @return
     */
    protected boolean isElementPresent(By by) {

        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Set focus and click on element
     *
     * @param element element on which we want to click
     */
    public void setFocusAndClickElement(WebElement element) {

        ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", element);
        setSleepTime(5000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        setSleepTime(5000);
    }

    /**
     * Scroll into view and click on element
     *
     * @param element Scroll into view a element
     */
    public void scrollToIntoView(WebElement element) {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        setSleepTime(2000);
    }

    /**
     * Method to verify if element is present
     *
     * @param
     * @return
     */
    protected static boolean isElementPresent(WebElement element) {

        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * Utility to switch between windows
     *
     * @param mainWindow parent window
     */
    @SuppressWarnings("unused")
    protected void changeTabs(String mainWindow) {

        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        for (String currentTab : newTab) {
            driver.switchTo().window(currentTab);
            driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
            driver.switchTo().window(mainWindow);
        }
    }

    /**
     * Utility to handle HTML dropdown list
     */
    protected void handleHtmlDropdownListWithVisibleText(WebElement element, String visibileText) {

        Select select = new Select(element);
        select.selectByVisibleText(visibileText);
    }

    /**
     * Utility to handle HTML dropdown list
     */
    protected void handleHtmlDropdownListWithIndex(WebElement element, int index) {

        Select select = new Select(element);
        select.selectByIndex(index);
    }

    /**
     * Utility to handle HTML dropdown list
     */
    protected List<WebElement> getHtmlDropdownListSize(WebElement element) {

        Select select = new Select(element);
        return select.getOptions();
    }

    /**
     * Utility to handle HTML dropdown list
     */
    protected WebElement getFirstSelectedOptionFromHtmlDropdownList(WebElement element) {

        Select select = new Select(element);
        return select.getFirstSelectedOption();
    }

    /**
     * Utility to handle HTML dropdown list
     */
    protected List<WebElement> getAllSelectedOptionFromMultiSelectDropdownList(WebElement element) {

        Select select = new Select(element);
        return select.getAllSelectedOptions();
    }

    /**
     * Utility to handle iframes
     */
    protected void switchToIFrameWithWebElement(WebElement element) {

        driver.switchTo().frame(element);
    }

    /**
     * Utility to handle iframes
     */
    protected void switchToIFrameWithIndex(int index) {

        driver.switchTo().frame(index);
    }

    /**
     * Utility to handle iframes
     */
    protected void switchFromIFrameToMainPage() {

        driver.switchTo().defaultContent();
    }

    /**
     * Utility for mouse hover
     */
    protected void mouseHover(WebElement element) {

        action = new Actions(driver);
        action.moveToElement(element).build().perform();

    }


    /**
     * This is sleep method from java only use it when uttermost required
     *
     * @param millis time in mili seconds
     */
    @SuppressWarnings("static-method")
    protected void setSleepTime(long millis) {

        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to execute scripts based on locale.
     *
     * @param locales - language name
     * @return languages
     */
    @SuppressWarnings("rawtypes")
    protected static Collection internationalization(String locales) {

        Object[] localeValues = locales.split("\\s*,\\s*");
        Object[] languages = new Object[localeValues.length];
        for (int i = 0; i < localeValues.length; i++) {
            languages[i] = new Object[]{localeValues[i]};
        }
        return Arrays.asList(languages);
    }

    /**
     * Method to navigate to specific page. It can be used wherever explicit url is
     * required to navigate on desired portal/page.
     *
     * @param nvigationUrl String.
     */
    protected void setSpecificNavigation(String nvigationUrl) {

        driver.get(nvigationUrl);
    }

    /**
     * @param str   string to be verified
     * @param reqEx regular expression
     * @return true /false
     * Method to verify string by using regular expression
     */
    @SuppressWarnings("static-method")
    protected boolean verifyStringWithRegEx(String str, String reqEx) {

        @SuppressWarnings("unused")
        Pattern pattern, patternNull;
        Matcher matcher;

        pattern = Pattern.compile(reqEx);
        patternNull = Pattern.compile("^$");

        matcher = pattern.matcher(str);

        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    /**
     * Method for fluent wait, it can be used to wait for particular element to load
     * on page, based on given time unit. Using polling mechanism it will lookup an
     * element on DOM in each and every 5 seconds (or provided time unit). Use this
     * wait only if element is present in DOM and that is enabling based on some
     * condition.
     *
     * @param locator By
     * @return waitElement WebElement
     */
    protected WebElement fluentWait(final By locator, long timeoutTime, long pollingTime) {

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeoutTime))
                .pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        WebElement waitElement = wait.until(new Function<WebDriver, WebElement>() {

            public WebElement apply(WebDriver input) {

                return driver.findElement(locator);
            }
        });
        return waitElement;
    }

    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");

        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));

    }

    /**
     * Method to refresh Page
     */
    protected void refreshPage() {

        driver.navigate().refresh();

    }

    /**
     * Method to read Properties File.
     *
     * @param country               String.It should be country folder which we creates under src/test/resources/CONFIG.
     * @param environmentFolderName String.It should be environment folder for which you want to extract Values.Expected Values
     *                              can be "DEV","QA","PROD","COMMON".
     * @note: For COMMON,You dnt need to create any folder.Put the file under /src/test/resources/CONFIG/{countryFolderName}
     */
    public static Properties readPropertiesFileContents(String country, String environmentFolderName) throws IOException {
        InputStream inputStream = null;
        Properties prop = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        if (environmentFolderName.equalsIgnoreCase("DEV")) {
            inputStream = loader.getResourceAsStream("config/" + country + "/" + environmentFolderName + "/config.properties");

        } else if (environmentFolderName.equalsIgnoreCase("PROD")) {

            inputStream = loader.getResourceAsStream("config/" + country + "/" + environmentFolderName + "/config.properties");

        } else if (environmentFolderName.equalsIgnoreCase("QA")) {

            inputStream = loader.getResourceAsStream("config/" + country + "/" + environmentFolderName + "/config.properties");
        } else if (environmentFolderName.equalsIgnoreCase("COMMON")) {
            inputStream = loader.getResourceAsStream("config/" + country + "/commonconfig.properties");


        }
        prop = new Properties();
        prop.load(inputStream);
        return prop;
    }

    /**
     * Method to read Properties File.
     */
    public static String getEnvironmentConfig(String key) throws IOException {
        Properties application = readPropertiesFileContents("EN", "QA");
        String value = application.getProperty(key);
        return value;
    }

    /**
     * Method to read Common Properties File.
     */
    public static String getCountryConfig(String key) throws IOException {
        Properties application = readPropertiesFileContents("EN", "COMMON");
        String value = application.getProperty(key);
        return value;
    }


}