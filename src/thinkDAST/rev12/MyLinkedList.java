package thinkDAST.rev12;

import java.util.Collection;

import thinkDAST.MyListInterface;

public class MyLinkedList<T> implements MyListInterface<T> {
	public class Node{
		Node next;
		T data;
		public Node(T data) {
			this.data = data;
		}
		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	Node head;
	int size;
	
	public MyLinkedList() {
		head = null;
		size = 0;
	}
	
	public boolean equals(T target, T value) {
		if(target == null) return value == null;
		return target.equals(value);
	}
	
	public Node getNode(int index) {
		if(index<0||index>=size) throw new IndexOutOfBoundsException();
		if(index==0) return head;
		Node node = head;
		for(int i=0;i<size;i++) {
			if(i==index) return node;
			node = node.next;
		}
		return node;
	}
	
	public int indexOf(T value) {
		Node node = head;
		for(int i=0;i<size;i++) {
			if(equals(value, node.data)) return i;
			node = node.next;
		}
		return -1;
	}
	
	public T get(int index) {
		Node n = getNode(index);
		return n.data;
	}
	
	public boolean add(T value) {
		if(head == null) head = new Node(value);
		else {
			Node node = head;
			for(;node.next!=null; node = node.next) {}
			node.next = new Node(value);
		}
		size++;
		return true;
	}
	
	public void add(int index, T value) {
		if(index == 0) head = new Node(value,head);
		else {
			Node prevNode = getNode(index-1);
			prevNode.next = new Node(value, prevNode.next);
		}
		size++;
	}
	
	public T set(int index, T value) {
		Node n = getNode(index);
		T val = n.data;
		n.data = value;
		return val;
		
	}
	
	public T remove(int index) {
		T val = get(index);
		if(index==0) head = head.next;
		else {
			Node prevNode = getNode(index-1);
			prevNode.next = prevNode.next.next;
		}
		size--;
		return val;
	}
	
	public boolean remove(T value) {
		int index = indexOf(value);
		if(index==-1) return false;
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
