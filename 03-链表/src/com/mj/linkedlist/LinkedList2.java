package com.mj.linkedlist;

import com.mj.list.List;


public class LinkedList2<E> implements List<E> {
	private int size;
	private Node<E> first;
	private Node<E> last;
	private static final int ELEMENT_NOT_FOUND = -1;
	
	private static class Node<E> {
		E element;
		Node prev;
		Node next;
		
		public Node(Node<E> prev,E element,Node<E> next){
			this.prev = prev;
			this.element = element;
			this.next = next;	
		}
		
	}
	
	private Node<E> node(int index){
		rangeCheck(index);
		
		if(index < (size/2)) {
			Node<E> node = first;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
			return node;
		} else {
			Node<E> node = last;
			for (int i = size-1; i > index; i--) {
				node = node.prev;
			}
			return node;
		}
	}
	

	


	@Override
	public void clear() {
		// TODO Auto-generated method stub
		first = null;
		last = null;
		size = 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public boolean contains(E element) {
		return indexOf(element) != ELEMENT_NOT_FOUND;
	}

	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		add(size,element);
		
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		rangCheckForAdd(index);
		if(index == size) {
			last = new Node(last, element, null);
			if(last.prev == null) {
				first = last;
			} else {
				last.prev.next = last;
			}
		} else {
			Node<E> node = node(index);
			Node<E> prev = node.prev;
			Node<E> next = node;
			node.prev = new Node<E>(prev, element, next);
			if(prev == null) {
				first = node.prev;
			} else {
				prev.next = node.prev;
			}
		}
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		Node<E> node = node(index);
		E oldElement = node.element;
		if(node.prev == null) {
			first = node.next;
		} else {
			node.prev.next = node.next;
		} 
		if(node.next == null) {
			last = node.prev; 
		} else {
			node.next.prev = node.prev;
		}
		size--;
		return oldElement;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return node(index).element;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		E oldElement = node(index).element;
		node(index).element = element;
		return oldElement;
	}

	@Override
	public int indexOf(E element) {
		// TODO Auto-generated method stub
		Node<E> node = first;
		if(element == null) {
			for (int i = 0; i < size; i++) {
				if(node.element == null) {
					return i;
				} else {
					node = node.next;
				}
			}
			return ELEMENT_NOT_FOUND;
		} else {
			for (int i = 0; i < size; i++) {
				if( element.equals(node.element)) {
					return i;
				} else {
					node = node.next;
				}
			}
			return ELEMENT_NOT_FOUND;
		}
	}
	
	private void rangeCheck(int index) {
		// TODO Auto-generated method stub
		if(index <0 || index>=size) {
			throw new IndexOutOfBoundsException();
		}
		
	}
	
	private void rangCheckForAdd(int index) {
		if(index < 0|| index > size ) {
			throw new IndexOutOfBoundsException();
		}
	}
	

}
