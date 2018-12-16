package thinkDAST.rev10;

import java.util.ArrayList;
import java.util.List;


public class MyLinearMap<K,V> {
	
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

	List<Entry> entries;

	public MyLinearMap() {
		entries = new ArrayList<>();
	}
	
	public int size() {
		return entries.size();
	}
	
	public boolean isEmpty() {
		return entries.size() == 0;
	}
	
	public void clear() {
		entries.clear();
	}
	
	public V put(K key, V val) {
		Entry e = getEntry(key);
		if(e == null) {
			entries.add(new Entry(key, val));
			return null;
		}
		V oldVal = e.value;
		e.value = val;	
		return oldVal;
	}
	
	public V remove(K key) {
		Entry e = getEntry(key);
		if(e == null) return null;
		V val = e.value;
		entries.remove(e);
		return val;
	}
	
	private Entry getEntry(K key) {
		for(Entry e : entries) {
			if(equals(e.key, key)) return e;
		}
		return null;
	}
	
	public boolean equals(Object target, Object value) {
		if(target == null) return value == null;
		return target.equals(value);
	}
	
	public V get(K key) {
		Entry e = getEntry(key);
		if(e == null) return null;
		return e.value;
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
