package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        ChromeDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement obj;
        driver.findElement(By.id("full_name")).sendKeys("alatoo");
        driver.findElement(By.name("email")).sendKeys("alatoo@gmail.com");
        driver.findElement(By.name("submit")).click();

    }
}
