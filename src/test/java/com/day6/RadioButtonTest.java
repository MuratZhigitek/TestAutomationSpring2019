package com.day6;

import com.Utlities.BrowserFactory;
import com.day4.library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RadioButtonTest {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {

        openRadioButtonPage();
        test4();
//
//        library.sleep(1);
//        test2();

        library.sleep(2);
        driver.close();

    }

    public static void openRadioButtonPage(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/radio_buttons");

    }
    public static void test1(){
        WebElement bluebtn = driver.findElement(By.id("blue"));


        if(bluebtn.isSelected()){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

    }
    public static void test2(){
        WebElement blackbtn = driver.findElement(By.id("black"));
        WebElement greenbtn = driver.findElement(By.id("green"));

        if(blackbtn.isEnabled() && !greenbtn.isEnabled()){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

    }
    public static void test3(){
        driver.findElement(By.id("blue")).click();
        WebElement bluebtn = driver.findElement(By.id("blue"));


        if(bluebtn.isSelected()){
            System.out.println("Clicked");
        }else{
            System.out.println("Not Clicked");
        }
        library.sleep(1);

        driver.findElement(By.id("black")).click();
        WebElement blackbtn = driver.findElement(By.id("black"));

        if(blackbtn.isSelected()){
            System.out.println("Clicked");
        }else{
            System.out.println("Not Clicked");
        }
    library.sleep(1);
        driver.findElement(By.id("green")).click();
        WebElement greenbtn = driver.findElement(By.id("green"));


        if(!greenbtn.isEnabled()){
            System.out.println("Not Clicked!");
        }else{
            System.out.println("Clicked :(");
        }


    }

    //lets write a task that will makes sure only one radio button is selected
    public static void test4(){
        // step 1 lets find all radio buttons
        List<WebElement> listOFButtons = driver.findElements(By.xpath("//input[@type='radio']"));

        // lets create counter

        int counter =0; // to count how many selected radio buttons
        //we will go through the list of WebElements and check one by one which radio is selected
        // if radio button is selected, increase count

        for (WebElement radiobutton : listOFButtons){
            if(radiobutton.isSelected()){
                System.out.println(radiobutton.getAttribute("id"));
                counter++;
            }
        }
        System.out.println(counter);

    }

}
