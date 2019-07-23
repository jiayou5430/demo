package com.example.demo.controller;

import com.example.demo.bean.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class test {
    public static void main(String[] args) {
        ExecutorService executorService =  Executors.newFixedThreadPool(1);
        for (int i = 0 ; i <1000;i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("----------");
                }
            });
        }
        try {
            executorService.shutdown();
            executorService.awaitTermination(1, TimeUnit.DAYS);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
