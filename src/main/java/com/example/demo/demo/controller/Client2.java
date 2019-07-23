package com.example.demo.demo.controller;

import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) {
        try {
            //创建一个socket 绑定地址端口号
            Socket socket = new Socket("127.0.0.1", 8080);
            //console录入
            Scanner scanner = new Scanner(System.in);
            String txt = scanner.next();
            //获取socket的输出流 将打印内容写入
            socket.getOutputStream().write(txt.getBytes());
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
