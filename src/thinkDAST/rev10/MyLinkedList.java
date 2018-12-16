package thinkDAST.rev10;

import java.util.Collection;

import thinkDAST.MyListInterface;

public class MyLinkedList<T> implements MyListInterface<T>  {
	
	public class Node{
		Node next;
		T value;
		public Node(T value) {
			this.value = value;
		}
		public Node(T value, Node next) {
			this.value = value;
			this.next = next;
		}
	}
	
	public Node head;
	public int size;
	
	public MyLinkedList() {
		head = null;
		size = 0;
	}
	public boolean equals(T target, T value) {
		if(target == null) return value == null;
		return target.equals(value);
	}
	
	public int indexOf(T value) {
		Node node = head;
		for(int i=0;i<size;i++) {
			if(equals(node.value, value)) return i;
			node = node.next;
		}
		return -1;
	}
	
	private Node getNode(int index) {
		if(index<0||index>=size) throw new IndexOutOfBoundsException();
		Node node = head;
		for(int i=0;i<size;i++) {
			if(i==index) break;
			node = node.next;
		}
		return node;
	}
	
	public T get(int index) {
		return getNode(index).value;
	}
	
	public boolean add(T value) {
		if(head == null) head = new Node(value);
		else {
			Node node = head;
			for(;node.next!= null; node = node.next) {}
			node.next = new Node(value);
		}
		size++;
		return true;
	}
	
	public void add(int index, T value) {
		if(index == 0)
			head = new Node(value, head);
		else {
			Node nodePrev = getNode(index-1);
			nodePrev.next = new Node(value, nodePrev.next);
		}
		size++;
	}
	
	public T set(int index, T value) {
		Node node = getNode(index);
		T val = node.value;
		node.value = value;
		return val;
	}
	
	public T remove(int index) {
		T val = get(index);
		if(index == 0) head = head.next;
		else {
			Node nodePrev = getNode(index-1);
			nodePrev.next = nodePrev.next.next;
		}
		size--;
		return val;
	}
	
	public boolean remove(T value) {
		int index = indexOf(value);
		if(index == -1 ) return false;
		remove(index);
		return true;
	}
	@Override
	public int size() {
		return size;
	}
	@Override
	public boolean addAll(Collection<? extends T> collection) {
		boolean flag = true;
		for (T element: collection) {
			flag &= add(element);
		}
		return flag;
	}

}
