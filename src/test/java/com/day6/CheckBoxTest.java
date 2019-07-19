package com.day6;

import com.Utlities.BrowserFactory;
import com.Utlities.SeleniumUtils;
import com.day4.library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class CheckBoxTest {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {

        test2();

    }

    public static void openCheckboxPage() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement checkBoxLogo = driver.findElement(By.tagName("h3"));
        if (checkBoxLogo.isDisplayed()) {
            System.out.println("Checkbox logo is visible");
        } else {
            System.out.println("Checkbox logo not found");
        }

    }

    public static void test1() {

        openCheckboxPage();

        WebElement box1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement box2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

        if (!box1.isSelected()) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        if (box2.isSelected()) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        driver.close();

    }

    public static void test2() {

        openCheckboxPage();

        WebElement box1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement box2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
       library.sleep(2);
        box1.click();//to select the check box
        box2.click();//to unselected, because by default it is selected

        if(box1.isSelected() && !box2.isSelected()){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
library.sleep(2);
    driver.close();

    }
}