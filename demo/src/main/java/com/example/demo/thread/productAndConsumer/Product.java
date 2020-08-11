package com.example.demo.thread.productAndConsumer;

import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;

public class Product extends Thread {
    private LinkedBlockingDeque<String> stringLinkedBlockingDeque;

    Product(LinkedBlockingDeque<String> stringLinkedBlockingDeque) {
        this.stringLinkedBlockingDeque = stringLinkedBlockingDeque;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            int nextInt = new Random().nextInt(5000);
            try {
                stringLinkedBlockingDeque.put("物品" + i);
                System.out.println("生产者生产：" + i);
                sleep(nextInt);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
