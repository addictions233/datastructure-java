package com.mj.queue;

import com.mj.linkedlist.*;
/**
 * 	最好用双向链表LinkedList而不是动态数组来实现队列Queue
 * 		注意:  队列的对头是链表的first , 队列的队尾是链表的last
 * @author one
 *
 * @param <E>
 */
public class Queue<E> {
	private List<E> list = new LinkedList<E>(); 
	
	/**
	 * 	返回队列中存储的元素个数
	 */
	public int size() {
		return list.size();
	}
	
	/**
	 * 	判断队列是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	/**
	 * 	队尾有元素入队列
	 */
	public void enQueue(E element) {
		list.add(element);
	}
	
	/**
	 * 	队头有元素出队列,并将该元素返回
	 */
	public E deQueue() {
		E element = list.remove(0);
		return element;
	}
	
	/**
	 * 	查询队列中的队头元素
	 */
	public E front() {
		return list.get(0);
	}

}
