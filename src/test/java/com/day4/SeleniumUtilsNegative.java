package com.day4;


import com.Utlities.SeleniumUtils;

public class SeleniumUtilsNegative {

    public static void verifyEquals(String expectedResult, String actualResult){


            if (!expectedResult.equals(actualResult)) {
                System.out.println("Passed");
            } else {
                System.out.println("Failed");
                System.out.println("Expected Result " + expectedResult);
                System.out.println("Actual Result " + actualResult);
            }

        }
    }

