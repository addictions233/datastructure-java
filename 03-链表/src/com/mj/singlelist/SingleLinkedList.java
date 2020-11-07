package com.mj.singlelist;
import com.mj.list.List;
/**
 *	动态数组有个明显的缺点,就是当数组添加一个元素进行1.5倍扩容时,新增加的存储空间有很多都没有使用,这样就造成了存储
 * 	空间的极大浪费,我们希望使用多少空间就申请多少空间,而不造成内存空间的浪费,这样我们就使用链表的数据结构还存储元素
 *	链表操作的时间复杂度肯定高于数组,当比数组的空间复杂度要低
 *  @author one
 *
 */
public class SingleLinkedList<E> implements List<E> { // LikedList和Node类的泛型应该和存储的element元素类型相同
	/**
	 * 	 链表中同样需要定义一个成员变量size,用来表示链表中存储的元素的个数,这个与动态数组相同
	 */
	private int size;

	/**
	 *  LinkList中还需要一个成员变量:首节点 firstNode,firstNode变量中存储第一个节点的地址值,没有首节点就没有找到后面的节点,
	 * 	节点对象作为成员变量,即一个引用数据类型,其实引用数据类型的成员变量用的最多, 像 String name 就是一个引用数据类型的成员变量
	 */
	private Node<E> first;
	
	/**
	 *	定义一个常量用来表示查询元素对应索引值时没有找到该元素时将该值返回
	 */
	private static final int ELEMENT_NOT_FOUND = -1;
	
	/**
	 * 	链表是通过节点来寻找下一个元素,节点可以看成是一个容器,节点容器中存储了本节点需要存储的元素和下一个节点的地址值,一个节点
	 * 	只能找到它后面紧跟着的节点,找不到其他的节点,我们把节点也看成一个对象,这样就需要定义节点类 Node ,Node类得定义成LinkList
	 * 	类的内部类,他有两个成员变量,一个指向链表中存储的元素,一个指向下一个节点Node<E>
	 */
	private static class Node<E> { // 内部类定义为静态的,由于需要存储各种类型的元素所用用泛型
		/**
		 * 	定义成员变量element, 表示节点中需要存储的元素,用泛型表示数据类型.链表的用途就是存储元素的嘛,所以肯定要定义该成员变量
		 * 	由于Node内部类声明为private , 所以它的成员变量就不用添加访问修饰符
		 */
		E element;

		/**
		 * 	定义成员变量 nextNode用来存储它自己的下一个Node节点的地址值,这样每个Node节点中都存储它的下一个Node节点的地址值, 就可以
		 */
		Node<E> next;
		
		/**
		 * 	定义Node<E>类的有参构造器
		 */
		public Node(E element, Node<E> next) {
			super();
			this.element = element;
			this.next = next;
		}

	}
	
	/**
	 * 	定义一个方法用来将指定索引index位置的Node对象返回  
	 * 		注意: 和  E get(int index)方法区分, get方法返回的是对应索引位置的元素element ,本方法返回的是对应索引的节点Node
	 * 			  由于节点对象是封装的不可见的,而元素element是可供外界访问的,所以获取Node节点的方法声明为private 
	 */
	private Node<E> node (int index){
		rangeCheck(index); //索引检查
		
		Node<E> node = first;  //必须拿到首节点firstNode才能拿到下一个节点
		for(int i=0 ; i<index ; i++) {
			/**
			 * 	这一句代码是链表查询的精髓所在
			 */
			node = node.next;
		}
		
		/**
		 * 	用递归来实现对index索引处的Node节点对象的查询,递归如何实现?????????
		 */
		/*
		 * Node<E> node2 = getNode(index); getNode(1) = for (int i = index; i >0 ; i--)
		 * { getNode(index) = getNode(index-1).nextNode; }
		 */
		 
		return node;
	}

	/**
	 * 	将链表中的元素清空
	 */
	@Override
	public void clear() {
		size =0;
		/*	
		 * 	将成员变量firstNode变量赋值为null,这样就没有变量指向第一个Node对象,这样Node对象就会被
		 *	 销毁,紧接着后面的Node对象都会被销毁
		 */
		first = null;
		
	}
	
	/**
	 * 	返回链表中存储的元素个数
	 */
	@Override
	public int size() {
		return size;
	}
	
	/**
	 * 	判断链表是否为空
	 */
	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public boolean contains(E element) {
		return indexOf(element) != ELEMENT_NOT_FOUND;
	}
	
	/**
	 * 	向链表的末尾添加元素
	 */
	@Override
	public void add(E element) {
		add(size,element);

	}

	/**
	 * 	向链表指定索引index的位置添加元素element
	 * 	添加一个新的节点Node对象只需要三步:
	 * 		1,创建一个新的节点Node对象,用来存储需要添加的元素
	 * 		2,将新节点所在索引index位置的上一个节点的成员变量nextNode指向新节点
	 * 		3,让新节点自己的成员变量nextNode指向它所在索引位置的原先的旧节点Node
	 */
	@Override
	public void add(int index, E element) {
		rangeCheckForAdd(index);
		/*
		 *	由于在添加节点Node时,得将新节点所在索引位置的上一个节点的成员变量nextNode指向它,
		 *	特殊情况当index=0,即首节点添加元素时,就没有上一个节点,这样就得单独讨论
		 */
		if(index == 0) {
			first = new Node<E>(element,first);
		} else {
			
		Node<E> prev = node(index-1);
		/*
		 * 	添加一个元素element, 肯定要创建一个Node节点对象,构造器中传入的参数:
		 * 	element即需要添加的元素, 而nextNode即在该索引上的原来的Node节点对象
		 */
		prev.next = new Node<E>(element,prev.next);
		}
		size++;
	}
	
	/**
	 *	删除指定索引位置的元素,并将该元素返回
	 *		1,就是删除该索引位置的节点,即将索引位置的节点的上一个节点的成员变量nextNode指向它
	 *		的下一个节点对象,这样就没有变量指向该节点本身,这样该节点就会被销毁
	 */
	@Override
	  public E remove(int index) { 
		E element = node(index).element;
		if(index == 0) {
			first = node(index).next;
		} else {
			node(index-1).next = node(index).next;
		}
		size--;
		return element;
	  }
	
	/**
	 * 	返回索引对应位置的元素element
	 */
	@Override
	public E get(int index) {
		return node(index).element;
	}
	
	/**
	 * 	将对应索引 index位置的元素修改为element,并将旧的元素返回
	 */
	@Override
	public E set(int index, E element) {
		E oldElement = node(index).element;
		node(index).element = element;
		return oldElement;
	}

	@Override
	public int indexOf(E element) {
		//遍历链表
		Node<E> node = first;
		//定义一个计数器
		int count = 0;
		for (int i = 0; i < size; i++) {
			if(node.element.equals(element)) return count;
			else {
				node = node.next;
				count++;
			}
		}
		return ELEMENT_NOT_FOUND;
	}
	
	/**
	 * 	定义一个方法,抛出索引越界异常
	 */
	private void outOfBounds(int index) {
		throw new IndexOutOfBoundsException("输入的索引index:"+index+"超过了size:"+size+"范围");
	}
	
	/**
	 * 	对删除,更改,查询等方法中传递的形参index进行值检查,如果index不满足要求,抛出索引越界异常
	 * @param index
	 */
	private void rangeCheck(int index) {
		if(index < 0 || index > size-1) {
			outOfBounds(index);
		}
	}
	
	/**
	 * 	对添加元素 add方法传入的形参index的值进行检查
	 */
	private void rangeCheckForAdd(int index) {
		if(index < 0 || index > size) {
			outOfBounds(index);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<E> node = first;
		sb.append(node.element.toString()).append("\u0020\u0020");
		for (int i = 1; i < size; i++) {
			node = node.next;
			sb.append(node.element.toString()).append("\u0020\u0020");
		}
		return sb.toString();
	}
	
}