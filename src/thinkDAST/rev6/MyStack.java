package thinkDAST.rev6;

import java.util.EmptyStackException;


public class MyStack<T> {

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
	
	public MyStack() {
		head = null;
	}
	
	public void push(T data) {
		if(head == null)
			head = new Node(data);
		else
			head = new Node(data, head);
	}
	
	public T peek() {
		if(head == null) throw new EmptyStackException();
		return head.data;
	}
	
	public T pop() {
		
		if(head == null) throw new EmptyStackException();
		T data = head.data;
		head = head.next;
		return data;
		
	}
	
	public boolean isEmpty() {
		return head == null;
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
