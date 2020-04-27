package com.hicsc;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PhilosopherTest {

    public static PhilosopherMonitor monitor = new PhilosopherMonitor();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Philosopher(i)).start();
        }
    }

    static class Philosopher implements Runnable {

        private int index;

        public Philosopher(int i) {
            this.index = i;
        }

        /**
         * 模拟哲学家的动作,不停的思考->拿起筷子->吃饭->放下筷子
         */
        @Override
        public void run() {
            try {
                while (true) {
                    thinking();
                    monitor.pickup(index);
                    System.out.println("哲学家" + index + "开始进餐");
                    eating();
                    monitor.putdown(index);
                    System.out.println("哲学家" + index + "放下筷子");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        /**
         * 模拟吃饭，占用一段时间资源
         */
        public void eating() {
            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /**
         * 模拟思考，占用一段时间资源
         */
        public void thinking() {
            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
