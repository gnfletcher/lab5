/**
 * 
 */
package sortingLab;

/**
 * @author FletcherG
 *
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class Sort {

  public Sort() {

  }

  public static Comparable[] quickSortRecur(Comparable[] array) {
    return quickSortRecur(array, array.length);
  }

  public static Comparable[] quickSortRecur(Comparable[] array, int length) {
    if (length == 1) {
      System.out.println(array[0]);
      return array;
    }
    if (length == 2) {
      System.out.println(array[0]);
      System.out.println(array[1]);
      return array;
    }
    Comparable[] left = new Comparable[length];
    Comparable[] right = new Comparable[length];
    int j = 0;
    int k = 0;
    for (int i = 1; i < length - 1; i++) {
      if (array[i] != null) {
        if (array[0].compareTo(array[i]) <= 0) {
          right[k] = array[i];
          k++;
        } else {
          left[j] = array[i];
          j++;
        }
      }
    }
    if (j > 0) {
      left = quickSortRecur(left, j + 1);
    }
    if (k > 0) {
      right = quickSortRecur(right, k + 1);
    }
    left[j] = array[0];
    j++;
    for (int i = 0; i <= k; i++) {
      if (right[i] != null) {
        left[j] = right[i];
        j++;
      }
    }
    return left;
  }

  public static Comparable[] quickSortIter(Comparable[] array) {
    int pivot = 0;
    int j = 0;
    int k = 0;
    while (pivot < array.length) {
      for (int i = pivot + 1; i < array.length; i++) {
        if (array[pivot].compareTo(array[i]) < 0) {
          if (i - k > 1) {
            Comparable temp = array[i];
            array[i] = array[k + 1];
            array[k + 1] = temp;
          }
          k++;
        }
        Comparable temp = array[pivot];
        array[pivot] = array[k];
        array[k] = temp;
        pivot = k + 1;
      }
    }
    return array;
  }


  public static Comparable[] bubbleSort(Comparable[] array) {
    boolean unordered = false;
    do {
      unordered = false;
      for (int i = 0; i < array.length - 1; i++) {
        if (array[i].compareTo(array[i + 1]) > 0) {
          Comparable temp = array[i + 1];
          array[i + 1] = array[i];
          array[i] = temp;
          unordered = true;
        }
      }
    } while (unordered);
    return array;
  }

  public static int[] bucketSort(int[] array) {
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
     if(array[i] / 10 < 0){
       ten.add(array[i]);
     } else if (array[i] / 100 < 0) {
       hundred.add(array[i]);
     } else if (array[i] / 1000 < 0) {
       thousand.add(array[i]);
     } else if (array[i] / 10000 < 0) {
       tenThousand.add(array[i]);
     } else if (array[i] / 100000 < 0) {
       hundredThousand.add(array[i]);
     } else if (array[i] / 1000000 < 0) {
       million.add(array[i]);
     } else if (array[i] / 10000000 < 0) {
       tenMillion.add(array[i]);
     } else if (array[i] / 100000000 < 0) {
       hundredMillion.add(array[i]);
     } else {
       billion.add(array[i]);
     }
    }
    
    ten = MyArray.radixSort(ten);
    hundred = MyArray.radixSort(hundred);
    thousand = MyArray.radixSort(thousand);
    tenThousand = MyArray.radixSort(tenThousand);
    hundredThousand = MyArray.radixSort(hundredThousand);
    million = MyArray.radixSort(million);
    tenMillion = MyArray.radixSort(tenMillion);
    hundredMillion = MyArray.radixSort(hundredMillion);
    billion = MyArray.radixSort(billion);
    
    int j = 0;
    
    for(int i = 0; i < ten.getSize(); i++){
      array[j] = (int) ten.get(i);
    }
    for(int i = 0; i < hundred.getSize(); i++){
      array[j] = (int) hundred.get(i);
    }
    for(int i = 0; i < thousand.getSize(); i++){
      array[j] = (int) thousand.get(i);
    }
    for(int i = 0; i < tenThousand.getSize(); i++){
      array[j] = (int) tenThousand.get(i);
    }
    for(int i = 0; i < hundredThousand.getSize(); i++){
      array[j] = (int) hundredThousand.get(i);
    }
    for(int i = 0; i < million.getSize(); i++){
      array[j] = (int) million.get(i);
    }
    for(int i = 0; i < tenMillion.getSize(); i++){
      array[j] = (int) tenMillion.get(i);
    }
    for(int i = 0; i < hundredMillion.getSize(); i++){
      array[j] = (int) hundredMillion.get(i);
    }
    for(int i = 0; i < billion.getSize(); i++){
      array[j] = (int) billion.get(i);
    }
    return array;
  }

  public static Comparable[] heapSort(Comparable[] array) {
    MyHeap heap = new MyHeap();
    heap.makeHeap(array[0]);
    for (int i = 1; i < array.length; i++) {
      heap.insert(array[i]);
    }
    int i = 0;
    while (!heap.isEmpty()) {
      array[i] = heap.findMin();
      heap.deleteMin();
      i++;
    }
    return array;
  }

  public static Comparable[] insertionSort(Comparable[] array) {
    Comparable p = array[0];
    Comparable[] sorted = new Comparable[array.length];
    sorted[0] = p;
    for (int i = 0; i < array.length - 1; i++) {
      if (p.compareTo(array[i + 1]) < 0) {
        p = array[i + 1];
        sorted[i + 1] = p;
      } else {
        Comparable temp = array[i + 1];
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
    return sorted;
  }

  public static Comparable[] mergeSort(Comparable[] array) {
    if (array.length == 1) {
      return array;
    }
    if (array.length == 2) {
      Comparable first = array[0];
      if (array[0].compareTo(array[1]) > 0) {
        array[0] = array[1];
        array[1] = first;
      }
      return array;
    }
    int mid = array.length / 2;
    Comparable[] first = new Comparable[mid];
    Comparable[] second = new Comparable[array.length - mid];
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
      if (first[j].compareTo(second[k]) < 0) {
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

  public static int[] radixSort(int[] array) {
    int digits = String.valueOf(array[0]).length();
    for (int i = 1; i < array.length; i++) {
      if (String.valueOf(array[i]).length() > digits) {
        digits = String.valueOf(array[i]).length();
      }
    }
    int i = 1;
    while (i <= digits) {
      int[] bucket = new int[array.length];
      int j = 0;
      int k = 0;
      while (j < 10) {
        for (int l = 0; l < array.length; l++) {
          if (array[l] % (int) (Math.pow(10, i)) / (int) (Math.pow(10, i - 1)) == j) {
            bucket[k] = array[l];
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

  public static Comparable[] treeSort(Comparable[] array) {
    MyTree tree = new MyTree(array[0]);
    for (int i = 1; i < array.length; i++) {
      tree = MyTree.insert(tree, array[i]);
    }
    Object[] treeArray = MyTree.inorder(tree).toArray();
    Comparable[] sorted = new Comparable[array.length];
    for (int i = 0; i < array.length; i++) {
      sorted[i] = (Comparable) treeArray[i];
    }
    return sorted;
  }

  public static String toString(int[] array) {
    String sorted = "[";
    for (int i = 0; i < array.length - 1; i++) {
      sorted = sorted + array[i] + ", ";
    }
    sorted = sorted + array[array.length - 1] + "]";
    return sorted;
  }

  public static String toString(Comparable[] array) {
    String sorted = "[";
    for (int i = 0; i < array.length - 1; i++) {
      sorted = sorted + array[i] + ", ";
    }
    sorted = sorted + array[array.length - 1] + "]";
    return sorted;
  }
}
