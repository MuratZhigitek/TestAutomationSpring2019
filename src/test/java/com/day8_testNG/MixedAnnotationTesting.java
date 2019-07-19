package com.day8_testNG;

import org.testng.annotations.*;

public class MixedAnnotationTesting {

    @BeforeClass
    public void beforeClass(){

        System.out.println("Before Class");
    }

    @BeforeMethod
    public void setUp(){

        System.out.println("Before method");
    }

    @Test
    public void test1(){

        System.out.println("I am test 1");
    }


    @AfterMethod
    public void tearDown(){

        System.out.println("After method");
    }
    @AfterClass
    public void afterClass(){

        System.out.println("After Class");
    }
}
