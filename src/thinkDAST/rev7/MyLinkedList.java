package thinkDAST.rev7;


public class MyLinkedList<T> {
	
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
	
	private Node head;
	int size;
	
	public MyLinkedList() {
		size=0;
		head = null;
	}
	
	public boolean equals(T target, T value) {
		if(target == null) return value==null;
		return target.equals(value);
	}
	
	public int indexOf(T value) {
		Node node = head;
		for(int i=0;i<size;i++) {
			if(equals(node.data, value)) return i;
			node = node.next;
		}
		return -1;
	}
	
	private Node getNode(int index) {
		if(index<0||index>=size) throw new IndexOutOfBoundsException();
		Node node = head;
		for(int i=0;i<size;i++) {
			if(i==index) break;
			node=node.next;
		}
		return node;
	}
	
	public boolean add(T value) {
		
		if(head == null) head = new Node(value);
		else {
			
			Node node = head;
			for(;node.next!= null;node=node.next) {}
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
	
	public T get(int index) {
		return getNode(index).data;
	}
	
	public T set(int index, T value) {
		Node node = getNode(index);
		T val = node.data;
		node.data=value;
		return val;
		
	}
	
	public T remove(int index) {
		T val = get(index);
		if(index==0)head = head.next;
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
