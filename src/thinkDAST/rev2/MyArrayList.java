package thinkDAST.rev2;

import java.util.Arrays;
import java.util.List;

public class MyArrayList<T> {
	
	private T[] array;
	int size;
	
	public MyArrayList() {
		array = (T[]) new Object[10];
		size = 0;
	}
	
	public boolean add(T obj) {
		if(size>=array.length) {
			T[] bigger = (T[]) new Object[array.length*2];
			System.arraycopy(array, 0, bigger, 0, array.length);
			array=bigger;
		}
		array[size] = obj;
		size++;
		return true;
		
	}
	
	public void add(int index, T obj) {
		if(index<0 || index>=size) {
			throw new IndexOutOfBoundsException();
		}
		add(obj);
		for(int i=size-1; i>index; i--) {
			array[i] = array[i-1]; //shift
		}
		array[index] = obj;
	}
	
	public T get(int index) {
		if(index<0 || index>=size) {
			throw new IndexOutOfBoundsException();
		}
		return array[index];
	}
	
	
	public T set(int index, T obj) {
		T val = get(index);
		array[index] = obj;
		return val;
	}
	
	public T remove(int index) {
		T val = get(index);
		
		for(int i=index;i<size-1;i++) {
			array[i]=array[i+1];
		}
		size--;
		return val;
	}
	
	
	public boolean remove(T obj) {
		int index = indexOf(obj);
		if(index == -1)
			return false;
		remove(index);
		return true;
	}
	
	public int indexOf(T obj) {
		for(int i=0; i<size; i++) {
			if(equals(obj, array[i])) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean equals(T target, T value) {
		if(target==null) {
			return value == null;
		}else
			return target.equals(value);
	}
	
	public void display() {
		System.out.println(Arrays.toString(array) +" size: "+ size);
	}
	
	
	public static void main(String[] args) {
		
//		MyArrayList arr = new MyArrayList();
//		arr.add(1);
//		arr.add(2);
//		arr.add(3);
//		System.out.println("Add 1,2,3");
//		arr.display();
//		arr.add(4);
//		arr.add(5);
//		arr.add(6);
//		arr.add(7);
//		arr.add(8);
//		arr.add(9);
//		arr.add(10);
//		System.out.println("Add 4,5,6,7,8,9,10");
//		arr.display();
//		arr.add(11);
//		System.out.println("Add 11");
//		arr.display();
//		arr.add(13);
//		arr.add(11,12);
//		System.out.println("Add 13 and add 12 at index 11");
//		arr.display();
//		System.out.println(arr.get(1));
//		arr.set(1, 1);
//		arr.display();
//		arr.remove(11);
//		arr.display();
//		arr.remove(new Integer(11));
//		arr.display();
//		System.out.println(arr.indexOf(13));
//		System.out.println(arr.indexOf(3));

	}
	
}