package com.day9_Xpath;

import com.Utlities.BrowserFactory;
import com.day4.library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RelativeXpathDemo {

    private WebDriver driver;
    //String buttons = "//button[starts-with(text(),'Button')]";
    String allButtonsLocator = "//button[starts-with(text(),'Button')]";
    String button2Locator = "//*[contains(@name,'button2')]";
    String button3Locator = "//button[starts-with(@id,'button_')]";
    String button4Locator = "//button[contains(text(),'Button 4')]";
    String button5Locator = "//button[5]";
    String button6Locator = "//*[@id='disappearing_button']";
    String button1Locator= "//button[.='Button 1']";
    String resultElement = "//p[@id='result']";

    @BeforeMethod
    public void setUp(){
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

    }

    @Test
    public void test1(){
    String expectedMessage = "Clicked on button three!";
    driver.findElement(By.xpath(button3Locator)).click();
        library.sleep(2);
    String actualMessage = driver.findElement(By.xpath(resultElement)).getText();
        Assert.assertEquals(actualMessage, expectedMessage);



    }

    @Test
    public void test2() {
        String expectedMessage = "Clicked on button four!";
        driver.findElement(By.xpath(button4Locator)).click();
        library.sleep(2);
        String actualMessage = driver.findElement(By.xpath(resultElement)).getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void test3() {
        String expectedMessage = "Clicked on button five!";
        driver.findElement(By.xpath(button5Locator)).click();
        library.sleep(2);
        String actualMessage = driver.findElement(By.xpath(resultElement)).getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void test4(){

        String expectedResult = "Now it's gone!";
        driver.findElement(By.xpath(button6Locator)).click();
        library.sleep(2);
        String actualResult = driver.findElement(By.xpath(resultElement)).getText();
        Assert.assertEquals(actualResult, expectedResult);

        Assert.assertTrue(driver.findElements(By.xpath(button6Locator)).size() == 0);

    }

    @Test
    public void clickOnEveryButton(){
        List<WebElement> buttons = driver.findElements(By.xpath(allButtonsLocator));
        for(WebElement button: buttons){
            button.click();
            library.sleep(1);
        }
    }
    @AfterMethod
    public void teardown(){

        driver.close();
    }

}
