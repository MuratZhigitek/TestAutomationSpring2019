package com.Utlities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SeleniumUtils {

    /*

    this code verifies if both results are equal
     */
    public static void verifyEquals(String expectedResult, String actualResult){

        if(expectedResult.equals(actualResult)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
            System.out.println("Expected result: " + expectedResult);
            System.out.println("Actual resulg: " + actualResult);
        }

    }

    public static void openPage(String page, WebDriver driver){
    // with this tag, we will find all examples on the home page
        List<WebElement>listofExamples = driver.findElements(By.tagName("a"));
        for(WebElement example : listofExamples){
            if(example.getText().contains(page)){
                example.click();
                break;
            }
        }
    }

}
