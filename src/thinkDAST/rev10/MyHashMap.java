package thinkDAST.rev10;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import thinkDAST.rev10.MyLinearMap.Entry;

public class MyHashMap<K,V> {
	
	List<MyLinearMap<K,V>> maps;
	final double FACTOR = 1.0;
	
	public MyHashMap() {
		maps = new ArrayList<>();
		makeMaps(2);
	}

	private void makeMaps(int n) {
		for(int i=0;i<n;i++) {
			maps.add(new MyLinearMap<K,V>());
		}
	}
	
	private int valuesSize() { 
		int count =0;
		for(MyLinearMap map : maps) {
			count += map.entries.size();
		}
		return count;
	}
	
	private MyLinearMap chooseMap(K key) {
		int index = key==null ? 0 : Math.abs(key.hashCode()) % maps.size();
		return maps.get(index);
	}
	
	public V put(K key, V value) {
		MyLinearMap<K,V> m = chooseMap(key);
		V val =  m.put(key, value);
		if(valuesSize()/maps.size()>FACTOR) rehash();
		return val;
	}
	
	public void clear() {
		for(MyLinearMap m : maps) {
			m.clear();
		}
	}
	
	private void rehash() {
		List<MyLinearMap<K,V>> copy = maps;
		clear();
		makeMaps(maps.size()*2);
		for(MyLinearMap<K,V> m : copy) {
			for(MyLinearMap<K,V>.Entry e: m.entries) {
				put(e.key, e.value);
			}
		}
	}
	
	public V remove(K key) {
		MyLinearMap<K,V> m = chooseMap(key);
		return m.remove(key);
	}
	
	public V get(K key) {
		MyLinearMap<K,V> m = chooseMap(key);
		return m.get(key);
	}
	
	public boolean isEmpty() {
		return maps.size() == 0;
	}
	
	public static void main(String[] args) {
		MyHashMap<String, Integer> map = new MyHashMap<>();
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
