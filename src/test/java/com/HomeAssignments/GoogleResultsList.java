package com.HomeAssignments;

import com.Utlities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleResultsList {

    static WebDriver driver = BrowserFactory.getDriver("chrome");


    public static void main(String[] args) {

        javaSearch();

        jUnitSearch();

        restAssured();

    }

    public static void openBrowser(){

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("http://google.com");

    }

    public static void javaSearch(){

        openBrowser();
        driver.findElement(By.name("q")).sendKeys("Java");
        driver.findElement(By.name("btnK")).click();

        String firstUrl = driver.findElement(By.className("iUh30")).getText();
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div[1]/a/div/cite")).click();
        String secondUrl = driver.getCurrentUrl();

        if(secondUrl.equals(firstUrl)){
            System.out.println("Similar URLs");
            System.out.println("First URL: " + firstUrl);
            System.out.println("Second URL: " + secondUrl);
        }else{
            System.out.println("Different URLs");
            System.out.println("First URL: " + firstUrl);
            System.out.println("Second URL: " + secondUrl);
        }
        driver.navigate().back();
        driver.findElement(By.name("q")).clear();

      //  driver.close();
    }

public static void jUnitSearch(){


   // openBrowser();
    driver.findElement(By.name("q")).sendKeys("JUnit");
    driver.findElement(By.className("Tg7LZd")).click();

    String firstUrl = driver.findElement(By.className("iUh30")).getText();
    driver.findElement(By.partialLinkText("https://junit.org/junit5")).click();
    String secondUrl = driver.getCurrentUrl();

    if(secondUrl.equals(firstUrl)){
        System.out.println("JUnit's URLs are Similar");
        System.out.println("JUnit's First URL: " + firstUrl);
        System.out.println("JUnit's Second URL: " + secondUrl);
    }else{
        System.out.println("Different URLs");
        System.out.println("JUnit's First URL: " + firstUrl);
        System.out.println("JUnit's Second URL: " + secondUrl);
    }
    driver.navigate().back();
    driver.findElement(By.name("q")).clear();
//driver.quit();
}

public static void restAssured(){

        driver.findElement(By.name("q")).sendKeys("REST Assured");
        driver.findElement(By.className("Tg7LZd")).click();
        String firstUrl = driver.findElement(By.className("iUh30")).getText();
    driver.findElement(By.className("LC20lb")).click();
    String secondUrl = driver.getCurrentUrl();

    if(secondUrl.equals(firstUrl)){
        System.out.println("REST Assured URLs are Similar");
        System.out.println("REST Assured First URL: " + firstUrl);
        System.out.println("REST Assured Second URL: " + secondUrl);
    }else{
        System.out.println("Different URLs");
        System.out.println("REST Assured First URL: " + firstUrl);
        System.out.println("REST Assured Second URL: " + secondUrl);
    }
    driver.navigate().back();
    driver.findElement(By.name("q")).clear();
    driver.quit();
}
}
