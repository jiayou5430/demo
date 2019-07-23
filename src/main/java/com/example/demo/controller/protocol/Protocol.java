package com.example.demo.controller.protocol;

import java.io.IOException;
import java.io.OutputStream;

public class Protocol {

    public static  final String DOLLAR_BYTE = "$";
    public static  final String STARRT_BYTE = "*";
    public static  final String BLANK_STRING = "\r\n";

    /**
     * 组装数据
     */
    public static  void  sendCommand(OutputStream os, Command command,byte[] ... args){
        StringBuilder sb = new StringBuilder();
        sb.append(STARRT_BYTE).append(args.length+1).append(BLANK_STRING);
        sb.append(DOLLAR_BYTE).append(command.name().length()).append(BLANK_STRING);
        sb.append(command.name()).append(BLANK_STRING);
        for (final byte[] bb : args){
            sb.append(DOLLAR_BYTE).append(bb.length).append(BLANK_STRING);
            sb.append(new String(bb)).append(BLANK_STRING);
        }
        try {
            System.out.println(sb.toString());
            os.write(sb.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public  static  enum Command{
        GET,SET,KEYS
    }
}
