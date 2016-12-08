package sortingLab;

import java.util.Random;

public class driver {
  @SuppressWarnings({"rawtypes", "unchecked"})
  public static void main(String[] args) {
    float startTime;
    float endTime;
    int size = 500000;
    Random value = new Random();
    MyArray<Comparable> array = new MyArray(size);
    startTime = System.nanoTime();
    for (int i = 0; i < size; i++) {
      array.add(value.nextInt(1000000));
      System.out.println(i);
    }

    endTime = System.nanoTime();
    System.out.printf("List build took %.5f seconds.%n", (endTime - startTime) / 1000000000);
    
    System.out.println("Start");
    startTime = System.nanoTime();

     array.mergeSort();
    // array.quickSortIter();
    // array.quickSortRecur();
    // array.insertionSort();
    // array.bubbleSort();
    // array.bucketSort();
    // array.radixSort();
    // array.treeSort();
    // array.heapSort();

    endTime = System.nanoTime();
    System.out.printf("List sort took %.5f seconds.%n", (endTime - startTime) / 1000000000);
    //System.out.println(array.toString());

  }

}
