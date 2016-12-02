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
    return quickSortRecur(array, 0);
  }

  public static Comparable[] quickSortRecur(Comparable[] array, int pivot) {
    if (pivot == array.length - 1) {
      return array;
    }
    Comparable[] left = new Comparable[array.length];
    Comparable[] right = new Comparable[array.length];
    int j = 0;
    int k = 0;
    for (int i = pivot + 1; i < array.length; i++) {
      if (array[pivot].compareTo(array[i]) < 0) {
        right[k] = array[i];
        k++;
      } else {
        Comparable temp = array[i];
        Comparable swap;
        for (int l = 0; l <= j; l++) {
          if (left[l] == null) {
            left[l] = array[i];
          } else if (left[l].compareTo(temp) > 0) {
            swap = left[l];
            left[l] = temp;
            temp = swap;
          }
        }
        j++;
      }
    }
    left[j + 1] = array[pivot];
    pivot = j + 2;
    for (int i = pivot; i < array.length; i++) {
      left[i] = right[i - pivot];
    }
    return quickSortRecur(array, pivot);
  }

  public static Comparable[] quickSortIter(Comparable[] array) {
    int pivot = 0;
    Comparable[] left = new Comparable[array.length];
    Comparable[] right = new Comparable[array.length];
    int j = 0;
    int k = 0;
    while (pivot < array.length) {
      for (int i = pivot + 1; i < array.length; i++) {
        if (array[pivot].compareTo(array[i]) < 0) {
          right[k] = array[i];
          k++;
        } else {
          Comparable temp = array[i];
          Comparable swap;
          for (int l = 0; l <= j; l++) {
            if (left[l] == null) {
              left[l] = array[i];
            } else if (left[l].compareTo(temp) > 0) {
              swap = left[l];
              left[l] = temp;
              temp = swap;
            }
          }
          j++;
        }
      }
      left[j + 1] = array[pivot];
      pivot = j + 2;
      for (int i = pivot; i < array.length; i++) {
        left[i] = right[i - pivot];
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
    int digits = String.valueOf(array[0]).length();
    for (int i = 1; i < array.length; i++) {
      if (String.valueOf(array[i]).length() > digits) {
        digits = String.valueOf(array[i]).length();
      }
    }
    int i = 0;
    while (i < digits) {
      int[] bucket = new int[array.length];
      int j = 0;
      int k = 0;
      while (j < 10) {
        for (int l = 0; l < array.length; l++) {
          if ((array[l] / Math.pow(10, 1)) % 10 == j) {
            bucket[k] = array[l];
            k++;
          }
        }
      }
      array = bucket;
      i++;
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
    Comparable[] unsorted = array;
    Comparable[] sorted = new Comparable[array.length];
    boolean unordered = false;
    do {
      for (int i = 0; i < unsorted.length; i++) {
        p = unsorted[i];
        if (p.compareTo(unsorted[i]) < 0) {
          if (sorted.length == 0) {
            sorted[0] = array[i];
          } else {
            for (int j = 0; j < sorted.length; j++) {
              if (array[i].compareTo(sorted[j]) > 0) {
                Comparable[] temp = new Comparable[array.length];
                for (int q = 0; q < sorted.length - 1; q++) {
                  temp[q] = sorted[j + q];
                }
                sorted[j] = unsorted[i];
                for (int q = 0; q < sorted.length - 1; q++) {
                  sorted[j + q + 1] = temp[q];
                }
              } else {
                sorted[sorted.length] = array[i];
              }
            }
          }
          unordered = false;
        } else {
          unordered = true;
        }
      }
    } while (unordered);
    return array;
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
      System.out.println(i + " " + j + " " + first.length + " " + array.length);
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
    int i = 0;
    while (i < digits) {
      int[] bucket = new int[array.length];
      int j = 0;
      int k = 0;
      while (j < 10) {
        for (int l = 0; l < array.length; l++) {
          if ((array[l] / Math.pow(10, 1)) % 10 == j) {
            bucket[k] = array[l];
            k++;
          }
        }
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
    return (Comparable[]) MyTree.inorder(tree).toArray();
  }
  
  public static String toString(Comparable[] array){
    String sorted = "[";
    for(int i = 0; i < array.length - 1; i++){
      sorted = sorted + array[i] + ", ";
    }
    sorted = sorted + array[array.length-1] + "]";
    return sorted;
  }
}
