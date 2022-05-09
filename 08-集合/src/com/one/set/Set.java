package com.one.set;

/**
 * @author one
 * @param <E> 元素泛型
 */
public interface Set<E> {
	/**
	 * 获取集合元素个数
	 * @return int
	 */
	int size();

	/**
	 * 集合是否为空
	 * @return boolean
	 */
	boolean isEmpty();

	/**
	 * 清空集合
	 */
	void clear();

	/**
	 * 判断集合是否包含元素
	 * @param element 元素
	 * @return boolean
	 */
	boolean contains(E element);

	/**
	 * 添加元素
	 * @param element 元素
	 */
	void add(E element);

	/**
	 * 删除元素
	 * @param element 元素
	 */
	void remove(E element);

	/**
	 * 遍历集合
	 * @param visitor
	 */
	void traversal(Visitor<E> visitor);

	/**
	 * 遍历集合时传入的访问器
	 * @param <E> 元素泛型
	 */
	public static abstract class Visitor<E> {
		/**
		 * 停止遍历集合标识
		 */
		boolean stop;

		/**
		 * 遍历集合的方法
		 * @param element 元素
		 * @return boolean
		 */
		public abstract boolean visit(E element);
	}
}
