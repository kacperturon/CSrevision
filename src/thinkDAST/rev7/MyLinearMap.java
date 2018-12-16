package thinkDAST.rev7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyLinearMap<K,V>{
	
	public class Entry{
		K key;
		V value;
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		public K getKey() {
			return key;
		}
		public V getValue() {
			return value;
		}
		
		public void setValue(V value) {
			this.value = value;
		}
	}
	
	List<Entry> entries = new ArrayList<>();

	public boolean equals(Object target, Object value) {
		if(target == null) return value==null;
		return target.equals(value);
	}
	
	public Entry getEntry(K key) {
		for(Entry entr: entries) {
			if(equals(entr.key, key))
				return entr;
		}
		return null;
	}
	
	
	public V put(K key, V value) {
		Entry entry = getEntry(key);
		if(entry == null) {
			entries.add(new Entry(key, value));
			return null;
		}else {
			V val = entry.getValue();
			entry.setValue(value);
			return val;
		}
	}
	
	public V get(K key) {
		Entry entry = getEntry(key);
		if(entry == null) return null;
		return entry.getValue();
	}
	
	public V remove(K key) {
		Entry entry = getEntry(key);
		if(entry !=null)
		{
			V value = entry.getValue();
			entries.remove(entry);
			return value;
		} else return null;
	}
	
	public void clear() {
		entries.clear();
	}
	
	public boolean isEmpty() {
		return entries.size()==0;
	}
	
	public static void main (String[] args) {
		MyLinearMap<String, Integer> map = new MyLinearMap<>();
		System.out.println(map.isEmpty());
		map.put("test1", 1);
		map.put("test2", 2);
		map.put("test3", 3);
		System.out.println(map.isEmpty());
		System.out.println(map.get("test2"));
		System.out.println(map.remove("test2"));
		System.out.println(map.get("test2"));
		System.out.println(map.put("test3", 6));
		System.out.println(map.get("test3"));
		map.clear();
		System.out.println(map.get("test1"));
		System.out.println(map.isEmpty());
		
	}

}
