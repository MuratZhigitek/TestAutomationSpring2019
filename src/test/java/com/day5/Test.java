package com.day5;

import com.cbt.utilities.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class Test {


    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.ebay.com");

        driver.findElement(By.id("gh-ac")).sendKeys("java book", Keys.ENTER);
        //driver.findElement(By.id("gh-btn")).click();

       String results = driver.findElement(By.className("srp-controls_count-heading")).getText();

        System.out.println(results);

    }
}
