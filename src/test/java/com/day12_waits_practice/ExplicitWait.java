package com.day12_waits_practice;

import com.Utlities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWait {

    WebDriver driver;

    String startButtonLocator = "#start>button";
    String username = "#username";
    String password = "#pwd";
    String submitButtonLocator = "button[type='submit']";
    String loadingBarLocator = "#loading";
    String enableButtonLocator = "#input-example> button";
    String addButtonLocator = "//button[text()='Add']";
    String removeButtonLocator = "//button[text()='Remove']";
    String spinnerLocator = "div[class='fa fa-cog fa-spin']";


    @BeforeMethod
    public void setUp() {

        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test
    public void waitForVisibilityTest(){

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        driver.findElement(By.cssSelector(startButtonLocator)).click();
        System.out.println(driver.findElement(By.cssSelector(loadingBarLocator)));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(username))));


        driver.findElement(By.cssSelector(username)).sendKeys("tomsmith");
        driver.findElement(By.cssSelector(password)).sendKeys("SuperSecretPassword");

        driver.findElement(By.cssSelector(submitButtonLocator)).click();


    }


    @Test
    public void waitForElementToBeClickable(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        driver.findElement(By.cssSelector(enableButtonLocator)).click();
        driver.findElement(By.cssSelector(enableButtonLocator)).click();
        //driver.findElement(By.xpath(removeButtonLocator)).click();
        driver.findElement(By.xpath(addButtonLocator)).click();
    }
    @Test
    public void waitForElementToBeClickable2(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/5");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(spinnerLocator))));

        driver.findElement(By.xpath(addButtonLocator)).click();
    }

    @AfterMethod
    public void teardown(){

        driver.quit();
    }
}
