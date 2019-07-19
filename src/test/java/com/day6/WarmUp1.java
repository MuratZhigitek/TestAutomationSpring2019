package com.day6;

import com.Utlities.BrowserFactory;
import com.day4.library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WarmUp1 {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {

        //warmUp1();
        warmUp2();


    }
        public static void warmUp1(){
            driver.manage().window().maximize();

            driver.get("https://amazon.com");
            driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Java Book");
            driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input")).click();

            String title = driver.getTitle();
            if(title.contains("Java Book")){
                System.out.println("Passed");
            }else{
                System.out.println("Failed");
            }

            library.sleep(2);
            driver.close();
        }

        public static void warmUp2(){

        driver.manage().window().maximize();
        driver.get("https://www.wikipedia.org/");

        driver.findElement(By.name("search")).sendKeys("selenium webdriver");
        driver.findElement(By.xpath("//*[@id=\"search-form\"]/fieldset/button/i")).click();

            driver.findElement(By.linkText("Selenium (software)")).click();

            String titleE= driver.getCurrentUrl();

            if (titleE.endsWith("x")) {
                System.out.print("Passed");
            } else
                System.out.print("Failed");


            driver.quit();
        }


}
