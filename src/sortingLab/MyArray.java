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
@SuppressWarnings({"rawtypes", "unchecked"})
public class MyArray<T> implements MyList<T> {
	private int size;
	private int length;
	private T[] array;

	/**
	 * 
	 */
	public MyArray() {
		this.length = 10;
		this.array = (T[]) Array.newInstance(MyArray.class, length);
		this.size = 0;
	}

	public MyArray(int size) {
		this.length = size;
		this.array = (T[]) Array.newInstance(MyArray.class, length);
		this.size = size;
	}

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
	
	public  T[] mergeSort() {
	    if (size == 1) {
	      return array;
	    }
	    if (size == 2) {
	      T first = array[0];
	      if (((Comparable) array[0]).compareTo(array[1]) > 0) {
	        array[0] = array[1];
	        array[1] = first;
	      }
	      return array;
	    }
	    int mid = size / 2;
	    MyArray first = new MyArray();
	    MyArray second = new MyArray();
	    for (int i = 0; i < mid; i++) {
	      first.add(array[i]);
	    }
	    for (int i = mid; i < array.length; i++) {
	      second.add(array[i]);
	    }
	    first.mergeSort();
	    second.mergeSort();
	    int j = 0;
	    int k = 0;
	    int i = 0;
	    while ((first.getSize() != j) && (second.getSize() != k)) {
	      if (((Comparable) first.get(j)).compareTo(second.get(k)) < 0) {
	        array[i] = (T) first.get(j);
	        j++;
	        i++;
	      } else {
	        array[i] = (T) second.get(k);
	        k++;
	        i++;
	      }
	    }
	    if (first.length == j) {
	      for (; i < array.length; i++) {
	        array[i] = (T) second.get(k);
	        k++;
	      }
	    } else {
	      for (; i < array.length; i++) {
	        array[i] = (T) first.get(j);
	        j++;
	      }
	    }
	    return array;
	  }
	
	public static MyArray radixSort(MyArray array) {
	    int digits = String.valueOf(array.get(0)).length();
	    for (int i = 1; i < array.length; i++) {
	      if (String.valueOf(array.get(i)).length() > digits) {
	        digits = String.valueOf(array.get(i)).length();
	      }
	    }
	    int i = 1;
	    while (i <= digits) {
	      MyArray bucket = new MyArray();
	      int j = 0;
	      int k = 0;
	      while (j < 10) {
	        for (int l = 0; l < array.size; l++) {
	          if ((int) array.get(l) % (int) (Math.pow(10, i)) / (int) (Math.pow(10, i - 1)) == j) {
	            bucket.set(l, array.get(l));
	            k++;
	          }
	        }
	        j++;
	      }
	      array = bucket;
	      i++;
	    }
	    return array;
	  }

}
