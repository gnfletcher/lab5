/**
 * 
 */
package sortingLab;

/**
 * @author FletcherG
 *
 */
public class Sort {

  public Sort() {

  }

  public static Comparable[] quickSortRecur(Comparable[] array) {
    return array;
  }

  public static Comparable[] quickSortIter(Comparable[] array) {
    return array;
  }

  public static Comparable[] bubbleSort(Comparable[] array) {
    boolean unordered = false;
    do {
      for (int i = 0; i < array.length; i++) {
        if (array[i].compareTo(array[i + 1]) > 0) {
          Comparable temp = array[i + 1];
          array[i + 1] = array[i];
          array[i] = temp;
          unordered = true;
        } else {
          unordered = false;
        }
      }
    } while (unordered);
    return array;
  }

  public static Comparable[] bucketSort(Comparable[] array) {
    return array;
  }

  public static Comparable[] heapSort(Comparable[] array) {
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
        array[0] = first;
      }
      return array;
    }
    int mid = array.length / 2;
    Comparable[] first = new Comparable[mid];
    Comparable[] second = new Comparable[array.length - mid];
    for (int i = 0; i < mid; i++) {
      array[i] = first[i];
    }
    for (int i = mid; i < array.length; i++) {
      array[i] = second[i - mid];
    }
    first = mergeSort(first);
    second = mergeSort(second);
    int j = 0;
    int k = 0;
    for(int i = 0; i < array.length; i++){
      if(first[j].compareTo(second[k]) < 0){
        array[i] = first[j];
        j++;
      } else {
        array[i] = second[k];
        k++;
      }
    }
    return array;

  }

  public static Comparable[] radixSort(Comparable[] array) {
    return array;
  }

  public static Comparable[] treeSort(Comparable[] array) {
    return array;
  }
}
