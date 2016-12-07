package sortingLab;

import java.util.Random;

public class driver {
  @SuppressWarnings({"rawtypes", "unchecked"})
  public static void main(String[] args) {

    int size = 15;
    Random value = new Random();
    MyArray<Comparable> array = new MyArray(size);
    for (int i = 0; i < size; i++) {
      array.add(value.nextInt(1000000));
    }

    System.out.println(array.toString());

    // array.mergeSort();
     array.quickSortIter();
    // array.quickSortRecur();
    // array.insertionSort();
    // array.bubbleSort();
    // array.bucketSort();
    // array.radixSort();
    // array.treeSort();
    // array.heapSort();

    System.out.println(array.toString());

  }

}
