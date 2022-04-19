package com.mj.tree;

import com.mj.printer.BinaryTreeInfo;

import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author one
 * 复写一遍二叉搜索树
 */
public class BinarySearchTree2<E> implements BinaryTreeInfo {
	/**
	 * 	定义一个成员变量size, 表示二叉搜索树中存储元素个数
	 */
	private int size;
	
	/**
	 * 	定义一个根节点成员变量
	 */
	private Node<E> root;
	
	/**
	 * 定义比较器成员变量
	 */
	private Comparator<E> comparator;
	
	
	/**
	 * 	定义一个Node节点内部类,当内部类不访问外部成员时定定义为静态的
	 *  节点类不希望外部访问,所有用private修饰
	 */
	
	private static class Node<E>{
		/*
		 * 	四个成员变量, 节点存储元素,父节点,左子节点,右子节点
		 */
		E element;
		Node<E> parent;
		Node<E> left;
		Node<E> right;
		
		/*
		 * Node类的构造器
		 */
		public Node(E element,Node<E> parent){
			this.element = element;
			this.parent = parent;
		}
	}
	
	/**
	 * BinarySearchTree类的无参构造器
	 * 		无参构造,成员变量  size=0, root=null
	 */
	public BinarySearchTree2() {
		super();
	}
	/**
	 * BinarySearchTree类的有参构造器,构造方法中传入比较器对象
	 */
	public BinarySearchTree2(Comparator<E> comparator) {
		this.comparator = comparator;
	}
	
	
	/**
	 * 获取二叉搜索树存储的元素个数
	 */
	public int size() {
		return size;
	}
	
	/**
	 * 判断二叉搜索树中存储的元素是否为空
	 */
	public boolean isEmpty() {
		return size==0;
	}
	
	/**
	 * 将二叉搜索树中元素清空
	 */
	public void clear() {
		this.root = null;
	}
	
	/**
	 * 	 比较两个元素的大小,如果element1>element2 返回正数, 如果element1<element2 返回负数, 如果element1=element2 返回0;
	 */
	@SuppressWarnings("unchecked")
	private int compare(E element1,E element2) {
		if(comparator!=null) {  // 如果传入比较器,就用比较器进行元素比较
			return comparator.compare(element1, element2);
		} else {
			return ((Comparable<E>)element1).compareTo(element2);  // 如果比较器为空,就用compareTo()方法进行比较
		}
	}
	
	/**
	 * 	向二叉搜索树中添加元素
	 */
	@SuppressWarnings("unchecked")
	public void add(E element) {
		//二叉搜索树中不能存储null,进行元素非空校验
		elementNotNull(element);
		
		//添加元素首先要判断根节点root是否为空,如果为空就对root节点进行初始化赋值
		if(root==null) {
			root = new Node<E>(element,null);
			size++;
			return;
		}
		
		//root节点不为空的情况
		Node<E> node = root;  //循环的中间节点变量
		Node<E> parent = root; //存储添加元素的节点的父节点
		int result=0;  // 存储每次比较值的结果(正,负,0)
		while(node!=null) {
			parent = node;
			result = compare(element, node.element);
			if(result>0) {
				node = node.right;
			}else if(result<0) {
				node = node.left;
			} else {  // 当两个元素相等的情况,新的元素覆盖旧元素,这样也能实现修改功能
				node.element = element;
				return;
			}
		}
		Node<E> newNode = new Node<E>(element, parent);
		if(result>0) {
			parent.right = newNode;
		}else{
			parent.left=newNode;
		}
		size++;
	}
	
	/**
	 * 前序遍历 : 递归实现
	 */
	public void preorderTraversal(){
		preorderTraversal(root);
	}
	private void preorderTraversal(Node<E> node) {
		if(node == null) return;
		System.out.println(node.element);
		preorderTraversal(node.left);
		preorderTraversal(node.right);
	}
	
	/**
	 * 层序遍历: 利用队列Queue, 迭代实现
	 */
	public void levelOrderTraversal() {
		LinkedList<Node<E>> list = new LinkedList<Node<E>>();
		list.offer(root);
		while(!list.isEmpty()) {
			Node<E> node = list.poll();
			System.out.println(node.element);
			if(node.left!=null) {
				list.offer(node.left);
			}
			if(node.right!=null) {
				list.offer(node.right);
			}
		}
		
	}
	
	/**
	 * 	获取一个节点的前驱节点:
	 * 		前驱节点定义: 中序遍历时(二叉搜索树元素从小到大排列),一个节点的前一个节点
	 */
	private Node<E> predecessor(Node<E> node){
		if(node==null) { return null; }
		if(node.left != null) {
			node = node.left;  
			while(node.right != null) {  //在左子树中找最大值
				node = node.right;
			}
			return node;
		} else {
			while(node.parent != null && node.parent.left==node ) {
				node = node.parent;
			} 
			return node.parent;	
		}	
	}
	/**
	 * 获取一个节点的后驱节点:
	 * 			后驱节点定义: 中序遍历时(二叉搜索树元素从小到大排列),一个节点的后一个节点
	 */
	private Node<E> successor(Node<E> node){
		if(node == null) return null;
		if(node.right != null) {
			node = node.right;
			while(node.left != null) {
				node = node.left;
			}
			return node;
		}
		while(node.parent != null && node.parent.right==node) {
			node = node.parent;
		}
		return node.parent;
	}

	
	/**
	 *  删除二叉搜索树中的指定元素
	 */
	public void remove(E element) {
		/*
		 * 删除二叉搜索树中的元素就得删除存储该元素的节点
		 * 第一步先找到存储该元素的节点,再将该节点删除
		 */
		remove(	getNode(element));
	}
	
	/**
	 * 根据给定的元素值element,获取存储该元素的节点node
	 */
	private Node<E> getNode(E element){
		if(element == null) return null;
		Node<E> node = root;
		int result;
		while(node != null) {
			result = compare(element, node.element);
			if(result == 0) {
				return node;
			} else if(result > 0) {
				node = node.right;
			} else {
				node = node.left;
			}
		}
		return null;
		
	}
	/**
	 * 删除二叉树的节点
	 */
	private void remove(Node<E> node) {
		if(node == null) return;  // 当需要删除的节点为null
		size--;
		if(hasTwoChildern(node)) { // 当需要删除的节点度为2
			/*
			 * 度为2的节点一定有前驱节点或者后继节点
			 * 且前驱后或者后继节点的度肯定是0或者1
			 */
			Node<E> successor = successor(node);
			node.element = successor.element;
			/*
			 * 将successor存储的节点地址值传递给node,这样原本要删除变量successor
			 * 指向的节点,现在变成了变量node指向的节点
			 */
			node = successor;  						
		}	
		Node<E>  replacement = node.left!=null?node.left:node.right;   //很重要,减少代码判断量
		if(replacement != null) {   //表明node节点度为1,且replacement为node节点的子节点
			if(node.parent == null) {
				root = replacement;
				replacement.parent = null;
			} else {
				 if(node.parent.left == node) {
					 node.parent.left = replacement;
					 replacement.parent = node.parent;
				 } else {
					 node.parent.right = replacement;
					 replacement.parent = node.parent;
				 }
				
			}
		} else {  //表明node节点度为0,为叶子节点
			if(node.parent == null) { //该叶子节点为根节点情况
				 root = null;   
			 } else { //普通叶子节点情况
				 if(node.parent.left == node) {
					 node.parent.left = null;
				 } else {
					 node.parent.right = null;
				 } 
			 }
		}
	
	}
	
	/**
	 * 判断一个节点是否是度为2的节点
	 */
	private boolean hasTwoChildern(Node<E> node) {
		boolean flag =false;
		if(node == null) return flag;
		if(node.left!= null && node.right!= null) {
			flag = true;
		} 
		return flag;
	}
	
	/**
	 * 	判断二叉搜索树中是否包含该元素
	 */
	public boolean contain(E element) {
		return false;
	}
	
	/**
	 * 由于二叉搜索树不能存储null元素,所以得对存储元素进行非空校验
	 */
	public void elementNotNull(E element) {
		if(element == null) {
			throw new IllegalArgumentException("this element can't be null");
		}
	}
	
	/**
	 * 实现 BinaryTreeInfo接口,获取控制体打印二叉搜索树功能而重写的抽象方法
	 * @return
	 */
	@Override
	public Object root() {
		return root;
	}
	@Override
	public Object left(Object node) {
		return ((Node)node).left;
	}
	@Override
	public Object right(Object node) {
		return ((Node)node).right;
	}
	@Override
	public Object string(Object node) {
		Node<E> node2 = (Node<E>)node;
		if(node2.parent == null) {
			return node2.element+"_pa:null";
		} else {
			return ((Node<E>)node).element+"_pa:"+node2.parent.element;
		}
	}
}
