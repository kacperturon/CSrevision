package thinkDAST.rev8;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import thinkDAST.MyListInterface;


public class MyArrayList<T> implements MyListInterface<T>{
	
	private T[] array;
	int size;
	
	public MyArrayList()
	{
		array = (T[]) new Object[10];
		size = 0;
	}
	
	public boolean equals(T target, T value) {
		if(target == null) return value == null;
		return target.equals(value);
	}
	
	public boolean addAll(Collection<? extends T> collection) {
		boolean flag = true;
		for (T element: collection) {
			flag &= add(element);
		}
		return flag;
	}
	public int indexOf(T value) {
		
		for(int i=0;i<size;i++) {
			if(equals(value, array[i]))
				return i;
		}
		return -1;
	}
	public int size() {
		return size;
	}
	public T get(int index) {
		if(index<0 || index >= size) throw new IndexOutOfBoundsException();
		return array[index];
	}
	
	public boolean add(T value) {
		if(size>=array.length) {
			T[] bigger = (T[]) new Object[array.length*2];
			System.arraycopy(array, 0, bigger, 0, array.length);
			array = bigger;
		}
		array[size] = value;
		size++;
		return true;
	}
	
	public void add(int index, T value) {
		if(index<0||index>=size) throw new IndexOutOfBoundsException();
		add(value);
		for(int i=size-1; i>index;i--) {
			array[i]=array[i-1];
		}
		array[index]=value;
		
	}
	public Object[] toArray() {
		return Arrays.copyOf(array, size);
	}
	
	public T set(int index, T value) {
		T val = get(index);
		array[index]=value;
		return val;
	}
	
	public T remove(int index) {
		T val = get(index);
		for(int i=index; i<size-1;i++) {
			array[i]=array[i+1];
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
		System.out.println(Arrays.toString(array));
	}
	
	public static void main(String args[]) {
		
		MyArrayList arr = new MyArrayList();
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
