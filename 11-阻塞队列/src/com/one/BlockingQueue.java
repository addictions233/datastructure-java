package com.one;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: BlockingQueue
 * @Description: Java 5 开始出现存在 java.util.concurrent 包下，阻塞队列是一个队列，
 * 当尝试从队列中出队并且队列为空时，或者尝试将项目入队并且队列已满时，线程进入等待状态。
 * 尝试从空队列中出队的线程进入阻塞状态，直到其他线程将一个元素插入队列中为止,唤醒出队列的线程。
 * 尝试使一个元素进入完整队列时,线程被阻塞，直到某个其他线程在队列中腾出空间为止，方法是使一个或多个元素出队或完全清除队列。

 * @Author: one
 * @Date: 2021/03/10
 */
public class BlockingQueue<E>{
    /**
     * 采用双向链表实现阻塞队列
     */
    private List<E> queue = new LinkedList<>();
    /**
     * 阻塞队列的最大长度为10
     */
    private int limit = 10;

    /**
     * 构造函数
     * @param limit 阻塞队列的长度
     */
    public BlockingQueue(int limit){
        this.limit = limit;
    }

    /**
     * 进队列: 阻塞队列中的进队列和出队列都是加锁对象的,线程安全的
     * @param element
     * @throws InterruptedException
     */
    public synchronized void enqueue(E element) throws InterruptedException {
        // 当阻塞队列为满队列时, 入队列线程进入阻塞状态
        while (this.queue.size() == limit){
            // wait()方法和notify()方法必须是锁对象调用,这样锁对象才能起到监控的作用
            // 非静态同步方法的锁对象就是this对象
            this.wait();
        }
        // 当阻塞队列为空队列时,只有当size=0时,出队列enqueue线程才会进入等待状态,需要被唤醒
        if (this.queue.size() == 0){
            // 唤醒所有等待的线程
            this.notifyAll();
        }
        // 元素入队列,同步代码块的锁资源时是在代码块全部执行完了之后才释放的
        this.queue.add(element);
    }

    /**
     * 出队列
     * @return
     */
    public synchronized E dequeue() throws InterruptedException {
        // 当队列为空时, 出队列被阻塞
        while(this.queue.size() == 0){
            this.wait();
        }
        // 当阻塞队列为满队列时,入队列线程是进入等待状态的,需要唤醒所有的入队列线程
        if(this.queue.size() == this.limit){
            this.notifyAll();
        }
        // 元素出队列,锁资源是在代码块执行结束之后释放的
        return this.queue.remove(0);
    }

    public List<E> getQueue() {
        return queue;
    }
}
