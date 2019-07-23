package com.example.demo.controller.client;

import com.example.demo.controller.connection.Connection;
import com.example.demo.controller.protocol.Protocol;

/**
 * 对外提供接口
 */
public class Client {

    Connection connection;

    public Client(String host,int port) {
        this.connection = new Connection(host,port);
    }

    public String set(String key, String value) {
        try {
            connection.sendCommand(Protocol.Command.SET,key.getBytes(),value.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  connection.getStatsCoedereply();
    }
    public String get(String key) {
        try {
            connection.sendCommand(Protocol.Command.GET,key.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  connection.getStatsCoedereply();
    }

}
