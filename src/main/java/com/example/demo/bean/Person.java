package com.example.demo.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class Person {

    @Value("${Person.name}")
    private String naem;

    @Value("#{10-1}")
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNaem() {
        return naem;
    }

    public void setNaem(String naem) {
        this.naem = naem;
    }

    public void Speak(String name){
        System.out.println("Hello! "+"My name is "+ name);
    }

}
