package thinkDAST.rev1;

public class MyArrayList<T> {

	int size;
	private T[] array;

	public MyArrayList() {
		array = (T[]) new Object[10];
		size = 0;
	}

	public T get(int index) {
		if (index >= size || index < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return array[index];
	}

	public Boolean add(T element) {
		if (size >= array.length) { // if too small double the size
			T[] bigger = (T[]) new Object[array.length * 2];
			System.arraycopy(array, 0, bigger, 0, size);
			array = bigger;
		}
		array[size] = element;
		size++;
		return true;
	}

	public void add(int index, T element) {
		if (index >= size || index < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}

		add(element);
		for (int i = size - 1; i > index; i--) {
			array[i] = array[i - 1];
			// shift the last element into index place
		}
		array[index] = element;
	}

	public int indexOf(Object o) {
		for (int i = 0; i < size; i++) {
			if (o.equals(array[i]))
				return i;
		}
		return -1;
	}

	public Boolean remove(Object o) {
		int index = indexOf(o);
		if (index == -1) {
			return false;
		}
		remove(index);
		return true;
	}

	public T remove(int index) {
		T val = get(index);
		for (int i = index; i < size - 1; i++) {
			array[i] = array[i + 1];
		}
		size--;
		return val;

	}

	public T set(int index, T element) {
		T val = get(index);
		array[index] = element;
		return val;
	}

	public static void main(String[] args) {
		MyArrayList arr1 = new MyArrayList();
		arr1.add(1);
		arr1.add(2);
		arr1.add(3);
		arr1.add(0, 5);
		arr1.remove(1);

		MyArrayList arr2 = arr1;
		arr2.add(4);

		System.out.println(
				"arr1: " + arr1.size + " " + arr1.get(0) + " " + arr1.get(1) + " " + arr2.get(2) + " " + arr2.get(3));

		System.out.println(
				"arr2: " + arr2.size + " " + arr2.get(0) + " " + arr2.get(1) + " " + arr2.get(2) + " " + arr2.get(3));

	}

}
