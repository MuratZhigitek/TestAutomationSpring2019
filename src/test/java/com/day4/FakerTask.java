package com.day4;

import com.github.javafaker.Faker;

public class FakerTask {

    public static void main(String[] args) {
        Faker faker = new Faker();
        String str = faker.chuckNorris().fact();
        System.out.println(str);


    }



}
