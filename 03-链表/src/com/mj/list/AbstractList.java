package com.mj.list;

/**
 * 	定义一List接口的抽象类,抽取 ArrayList类和 LinkedList类的共有方法
 * @author one
 *
 * @param <E>
 */
public abstract class AbstractList<E> implements List<E> {
	/**
	 * 	定义size成员变量
	 */
	private int size;
	
	/**
	 * 清除所有的元素
	 */
	public abstract void clear() ;
	
	/**
	 * 返回数组中存储的元素个数
	 */
	public int size() {
		return size;
	}
	
	/**
	 * 判断集合是否为空
	 */
	public boolean isEmpty() {
		return size==0;
	}
	
	/**
	 * 是否包含某个元素
	 */
	public abstract boolean contains( E element);
	
	/**
	 * 在集合中添加添加元素
	 */
	public abstract void add(E element);
	
	/**
	 * 在集合指定索引中添加元素
	 */
	public abstract void add(int index, E element);
	
	/**
	 * 删除集合中的某个元素
	 */
	public abstract E remove(int index);
	
	/**
	 * 获取某个索引处的元素
	 */
	public abstract E get(int index);
	
	/**
	 * 将某个索引的元素改成给定的元素,并将旧的元素返回
	 */
	public abstract E set(int index , E element);
	
	/**
	 * 查询某个元素在集合中的索引值
	 */
	public abstract int indexOf(E element);
}
