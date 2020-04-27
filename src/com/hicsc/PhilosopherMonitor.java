package com.hicsc;

import java.util.concurrent.Semaphore;

public class PhilosopherMonitor {
    // 2.共享数据
    boolean[] fork = new boolean[5];
    // 3.条件变量
    Semaphore[] conditions = new Semaphore[5];
    // 4.初始化代码
    public PhilosopherMonitor() {
        for (int i = 0; i < 5; i++) {
            conditions[i] = new Semaphore(1);
        }
    }
    // 5.对外方法
    /**
     * 第i位哲学家拿起筷子
     */
    void pickup(int i) throws InterruptedException {
        int left = i;
        int right = (i + 1) % 5;
        if (!fork[left]) {
            conditions[left].acquire();
        }
        fork[left] = false;
        if (!fork[right]) {
            conditions[right].acquire();
        }
        fork[right] = false;
    }

    /**
     * 第i位哲学家放下筷子
     */
    void putdown(int i) {
        int left = i;
        int right = (i + 1) % 5;
        if (conditions[left].tryAcquire()) {
            // 如果没有人等待这只筷子,则直接改变状态
            fork[left] = true;
        } else {
            // 有人等待这跟筷子，唤醒等待
            conditions[left].release();
        }
        if (conditions[right].tryAcquire()) {
            // 如果没有人等待这只筷子,则直接改变状态
            fork[right] = true;
        } else {
            // 有人等待这跟筷子，唤醒等待
            conditions[right].release();
        }
    }
}
