package thinkDAST.rev8;

import java.util.ArrayList;
import java.util.List;

import thinkDAST.rev8.MyLinearMap;

public class MyBetterMap<K,V> {
	
	List<MyLinearMap<K,V>> maps;
	
	public MyBetterMap() {
		makeMaps(2);
	}
	
	protected void makeMaps(int n) {
		maps = new ArrayList<>();
		for(int i=0;i<n;i++) {
			maps.add(new MyLinearMap<>());
		}
	}
	
	private MyLinearMap<K,V> chooseMap(K key){
		int index = key==null? null: (Math.abs(key.hashCode())%maps.size());
		return maps.get(index);
	}
	
	public V put(K key, V value) {
		return chooseMap(key).put(key, value);
	}
	
	public V get(K key) {
		MyLinearMap<K,V> map = chooseMap(key);
		return map.get(key);
	}
	
	public V remove(K key) {
		MyLinearMap<K,V> map = chooseMap(key);
		return map.remove(key);
		
	}
	
	public boolean isEmpty() {
		return this.maps.size() ==0;
	}
	
	public void clear() {
		for (int i=0; i<maps.size(); i++) {
			maps.get(i).clear();
		}
	}
	
	public int size() {
		int count =0;
		for(MyLinearMap<K,V> map: maps) {
			count += map.size();
		}
		return count;
	}
	
	public static void main (String[] args) {
		MyBetterMap<String, Integer> map = new MyBetterMap<>();
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
