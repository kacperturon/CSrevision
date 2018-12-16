package thinkDAST.rev10;


public class MyTreeMap<K,V> {

	public class Node{
		Node left;
		Node right;
		K key;
		V value;
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			left = null;
			right = null;
		}
	}
	
	Node root;
	int size;
	
	public MyTreeMap() {
		root = null;
		size = 0;
	}

	public boolean equals(Object target, Object value) {
		if(target == null) return value == null;
		return target.equals(value);
	}
	
	public void clear() {
		root = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public V get(K key) {
		Node node = findNode(root, key);
		return node.value;
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
	
	public boolean containsValue(V value) {
		return containsValueHelper(root, value);
	}
	
	private boolean containsValueHelper(Node node, V value) {
		if(node == null) return false;
		if(equals(node.value, value)) return true;
		if(containsValueHelper(node.left, value)) return true;
		if(containsValueHelper(node.right, value)) return true;
		return false;
	}
	
	public V put(K key, V val) {
		if(key == null)throw new NullPointerException();
		if(root == null) {
			root = new Node(key, val);
			size++;
			return null;
		}else
		return putHelper(root, key, val);
	}
	
	private V putHelper(Node node, K key, V val) {
		Comparable<? super K> k = (Comparable<? super K>) key;
		int cmp =k.compareTo(node.key);
		if(cmp<0) {
			if(node.left == null) {
				node.left = new Node(key, val);
				size++;
				return null;
			} else return putHelper(node.left, key, val);
		}
		if(cmp>0){
			if(node.right == null) {
				node.right = new Node(key, val);
				size++;
				return null;
			}else return putHelper(node.right, key, val);
		}
		V oldVal = node.value;
		node.value = val;
		return oldVal;
		
	}
	
	
	public V remove(K key) {
		return removeHelper(root, key);
	}
	
	private V removeHelper(Node root, K key) {
		Comparable<? super K> k = (Comparable<? super K>) key;
		int cmp = k.compareTo(key);
		Node node = findNode(root, key);
		Node parent = findParent(root, key);
		System.out.println(parent.value);
		V val = get(key);
		if(node.left == null && node.right == null) { // no children
			if(parent.left != null && equals(parent.left.key, node.key)) parent.left = null;
			else parent.right = null;
		}else if(node.left == null && node.right !=null || node.right == null && node.left != null) { // 1 child
			if(parent.left != null && equals(parent.left.key, node.key)) 
				if(node.left!=null) parent.left = node.left;
				else parent.left = node.right;
			else 
				if(node.left!=null) parent.right = node.left;
				else parent.right = node.right;
		}else { // 2 children
			Node lowest = findNodeLowestValue(node);
			System.out.println("lowest: "+lowest.value);
			removeHelper(node, lowest.key);
			node.key = lowest.key;
			node.value = lowest.value;
		}
		size--;
		return val;
		
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
	
	private Node findNodeLowestValue(Node node) {
		if(node.left == null) return node; 
		return findNodeLowestValue(node.left);
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
