package com.mj.arraylist;

/**
 * 	由于动态数组和链表有很多相同的方法,例如 add,remove,clear,indexOf等
 * 	但是他们两个类这些方法的实现方式完全不同,所用将这些方法抽取为一个接口
 * 	让他们两个去实现这个接口,也就必须重写这些方法,即必须提供这些功能供外界使用
 */
public interface List<E> { 
	/**
	 *	 清除所有的元素
	 */
	void clear();
	
	/**
	 * 	返回数组中存储的元素个数
	 */
	int size();
	
	/**
	 * 	判断集合是否为空
	 */
	boolean isEmpty();
	
	/**
	 * 是否包含某个元素
	 */
	boolean contains( E element);
	
	/**
	 * 	在集合中添加添加元素
	 */
	void add(E element);
	
	/**
	 * 	在集合指定索引位置添加元素
	 */
	void add(int index, E element);
	
	/**
	 *	 删除集合中的某个元素,并将该元素返回
	 */
	E remove(int index);
	
	/**
	 * 	查询某个索引处的元素
	 */
	E get(int index);
	
	/**
	 * 	将某个索引位置的元素改成给定的元素,并将旧的元素返回
	 */
	E set(int index , E element);
	
	/**
	 * 	查询某个元素在集合中的索引值
	 */
	int indexOf(E element);
}
