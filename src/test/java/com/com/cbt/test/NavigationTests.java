package com.com.cbt.test;

import com.cbt.utilities.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class NavigationTests {

    public static void main(String[] args) throws Throwable {

        WebDriverManager.chromedriver().setup();
       ChromeDriver driver = new ChromeDriver();

        String url = "http://google.com";
        driver.get(url);
        String urlTitle = driver.getTitle();

        String url2 = "https://etsy.com";
        driver.navigate().to(url2);
        String urlTitle2 = driver.getTitle();

        driver.navigate().back();
        if(driver.getTitle().equals(urlTitle)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        driver.navigate().forward();
        if(driver.getTitle().equals(urlTitle2)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        Thread.sleep(3000);
        driver.close();


        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver1 = new FirefoxDriver();


        String url1 = "http://google.com";
        driver1.get(url1);
        String urlTitle1 = driver1.getTitle();

        String url3 = "https://etsy.com";
        driver1.navigate().to(url3);
        String urlTitle3 = driver1.getTitle();

        driver1.navigate().back();
        if(driver1.getTitle().equals(urlTitle1)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        driver1.navigate().forward();
        if(driver1.getTitle().equals(urlTitle3)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        Thread.sleep(3000);
        driver1.close();



        //WebDriver driver2 = new SafariDriver().
        SafariDriver driver3 = new SafariDriver();

        driver3.get("http://google.com");
        String urlTitle4 = driver3.getTitle();

        String url5 = "https://etsy.com";
        driver3.navigate().to(url5);
        String urlTitle5 = driver3.getTitle();

        driver3.navigate().back();
        if(driver3.getTitle().equals(urlTitle4)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        driver3.navigate().forward();
        if(driver3.getTitle().equals(urlTitle5)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        Thread.sleep(3000);
        driver.close();


    }

    }


