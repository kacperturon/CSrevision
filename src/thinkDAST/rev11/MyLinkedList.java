package thinkDAST.rev11;

import java.util.Collection;

import thinkDAST.MyListInterface;

public class MyLinkedList<T> implements MyListInterface<T> {
	class Node{
		T data;
		Node next;
		public Node(T data) {
			this.data = data;
		}
		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	Node root;
	int size;
	
	public MyLinkedList() {
		root = null;
		size = 0;
	}
	
	public boolean equals(T target, T value) {
		if(target==null) return value==null;
		return target.equals(value);
	}
	
	public int indexOf(T value) {
		Node node = root;
		for(int i=0; i<size;i++) {
			if(equals(value, node.data)) return i;
			node = node.next;
		}
		return -1;
	}
	
	private Node getNode(int index) {
		if(index<0||index>=size) throw new IndexOutOfBoundsException();
		Node node = root;
		for(int i=0; i<size;i++) {
			if(index  == i) break;
			node = node.next;
		}
		return node;
	}
	
	public T get(int index) {
		return getNode(index).data;
	}
	
	public boolean add(T value) {
		if(root == null) {
			root = new Node(value);
		}else {
			Node node = root;
			for(;node.next!=null;node=node.next) {}
			node.next=new Node(value);
		}
		size++;
		return true;
	}
	
	public void add(int index, T value) {
		if(index==0) root = new Node(value, root);
		else {
			Node nodePrev = getNode(index-1);
			nodePrev.next = new Node(value, nodePrev.next);
		}
		size++;
	}
	
	public T set(int index, T value) {
		Node node = getNode(index);
		T val = node.data;
		node.data = value;
		return val;
	}
	
	public T remove(int index) {
		T val = get(index);
		if(index==0) root = root.next;
		else {
			Node prevNode = getNode(index-1);
			prevNode.next = prevNode.next.next;
		}
		size--;
		return val;
	}
	public boolean remove(T value) {
		int index = indexOf(value);
		if(index == -1) return false;
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
