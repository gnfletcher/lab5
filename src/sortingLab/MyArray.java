/**
 * 
 */
package sortingLab;

import java.lang.reflect.Array;

/**
 * Implements MyList interface as an array.
 * 
 * @author Greg Fletcher
 * @author Sean O'Donnell
 *
 * @param <T> list type
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class MyArray<T> implements MyList<T> {
  private int size;
  private int length;
  private T[] array;

  /**
   * Default constructor initializes an empty array of length 10.
   */
  public MyArray() {
    this.length = 10;
    this.array = (T[]) Array.newInstance(MyArray.class, length);
    this.size = 0;
  }

  /**
   * Constructor creating an array with the given size
   * 
   * @param length
   */
  public MyArray(int size) {
    this.length = size;
    this.array = (T[]) Array.newInstance(MyArray.class, length);
    this.size = 0;
  }

  /**
   * Adds element at a given index.
   * 
   * @param index index to add at.
   * @param object element to be added.
   * @return boolean if operation was successful.
   */
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

  /**
   * Adds element at the end of the list.
   * 
   * @param index index to add at.
   * @param object element to be added.
   * @return boolean if operation was successful.
   */
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

  /**
   * Clears list of all elements.
   * 
   * @return boolean if operation was successful.
   */
  @Override
  public boolean clear() {
    this.array = (T[]) new Object[10];
    this.length = 10;
    this.size = 0;
    return true;
  }

  /**
   * Searches list for given element.
   * 
   * @param object to search for in list.
   * @return boolean if operation was successful.
   */
  @Override
  public boolean contains(T object) {
    for (int i = 0; i < this.size; i++) {
      if (array[i].equals(object)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Retrieves element at given index.
   * 
   * @param index of element to retrieve.
   * @return element
   */
  @Override
  public T get(int index) {
    return (T) array[index];
  }

  /**
   * Searches list for given element to find index value.
   * 
   * @param object to search for in list.
   * @return int value of the element's index.
   */
  @Override
  public int indexOf(T object) {
    for (int i = 0; i < this.size; i++) {
      if (array[i].equals(object)) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Check if list is empty.
   * 
   * @return boolean if list does not have content.
   */
  @Override
  public boolean isEmpty() {
    if (size == 0) {
      return true;
    }
    return false;
  }

  /**
   * Removes element at given index.
   * 
   * @param index of element to be removed.
   * @return object that was removed.
   */
  @Override
  public T remove(int index) {
    T removed = array[index];
    for (int i = index + 1; i < array.length; i++) {
      array[i] = array[i + 1];
    }
    this.size = size - 1;
    return removed;
  }

  /**
   * Removes given object from list.
   * 
   * @param object to be removed.
   * @return object that was removed.
   */
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

  /**
   * Sets value of element to given value at given index.
   * 
   * @param index index of element to set value.
   * @param element value to set.
   * @return boolean if operation was successful.
   */
  @Override
  public boolean set(int index, T element) {
    array[index] = element;
    return true;
  }

  /**
   * Returns number of elements in list.
   * 
   * @return int value of list size.
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Creates a list from a section of elements for a list from a given index to a given index.
   * 
   * @param fromIndex starting index for new list
   * @param toIndex ending index for new list
   * @return list of the specified subset.
   */
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

  /**
   * Converts content of list to an array.
   * 
   * @return array of list elements
   */
  @Override
  public T[] toArray() {
    return (T[]) array;
  }

  /**
   * Takes two elements at given indexes and exchanges their value.
   * 
   * @param position1 index of first element
   * @param position2 index of second element
   * @return boolean if operation was successful.
   */
  @Override
  public boolean swap(int position1, int position2) {
    T first = array[position1];
    T second = array[position2];
    array[position1] = second;
    array[position2] = first;
    return true;
  }

  /**
   * Moves elements in list by given number of elements. Indexes can move in a positive or negative
   * direction.
   * 
   * @param positions number of indexes to move elements of list.
   * @return boolean if operation was successful.
   */
  @Override
  public boolean shift(int positions) {
    T[] newArray = (T[]) new Object[array.length];
    if (positions > 0) {
      int j = 0;
      for (int i = positions; i < size - 1; i++) {
        newArray[j] = array[i];
        j++;
      }
      for (int i = 0; i < positions; i++) {
        newArray[j] = array[i];
        j++;
      }
    } else if (positions < 0) {
      int j = 0;
      for (int i = size + positions - 1; i < size - 1; i++) {
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

  /**
   * Gets size of array.
   * 
   * @return int of array size
   */
  public int getSize() {
    return size;
  }

  /**
   * Provides a String representation of the items in the array
   * 
   * @return String representation of array
   */
  public String toString() {
    String sorted = "[";
    for (int i = 0; i < size - 1; i++) {
      sorted = sorted + array[i] + ", ";
    }
    sorted = sorted + array[size - 1] + "]";
    return sorted;
  }

  /**
   * Performs Merge Sort on the array
   * 
   */
  public void mergeSort() {
    this.array = mergeSort(array);
  }

  /**
   * Sorts the array using Merge Sort
   * 
   * @param array to be sorted
   * @return array that has been sorted
   */
  public T[] mergeSort(T[] array) {
    if (array.length == 1) {
      return array;
    }
    if (array.length == 2) {
      Comparable first = (Comparable) array[0];
      if (((Comparable) array[0]).compareTo(array[1]) > 0) {
        array[0] = array[1];
        array[1] = (T) first;
      }
      return array;
    }
    int mid = array.length / 2;
    T[] first = (T[]) new Object[mid];
    T[] second = (T[]) new Object[array.length - mid];
    for (int i = 0; i < mid; i++) {
      first[i] = array[i];
    }
    for (int i = mid; i < array.length; i++) {
      second[i - mid] = array[i];
    }
    first = mergeSort(first);
    second = mergeSort(second);
    int j = 0;
    int k = 0;
    int i = 0;
    while ((first.length != j) && (second.length != k)) {
      if (((Comparable) first[j]).compareTo(second[k]) < 0) {
        array[i] = first[j];
        j++;
        i++;
      } else {
        array[i] = second[k];
        k++;
        i++;
      }
    }
    if (first.length == j) {
      for (; i < array.length; i++) {
        array[i] = second[k];
        k++;
      }
    } else {
      for (; i < array.length; i++) {
        array[i] = first[j];
        j++;
      }
    }
    return array;
  }

  /**
   * Sorts the array using Radix Sort
   * 
   * @param array to be sorted
   * @return array that has been sorted
   */
  public MyArray radixSort(MyArray array) {
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
      while (j < 10) {
        for (int l = 0; l < array.size; l++) {
          if ((int) array.get(l) % (int) (Math.pow(10, i)) / (int) (Math.pow(10, i - 1)) == j) {
            bucket.add(array.get(l));
          }
        }
        j++;
      }
      array = bucket;
      i++;
    }
    return array;
  }

  /**
   * Sorts the array using Merge Sort
   * 
   */
  public void radixSort() {
    int digits = String.valueOf(array[0]).length();
    for (int i = 1; i < array.length; i++) {
      if (String.valueOf(array[i]).length() > digits) {
        digits = String.valueOf(array[i]).length();
      }
    }
    int i = 1;
    while (i <= digits) {
      T[] bucket = (T[]) new Object[array.length];
      int j = 0;
      int k = 0;
      while (j < 10) {
        for (int l = 0; l < array.length; l++) {
          if ((int) array[l] % (int) (Math.pow(10, i)) / (int) (Math.pow(10, i - 1)) == j) {
            bucket[k] = array[l];
            k++;
          }
        }
        j++;
      }
      array = bucket;
      i++;
    }

  }

  /**
   * Sorts the array using Bucket Sort
   * 
   * @param array to be sorted
   * @return array that has been sorted
   */
  public void bucketSort() {
    MyArray ten = new MyArray();
    MyArray hundred = new MyArray();
    MyArray thousand = new MyArray();
    MyArray tenThousand = new MyArray();
    MyArray hundredThousand = new MyArray();
    MyArray million = new MyArray();
    MyArray tenMillion = new MyArray();
    MyArray hundredMillion = new MyArray();
    MyArray billion = new MyArray();

    for (int i = 0; i < array.length; i++) {
      if ((int) array[i] / 10 < 0) {
        ten.add(array[i]);
      } else if ((int) array[i] / 100 < 0) {
        hundred.add(array[i]);
      } else if ((int) array[i] / 1000 < 0) {
        thousand.add(array[i]);
      } else if ((int) array[i] / 10000 < 0) {
        tenThousand.add(array[i]);
      } else if ((int) array[i] / 100000 < 0) {
        hundredThousand.add(array[i]);
      } else if ((int) array[i] / 1000000 < 0) {
        million.add(array[i]);
      } else if ((int) array[i] / 10000000 < 0) {
        tenMillion.add(array[i]);
      } else if ((int) array[i] / 100000000 < 0) {
        hundredMillion.add(array[i]);
      } else {
        billion.add(array[i]);
      }
    }

    ten = ten.radixSort(ten);
    hundred = hundred.radixSort(hundred);
    thousand = thousand.radixSort(thousand);
    tenThousand = tenThousand.radixSort(tenThousand);
    hundredThousand = hundredThousand.radixSort(hundredThousand);
    million = million.radixSort(million);
    tenMillion = tenMillion.radixSort(tenMillion);
    hundredMillion = hundredMillion.radixSort(hundredMillion);
    billion = billion.radixSort(billion);

    int j = 0;
    for (int i = 0; i < ten.getSize(); i++) {
      array[i] = (T) ten.get(i);
      j++;
    }
    for (int i = 0; i < hundred.getSize(); i++) {
      array[i] = (T) hundred.get(i);
      j++;
    }
    for (int i = 0; i < thousand.getSize(); i++) {
      array[i] = (T) thousand.get(i);
      j++;
    }
    for (int i = 0; i < tenThousand.getSize(); i++) {
      array[i] = (T) tenThousand.get(i);
      j++;
    }
    for (int i = 0; i < hundredThousand.getSize(); i++) {
      array[i] = (T) hundredThousand.get(i);
      j++;
    }
    for (int i = 0; i < million.getSize(); i++) {
      array[i] = (T) million.get(i);
      j++;
    }
    for (int i = 0; i < tenMillion.getSize(); i++) {
      array[i] = (T) tenMillion.get(i);
      j++;
    }
    for (int i = 0; i < hundredMillion.getSize(); i++) {
      array[j] = (T) hundredMillion.get(i);
      j++;
    }
    for (int i = 0; i < billion.getSize(); i++) {
      array[j] = (T) billion.get(i);
      j++;
    }

  }

  /**
   * Sorts the Tree using Tree Sort
   * 
   */
  public void treeSort() {
    MyTree tree = new MyTree((Comparable) array[0]);
    for (int i = 1; i < array.length; i++) {
      tree = MyTree.insert(tree, (Comparable) array[i]);
    }
    Object[] treeArray = MyTree.inorder(tree).toArray();
    for (int i = 0; i < array.length; i++) {
      array[i] = (T) treeArray[i];
    }

  }

  /**
   * Sorts the Heap using Heap Sort
   * 
   */
  public void heapSort() {
    MyHeap heap = new MyHeap();
    heap.makeHeap((Comparable) array[0]);
    for (int i = 1; i < array.length; i++) {
      heap.insert((Comparable) array[i]);
    }
    int i = 0;
    while (!heap.isEmpty()) {
      array[i] = (T) heap.findMin();
      heap.deleteMin();
      i++;
    }
  }

  /**
   * Sorts the array using Bubble Sort
   * 
   */
  public void bubbleSort() {
    boolean unordered = false;
    do {
      unordered = false;
      for (int i = 0; i < array.length - 1; i++) {
        if (((Comparable) array[i]).compareTo(array[i + 1]) > 0) {
          T temp = array[i + 1];
          array[i + 1] = array[i];
          array[i] = temp;
          unordered = true;
        }
      }
    } while (unordered);
  }

  /**
   * Sorts the array using Insertion Sort
   * 
   */
  public void insertionSort() {
    Comparable p = (Comparable) array[0];
    Comparable[] sorted = new Comparable[array.length];
    sorted[0] = p;
    for (int i = 0; i < array.length - 1; i++) {
      if (p.compareTo(array[i + 1]) < 0) {
        p = (Comparable) array[i + 1];
        sorted[i + 1] = p;
      } else {
        Comparable temp = (Comparable) array[i + 1];
        int j = i;
        while (j >= 0 && sorted[j].compareTo(array[i + 1]) > 0) {
          j--;
        }
        for (int q = i; q > j; q--) {
          sorted[q + 1] = sorted[q];
        }
        sorted[j + 1] = temp;
      }
    }
    this.array = (T[]) sorted;
  }

  /**
   * Performs Recursive Quick Sort on the array
   * 
   */
  public void quickSortRecur() {
    this.array = quickSortRecur(array, size);
  }

  /**
   * Sorts the array Recursively using Quick Sort
   * 
   * @param array to be sorted
   * @param length of the array
   * @return array that has been sorted
   */
  public T[] quickSortRecur(T[] array, int length) {
    if (length == 1) {
      return array;
    }
    T[] left = (T[]) new Object[length];
    T[] right = (T[]) new Object[length];
    int j = 0;
    int k = 0;
    for (int i = 1; i < length; i++) {
      if (array[i] != null) {
        if (((Comparable) array[0]).compareTo(array[i]) <= 0) {
          right[k] = array[i];
          k++;
        } else {
          left[j] = array[i];
          j++;
        }
      }
    }
    left[j] = array[0];
    j++;
    if (j > 0) {
      left = quickSortRecur(left, j);
    }
    if (k > 0) {
      right = quickSortRecur(right, k);
    }
    j = 0;
    for (int i = 0; i < left.length; i++) {
      if (left[i] != null) {
        array[j] = left[i];
        j++;
      }
    }
    for (int i = 0; i < right.length; i++) {
      if (right[i] != null) {
        array[j] = right[i];
        j++;
      }
    }
    return array;
  }

  /**
   * Sorts the array Iteratively using Quick Sort
   * 
   * @param array to be sorted
   * @return array that has been sorted
   */
  public void quickSortIter(){
    int pivot = 0;
    int partition;
    boolean unordered = false;
    do {
      unordered = false;
      partition = pivot;
      for (int i = pivot + 1; i < array.length - 1; i++) {
        if (((Comparable) array[pivot]).compareTo(array[i]) >= 0) {
          if (i - partition > 1) {
            T temp = array[i];
            array[i] = array[partition];
            array[partition] = temp;
            partition++;
            unordered = true;
          } else {
            partition++;
            unordered = true;
          }
        }
      }
      T temp = array[partition];
      array[partition] = array[pivot];
      array[pivot] = temp;
      if (partition < array.length) {
        for (int i = 0; i < partition; i++) {
          if (((Comparable) array[i]).compareTo(array[i + 1]) > 0) {
            pivot = i;
            break;
          }
        }
      }
    } while (unordered);

  }
}
