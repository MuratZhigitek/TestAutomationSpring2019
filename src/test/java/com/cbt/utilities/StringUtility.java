package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

public class StringUtility {

    public static void verifyEquals(String expected, String actual){

        if(expected== actual){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

    }
}
