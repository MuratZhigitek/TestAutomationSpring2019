package com.day5;

import com.Utlities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LocatorClassName {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com");

        List<WebElement> name = driver.findElements(By.className("list-group-item"));
        System.out.println(name.size());

        for(WebElement names : name){
            System.out.println(names.getText());
        }
    driver.close();

    }
}
