package thinkDAST.rev5;

import java.util.EmptyStackException;

public class MyStack<T> {
	
	public class Node{
		T data;
		Node next;
		Node(T data){
			this.data = data;
		}
		Node(T data, Node next){
			this.data = data;
			this.next = next;
		}
	}
	
	Node head;
	
	public MyStack() {
		head = null;
	}
	
	public void push(T value) {
		head = new Node(value,head);
	}
	
	public T pop() {
		if(head == null) throw new EmptyStackException();
		T val = head.data;
		head = head.next;
		return val;
	}
	
	public T peek() {
		if(head == null) throw new EmptyStackException();
		return head.data;
	}
	
	public boolean isEmpty() {
		return head==null;
	}
	
	public static void main(String[] args) {
		MyStack stack = new MyStack();
		System.out.println(stack.isEmpty());
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.peek());
		stack.push(4);
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.isEmpty());
	}
}
