package thinkDAST.rev8;

import java.util.List;
import java.util.Map;


public class MyHashMap<K,V> extends MyBetterMap<K,V> {
	
	protected final double FACTOR = 1.0;
	
	@Override
	public V put(K key, V value){
		V val = super.put(key, value);
		if((double)size()/(double)maps.size()>=FACTOR) {
			rehash();
		}
		return val;
	}
	
	private void rehash() {
		List<MyLinearMap<K,V>> oldMaps = maps;
		clear();
		makeMaps(maps.size()*2);
		for(MyLinearMap<K,V> map: oldMaps) {
			for(MyLinearMap<K, V>.Entry entry: map.getEntries()) {
				put(entry.getKey(), entry.getValue());
			}
		}
	}
	
	public static void main(String[] args) {
//		MyHashMap<String, Integer> map = new MyHashMap<String, Integer>();
//		for (int i=0; i<10; i++) {
//			map.put(new Integer(i).toString(), i);
//		}
//		Integer value = map.get("3");
//		System.out.println(value);
		
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
