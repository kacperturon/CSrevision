package thinkDAST.rev4;

import java.util.Arrays;
import java.util.EmptyStackException;


public class MyArrayList<T>{

	private T[] array;
	int size;
	
	public MyArrayList() {
		array = (T[]) new Object[10];
		size = 0;
	}
	
	public boolean add(T val) {
		if(size>=array.length) {
			T[] bigger = (T[]) new Object[array.length*2];
			System.arraycopy(array, 0, bigger, 0, array.length);
			array = bigger;
		}
		array[size]=val;
		size++;
		return true;
	}
	
	public void add(int index, T val) {
		if(index<0||index>=size) throw new IndexOutOfBoundsException();
		add(val);
		
		for(int i=size-1; i>index;i--) {
			array[i]=array[i-1];
		}
		array[index]=val;
	}
	
	public T get(int index) {
		if(index<0||index>=size) throw new IndexOutOfBoundsException();
		return array[index];
	}
	
	public T remove(int index) {
		if(index<0||index>=size) throw new IndexOutOfBoundsException();
		T val = get(index);
		for(int i=index;i<size-1;i++) {
			array[i]= array[i+1];
		}
		size--;
		return val;
	}
	
	public boolean remove(T val) {
		int index = indexOf(val);
		if(index == -1) return false;
		remove(index);
		return true;
	}
	
	public T set(int index, T val) {
		if(index<0||index>=size) throw new IndexOutOfBoundsException();
		T oldVal = array[index];
		array[index] = val;
		return oldVal;
	}
	
	public int indexOf(T val) {
		for(int i=0;i<size;i++) {
			if(equals(array[i],val))
				return i;
		}
		return -1;
	}
	
	public boolean equals(T target, T value) {
		if(target==null) return value==null;
		return target.equals(value);
	}
	
	public void display() {
		System.out.println(Arrays.toString(array));
	}
	
    //stack methods: push, pop, peek, isEmpty
	
	public void push(T val) {
		add(val);
	}
	
	public T pop() {
		if(isEmpty()) throw new EmptyStackException();
		return remove(0);
	}
	
	public T peek() {
		if(isEmpty()) throw new EmptyStackException();
		return get(0);
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public static void main(String args[]) {
		MyArrayList queue = new MyArrayList();
		System.out.println("isEmpty: "+queue.isEmpty());
		queue.push(1);
		queue.push(2);
		queue.push(3);
		System.out.println("isEmpty: "+queue.isEmpty());
		queue.display();
		System.out.println("peek: "+queue.peek());
		System.out.println("pop: "+queue.pop());
		queue.push(5);
		queue.display();
		System.out.println("peek: "+queue.peek());

	}
}
