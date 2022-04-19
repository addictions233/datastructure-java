package com.Test;

import com.blockqueue.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @ClassName: BlockQueueTest
 * @Description: 测试使用JDK自带的
 * @Author: one
 * @Date: 2021/03/10
 */
public class BlockQueueTest {
    public static void main(String[] args) throws InterruptedException {
        // 定义阻塞队列对象
        ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);
        // 开启新线程让阻塞队列中的数据出队列
        new Thread() {
            @Override
            public void run() {
                while(true) {
                    try {
                        Integer data = blockingQueue.take(); // 如果队列中的数据为空,take()方法会阻塞
                        System.out.println("消费的数据:" + data);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        // 使用主线程向阻塞队列中添加数据
        addDataToBlockingQueue(blockingQueue);
    }

    private static void addDataToBlockingQueue(ArrayBlockingQueue<Integer> blockingQueue) {
        // 向阻塞队列中添加100条数据
        for (int i = 0; i < 100; i++) {
            try {
                blockingQueue.put(i); // 如果队列已满,就进入阻塞状态
                System.out.println("生产的数据:" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
