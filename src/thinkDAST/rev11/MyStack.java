package thinkDAST.rev11;

import java.util.EmptyStackException;

import thinkDAST.rev10.MyStack.Node;

public class MyStack<T> {
	
	public class Node{
		Node next;
		public T data;
		public Node(T data) {
			this.data = data;
		}
		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	public Node head;
	
	public MyStack() {
		head = null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void push(T value) {
		if(head==null) head = new Node(value);
		else {
			head = new Node(value, head);
		}
	}
	
	public T pop() {
		if(isEmpty()) throw new EmptyStackException() ;
		T val = head.data;
		head = head.next;
		return val;
	}
	
	public T peek() {
		if(isEmpty()) throw new EmptyStackException();
		return head.data;
	}
	
	public int size() {
		if(head == null) return 0;
		Node node = head;
		int counter = 1;
		for(;node.next!=null;node=node.next, counter++) {}
		System.out.println(counter);
		return counter;
	}
	

}
