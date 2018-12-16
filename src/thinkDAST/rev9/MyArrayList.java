package thinkDAST.rev9;

import java.util.Collection;

import thinkDAST.MyListInterface;

public class MyArrayList<T> implements MyListInterface<T> {
	
	private int size;
	private T[] array;
	
	public MyArrayList() {
		size=0;
		array = (T[]) new Object[10];
	}
	
	public boolean add(T value) {
		if(size>=array.length) {
			T[] bigger = (T[]) new Object[array.length*2];
			System.arraycopy(array, 0, bigger, 0, array.length);
			array = bigger;
		}
		array[size]=value;
		size++;
		return true;
	}
	
	public void add(int index, T value) {
		if(index<0||index>=size) throw new IndexOutOfBoundsException();
		add(value);
		for(int i=size-1;i>index;i--) {
			array[i]=array[i-1];
		}
		array[index]=value;
	}
	
	public T set(int index, T value) {
		T val = get(index);
		array[index]=value;
		return val;
	}
	
	public boolean equals(T target, T value) {
		if(target == null) return value == null;
		return target.equals(value);
	}
	public int indexOf(T value) {
		for(int i=0;i<size;i++) {
			if(equals(value, array[i])) return i;
		}
		return -1;
	}
	
	public T get(int index) {
		if(index<0||index>=size) throw new IndexOutOfBoundsException();
		return array[index];
	}
	
	public T remove(int index) {
		T val = get(index);
		for(int i=index; i<size-1; i++) {
			array[i]=array[i+1];
		}
		size--;
		return val;
	}
	
	public int size() {
		return size;
	}
	public boolean addAll(Collection<? extends T> collection) {
		boolean flag = true;
		for (T element: collection) {
			flag &= add(element);
		}
		return flag;
	}
	
	public boolean remove(T value) {
		int index = indexOf(value);
		if(index == -1) return false;
		remove(index);
		return true;
	}
	
}
