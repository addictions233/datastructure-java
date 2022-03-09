package com.one;

/**
 * @ClassName: BlockQueueTest
 * @Description: TODO
 * @Author: one
 * @Date: 2021/03/10
 */
public class BlockQueueTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue queue = new BlockingQueue(5);
        queue.enqueue("aaaa");
        queue.enqueue("bbbb");
        System.out.println("queue:"+queue.getQueue());
        System.out.println(queue.dequeue());
    }
}
