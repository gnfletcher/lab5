package sortingLab;

import java.util.Random;

public class driver {
  public static void main(String[] args) {

    int size = 15;
    Random value = new Random();
    MyArray<Comparable> array = new MyArray(size);
    for (int i = 0; i < size; i++) {
      array.add(value.nextInt(1000000));
    }

    System.out.println(array.toString());

    // array.mergeSort();
    // array.quickSortRecur();
    array.quickSortIter();
    // array.treeSort();
    // array.heapSort();
    // array.bubbleSort();
    // array.insertionSort();
    // array.radixSort();
    // array.bucketSort();

    System.out.println(array.toString());

  }

}
