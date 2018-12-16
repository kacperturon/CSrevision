package thinkDAST.rev10;

import java.util.NoSuchElementException;


public class MyQueue<T> {
	
	public class Node{
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
	
	public Node tail, head;
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public T remove() {
		if(head == null) throw new NoSuchElementException();
		T val = head.data;
		head = head.next;
		if(head == null) tail = null;
		return val;
	}
	
	public T peek() {
		if(head == null) throw new NoSuchElementException();
		return head.data;
	}
	
	public void add(T value) {
		if(head == null) head = tail = new Node(value);
		else{
			tail.next = new Node(value);
			tail = tail.next;
		}
	};
	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		System.out.println(queue.isEmpty());
		queue.add(1);
		queue.add(2);
		queue.add(3);
		System.out.println(queue.peek());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());

		System.out.println(queue.isEmpty());
	}

}
