package com.example.demo.demo.controller;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class QQServer {
    public static void main(String[] args) {
        byte[] bytes = new byte[10204];
        try {
            //创建一个socket 服务
            ServerSocket serverSocket  = new ServerSocket();
            //绑定监听的 IP 和地址
            serverSocket.bind(new InetSocketAddress(8080));
            System.out.println("启动了吗");
            while (true){
                System.out.println("wait conn");
                //监听绑定的地址
                Socket socket = serverSocket.accept();
                //将监听到的socket的输入流读取成byte
                int num = socket.getInputStream().read(bytes);
                String  content = new String(bytes);
                System.out.println(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
