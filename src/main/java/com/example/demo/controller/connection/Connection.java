package com.example.demo.controller.connection;

import com.example.demo.controller.protocol.Protocol;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 传输层
 */

public class Connection {
    private Socket socket;
    private String host;
    private int port;
    private OutputStream outputStream;
    private InputStream inputStream;

    public Connection(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Connection connection() {
        try {
            socket = new Socket(host, port);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    public  String getStatsCoedereply(){
        byte[] bytes = new byte[1024];
        try {
            socket.getInputStream().read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(bytes);
    }

    public  Connection sendCommand(Protocol.Command command, byte[] ... args){
        connection();
        Protocol.sendCommand(outputStream,command,args);
        return this;
    }

}