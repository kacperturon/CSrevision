package thinkDAST.rev9;

import java.util.EmptyStackException;

import thinkDAST.rev8.MyStack.Node;


public class MyStack<T> {
	
	public class Node{
		public T data;
		Node next;
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
		return head ==null;
	}
	
	public T peek(){
		if(isEmpty()) throw new EmptyStackException();
		return head.data;
	}
	public void push(T value) {
		if(head == null) head = new Node(value);
		else {
			head = new Node(value, head);
		}
	}
	public T pop() {
		if(isEmpty()) throw new EmptyStackException();
		T val = head.data;
		head = head.next;
		return val;
	}
	
	public int size() {
		if(head == null) return 0;
		Node node = head;
		int counter = 1;
		for(;node.next!=null;node=node.next, counter++) {}
		return counter;
	}
	public static void main(String[] args) {
		MyStack stack = new MyStack();
//		System.out.println(stack.isEmpty());
		stack.push(1);
		stack.push(2);
		stack.push(3);
//		System.out.println(stack.peek());
		stack.push(4);
//		System.out.println(stack.peek());
//		System.out.println(stack.pop());
//		System.out.println(stack.peek());
//		System.out.println(stack.isEmpty());
	}

}
