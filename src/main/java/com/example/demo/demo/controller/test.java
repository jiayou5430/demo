package com.example.demo.demo.controller;

import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        Map a = new HashMap();
      a.put("1","liuc");
        String oldv = (String) a.put("1","liuc1");
        System.out.println(a.get("1"));
        System.out.println(oldv);
    }
}
