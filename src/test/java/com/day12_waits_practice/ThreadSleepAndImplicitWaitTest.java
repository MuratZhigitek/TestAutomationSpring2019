package com.day12_waits_practice;

import com.Utlities.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ThreadSleepAndImplicitWaitTest {

WebDriver driver;
String helloWorldMessageLocator =  "#finish>h4";
String startButtonLocator = "#start>button";


    @BeforeMethod
    public void setUp(){

        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

}
    @Test
    public void waitTest1(){
        driver.findElement(By.cssSelector(startButtonLocator)).click();
       String actualResult =  driver.findElement(By.cssSelector(helloWorldMessageLocator)).getText();
       String expectedResult = "Hello World!";

        Assert.assertEquals(actualResult, expectedResult);

}

    @Test
    public void waitTest2(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");
        String expectedResult = "Hello World!";
        String actualResult = driver.findElement(By.cssSelector(helloWorldMessageLocator)).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @AfterMethod
    public  void teardown(){

        driver.close();
}

}
