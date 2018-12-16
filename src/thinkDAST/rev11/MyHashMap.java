package thinkDAST.rev11;

import java.util.ArrayList;
import java.util.List;


public class MyHashMap<K,V> {
	List<MyLinearMap<K,V>> maps;
	double FACTOR =1.0;
	int size;
	public MyHashMap() {
		maps = new ArrayList<>();
		makeMaps(2);
		size=0;
	}
	
	private void makeMaps(int n) {
		for(int i=0;i<n;i++)
			maps.add(new MyLinearMap<K, V>());
	}
	
	private MyLinearMap<K,V> chooseMap(K key) {
		int index = key==null ? 0 : Math.abs(key.hashCode()) % maps.size();
		return maps.get(index);
	}
	
	private int size() { // fix
		return size;
	}
	
	public V put(K key, V value) {
		MyLinearMap<K,V> map = chooseMap(key);
		size -= map.size();
		V val =	map.put(key, value);
		size += map.size();
		if(size()/maps.size()>FACTOR) {
			rehash();
			size=0;
		}
		return val;
	}
	
	public V get(K key) {
		MyLinearMap<K,V> map = chooseMap(key);
		return map.get(key);
	}
	
	public V remove(K key) {
		MyLinearMap<K,V> map = chooseMap(key);
		size -= map.size();
		V val = map.remove(key);
		size += map.size();
		return val;
	}
	
	private void clear() {
		size=0;
		for(MyLinearMap<K,V> m : maps) {
			m.clear();
		}

	}
	
	private void rehash() {
		List<MyLinearMap<K,V>> cpy = maps;
		int size = maps.size();
		makeMaps(size*2);
		for(MyLinearMap<K,V> m : cpy) {
			for(MyLinearMap<K,V>.Entry e : m.entries) {
				put(e.getKey(), e.getValue());
			}
		}
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
