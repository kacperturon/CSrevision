package thinkDAST.rev3;

import thinkDAST.rev2.MyLinkedList.Node;

public class MyLinkedList<T> {
	
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

	private Node head;
	int size;
	
	public MyLinkedList() {
		head = null;
		size = 0;
	}
	
	public boolean add(T val) {
		if(head == null)
			head = new Node(val);
		else {
			Node node = head;
			for(;node.next!=null; node= node.next) {}
			node.next = new Node(val);
		}
		size++;
		return true;
		
	}
	
	public void add(int index, T val) {
		if(index == 0) head = new Node(val, head);
		else {
			Node prevNode = getNode(index-1);
			prevNode.next = new Node(val, prevNode.next);
		}
		size++;
	}
	
	public T get(int index) {
		return getNode(index).data;
	}
	
	public T remove(int index) {
		T val = get(index);
		if(index == 0)
			head = head.next;
		else{
			Node prevNode = getNode(index-1);
			prevNode.next = prevNode.next.next;
		}
		size--;
		return val;
	}
	
	public boolean remove(T val) {
		int index = indexOf(val);
		if(index == -1)
			return false;
		remove(index);
		return true;
	}
	
	public T set(int index, T val) {
		Node node = getNode(index);
		T oldVal = node.data;
		node.data = val;
		return oldVal;
	}
	
	private Node getNode(int index) {
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
		Node node = head;
		for(int i=0; i<size; i++) {
			if(i==index) break;
			node = node.next;
		}
		return node;
	}
	
	public int indexOf(T val) {
		Node node = head;
		for(int i=0; i<size; i++) {
			if(equals(node.data, val)) return i;
			node = node.next;
		}
		return -1;
	}
	
    public boolean equals(T target, T value) {
    	if(target==null) return value==null;
    	return target.equals(value);
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
	
    public static void main(String[] args) {
		MyLinkedList arr = new MyLinkedList();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		System.out.println("Add 1,2,3");
		arr.display();
		arr.add(4);
		arr.add(5);
		arr.add(6);
		arr.add(7);
		arr.add(8);
		arr.add(9);
		arr.add(10);
		System.out.println("Add 4,5,6,7,8,9,10");
		arr.display();
		arr.add(11);
		System.out.println("Add 11");
		arr.display();
		arr.add(13);
		arr.add(11,12);
		System.out.println("Add 13 and add 12 at index 11");
		arr.display();
		System.out.println(arr.get(1));
		arr.set(1, 1);
		arr.display();
		arr.remove(11);
		arr.display();
		arr.remove(new Integer(11));
		arr.display();
		System.out.println(arr.indexOf(13));
		System.out.println(arr.indexOf(3));
    }
}
