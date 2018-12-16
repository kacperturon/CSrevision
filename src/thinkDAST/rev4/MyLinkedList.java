package thinkDAST.rev4;

import java.util.EmptyStackException;

public class MyLinkedList<T> {
	
	
	public class Node {
		T data;
		Node next;
		public Node(T data) {
			this.data = data;
			this.next = null;
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
	
	public boolean add(T val) {
		if(head == null) head = new Node(val);
		else {
			Node node = head;
			for(;node.next != null; node=node.next) {}
			node.next = new Node(val);
		}
		size++;
		return true;
	}
	
	public void add(int index, T val) {
		if(index == 0) head = new Node(val, head);
		else {
			Node node = getNode(index-1);
			node.next = new Node(val, node.next);
			
		}
		size++;
		
	}
	
	public boolean remove(T val) {
		int index = indexOf(val);
		if(index == -1) return false;
		if(index == 0) head = head.next;
		else {
			Node prevNode = getNode(index-1);
			prevNode.next = prevNode.next.next;
		}
		size--;
		return true;
	}
	
	public T remove(int index) {
		T val = get(index);
		remove(val);
		return val;
	}
	
	public T set(int index, T val) {
		Node node = getNode(index);
		T oldVal = node.data;
		node.data = val;
		return oldVal;
		
	}
	
	public T get(int index) {
		return getNode(index).data;
	}
	
	public int indexOf(T val) {
		Node node = head;
		for(int i=0; i<size;i++) {
			if(equals(node.data, val)) return i;
			node = node.next;
		}
		return -1;
	}
	
	private boolean equals(T target, T value) {
		if(target == null)return value == null;
		return target.equals(value);
	}
	
	private Node getNode(int index) {
		if(index<0||index>=size) throw new IndexOutOfBoundsException();
		Node node = head;
		for(int i=0; i<index;i++) {
			if(i==index) break;
			node = node.next;
		}
		return node;
	}
	
    public void display() {
    	String output = "";
		Node node = head;
		for(int i=0; i<size; i++) {
			output += node.data+", ";
			node = node.next;
		}
		System.out.println(output);
    }
    
    //stack methods: push, pop, peek, isEmpty
    public T pop() {
    	if(isEmpty()) throw new EmptyStackException();
    	return remove(0);
    }
    
    public void push(T val) {
    	add(0, val);
    }
    
    public T peek() {
    	if(isEmpty()) throw new EmptyStackException();
    	return head.data;
    }
    
    public boolean isEmpty() {
    	return size==0;
    }
	
	public static void main(String[] args) {
		MyLinkedList stack = new MyLinkedList();
		System.out.println("isEmpty: "+stack.isEmpty());
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println("isEmpty: "+stack.isEmpty());
		stack.display();
		System.out.println("peek: "+stack.peek());
		System.out.println("pop: "+stack.pop());
		stack.push(5);
		stack.display();
		System.out.println("peek: "+stack.peek());

		
		
	}
}

