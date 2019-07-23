package com.example.demo.demo.controller;


public class NodeTest {
    public static void main(String[] args) {
        add("1");
        add("2");
        System.out.println();
    }
    private static String result = "";
    private static Node head;
    private static void add(String data){
        if(null == data){
            head = new Node();
            result = head.data;
        }else{
            Node temp = head;
            while (head.next !=  null){
                temp = temp.next;
            }
            temp.next = new Node();
        }
    }

    public static class Node {
        public String data;
        public Node next;
        public Node(){
            this.data =data;
        }
    }
}
