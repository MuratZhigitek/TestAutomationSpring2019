package com.day4;

import com.Utlities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class VyTruckLogin {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeDriver driver = new ChromeDriver();
        driver.get("http://qa2.vytrack.com/user/login");

        Thread.sleep(1000);
        driver.findElement(By.name("_username")).sendKeys("user174");
        driver.findElement(By.name("_password")).sendKeys("UserUser123"); Thread.sleep(1000);
        driver.findElement(By.name("_submit")).click(); Thread.sleep(1000);
        driver.findElementByXPath("//*[@id=\"user-menu\"]/a").click(); Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"user-menu\"]/ul/li[4]/a")).click();


        SeleniumUtils.verifyEquals("Login Success", "Logged in");


        Thread.sleep(2000);
        driver.close();


    }


}
