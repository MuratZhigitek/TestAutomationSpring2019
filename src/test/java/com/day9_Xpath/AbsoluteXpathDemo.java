package com.day9_Xpath;

import com.Utlities.BrowserFactory;
import com.day4.library;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AbsoluteXpathDemo {

    private WebDriver driver;
    String fullNameLocator = "/html/body/div/div[2]/div/div/form/div/div[1]/input[@name='full_name']";
    String emailLocator = "html/body/div/div[2]/div/div/form/div/div[1]/input[@name='email']";
    String signUpButton = "html/body/div/div[2]/div/div/form/button";

    @BeforeMethod //it runs before every @Test
    public void setUp(){
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

    }

    @Test
    public void test1(){

        driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/div/div[1]/input[@name='full_name']")).sendKeys("Will Smith");
        driver.findElement(By.xpath("html/body/div/div[2]/div/div/form/div/div[1]/input[@name='email']")).sendKeys("tomsmith@gmail.com");
        library.sleep(2);
        driver.findElement(By.xpath("html/body/div/div[2]/div/div/form/button")).click();
        library.sleep(2);
        String expectedResult = "Thank you for signing up. Click the button below to return to the home page.";
        String actualResult = driver.findElement(By.xpath("html/body/div/div[2]/div/div/h3")).getText();
        Assert.assertEquals(actualResult, expectedResult);

        library.sleep(2);
    }

    @Test
    public void negativeTest(){
        String expectedLink = driver.getCurrentUrl();
        driver.findElement(By.xpath(fullNameLocator)).sendKeys("Tom Smith");
        driver.findElement(By.xpath(emailLocator)).sendKeys("email");
        library.sleep(2);
        driver.findElement(By.xpath(signUpButton)).click();
        library.sleep(2);
        String actualLink = driver.getCurrentUrl();



    }

    @AfterMethod  // it will run after every @Test
    public void tearDown(){
    driver.close();


    }


}
