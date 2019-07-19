package com.day4;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

    public static void main(String[] args) throws Throwable {

        WebDriverManager.chromedriver().setup(); // set up webdriver, to avoid SystemsetProperty
        WebDriver driver = new ChromeDriver(); // create object or chromedriver
        driver.manage().window().maximize();// to maximize the browser
        driver.get("http://practice.cybertekschool.com/forgot_password"); // open url

        Faker faker = new Faker();


        WebElement emailInput = driver.findElement(By.name("email"));// found a box
       String name = faker.pokemon().name().replace(" ", "").toLowerCase();
       Thread.sleep(3000);

       emailInput.sendKeys(faker.internet().emailAddress());

       Thread.sleep(2000);
       emailInput.clear();

       emailInput.sendKeys(name+"@gmail.com"+ Keys.ENTER);
        //emailInput.sendKeys("email@gmail.com"+ Keys.ENTER);// entered a message

        Thread.sleep(2000);
//        WebElement submitButton = driver.findElement(By.id("form_submit"));// found a box button
//        submitButton.click(); // clicking the button
//        Thread.sleep(3000);

        WebElement confirmationMessage = driver.findElement(By.name("confirmation_message"));
        String expectedMessage = "Your e-mail's been sent!";
        String actualMessage = confirmationMessage.getText();// how to get the text element

        if(actualMessage.equals(expectedMessage)){
            System.out.println("Test Passed!!!");
            System.out.println("Good job, Welldone!!!");
        }else{
            System.out.println("Test failed :(");
            System.out.println("Expected message " + expectedMessage);
            System.out.println("Actual message " + actualMessage);
        }

        driver.close();
        //driver.quit();

    }
}
