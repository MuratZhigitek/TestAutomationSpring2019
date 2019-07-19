package com.day13_actions;

import com.day4.library;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionClassTests {

 WebDriver driver;

 //simple hover example with images
 String user1TextLocater = "//a[@href='/users/1']/preceding-sibling::h5";
 String firstImageLocator = "(//img)[1]";

 // hover over actions
 String enableOptionalLocator = "ui-id-3";
 String downloadsOptionalLocator = "ui-id-4";
 String pdfOptionalLocator = "ui-id-5";

 //drag and drop website
 String moonLocator = "draggable";
 String earthLocator = "droptarget";


 @BeforeMethod
 public void setUp(){

     WebDriverManager.chromedriver().setup();
     driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

 }
@Test
 public void hoverTest1(){
        driver.get("http://practice.cybertekschool.com/hovers");

        Actions action = new Actions(driver);
//        action.moveToElement(driver.findElement(By.xpath(firstImageLocator))).perform();
//        String expectedText = "name: user1";
//        String actualText =  driver.findElement(By.xpath(user1TextLocater)).getText();
//         Assert.assertEquals(actualText, expectedText);
//        library.sleep(3);

    List<WebElement> images =  driver.findElements(By.tagName("img"));
    for(WebElement image : images) {
        library.sleep(1);
        action.moveToElement(image).perform();

    }
    }

    @Test
    public void hoverTest2(){

    driver.get("http://practice.cybertekschool.com/jqueryui/menu");
    Actions action = new Actions (driver);

    WebElement element = driver.findElement(By.id(enableOptionalLocator));
    WebElement downloadelement1 = driver.findElement(By.id(downloadsOptionalLocator));
    WebElement pdfelement2 = driver.findElement(By.id(pdfOptionalLocator));

    action.moveToElement(element).pause(1000).moveToElement(downloadelement1).pause(1000).moveToElement(pdfelement2).build().perform();
 }
@Test
 public void dragAndDropTest1(){

     driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

     Actions action = new Actions(driver);
     WebElement moon = driver.findElement(By.id(moonLocator));
     WebElement earth = driver.findElement(By.id(earthLocator));
     action.dragAndDrop(moon, earth).perform();
     String expectedMessage = "You did great!";
     String actualMessage = earth.getText();
     Assert.assertEquals(actualMessage, expectedMessage);
     library.sleep(3);
 }

 @AfterMethod
    public void teardown(){
     driver.close();
 }
}
