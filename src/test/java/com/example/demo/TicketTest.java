package com.example.demo;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketTest {
     private static Integer coun1t1=100;
     private Lock lock = new ReentrantLock();
    @Test
    public void  ticketTest() throws  Exception{
        TicketTestRunable tr = new TicketTestRunable();
        Thread t1 = new Thread(tr,"窗口A");
        Thread t2 = new Thread(tr,"窗口B");
        Thread t3 = new Thread(tr,"窗口C");
        Thread t4 = new Thread(tr,"窗口D");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        Thread.currentThread().join();
    }
    public class TicketTestRunable implements Runnable{
        @Override
        public void run() {
            while (coun1t1>0){
                lock.lock();
                try {
                    if (coun1t1>0){
                        System.out.println(Thread.currentThread().getName()+"售出第"+(coun1t1--)+"张票");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }


                try {
                    Thread.sleep(200);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }
    }
}
