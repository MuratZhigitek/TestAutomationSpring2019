package com.cbt.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

    public static WebDriver getDriver(String browser){

        if(browser.equals("chrome")){

            return new ChromeDriver();
        }else if(browser.equals("firefox")){
            return new FirefoxDriver();
        }else if(browser.equals("safari")) {
            return new SafariDriver();
        }else{
            return null;

        }
    }
}
