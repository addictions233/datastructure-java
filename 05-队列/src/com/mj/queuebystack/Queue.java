package com.mj.queuebystack;
/**
 * 	需求:
 * 		用栈 Stack来实现队列
 * 		分析: 通常情况下是用双向链表LinkedList来实现队列Queue,如果想用栈Stack来实现队列, 需要用到两个栈 Stack inStack和outStack来实现
 * @author one
 *
 */
public class Queue<E> {
	private Stack<E> inStack = new Stack<>();
	private Stack<E> outStack = new Stack<>();
	
	/**
	 * 	获取队列中存储的元素个数
	 */
	public int Size() {
		return inStack.size()+outStack.size();
	}
	
	/**
	 * 	判断队列是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return inStack.isEmpty() && outStack.isEmpty();
	}
	
	/**
	 * 	队列中有元素从队尾入队
	 */
	public void enQueue(E element){
		inStack.push(element);
	}
	
	/**
	 * 	队列中有元素从队头出队列
	 */
	public E deQueue() {
		if(outStack.isEmpty()) {
			while(!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
			
			return outStack.pop();
		} else {
			return outStack.pop();
		}
	}
	
	/**
	 * 	查看队列的队头元素
	 */
	public E front() {
		if(outStack.isEmpty()) {
			while(!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
			
			return outStack.top();
		} else {
			return outStack.top();
		}
	}
	

}
