package thinkDAST.rev9;

import java.util.ArrayList;
import java.util.List;


public class MyHashMap<K,V> {
	List<MyLinearMap<K,V>> maps;
	double FACTOR = 1.0;
	
	public MyHashMap() {
		maps = new ArrayList<>();
		makeMaps(2);
	}
	
	public void makeMaps(int n) {
		for(int i=0; i<n; i++) {
			maps.add(new MyLinearMap<>());
		}
	}
	
	public MyLinearMap<K,V> chooseMap(K key){
//		System.out.println(maps.size());
		int index = key == null ? null : (Math.abs(key.hashCode()) % maps.size());
		return maps.get(index);
	}
	
	public V get(K key) {
		MyLinearMap<K,V> map = chooseMap(key);
		return map.get(key);
	}
	
	public V remove(K key) {
		MyLinearMap<K,V> map = chooseMap(key);
		V val = map.get(key);
		map.remove(key);
		return val;
	}
	
	public int size() {
		int count =0;
		for(MyLinearMap<K,V> map : maps) {
			count += map.entries.size();
		}
		return count;
	}
	
	private void rehash() {
//		System.out.println("rehash");
		List<MyLinearMap<K,V>> mapsOld = maps;
		clear();
		makeMaps(maps.size()*2);
		for(MyLinearMap<K,V> map: mapsOld) {
			for(MyLinearMap<K, V>.Entry entry: map.entries)
				map.put(entry.getKey(), entry.getValue());
		}
	}
	
	public void clear() {
		for (int i=0; i<maps.size(); i++) {
			maps.get(i).clear();
		}
	}
	
	public V put(K key, V value) {
		MyLinearMap<K,V> map = chooseMap(key);
		V val = map.put(key, value);
		if((double)(size() / maps.size()) >=FACTOR) {
			rehash();
		}
		return val;
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
