package thinkDAST.rev8;

import java.util.ArrayList;
import java.util.List;

import thinkDAST.rev7.MyLinearMap.Entry;


public class MyLinearMap<K,V> {
	
	public class Entry{
		K key;
		V value;
		public Entry(K key, V value){
			this.key = key;
			this.value = value;
		}
		public K getKey(){
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
	
	private boolean equals(Object target, Object value) {
		if(target == null) return value == null;
		return target.equals(value);
	}
	
	private Entry getEntry(K key) {
		for(Entry e: entries) {
			if(equals(e.getKey(), key))
				return e;
		}
		return null;
	}
	
	public V get(K key) {
		Entry e = getEntry(key);
		if(e == null ) return null;
		return e.getValue();
	}
	
	public boolean isEmpty() {
		if(entries.size()==0) return true;
		return false;
	}
	public List<Entry> getEntries(){
		return entries;
	}
	public int size() {
		return entries.size();
	}
	public V put(K key, V value) {
		Entry e = getEntry(key);
		if(e == null)
			entries.add(new Entry(key, value));
		else {
			V old = e.getValue();
			e.setValue(value);
			return old;
		}
		return null;
	}
	
	public V remove(K key) {
		Entry e = getEntry(key);
		if(e==null) return null;
		V val = e.getValue();
		entries.remove(e);
		
		return val;
	}
	
	public void clear() {
		this.entries.clear();
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
