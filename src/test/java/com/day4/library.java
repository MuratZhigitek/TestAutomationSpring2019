package com.day4;

public class library {

    public static void sleep(double s){

        try{
            Thread.sleep((long)s*1000);
        } catch (InterruptedException e){

        }



    }
}
