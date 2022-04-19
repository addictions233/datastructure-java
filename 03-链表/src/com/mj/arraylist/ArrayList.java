package com.mj.arraylist;
/**
 * 	泛型动态数组的实现,在动态数组中存储引用数据类型元素
 */
import com.mj.list.List;

import java.util.Arrays;


public class ArrayList<E> implements List<E> {
	/**
	 * 	定义成员变量size ,用来表示数组集合中存储的元素个数
	 */
	private int size;
	
	/**
	 * 	定义一个成员变量数组,用来存储元素
	 */
	private E[] elements;
	
	/**
	 * 	自定义一个常量,用来对数组的长度进行初始化赋值
	 */
	private static int DEFAULT_CAPCITY = 10;
	
	/**
	 * 	自定义一个常量,如果查询元素时没有找到就将该常量返回
	 */
	private static int ELEMENT_NOT_FOUND = -1;
		
	/**
	 *	构造函数
	 *	1,有参构造函数通常会对成员变量进行初始化赋值
	 *	2,由于成员变量size默认初始化值为0,刚开始数组中存储的元素个数为0,所以可以不用显性初始化,
	 *	3,只需要定义成员变量 elements[]数组进行初始化就好了,而数组的初始化就是指定数组长度
	 */
	public ArrayList(int capacity) {
		capacity = capacity > DEFAULT_CAPCITY ? capacity : DEFAULT_CAPCITY;
		//下面这样写会报错 : Cannot create a generic array of E (不能创建一个泛型数组)
//		elements = new E[capacity];  // 没有泛型数组
		elements = (E[]) new Object[capacity];  // 创建一个Object类型数组,然后再对数组向下转型
	}
	
	/**
	 * 	空参构造一样得对数组进行初始化长度赋值, 可以直接用this调用有参构造
	 */
	public ArrayList() {
		this(DEFAULT_CAPCITY);  
	}
	
	/**
	 *	将数组中的元素清空
	 */
	@Override
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null; 
		}
		size = 0;
	}
	
	/**
	 *	获取数组中存储的元素个数
	 */
	@Override
	public int size() {
		return size;
	}
	
	/**
	 * 	判断集合是否为空
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * 	判断集合中是否包含该元素
	 */
	@Override
	public boolean contains(E element) {
		return indexOf(element) != ELEMENT_NOT_FOUND;
	}
	
	/**
	 * 	在数组的末尾添加元素
	 */
	@Override
	public void add(E element) {
		add(size,element);  //直接调用带索引参数的add方法
		
	}
	
	/**
	 * 	在指定索引位置添加元素
	 * 	注意: 添加和删除元素一定要注意特殊情况,如果只考虑一般情况代码可能有错误
	 * 	例如: 
	 * 		1,当index = 0或者 size-1 即首尾两端添加元素的情况
	 * 		2,当数组为空或者只有一个元素时再添加元素的情况
	 * 		3,当数组为满数组时再添加一个元素的情况
	 */
	@Override
	public void add(int index, E element) {
		rangeCheckForAdd(index);  //对索引index进行检查
		ensureCapacity();   //对数组容量进行检查
		for (int i = size-1; i >= index; i--) {
			//注意数组elements的索引范围是0到length-1 
			elements[i+1] = elements[i];
		}
		elements[index] = element;
		size++;
	}
	
	/**
	 * 	将索引index位置的元素删除,将被删除的元素返回,并将后面的元素向前移动
	 */
	@Override
	public E remove(int index) {
		rangeCheck(index); //对索引index进行检查
		E oldElement = elements[index];
		for (int i = index; i < size-1; i++) {
			elements[i] = elements[i+1];
		}
		size--;
		elements[size] = null;
		return oldElement;
	}
	
	/**
	 * 	获取 索引index处的元素
	 */
	@Override
	public E get(int index) {
		rangeCheck(index);
		return elements[index];
	}
	
	/**
	 * 将索引index处的元素改为element,并将原有的元素返回
	 */
	@Override
	public E set(int index, E element) {
		rangeCheck(index);
		E oldElement = elements[index];
		elements[index] = element;
		return oldElement;
	}
	
	/**
	 * 	查找元素element在数组中的索引值,并将索引值返回
	 * 	如果数组中没有该元素就将常量 ELEMENT_NOT_FOUND返回
	 */
	@Override
	public int indexOf(E element) {
		//遍历数组
		// 假如动态数组设计功能可以存储 null 元素
		if(element == null) {
			for (int i = 0; i < elements.length; i++) {
				if( elements[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (element.equals(elements[i]))
					return i;  //如果数组中包含了该元素,那么这里的return语句就执行了,方法就结束了,后面的return语句就不会执行
			}
		}
		
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(element))
				return i;  //如果数组中包含了该元素,那么这里的return语句就执行了,方法就结束了,后面的return语句就不会执行
		}
		return ELEMENT_NOT_FOUND;  
	}
	
	/**
	 * 	保持代码的健壮性,由于索引index是 int 类型,但数组的索引只能是[0,size-1]的整数,对于 remove get set等
	 * 	方法的index,输入不在正确范围的index就存在索引越界异常,所以得对形参中传递进来的index值进行检查
	 */
	private void rangeCheck(int index) {  //用不用定义成 static类型? 没必要
		if(index < 0 || index > size-1) {
			throw new ArrayIndexOutOfBoundsException("索引index="+index+"超出了size-1="+(size-1)+"的范围");
		}
	}
	
	/**
	 * 	对于添加元素来说,即调用add(int index,E elements),可以在数组末尾进行添加,所有该方法中的index可以是size
	 * 	即数组的最末尾元素的后面一个位置
	 */
	private void rangeCheckForAdd(int index) {
		if ( index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException("索引index="+index+"超出了size="+size+"的范围");
		}
	}
	
	/**
	 * 	动态数组的核心就在动态扩容, 当数组容量不够用时,就将数组容量扩大1.5倍
	 * 	只有在添加元素时才会用到更多的数组容量,所以只需要在add方法中判断容量是否够用
	 *	如果容量够用就保持不变,如果容量不够用就将容量扩大到1.5部,下面写扩容方法
	 */
	private void ensureCapacity() {
		if(elements.length>=size+1) {
			return;
		} else {
			int oldCapacity = elements.length;
			int newCapacity = oldCapacity + (oldCapacity>>1);
			E[] newElements = (E[])new Object[newCapacity];
			//将旧的数组中元素拷贝到新数组中
	 		//方法1:遍历旧数组将元素逐个拷贝到新数组
			/*
			 * for (int i = 0; i < elements.length; i++) { newElements[i] = elements[i]; }
			 */
			
			/*
			 * 	方法2:用数组工具类 Arrays类中的copyOf(E[] array,int length) 
			 * 			第一个参数是需要被拷贝的数组,第二参数是新数组的长度
			 */
			newElements = Arrays.copyOf(elements, newCapacity);
			//将成员变量elements指向新的数组,旧的数组由于没有被栈变量指向就会被jvm垃圾回收
			elements = newElements;
			System.out.println("数组容量由"+oldCapacity+"变成了新的容量"+newCapacity);
		}
	}
	//重写toString方法,方便将ArrayList打印输出
	// 也可以用数组工具 Arrays的 toString()方法
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(); 
		for (int i = 0; i < size; i++) {
			sb.append(elements[i].toString()).append("  ");
		}
		return sb.toString();
	}
	

}
