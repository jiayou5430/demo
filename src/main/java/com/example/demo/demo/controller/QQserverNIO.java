package com.example.demo.demo.controller;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

public class QQserverNIO {
    public static void main(String[] args) {
        List<SocketChannel> list = new ArrayList<SocketChannel>();
        ByteBuffer bytes = ByteBuffer.allocate(512);
        try {
            ServerSocketChannel serverSocketChannel  = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(8080));
            serverSocketChannel.configureBlocking(false);
            while (true){
                for (SocketChannel channel : list){
                    int num = channel.read(bytes);
                    if (num > 0){
                        System.out.println("我要开始打印了");
                        Buffer a =  bytes.flip();
                        a.toString();
                        System.out.println(a);
                    }
                }
                System.out.println("wait conn");
                SocketChannel socketChannel = serverSocketChannel.accept();
                if(socketChannel == null){
                    Thread.sleep(3500);
                    System.out.println("no conn");
                }else{
                    System.out.println("conn -------->");
                    socketChannel.configureBlocking(false);
                    list.add(socketChannel);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
