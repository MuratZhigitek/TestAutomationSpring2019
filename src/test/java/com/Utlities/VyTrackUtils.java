package com.Utlities;

import com.day4.library;
import com.google.common.collect.Multimaps;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class VyTrackUtils {
    //we dont want to access these var outside of class
   private static  String usernameLocator = "prependedInput";
   private static String passwordLocator = "prependedInput2";

    public static void login(WebDriver driver, String username, String password){
        driver.findElement(By.id(usernameLocator)).sendKeys(username);
        driver.findElement(By.id(passwordLocator)).sendKeys(password, Keys.ENTER);
        library.sleep(3);


    }

    public static void navigateToModule(WebDriver driver, String tab, String module) {

        String tabLocator = "//span[contains(text(),'" + tab + "') and contains(@class, 'title title-level-1')]";
        String moduleLocator = "//span[contains(text(),'" + module + "') and contains(@class, 'title title-level-2')]";
        driver.findElement(By.xpath(tabLocator)).click();
        library.sleep(2);
        driver.findElement(By.xpath(moduleLocator)).click();
        library.sleep(2);
    }
        public static void verifyEquals(String expectedResult, String actualResult){
            if(expectedResult.equals(actualResult)){
                System.out.println("Passed");
            }else{
                System.out.println("Failed");
                System.out.println("Expected result: "+expectedResult);
                System.out.println("Actual result: "+actualResult);
            }

    }

    public static void clickWithWait(WebDriver driver, By by, int attepmts){
         int counter = 0;
          while(counter<attepmts){
              try{
                  driver.findElement(by).click();

                  break;
              }catch (WebDriverException e){
                  System.out.println(e);
                  System.out.println("Attempt : " + ++counter);

                  library.sleep(1);
              }
          }

    }


}
