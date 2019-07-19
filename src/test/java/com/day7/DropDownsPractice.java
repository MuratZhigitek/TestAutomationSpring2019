package com.day7;

import com.Utlities.BrowserFactory;
import com.Utlities.SeleniumUtils;
import com.Utlities.verifyDisplayed;
import com.day4.library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownsPractice {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {

        test1();
       // testSelect();
//test2();
        //test3();
        test4();
        library.sleep(2);
        driver.close();

    }

    public static void test1() {

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");

        String expected = "Dropdown List";

        WebElement element = driver.findElement(By.xpath("//h3[text()='Dropdown List']"));


        if (element.isDisplayed()) {
            System.out.println("Passed");
            System.out.println(element.getText() + " is visible");
        } else {
            System.out.println("Failed");
            System.out.println(element.getText() + " is not visible");

            library.sleep(2);

        }

    }
    public static void testSelect() {

        WebElement dropdown1 = driver.findElement(By.id("dropdown"));
        //to work with select elements, we need to use Select class
        // do not forget to pass web element of that dropdown that you found into constructor
        Select dropDown = new Select(dropdown1);

        //since dropdown consists of options
        // we can check which one is selected
        // getFirstSelectedOption() return web element, use getText() method if you want to get a text of this option, Usually
        //text is visible part of dropdown. Value or attributes of drop down, not visible

        String actual = dropDown.getFirstSelectedOption().getText();
        String expected = "Please select an option";
        SeleniumUtils.verifyEquals(expected, actual);

        List<WebElement> options = dropDown.getOptions();

        for (WebElement option : options) {
            System.out.println(option.getText());

        }
    }
        public static void test2(){

            WebElement dropDownState = driver.findElement(By.id("state"));

            Select dropDownSelect = new Select(dropDownState);

            List<WebElement> states = dropDownSelect.getOptions();
            for (WebElement stateList : states) {

                System.out.println(stateList.getText());
            }

            dropDownSelect.selectByVisibleText("Texas");
            library.sleep(1);
            dropDownSelect.selectByVisibleText("Virginia");
        }

    public static void  test3(){
        WebElement dropDownState = driver.findElement(By.id("state"));

        Select dropDownSelect = new Select(dropDownState);

        List<WebElement> states = dropDownSelect.getOptions();
        for (WebElement stateList : states) {

            library.sleep(1);
            dropDownSelect.selectByVisibleText(stateList.getText());
        }

    }

        public static void test4(){

            WebElement dropdownState = driver.findElement(By.id("state"));
            Select dropDownSelect = new Select(dropdownState);

            dropDownSelect.selectByValue("PA");
            library.sleep(2);
        }
    }
