package com.example.demo.controller;

import redis.clients.jedis.Jedis;
import com.example.demo.controller.client.Client;

public class redisTest {
    public static void main(String[] args) {
        Client jedis = new Client("127.0.0.1",6379);
        String aa =  jedis.set("7788", "oic");
      //  jedis.del("7788");
        System.out.println(jedis.get("7788"));
    }
}
