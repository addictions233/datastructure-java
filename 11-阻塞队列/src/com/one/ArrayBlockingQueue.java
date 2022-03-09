package com.one;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: BlockingQueue2
 * @Description: 使用数组实现阻塞队列
 * @Author: one
 * @Date: 2021/07/05
 */
public class ArrayBlockingQueue<E> {
    /**
     * 阻塞队列中最多存储的元素个数
     */
    private int limit;
    /**
     * 用动态数组来实现阻塞队列
     */
    private ArrayList<E> list = new ArrayList<>(limit);

    /**
     * ReentrantLock锁对象
     */
    private static final ReentrantLock LOCK = new ReentrantLock();

    /**
     * 构造方法
     *
     * @param limit 阻塞队里的长度
     */
    public ArrayBlockingQueue(int limit) {
        this.limit = limit;
    }

    /**
     * 元素入阻塞队列
     *
     * @param element 元素
     */
    public void put(E element) {
        LOCK.lock();
        try {
            while (list.size() == limit) {
                // 如果阻塞队列为满队列,则线程进入等待状态
                LOCK.wait();
            }
            if (list.size() == 0) {
                // 唤醒所有等待的线程,只用当size=0时,出队列线程才会进入等待状态,需要被唤醒
                LOCK.notifyAll();
            }
            list.add(element);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放锁资源必须在finally语句中执行
            LOCK.unlock();
        }
    }

    /**
     * 元素出队列
     * @return E
     */
    public E take() throws InterruptedException {
        LOCK.lock();
        try {
            while (list.size() == 0) {
                LOCK.wait();
            }
            // 当队列达到满队列时,入队列线程才会有进入等待状态,需要被唤醒
            if (list.size() == limit) {
                LOCK.notifyAll();
            }
            return list.remove(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放锁资源必须在finally语句中执行
            LOCK.unlock();
        }
        return null;
    }
}
