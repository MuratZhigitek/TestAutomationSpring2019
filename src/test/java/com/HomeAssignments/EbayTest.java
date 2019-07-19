package com.HomeAssignments;

import com.Utlities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class EbayTest {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {

    ebayTest();
    }

    public static void ebayTest(){

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("wooden spoon");
        driver.findElement(By.id("gh-btn")).click();

        String results = driver.findElement(By.xpath("//*[@id=\"w4\"]/div[2]/div[1]/div[1]/h1")).getText();
        //System.out.println(results);

        String result1 = results.replaceAll(",","").substring(0,5);
        int resultOne = Integer.parseInt(result1);


        driver.findElement(By.linkText("All")).click();
        String results2 = driver.findElement(By.xpath("//*[@id=\"w4\"]/div[2]/div[1]/div[1]/h1")).getText();
       // System.out.println(results2);

        String result2 = results2.replaceAll(",", "").substring(0,5);
        int resultTwo=Integer.parseInt(result2);

        if(resultTwo>resultOne){
            System.out.println("Passed");
            System.out.println("Result of search 1: " + results);
            System.out.println("Result of All: " + result2);

        }else{
            System.out.println("Failed");
        }

        driver.navigate().back();

        String searchKeep = driver.findElement(By.id("gh-ac")).getAttribute("value");

        if(searchKeep.contains("wooden spoon")){
            System.out.println("Passed");
            System.out.println(searchKeep + " is displayed");
        }else{
            System.out.println("Failed");
            System.out.println("Empty");
        }
        driver.close();
    }
}
