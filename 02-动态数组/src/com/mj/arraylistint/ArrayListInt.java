package com.mj.arraylistint;

/** 
 *	 动态数组,先在动态数组中存储基本数据类型数据
 * @author one
 *
 */
public class ArrayListInt {
	/**
	 * 	声明一个变量size用来表示动态数组存储的元素个数
	 */
	private int size;
	
	/**
	 * 	声明一个整型数组elements,不用对elements进行初始化,elements在ArrayList的构造方法中进行初始化
	 */
	private int[] elements;
	
	/**
	 *	自定义常量,用来表示初始化数组的长度,在这里定义数组初始化长度默认为10
	 * @param Capacity
	 */
	private static final int DEFAULT_CAPACITY = 10;
	
	/**
	 * 	定义一个常量,当无法查询到该元素在数组中对应的索引值时,返回该常量 -1,类似于立 flag和index
	 * @param capacity
	 */
	private static final int ELEMENT_NOT_FOUND = -1;
	
	/**
	 * 	动态数组的初始化只用指定数组的初始化长度就行了
	 * @param capacity
	 */
	//有参构造方法
	public ArrayListInt(int capacity) {
		capacity = capacity>DEFAULT_CAPACITY ? capacity:DEFAULT_CAPACITY;
		elements = new int[capacity];
		
	}
	//空参构造方法
	public ArrayListInt() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * clear方法,将动态数组中的元素清空
	 */
	public void clear() {
		size = 0;  //虽然没有实际清空数组中存储的元素,但从外部无法访问数组中的元素,相当于清空数组元素
	}
	
	/**
	 *	  获取数组中存储的元素个数
	 */
	public int size() {
		return size;
	}
	
	/**
	 * 	判断数组是否为空
	 */
	public boolean isEmpty() {
		return size==0;
	}
	
	/**
	 * 	判断是否包含该元素
	 */
	public boolean contains(int element) {
		return indexOf(element)!=ELEMENT_NOT_FOUND;
	}
	
	/**
	 * 	添加元素到动态数组的末尾
	 */
	public void add(int element) {
		add(size,element);
	}
	
	/**
	 *	 在索引index处添加元素element
	 */
	public void add(int index,int element) {
		rangeCheckForAdd(index);
		/*
		 * 	因为元素是一个一个添加,只要确保现有容量比size大于1,就能够添加元素
		 */
		ensureCapacity(size+1);
		
		for (int i = size-1; i >=index; i--) {
			elements[i+1] = elements[i];
		}
		elements[index] = element;
		size++;
	}
	
	/**
	 *	 获取索引index处的元素
	 */
	public int get(int index) {
		rangeCheck(index);
		return elements[index];
	}
	
	/**
	 * 	将索引index处的值改为给定,并返回索引处原子
	 */
	public int set(int index,int element) {
		rangeCheck(index);
		int oldElement = elements[index];
		elements[index] = element;
		return oldElement;
	}
	
	/**
	 * 	移除索引index处的元素,并将旧的值返回
	 */
	public int remove(int index) {
		rangeCheck(index);
		int oldElement = elements[index];
		for (int i = index; i < size-1; i++) {
			elements[i] = elements[i+1];
		}
		size--;
		return oldElement;
	}
	/**
	 * 	获取索引index处的元素
	 */
	public int indexOf(int element) {
		for (int i = 0; i < size; i++) {
			if(elements[i]==element) return i;
		}
		return ELEMENT_NOT_FOUND;
	}
				
	
	/**
	 * 	动态扩容的实现
	 * @param index
	 */
	private void ensureCapacity(int Capacity) {
		int oldCapacity = elements.length;
		if(oldCapacity >= Capacity) return;
		else {
			int newCapacity = oldCapacity+(oldCapacity>>1);
			int[] newElements = new int[newCapacity];
			for (int i = 0; i < size; i++) {
				newElements[i] = elements[i];
			}
			elements = newElements;
			System.out.println("容量由"+oldCapacity+"变成了"+newCapacity);
		}
	}
	private void outOfBounds(int index) {
		throw new IndexOutOfBoundsException("index="+index+"超出了size:"+size+"范围");
	}
	private void rangeCheck(int index) {
		if(index<0 ||index>size-1) {
			outOfBounds(index);
		}
	}
	private void rangeCheckForAdd(int index) {
		if(index<0 || index>size) {
			outOfBounds(index);
		}
	}
	/**
	 * 	写数组的toString方法
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("size=").append(size).append(",").append("[");
		for (int i = 0; i < size; i++) {
			if(i==0) {
				sb.append(elements[i]);
			} else {
				sb.append(",").append(elements[i]);
			}
			
		}
		sb.append("]");
		return sb.toString();
	}
	
}
