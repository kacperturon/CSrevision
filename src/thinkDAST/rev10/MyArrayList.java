package thinkDAST.rev10;

import java.util.Collection;

import thinkDAST.MyListInterface;

public class MyArrayList<T> implements MyListInterface<T> {
	
	int size;
	T[] array;
	
	public MyArrayList() {
		size=0;
		array = (T[]) new Object[10];
	}
	
	public boolean equals(T target, T value) {
		if(target == null) return value == null;
		return target.equals(value);
	}
	
	public int indexOf(T val) {
		for(int i=0;i<size; i++) {
			if(equals(array[i], val)) return i;
		}
		return -1;
	}
	
	public boolean add(T val) {
		if(size>=array.length) {
			T[] bigger = (T[]) new Object[array.length*2];
			System.arraycopy(array, 0, bigger, 0, array.length);
			array = bigger;
		}
		array[size] = val;
		size++;
		return true;
	}
	
	public void add(int index, T val) {
		if(index<0||index>=size) throw new IndexOutOfBoundsException();
		add(val);
		for(int i=size-1; i>index; i--) {
			array[i]=array[i-1];
		}
		array[index] = val;
	}
	
	public T get(int index) {
		if(index<0||index>=size) throw new IndexOutOfBoundsException();
		return array[index];
	}
	public T set(int index, T val) {
		T oldVal = get(index);
		array[index]=val;
		return oldVal;
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

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean addAll(Collection<? extends T> collection) {
		boolean flag = true;
		for (T element: collection) {
			flag &= add(element);
		}
		return flag;
	}
	
	
	
	
}
