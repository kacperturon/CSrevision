package thinkDAST.rev11;

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
		this.entries = new ArrayList<>();
	}
	public boolean equals(Object target, Object value) {
		if(target==null) return value == null;
		return target.equals(value);
	}
	
	private Entry getEntry(K key) {
		for(Entry e: entries) {
			if(equals(e.key, key)) return e;
		}
		return null;
	}
	
	public V get(K key) {
		Entry e = getEntry(key);
		if(e==null) return null;
		return e.value;
	}
	
	public V put(K key, V value) {
		Entry e = getEntry(key);
		if(e==null) {
			entries.add(new Entry(key, value));
			return null;
		}
		V val = e.value;
		e.value = value;
		return val;
	}
	
	public V remove(K key) {
		Entry e = getEntry(key);
		if(e==null) return null;
		V val = e.value;
		entries.remove(e);
		return val;
	}
	
	public boolean isEmpty() {
		return entries.isEmpty();
	}
	public void clear() {
		entries.clear();
	}
	public int size() {
		return entries.size();
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
