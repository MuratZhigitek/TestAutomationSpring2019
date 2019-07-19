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

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class SaveAndChanceOptionsTest {

    WebDriver driver;
    String createCalendarEventButtonLocator = "a[title='Create Calendar event']";
    String cancelButtonLocator = "a[title='Cancel']";
    String saveAndCloseLocator = "//div/button[contains(text(), 'Save and Close')]";
    String saveAndCloseToggleLocator = "a[class='btn-success btn dropdown-toggle']";
    String saveAndCloseOptionLocator = "//li/button[contains(text(),'Save and Close')]";
    String saveAndNewOptionLocator = "//li/button[contains(text(),'Save and New')]";
    String saveLocator = "//li/button[contains(text(),'Save')]";

    String currentUserLocator = "#user-menu > a";
    String selectedOwnerLocator = ".select2-chosen";
    String titleLocator = "[id^='oro_calendar_event_form_title']";
    String startDateLocator = "[id^='date_selector_oro_calendar_event_form_start']";
    String startTimeLocator = "[id^='time_selector_oro_calendar_event_form_start']";


    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://qa2.vytrack.com/user/login");
        VyTrackUtils.login(driver, "salesmanager270", "UserUser123");


    }

    @Test
    public void verifyCancelButton(){
        VyTrackUtils.navigateToModule(driver, "Activities", "Calendar Events");
        library.sleep(2);
        driver.findElement(By.cssSelector(createCalendarEventButtonLocator)).click();
        Assert.assertTrue(driver.findElement(By.cssSelector(cancelButtonLocator)).isDisplayed());


    }

    @Test
    public void verifySaveAndCloseDropdown(){

        VyTrackUtils.navigateToModule(driver, "Activities", "Calendar Events");
        library.sleep(2);
        driver.findElement(By.cssSelector(createCalendarEventButtonLocator)).click();
        library.sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath(saveAndCloseLocator)).isDisplayed());
        library.sleep(2);
        driver.findElement(By.cssSelector(saveAndCloseToggleLocator)).click();
        library.sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath(saveAndCloseOptionLocator)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(saveAndNewOptionLocator)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(saveLocator)).isDisplayed());



    }

//    @Test
//    public void verifyStartDateAndTime(){
//        VyTrackUtils.navigateToModule(driver, "Activities", "Calendar Events");
//        driver.findElement(By.cssSelector(createCalendarEventButtonLocator)).click();
//        library.sleep(2);
//
//        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM d, yyy"));
//        String actualDate = driver.findElement(By.cssSelector(startDateLocator)).getAttribute("value");
//
//        String expectedTime = LocalTime.now().format(DateTimeFormatter.ofPattern("h:mm a"));
//        String actualTime = driver.findElement(By.cssSelector(startTimeLocator)).getAttribute("value");
//
//        Assert.assertEquals(actualDate, expectedDate);
//        Assert.assertEquals(actualTime, expectedTime);
//    }


    @AfterMethod
    public void teardown() {
        driver.close();
    }
    @AfterMethod
    public void tearDown(){

        driver.close();
    }
}
