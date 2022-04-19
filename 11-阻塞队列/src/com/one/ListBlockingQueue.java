package com.one;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: LinkedListBlockingQueue
 * @Description: 使用链表实现阻塞队列
 * @Author: one
 * @Date: 2022/03/25
 */
public class ListBlockingQueue<E> {
    /**
     * 使用链表存储数据
     */
    private final LinkedList<E> list =  new LinkedList<>();

    /**
     * ReentrantLock锁对象
     */
    private final ReentrantLock LOCK = new ReentrantLock();



    private int capacity;

    public ListBlockingQueue(int capacity) {
        this.capacity = capacity;
        Condition condition = LOCK.newCondition();
    }

    public void enqueue(E element) {

    };
}
