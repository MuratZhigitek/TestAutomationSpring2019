package com.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class MultipleButtonCSSSelector {


    String button1 = "[onclick='button1()']";
    String button2 = ".btn.btn-primary:nth-of-type(2)";
    String button3 = "[id^='button_']";
    String button4 = "[id$='_button'][onclick='button4()']";
    String button5 = "[onclick*='5']";
    String button6 = "#disappearing_button";
    String result = "#result";

    WebDriver driver;



    @BeforeClass
    public void beforeClass(){

        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
    }

    @Test (priority =1, description = "Verifying button 1")
    public void button1Test() {
        driver.findElement(By.cssSelector(button1)).click();
        String expectedResult = "Clicked on button one!";
        String actualResult = driver.findElement(By.cssSelector(result)).getText();
        Assert.assertEquals(actualResult, expectedResult);

    }


    @Test (priority =2, description = "Verifying button 2")
    public void button2Test() {
        driver.findElement(By.cssSelector(button2)).click();
        String expectedResult = "Clicked on button two!";
        String actualResult = driver.findElement(By.cssSelector(result)).getText();
        Assert.assertEquals(actualResult, expectedResult);
        throw new SkipException("I don't want this test");
    }
    @AfterMethod
    public void tearDown(){

        driver.close();
    }
}
