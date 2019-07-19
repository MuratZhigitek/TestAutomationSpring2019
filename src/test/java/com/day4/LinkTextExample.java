package com.day4;

import com.Utlities.BrowserFactory;
import com.Utlities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LinkTextExample {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {

        //test1();
        test2();
    }
    public static void test1(){

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://practice.cybertekschool.com");
        driver.findElement(By.linkText("A/B Testing")).click();
        library.sleep(2);
        SeleniumUtils.verifyEquals("Passed","Needs to visit the page");
        driver.close();

    }
    public static void test2(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://practice.cybertekschool.com");
        library.sleep(2);
        List<WebElement>links = driver.findElements(By.tagName("a"));

       // for(WebElement link : links){
        for(int i=1; i<links.size();i++){

            if(i==4) {
                continue;
            }
                links.get(i).click();
                library.sleep(1);
                driver.navigate().back();
                library.sleep(2);
                links = driver.findElements(By.tagName("a"));
                System.out.println(links.get(i).getText());



        }
        driver.close();

    }
}
