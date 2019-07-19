package com.day11;

import com.Utlities.VyTrackUtils;
import com.day4.library;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VyTrackAutomation {

    /*

    Login as story manager
Go to Activities --> Calls
Verify that Log Call button is displayed
Go to Activities --> Calendar Events
Verify that Create Calendar Event button is displayed


     */

    WebDriver driver;
    String createButtonLocator = "a[title='Log call']";
    String createCalendarEventButtonLocator = "a[title='Create Calendar event']";

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://qa2.vytrack.com/user/login");

    }
    @Test
    public void storeManager(){
        // login
        VyTrackUtils.login(driver, "storemanager85", "UserUser123");
        library.sleep(2);
        //navigate to the Calls
        VyTrackUtils.navigateToModule(driver, "Activities", "Calls");
        library.sleep(2);
        Assert.assertTrue(driver.findElement(By.cssSelector(createButtonLocator)).isDisplayed());
        library.sleep(1);

        VyTrackUtils.navigateToModule(driver, "Activities", "Calendar Events");
        Assert.assertTrue(driver.findElement(By.cssSelector(createCalendarEventButtonLocator)).isDisplayed());

    }
    @Test
    public void salesManager(){
        // login
        VyTrackUtils.login(driver, "salesmanager270", "UserUser123");
        library.sleep(2);
        //navigate to the Calls
        VyTrackUtils.navigateToModule(driver, "Activities", "Calls");
        library.sleep(2);
        Assert.assertTrue(driver.findElement(By.cssSelector(createButtonLocator)).isDisplayed());
        library.sleep(1);

        VyTrackUtils.navigateToModule(driver, "Activities", "Calendar Events");
        Assert.assertTrue(driver.findElement(By.cssSelector(createCalendarEventButtonLocator)).isDisplayed());

    }

    @AfterMethod
    public void tearDown(){

        driver.close();
    }
}
