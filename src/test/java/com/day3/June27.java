package com.day3;

import com.day4.library;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class June27 {

    public static void mains(){

        main( new String[]{"A"} );

    }

    public static void main( String[] args )  {

        //   System.setProperty("Webdrivername","path");

        WebDriverManager.chromedriver().setup();   // sets System properties

        WebDriver driver = new ChromeDriver();  // opens the browser
        // webdriver is an interface implemnted by chromedriver class


        driver.get("http://www.google.com");  // protocol must be provided
        // http : hypertext transfer protocol
        // https:  hypertext transfer protocol secure

        String  PageTitle = driver.getTitle();


        // expected condition: titile should contain "Google"


// verify title
        if(PageTitle.contains("Amazon")){

            System.out.println("Page titile is verified");

        } else{

            System.out.println("Page title is not verified");
            //  System.exit(0);
        }

        // new Actions(driver).pause(3000).perform();
//        try {
//            Thread.sleep(3000);    // Checked exceptions needs to be handled immidietly. because they occure during compile time
//        } catch (Exception e){
//
//        }

        library.sleep(3.5);

// manage window:

        // maximize window:
        driver.manage().window().maximize();

        library.sleep(2.5 );

        // fullscreen:
        driver.manage().window().fullscreen();

    // Navigate refresh, go back , go forward, open URL

        //refresh
        driver.navigate().refresh();

        library.sleep(2);

        //go back
        driver.navigate().back();
        library.sleep(2);

        //go forward
        driver.navigate().forward();
        library.sleep(2);

        //open a new website
        driver.navigate().to("http://walmart.com");


        String pageUrl = driver.getCurrentUrl();

        if(pageUrl.contains("www.amazon.com")){
            System.out.println("URL is verified");
        }else{
            System.err.println("URL is not verified");
            //System.exit(2); it exits from the testing


        }
        library.sleep(2);

    driver.navigate().back();


    /*
    differences between navigate().to() and get():
        get()- wait for webpage fully uploaded.
        navigate().to() doesnt need to wait, thus it is faster;

     */


        System.out.println("Test completed");


        //      method1();  // throws

        method2();   // try& catch
    /*
    driver.quit() also works to close the browser. However, the differences is it closes entire browser. where else, close() closes only a tab.
     */
    driver.close();
    }


    public static void method1() throws  Exception{


        Thread.sleep(1000);

    }

    public static void method2() {


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }

    }






}

