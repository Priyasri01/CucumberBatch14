package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.PageInitializer;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonMethods extends PageInitializer { /*we created this commonMethods class and store all the common methods(like open Browser, launch application , close the browser,
  click, sendkeys and so on)which are used throughout the framework.*/

    public static WebDriver driver; //launch in one place and call it the whole class.

    public static void openBrowserAndLaunchApplication(){
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH); // calling method where file is available  and specifying method in which the path is available.
        switch (ConfigReader.getPropertyValue("browser")){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser name");
        }
        //After we open the Browser(line 21) , now we are launch the application(line 43)
        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url")); // in here we are calling the getPropertyValue()method from configReader class to launch the application.
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS); //in here we provided the implicit wait(global wait)
        intializePageObjects(); // now we are calling this method to utilize it.
  /*   DOMConfigurator.configure("log4j.xml"); //calling the  file what we created under target for configuration
        Log.startTestCase("My First test case is login test"); //calling the method from the log class.
        Log.info("My login is  going on");
        Log.warning("My test case might fail"); */


    }

public static void closeBrowser(){ // create this method to close the browser
       /* Log.info("My test case is about to complete");
        Log.endTestCase("This is my login test case again");*/

        driver.quit();
}

    //we use this method instead of send keys method throughout the framework
    public static void sendText(WebElement element, String textToSend){ /*in here  we are passing two parameter first is WebElement & second one is string.
     please note we can call this method where every we need to perform sendkey operation.*/
        element.clear();// step:1 if any text is available on the  feild, it will clear then will proceed the next step
        element.sendKeys(textToSend);//step:2 it will pass the text to that particular feild
    }

    /*when element not properly loaded we have to wait until webelement clickable/visible and so on .
   for that we need explicit wait , so we created this method. to create explicit wait we have 2 stpes.
   1.define the wait (meaning create instance for the WebdriverWait & second steps
    wait until my condition is met. these two steps we are creating in separate method and operation(clicking in line 68) which is done on another method.
    this is the beauty of the framework , because every single part is split in segregation form. so that even we can take small piece of code according to our requirement.
   */
    public static WebDriverWait getWait(){  // this will return the wait so wherever we need, we can call this.
        WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT); //step1: define method
        return wait;
    }


    public static void waitForClickability(WebElement element){ //this method will wait for the element to be clickable, with in the given frame time.
        getWait().until(ExpectedConditions.elementToBeClickable(element));//step2:wait until your condition met with in the given frame time
    }

    public static void waitForVisibility(WebElement element){

        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public static void click(WebElement element){ //actual  use of these  methods(58&64) is for the click operation
        waitForClickability(element); //this method we are calling over here for the element (basically , it will go to line 64 and wait util excepted conditions met with in the given time frame.
        element.click(); //then do the click operation.
    }

    private static WebDriverWait createExplicitWait() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
        return webDriverWait;
    }
    public static void waitForElementToBeClickable(WebElement element) {
        createExplicitWait().until(ExpectedConditions.elementToBeClickable(element));
        //element.click();
    }

 /*
        about javaScript Using JavaScriptExecutor we can perform:
● Click on some elements
● Scroll page
● Refresh page
● Highlight an element
basically to mouse and keyboard handle
JavaScriptExecutor provides “execute script” &
"executeAsyncScript" methods, to run JavaScript in the
context of the currently selected frame or window.
note:JavascriptExecutor in Selenium is very crucial when you are having some problems while using Selenium built-in methods.
Sometimes we cannot handle some conditions or problems with Webdriver, web controls don’t react well against selenium commands.
In these kinds of situations, we use the JavascriptExecutor Selenium interface.
         */

    public static JavascriptExecutor getJSExecutor(){ //this method will return javascript object since we created  Instance for JavaScriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }
    //this function will perform click on element with the help of  javascript executor object, which we created in the above method
    public static void jsClick(WebElement element){
        getJSExecutor().executeScript("arguments[0].click();", element);
    }

 //we can select the dropdown in three ways they are by index by value and by visible Text , i am  using text here
 public static void selectDropdown(WebElement element, String text){
     Select s = new Select(element);
     s.selectByVisibleText(text);


 }
 /*note : the same selectDropdown()method i spilt into two , one method created for object itself  , so that i can call this method anywhere in the framework
   and we can utilize the various method  which are available in the select class.
public static Select getSelObj(WebElement element){

     Select s= new Select(element);
     return s; //we can call this method in anywhere and we can utiliz all the method whcih are available in the select class.
 }

 public static void selectDropDown(WebElement element, String text) {//we can select the dropdown in three ways by text, by value, by index

     getSelObj(element).selectByVisibleText(text);
 }*/

    public static byte[] takeScreenshot(String fileName){
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile =  ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourceFile,
                    new File(Constants.SCREENSHOT_FILEPATH + fileName + " " +
                            getTimeStamp("yyyy-MM-dd-HH-mm-ss")+".png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return picBytes;
    }

    public static String getTimeStamp(String pattern){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static void handleDropdown(WebElement element, String text) {
        Select select = new Select(element);

        List<WebElement> options = select.getOptions();

        for (WebElement value : options) {
            String optionText = value.getText();

            if (optionText.equals(text)) {
                select.selectByVisibleText(text);
                break;
            }
        }
    }

    /**
     * chooseDateFromCalendar Method
     *
     * This method needs the following information to function:
     *
     * @param element - the element to be clicked on to reveal the calendar
     * @param monthDropdown - the xpath to the dropdown for month
     * @param yearDropdown - the xpath to the dropdown for year
     * @param dayElements - A List<WebElements> object that contains all of the td
     * @param monthOptionValue - The option value associated with the month you want... ie 1
     * @param year - the year you want... ie 2022
     * @param day - The day you want... ie 3
     */
    public static void chooseDateFromCalendar(WebElement element,
                                              WebElement monthDropdown,
                                              WebElement yearDropdown,
                                              List<WebElement> dayElements,
                                              String monthOptionValue,
                                              String year,
                                              String day) {

        waitForElementToBeClickable(element);

        WebDriverWait wait = createExplicitWait();
        wait.until(ExpectedConditions.elementToBeClickable(monthDropdown));

        Select select = new Select(monthDropdown);
        select.selectByVisibleText(monthOptionValue);

        select = new Select(yearDropdown);
        select.selectByVisibleText(year);


        for (WebElement dayElement : dayElements) {
            if (dayElement.getText().equals(day)) {
                dayElement.click();
                break;
            }
        }

    }

}
