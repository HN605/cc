package com.example.demo.test;

/**
 * WaitSleepDemo
 */
public class WaitSleepDemo {

    public static void main(String[] args) {
        Object lock = new Object();

        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("Thread A is waiting to get lock");
                synchronized (lock) {
                    System.out.println("Thread A has got the lock");
                    try {
                        //Thread.sleep(1000);
                        lock.wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Thread A is done");
                }
            }

        }).start();

        try {
            Thread.sleep(20);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        new Thread(new Runnable(){
        
            @Override
            public void run() {
                System.out.println("Thread B is waiting to get lock");
                synchronized(lock) {
                    System.out.println("Thread B has got the lock");
                    try {
                        //lock.wait(1000);
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread B is done");
                }
            }
        }).start();
    }
}