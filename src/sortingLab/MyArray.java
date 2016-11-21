/**
 * 
 */
package sortingLab;

import java.lang.reflect.Array;

/**
 * @author FletcherG
 * @param <E>
 *
 */
public class MyArray<T> implements MyList<T> {
	private int size;
	private int length;
	private T[] array;

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public MyArray() {
		this.length = 10;
		this.array = (T[]) Array.newInstance(MyArray.class, length);
		this.size = 0;
	}

	@SuppressWarnings("unchecked")
	public MyArray(int size) {
		this.length = size;
		this.array = (T[]) Array.newInstance(MyArray.class, length);
		this.size = size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean add(int index, T object) {
		T[] newArray;
		if (array[array.length - 1] != null) {
			newArray = (T[]) new Object[array.length * 2];
		} else {
			newArray = (T[]) new Object[array.length];
		}
		for (int i = 0; i < index; i++) {
			newArray[i] = array[i];

		}
		newArray[index] = object;
		for (int i = index + 1; i < array.length; i++) {
			newArray[i] = array[i - 1];
		}
		this.size++;
		this.array = newArray;
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean add(T object) {
		T[] newArray;
		if (array[array.length - 1] != null) {
			newArray = (T[]) new Object[array.length * 2];
		} else {
			newArray = (T[]) new Object[array.length];
		}
		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		newArray[size] = object;
		this.size++;
		this.array = newArray;
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean clear() {
		this.array = (T[]) new Object[10];
		this.length = 10;
		this.size = 0;
		return true;
	}

	@Override
	public boolean contains(T object) {
		for (int i = 0; i < this.size; i++) {
			if (array[i].equals(object)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public T get(int index) {
		return (T) array[index];
	}

	@Override
	public int indexOf(T object) {
		for (int i = 0; i < this.size; i++) {
			if (array[i].equals(object)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public T remove(int index) {
		T removed = array[index];
		for (int i = index + 1; i < array.length; i++) {
			array[i] = array[i + 1];
		}
		this.size = size - 1;
		return removed;
	}

	@Override
	public T remove(Object object) {
		T removed = null;
		for (int i = 0; i < array.length; i++) {
			while (!array[i].equals(object)) {

			}
			removed = array[i];
			array[i] = array[i + 1];
		}
		this.size = size - 1;
		return removed;
	}

	@Override
	public boolean set(int index, T element) {
		array[index] = element;
		return true;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public T[] subList(int fromIndex, int toIndex) {
		@SuppressWarnings("unchecked")
		T[] newArray = (T[]) new Object[toIndex - fromIndex + 1];
		int j = 0;
		for (int i = fromIndex; i < toIndex; i++) {
			newArray[j] = array[i];
			j++;
		}
		return newArray;
	}

	@Override
	public T[] toArray() {
		return (T[]) array;
	}

	@Override
	public boolean swap(int position1, int position2) {
		T first = array[position1];
		T second = array[position2];
		array[position1] = second;
		array[position2] = first;
		return true;
	}

	@Override
	public boolean shift(int positions) {
		@SuppressWarnings("unchecked")
		T[] newArray = (T[]) new Object[array.length];
		if (positions > 0) {
			int j = 0;
			for (int i = positions; i < size -1; i++) {
				newArray[j] = array[i];
				j++;
			}
			for (int i = 0; i < positions; i++) {
				newArray[j] = array[i];
				j++;
			}
		} else if (positions < 0) {
			int j = 0;
			for (int i = size + positions - 1; i < size -1; i++) {
				newArray[j] = array[i];
				j++;
			}
			for (int i = 0; i < size + positions; i++) {
				newArray[j] = array[i];
				j++;
			}
		} else {
			return true;
		}
		this.array = newArray;
		return true;
	}

	public int getSize() {
		return size;
	}
}
