package com.example.demo.test;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * CyclicBarrierTest
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable(){
        
            @Override
            public void run() {
                System.out.println("老司机发车！");
            }
        });

        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable(){
            
                @Override
                public void run() {
                    int time = random.nextInt(5);
                    System.out.println(Thread.currentThread().getName() + "开始出发");
                    try {
                        TimeUnit.SECONDS.sleep(time);
                        System.out.println(Thread.currentThread().getName() + "到达车站了" + "在路上耗时" + time + "秒");
                    cyclicBarrier.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }                   
                }
            }).start();
        }
    }
}