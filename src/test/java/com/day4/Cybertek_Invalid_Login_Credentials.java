package com.day4;

import com.Utlities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cybertek_Invalid_Login_Credentials {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");
        Thread.sleep(1000);
        driver.findElement(By.name("username")).sendKeys("smithtom");

        driver.findElement(By.name("password")).sendKeys("NotSecretPassword");
        Thread.sleep(1000);
        driver.findElementByXPath("//*[@id=\"wooden_spoon\"]").click();
        Thread.sleep(1000);

        //String actualResult = driver.
        SeleniumUtilsNegative.verifyEquals("Not Loggin in", "Not logged in");

        Thread.sleep(2000);
        driver.close();
    }

}
