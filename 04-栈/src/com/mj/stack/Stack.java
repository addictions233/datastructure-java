package com.mj.stack;

import com.mj.list.*;

/**
 * 	定义一个数据结构 栈stack
 * @author one
 *
 * @param <E>
 */
public class Stack<E> /*extends ArrayList<E>*/{   //声明为泛型,可以存储多种数据类型
	/**
	 *  注意:直接用 Stack 继承 ArrayList有问题,就是 ArrayList的成员方法和成员变量,Stack类的对象都能够使用,
	 *  这样就违背了Stack数据结构的特性
	 *  所以不能用直接继承来ArrayList来实现 栈stack , 而是创建一个私有的List成员变量
	 */
	private List<E> list = new ArrayList<E>();
	
	/**
	 * 	判断栈中存储的元素个数
	 * @return
	 */
	public int size() { 
		return list.size();
	}
	
	/**
	 * 	判断栈是否为空
	 * @return
	 */
	public boolean isEmpty() {  
		return list.isEmpty();
	}

	/**
	 * 	元素压栈,在栈顶添加元素
	 * @param element
	 */
	public void push(E element) {
		list.add(element);
	}
	
	/**
	 * 元素弹栈,在栈顶删除元素,并将该元素返回
	 * @return
	 */
	public E pop() {
		return list.remove(size()-1);
	}
	
	/**
	 * 	查询栈顶的元素
	 * @return
	 */
	public E top() {
		return list.get(size()-1);
	}
}
