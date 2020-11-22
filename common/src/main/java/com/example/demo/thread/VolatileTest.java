package com.example.demo.thread;

import java.util.concurrent.TimeUnit;

public class VolatileTest {
    public static void main(String[] args) {
        final MyData myData = new MyData();
        // 开启一个新的线程
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "开始了...");
            try{
                TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
            // 在子线程中修改了变量的信息  修改的本线程在工作内存中的数据
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "更新后的数据是："+myData.number);
        },"BBB").start();
        // 因为在其他线程中修改的信息主线程的工作内存中的数据并没有改变所以此时number还是为0
        while(myData.number == 0){
            // 会一直卡在此处
            //System.out.println("1111");
        }
        System.out.println(Thread.currentThread().getName()+"\t number =  " + myData.number);
    }
}

class MyData {
    //int number = 0;
    volatile int number = 0;
    public void addTo60() {
        this.number = 60;
    }
}
