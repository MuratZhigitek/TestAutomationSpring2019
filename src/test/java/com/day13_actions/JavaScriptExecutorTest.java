package com.day13_actions;

import com.day4.library;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutorTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    @Test
    public void jsExecutor(){
        driver.get("http://practice.cybertekschool.com/");
        // we want to run some JS code
        // for this, we have to use JSExecutor interface
        // since it is an interface, we cannot create an object
        // we just have to cast webdriver

       JavascriptExecutor js = (JavascriptExecutor)driver;
       //and then to execute script itself
        // we call execute Script method
        // executeScript return an object
       String title = (String) js.executeScript("return document.title");
       // or you can execute some script without any return
       js.executeScript("alert ('Hello Spartans!!!!')");
        library.sleep(3);

        Alert alert = driver.switchTo().alert();
        //Alert interface handles alerts
        // what is alerts?
        // it is a pop up window
        // we can use accept() to select Ok in the pop up
        alert.accept();
        System.out.println(title);


    }
    @Test
    public void scrollTest1(){

        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        for (int i = 0; i < 10; i++) {

            js.executeScript("window.scrollBy(0, 250)");
            library.sleep(1);
        }
    }

    @Test
    public void scrollTest2() {

        driver.get("http://practice.cybertekschool.com");
        WebElement footerLink =  driver.findElement(By.linkText("Cybertek School"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        library.sleep(2);
        js.executeScript("arguments[0].scrollIntoView(true)", footerLink);

        library.sleep(2);


    }
    @AfterMethod
    public void teardown(){

        driver.close();
    }
}
