package com.example.demo.thread.productAndConsumer;

import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;

public class Consumer extends Thread {
    private LinkedBlockingDeque<String> stringLinkedBlockingDeque;

    Consumer(LinkedBlockingDeque<String> stringLinkedBlockingDeque) {
        this.stringLinkedBlockingDeque = stringLinkedBlockingDeque;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            int nextInt = new Random().nextInt(10000);
            try {
                sleep(nextInt);
                String take = stringLinkedBlockingDeque.take();
                System.out.println(Thread.currentThread() + "消费者:" + take);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
