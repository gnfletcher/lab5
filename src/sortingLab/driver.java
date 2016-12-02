package sortingLab;

import java.util.Random;

public class driver {
	public static void main(String[] args){
		int[] array = {4564, 1, 3255, 254, 87, 921, 35, 2121, 156};
		Comparable[] arrayComp = {4564, 5000, 6000, 1, 3255, 254, 87, 921, 35, 2121, 156};
		
		//Comparable[] arrayQSR = Sort.quickSortRecur(arrayComp);
		//Comparable[] arrayQSI = Sort.quickSortIter(arrayComp);
		//Comparable[] arrayMerge = Sort.mergeSort(arrayComp);
		//Comparable[] arrayInser = Sort.insertionSort(arrayComp);
		//Comparable[] arrayBubble = Sort.bubbleSort(arrayComp);
		//Comparable[] arrayHeap = Sort.heapSort(arrayComp);
		//Comparable[] arrayTree = Sort.treeSort(arrayComp);
		//int[] arrayRadix = Sort.radixSort(array);
		int[] arrayBucket = Sort.bucketSort(array);
		
		//Random value = new Random();
		//MyTree tree = new MyTree();
		//for(int i = 0; i < 500000; i++){
		//  tree.insert(tree, value.nextInt(1000));
		//}
		
		//System.out.println(Sort.toString(arrayQSR));
		//System.out.println(Sort.toString(arrayQSI));
		//System.out.println(Sort.toString(arrayMerge));
		//System.out.println(Sort.toString(arrayInser));
		//System.out.println(Sort.toString(arrayBubble));
		//System.out.println(Sort.toString(arrayHeap));
		//System.out.println(Sort.toString(arrayTree));
		//System.out.println(arrayRadix.toString());
		System.out.println(arrayBucket.toString());
	}

}
