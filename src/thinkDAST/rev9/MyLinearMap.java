package thinkDAST.rev9;

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
	
	public List<Entry> entries;
	
	public MyLinearMap() {
		entries = new ArrayList<>();
	}
	
	private boolean equals(Object target, Object value) {
		if(target == null) return value==null;
		return target.equals(value);
	}
	
	private Entry getEntry(K key) {
		for(Entry entry: entries) {
			if(equals(entry.key,key))
				return entry;
		}
		return null;
	}
	
	public V put(K key, V value) {
		Entry entry = getEntry(key);
		if(entry == null) entries.add(new Entry(key, value));
		else {
			V val = entry.getValue();
			entry.setValue(value);
			return val;
		}
		return null;
	}
	
	public V get(K key) {
		Entry entry = getEntry(key);
		if(entry== null) return null;
		return entry.getValue();
		
	}
	
	public V remove(K key) {
		Entry entry = getEntry(key);
		if(entry == null) return null;
		V value = entry.getValue();
		entries.remove(entry);
		return value;
	}

	public void clear() {
		this.entries.clear();
	}
	
	
	public boolean isEmpty() {
		return entries.size() ==0;
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
	
	
	//put, get, remove, isempty
}
