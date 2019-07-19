package com.day5;

import com.Utlities.BrowserFactory;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LocatorClassXPath {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
