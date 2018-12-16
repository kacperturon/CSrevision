package thinkDAST.rev11;

import thinkDAST.rev10.MyTreeMap.Node;

public class MyTreeMap<K,V> {
	public class Node{
		Node right;
		Node left;
		K key;
		V value;
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	
	Node root;
	int size;
	public MyTreeMap() {
		root = null;
		size =0;
	}
	

	private Node findNode(Node node, K key) {
		Node out = node;
		Comparable<? super K> k = (Comparable<? super K>) key;
		int cmp = k.compareTo(node.key);
		
		if(cmp == 0) out = node;
		else if(cmp<0) out = findNode(node.left, key);
		else out = findNode(node.right, key);
		
		return out;
	}
	
	public V get(K key) {
		Node n = findNode(root, key);
		return n.value;
	}
	
	public V put(K key, V value) {
		if(key == null) throw new NullPointerException();
		if(root == null) {
			root = new Node(key, value);
			size++;
			return null;
		}else return putHelper(root, key, value);
	}
	private V putHelper(Node node, K key, V value) {
		Comparable<? super K> k = (Comparable<? super K>) key;
		int cmp = k.compareTo(node.key);
		
		if(cmp<0) {
			if(node.left == null) {
				node.left = new Node(key, value);
				size++;
				return null;
			}
			else return putHelper(node.left, key, value);
		}
		if(cmp>0){
			if(node.right == null) {
				node.right = new Node(key, value);
				size++;
				return null;
			}else return putHelper(node.right, key, value);
		}
		V val = node.value;
		node.value = value;
		return val;
	}
	
	public boolean containsValue(V value) {
		return containsValueHelper(root, value);
		
	}
	public boolean equals(Object target, Object value) {
		if(target == null) return value == null;
		return target.equals(value);
	}
	
	private boolean containsValueHelper(Node node, V value) {
		if(node == null) return false;
		if(equals(value, node.value)) return true;
		if(containsValueHelper(node.left, value)) return true;
		if(containsValueHelper(node.right, value)) return true;
		return false;
	}

	
	public void clear() {
		size = 0;
		root= null;
	}
	public int size() {
		return size;
	}
	
	public V remove(K key) {
		return removeHelper(root, key);
	}
	
	private V removeHelper(Node node, K key) {
		Node child = findNode(node, key);
		Node parent = findParent(node, key);
		V val = get(key);
		if(child.left == null && child.right == null) {
			if(parent.left != null && equals(parent.left.key, child.key )) parent.left = null;
			else parent.right = null;
		}else if(child.left == null && child.right != null || child.right == null && child.left != null) {
			if(parent.left != null && equals(parent.left.key, child.key)) 
				if(child.left!=null) parent.left = child.left;
				else parent.left = child.right;
			else 
				if(child.left!=null) parent.right = child.left;
				else parent.right = child.right;
		} else {
			Node lowest = findLowestValNode(child);
			removeHelper(child, lowest.key);
			child.key = lowest.key;
			child.value = lowest.value;
		}
		size--;
		return val;
	}
	
	private Node findLowestValNode(Node node) {
		if(node.left==null) return node;
		return findLowestValNode(node.left);
	}
	
	private Node findParent(Node node, K key) {
		Comparable<? super K> k = (Comparable<? super K>) key;
		int cmp = k.compareTo(node.key);
		
		if(cmp<0) {
			if(equals(node.left.key,key)) return node;
			else return findParent(node.left, key);
		}else {
			if(equals(node.right.key,key)) return node;
			else return findParent(node.right, key);
		}
	}
	public boolean isEmpty() {
		return size == 0;
	}
	
	public static void main(String[] args) {
		MyTreeMap<String, Integer> map = new MyTreeMap<>();
		System.out.println(map.isEmpty());
		map.put("5", 5);
		map.put("2", 2);
		map.put("1", 1);
		map.put("3", 3);
		map.put("4", 4);
		map.put("6", 6);
		
		System.out.println(map.isEmpty());
		System.out.println("size: "+map.size());

		System.out.println(map.get("2"));
		System.out.println(map.get("4"));
		System.out.println(map.get("1"));
		
		System.out.println(map.containsValue(6));
		
		System.out.println();
		System.out.println(map.remove("4"));
		System.out.println("size: "+map.size());
		System.out.println(map.containsValue(4));
		map.put("4", 4);
		System.out.println("size: "+map.size());
		System.out.println();
		
		System.out.println(map.remove("3"));
		System.out.println("size: "+map.size());
		System.out.println(map.containsValue(3));
		System.out.println(map.containsValue(4));

		map.put("3", 3);

		System.out.println(map.remove("2"));
		System.out.println("size: "+map.size());
		System.out.println(map.containsValue(2));
		System.out.println(map.containsValue(1));
		System.out.println(map.containsValue(3));
		System.out.println(map.containsValue(4));

		System.out.println();
		map.clear();
		System.out.println(map.isEmpty());
		
	}

}
