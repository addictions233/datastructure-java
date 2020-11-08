package com.mj;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

import com.mj.printer.BinaryTreeInfo;


/**
 * 	二叉搜索树的代码实现
 * @author one
 *
 */
public class BinarySearchTree<E> implements BinaryTreeInfo { // 实现BinaryTreeInfo是为了能够打印二叉搜索树
	/**
	 * 	分析: BinarySearchTree<E extends Comparable<? super E>>
	 *     泛型为什么可以这么写?
	 *        1, BinarySearchTree集合中元素必须具备可比较性,所以类型变量E extends Comparable没有问题
	 *        2, Comparable接口的类型变量要怎么写?
	 *        	    假如: 此处的类型变量E在创建BinarySearchTree对象时初始化为了Employee,已知: Manager extends Employee
	 *        	    那么 BinarySearchTree<Employee>集合因为多态特点必定是可以存储 Manager元素的,那么CompareTo()方法
	 *        	    在调用时就成可能出现以下四种情况:
	 *        	    manager.compareTo(manager), manager.compareTo(employee)
	 *        	    employee.compareTo(manager),employee.compareTo(employee)  
	 *        3,所以Comparable接口的类型变量必须能接受二叉搜索树的类型变量E及其子类类型对象
	 *          直接写成 E extends Comparable<E>和 E extends Comparable<? extends E>都是可以的
	 */
	
	/**
	 * 	二叉搜索树和线性表一样必须有一个 size属性,表示存储的元素个数
	 */
	private int size;
	
	/**
	 * 	二叉搜索树必须有一个根节点root,类似于如链表中头节点head,没有该节点就不知道后面的所有节点
	 */
	private Node<E> root;
	
	/**
	 * 声明一个比较器对象,用来接收创建BinarySearchTree对象传递进行的比较器
	 */
	private Comparator<E> comparator;
	
	/**
	 * BinarySearchTree的不带比较器的无参构造构造方法
	 * 当创建该类对象时不需要对其成员变量进行初始化,即使用成员变量的默认初始化值,就用无参构造
	 */
	public BinarySearchTree(){
		super();
	}
	/**
	 * 	BinarySearchTree的带比较器的有参构造方法
	 *  有参构造方法就是为了在创建对象时对对象成员变量进行初始化
	 */
	public BinarySearchTree(Comparator<E> comparator) {
		super();
		this.comparator = comparator;
	}
	
	/**
	 * 	二叉搜索树和链表一样也是由一个个节点组成,每个节点中包含element,left,right,parent四个属性
	 * 	element: 节点存储的元素值, left: 它的左子节点地址值,right: 它的右子节点地址值 parent:它的父节点地址值
	 *  将节点属性封装在内部类中Node当中
	 */
	private static class Node<E>{
		E element;
		Node<E> left;
		Node<E> right;
		@SuppressWarnings("unused")
		Node<E> parent;
		/**
		 * 构造方法: 只用初始化element和parent两个属性就行,因为节点都是一个一个添加的,当添加给新的节点时,它的左子节点和
		 * 右子节点都没有确定,所以不用初始化left和right属性,但是它的位置会按照二叉搜索树的排序规则确定,所以它的父节点是确定
		 * 的,所以可以初始化parent属性
		 */
		public Node(E element,Node<E> parent) {
			this.element = element;
			this.parent = parent;	
		}
	}
	/**
	 * 	获取二叉搜索树中的元素个数
	 */
	public int size() {
		return size;
	}
	
	/**
	 * 判断二叉搜索树是否为空
	 */
	public boolean isEmpty() {
		return size==0;
		
	}
	
	/**
	 * 将二叉树中的元素清空
	 */
	public void clear() {
		
	}
	/**
	 * 向二叉搜索树中添加元素
	 * 		向集合中添加元素一定要考虑边界特殊情况
	 */
	public void add(E element) {
		//因为二叉搜索树中不能存储null元素,所以每次添加元素之前都必须进行非空校验
		elementNotNullCheck(element);
		
		//判断根节点是否为空,如果根节点为空,添加根节点
		if(root == null) {
			root = new Node<>(element, null);
			size++;
			return;
		}
		Node<E> node = root; // 拿到根节点
		/*
		 * 定义一个局部变量parent用来存储新添加的节点的父类节点地址
		 * 考虑到变量的作用域,add()方法的parent变量可以和内部类 class Node<E>中成员变量parent同名
		 */
		Node<E> parent = root; 
		// 定义二叉搜索树的两个元素的比较值
		int comp = 0;
		/*
		 * 	重点: 常规添加元素, 二叉搜索树能够实现元素添加的功能是基于该树中存储的元素能够比较大小,
		 *  自己定义一个 compareTo(E element1,E element2)方法来比较两个元素大小
		 */
		while(node != null) {
				parent = node;
			    comp = compare(element, node.element);
				if(comp>0) {
					node = node.right;
				} else if(comp<0) {
					node = node.left;
				} else { // 表示两个元素相等,值相等情况下的处理可以自己定义
					node.element = element;  // 当值相等时就用新值覆盖旧的值
					return;
				}
		}
		/**
		 * 	创建新的节点对象需要其parent节点地址作为构造函数实参传递, 还要让其parent节点的left或者right成员变量指向自己
		 */
		Node<E> newNode = new Node<>(element, parent);
		if(comp>0) {
			parent.right = newNode;
		}  else {   //这里直接用else的原因,经过前面的判断这里的comp肯定不会是0
			parent.left = newNode;
		}
		size++;
		
	}
	/**
	 * 代码重点部分:
	 * 定义一个比较方法compare(),如果该方法返回值大于0,表示element1大于element2 ,如果小于0,表示element1 小于element2,如果等于0,表示两个元素相等
	 * 	二叉查找树必须存储可比较的元素,有两种比较方法:
	 * 		第一种: 元素所属的类实现Comparable接口,即元素自带可比较方法
	 * 		第二种: 创建BinarySearchTree对象时,传递给该对象一个比较器用来存储没有实现Comparable接口的
	 * @param element1
	 * @param element2
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private int compare(E element1,E element2) {
		if(comparator != null) {   //如果创建BinarySearchTree对象时传入了比较器,优先使用比较器对象进行比较
			return comparator.compare(element1, element2);
		} else {
			/*
			 * 当BinarySearchTree对象没有比较器时,对元素进行强转Comparable,如果该元素没有实现Comparable接口
			 * 就会报出类型转换异常,如果实现了Comparable接口,就可以调用CompareTo方法
			 */
			return ((Comparable<E>)element1).compareTo(element2);
		}
		
	}
	
	/**
	 * 前序遍历二叉搜索树:  
	 * 		按照根节点,左子树,右子树的顺序遍历 用到递归的方法
	 */
	public void preorderTraversal(Visitor<E> visitor) { //带访问器
		if(visitor == null) return;
		preorderTraversal(root,visitor);
	}
	
	/**
	 * 递归遍历方法
	 * 		递归三要素: 1,方法有形参 2,方法内部调用方法本身,但方法有出口 3,传递给方法的实参在不断朝出口方向变化
	 */
	private void preorderTraversal(Node<E> node,Visitor<E> visitor) { //实参node 在不断朝node == null 变化
		if(node == null || visitor.stop) return; // 方法的出口
//		System.out.println(node.element);
		visitor.stop = visitor.visit(node.element);
		preorderTraversal(node.left,visitor); //调用方法本身
		preorderTraversal(node.right,visitor); //调用方法本身
	}
	
	
	/**
	 * 中序遍历二叉搜索树: 按照左子树,根节点,右子树的顺序遍历
	 * 		中序遍历方法的特点: 也是按照元素值从小到大的顺序遍历
	 */
	public void inorderTraversal(Visitor<E> visitor) { //带访问器
		if(visitor == null) return;
		inorderTraversal(root,visitor);
	}
	private  void inorderTraversal(Node<E> node,Visitor<E> visitor) { //为什么要写两个方法,递归方法必须带形参,可以没有返回值
		if(node == null || visitor.stop) return; //递归方法出口
		inorderTraversal(node.left,visitor);
//		System.out.println(node.element);
		if(visitor.stop) return;
	    visitor.stop = visitor.visit(node.element);  
		/* 当判定变量stop为false时,遍历继续进行,当变量stop为true时,遍历停止
		 * stop定义的位置: 当遍历到需要的元素时,stop变为true之后,所以的递归方法都应该返回,即所有的递归方法里的变量stop都应为true
		 * 那么变量stop必定不能定义为方法里面的局部变量,如果变量stop定义为类BinarySearchTree里面的成员变量,那么三种遍历前序,中序
		 * 后续都需要分别定义一个stop成员变量比较复杂,一种更取巧的做法是将变量stop定义为类Visitor的成员变量,将Visitor由接口转换为抽象类
		 * 因为传递给每个递归方法的visitor对象都是同一个相同对象.
		 */
		inorderTraversal(node.right,visitor);
	}
	
	/**
	 * 后序遍历二叉搜索树: 按照左子树,右子树,根节点的顺序遍历
	 */
	public void postorderTraversal(Visitor<E> visitor) {  //带访问器
		if(visitor == null) return;
		postorderTraversal(root,visitor);
	}
	public void postorderTraversal(Node<E> node,Visitor<E> visitor) {
		if(node == null || visitor.stop) return;
		postorderTraversal(node.left,visitor);
		postorderTraversal(node.right,visitor);
//		System.out.println(node.element);
		if(visitor.stop)return;
		visitor.stop = visitor.visit(node.element);
	}

	
	/**
	 * 层序遍历二叉搜索树,即是从上到下,从左到右依次取出每个元素, 按照遍历顺序将元素打印在控制台
     * 层序遍历需要用到队列 Queue
	 */
	public void levelOrderTraversal() {
		//进行根节点的非空校验
		if(root == null) return;
		
		/*
		 * java当中的链表LinkedList实现了队列Queue接口
		 */
		Queue<Node<E>> queue  = new LinkedList<>();
		//先想队列中添加根节点
		queue.offer(root);
		//然后当队列不为空时,每个节点不断出队
		while(!queue.isEmpty()) {
			Node<E> node = queue.poll(); // 节点出队列
			System.out.println(node.element);
			if(node.left != null) queue.offer(node.left);
			if(node.right != null) queue.offer(node.right);
		}
		
	}
	/**
	 * 用带访问器Visitor<E>的方法层序遍历二叉搜索树,并用visit(E e)方法对元素进行操作
	 * @param visitor
	 */
	public void levelorderTraversal(Visitor<E> visitor) {
        if(root == null || visitor == null) return;
		Queue<Node<E>> queue  = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			Node<E> node = queue.poll();
//			System.out.println(node.element); //不再是将元素进行简单的输出打印
			/*
			 * 调用访问器接口Visit<E>中的方法 visit(E e)对元素进行操作
			 */
			boolean flag = visitor.visit(node.element);
			/*
			 * 如果遍历到了想要的元素就将方法返回,停止遍历
			 */
			if(flag) return;
			if(node.left != null) queue.offer(node.left);
			if(node.right != null) queue.offer(node.right);
		}
		
	}
	
	/**
	 * 回调接口
	 * @author one
	 * @param <E>
	 */
//	public static interface Visitor<E>{
//		boolean visit(E element);
//	}
	
	public static abstract class Visitor<E>{
		boolean stop;
		public abstract boolean visit(E element);
	}
	
	/**
	 * 获取一个节点的前驱节点 
	 * 			前驱节点定义: 一个节点中序遍历时它的前面一个节点
	 */
	private Node<E> predcessor(Node<E> node){
		if(node == null) return null;
		if(node.left != null) {
			node = node.left;
			while(node.right != null) {
				node = node.right;
			}
			return node;
		}
		while(node.parent!=null && node.parent.left==node) {
			node = node.parent;
		}
		return node.parent;
	}
	/**
	 *  获取一个节点的后继节点
	 *  		后继节点定义: 一个节点中序遍历时它的后面的一个节点
	 */
	private Node<E> successor(Node<E> node){
		if(node == null) return null;
		if(node.right!= null) {
			node = node.right;
			while(node.left!=null) {
				node = node.left;
			}
			return node;
		} else {
			while(node.parent!=null && node==node.parent.right) {
				node = node.parent;
			}
			return node.parent;
		}
	}
	
	/**
	 * 	将二叉搜索树中指定元素删除
	 */
	public void remove(E element) {
		remove(node(element));
	}
	/**
	 *  获取存储指定元素的节点
	 */
	private Node<E> node(E element){
		if(element == null) return null;
		Node<E> node = root;
		while(node != null) {
			int comp = compare(element, node.element);
			if(comp == 0) {
				return node;
			} else if(comp > 0) {
				node = node.right;
			} else {
				node = node.left;
			}
		} 
		return null;
	}
	/**
	 * 删除二叉搜索树中指定节点node
	 */
	private void remove(Node<E> node) {
		if(node == null) return;
		size--;
		if(hasTwoChildern(node)) {  // 需要删除的节点度为2
			/*
			 * 度为2的节点一定有前驱或者后继节点
			 * 且前驱和后者后继节点的度一定为0或者1
			 * 因为度为2的节点的后继或者前驱节点一定在自己的子树中
			 */
			Node<E> successor = successor(node);
			node.element = successor.element;  //将其后继节点的元素值覆盖在该节点的元素值
			node = successor;  //然后将其后继节点删除
		}
		/*
		 * 统一成了删除一个度为0或者1的node节点
		 */
		Node<E> replacement = node.left!=null?node.left:node.right;
		if(replacement == null) { //要删除的节点度为0
			if(node.parent == null) {  //要删除的节点为根节点root 
				root = null;
			}else {  //普通度为0的节点
				if(node.parent.left == node) {
					node.parent.left = null;
				} else {
					node.parent.right = null;
				}
			}
		}else {   //要删除的节点度为1,且其子节点为 replacement
			if(node.parent == null) {  //要删除的节点为根节点
				root = replacement;
				replacement.parent = null;
			} else {  //普通度为1的节点
				if(node.parent.left == node) {
					node.parent.left = replacement;
					replacement.parent = node.parent;
				} else {
					node.parent.right = replacement;
					replacement.parent = node.parent;
				}
			}
		}	
	}
	/**
	 *  判断一个节点是否度为2的节点,如果是返回true
	 */
	private boolean hasTwoChildern(Node<E> node) {
		boolean flag = false;
		if(node == null) return flag;
		if(node.left!=null && node.right!=null) {
			flag = true;
		}
		return flag;
	}
	
	/**
	 *  二叉树是不允许存储null元素的,所以添加元素必须进行非空校验
	 * 	定义 elementNotNullCheck()方法进行非空校验
	 *  @param element
	 */
	private void elementNotNullCheck(E element) {
		if(element == null) {
			throw new IllegalArgumentException("element can't be null");
		} 
	}
	
	/**
	 * 获取根节点
	 */
	public Node<E> getRoot(){
		return root;
	}
	
	/**
	 * 以下四个方法是实现BinaryTreeInfo接口后重写的抽象方法
	 * 目的是为了在控制台能够打印二叉树
	 */
	@Override
	public Object root() {
		return root;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Object left(Object node) {
		return ((Node<E>)node).left;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Object right(Object node) {
		return ((Node<E>)node).right;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Object string(Object node) {
		Node<E> node2 = (Node<E>)node;
		if(node2.parent == null) {
			return node2.element+"_ pa:null";
		} else {
			return node2.element+"_ pa:"+node2.parent.element;
		}
		
	}

}
