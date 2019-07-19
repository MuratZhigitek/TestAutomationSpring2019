package com.day4;

import com.Utlities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class UdemyClass1 {

   static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.google.com/gmail/about/#");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

       // System.out.println( driver.getPageSource()); this allows to print source and find keys

//        driver.get("https://yahoo.com");
//        driver.navigate().back();
//        driver.navigate().forward();
        driver.findElement(By.linkText("Create an account")).click();

        driver.findElement(By.id("firstName")).sendKeys("Esad");

        driver.findElement(By.id("lastName")).sendKeys("Sadyk");

        driver.findElement(By.id("username")).sendKeys("esad12");

        driver.findElement(By.name("Passwd")).sendKeys("firstGmail19");

        driver.findElement(By.name("ConfirmPasswd")).sendKeys("firstGmail19");

        driver.findElement(By.xpath("//*[@id=\"accountDetailsNext\"]/span/span")).click();



        library.sleep(2);
        driver.quit();

    }
}
