package thinkDAST;

import java.util.Collection;

public interface MyListInterface<T> {
	public int indexOf(T value);
	
	public boolean equals(T value, T target);
	
	public T set(int index, T value);
	
	public T get(int index);
	
	public boolean add(T value);
	
	public void add(int index, T value);
	
	public T remove(int index);
	
	public boolean remove(T value);
	
	public int size();
	
	public boolean addAll(Collection<? extends T> collection);

}
