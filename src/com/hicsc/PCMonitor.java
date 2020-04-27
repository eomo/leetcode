package com.hicsc;

import java.util.Random;

public class PCMonitor {

    public static void main(String[] args) {
        final ProducerConsumerMonitor monitor = new ProducerConsumerMonitor(2);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                int item = new Random().nextInt(100);
                try {
                    monitor.procedure(item);
                    System.out.println("生产者生产：" + item);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    int item = monitor.comsumer();
                    System.out.println("消费者消费：" + item);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
