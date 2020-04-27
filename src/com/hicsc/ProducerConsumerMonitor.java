package com.hicsc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ProducerConsumerMonitor {
    private final int capacity;
    // 1.一把锁
    Lock mutex = new ReentrantLock();
    // 2.共享数据
    List<Integer> data;
    // 3.条件变量
    // 条件变量：队列不满
    final Condition notFull = mutex.newCondition();
    // 条件变量：队列不空
    final Condition notEmpty = mutex.newCondition();

    // 4.初始化
    public ProducerConsumerMonitor(int capacity) {
        this.data = new ArrayList<>(capacity);
        this.capacity = capacity;
    }

    // 5.对外方法
    public void procedure(int item) throws InterruptedException {
        mutex.lock();
        try {
            while (data.size() == capacity) {
                notFull.await();
            }
            data.add(item);
            // 入队后,通知可出队
            notEmpty.signal();
        } finally {
            mutex.unlock();
        }
    }

    public int comsumer() throws InterruptedException {
        mutex.lock();
        try {
            while (data.isEmpty()) {
                notEmpty.await();
            }
            int result = data.get(0);
            data.remove(0);
            // 入队后,通知可出队
            notFull.signal();
            return result;
        } finally {
            mutex.unlock();
        }
    }
}