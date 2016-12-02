package sortingLab;

public class driver {
	public static void main(String[] args){
		int[] array = {4564, 1, 3255, 254, 87, 921, 35, 2121, 156};
		Comparable[] arrayComp = {4564, 1, 3255, 254, 87, 921, 35, 2121, 156};
		
		//Comparable[] arrayQSR = Sort.quickSortRecur(arrayComp);
		//Comparable[] arrayQSI = Sort.quickSortIter(arrayComp);
		Comparable[] arrayMerge = Sort.mergeSort(arrayComp);
		Comparable[] arrayInser = Sort.insertionSort(arrayComp);
		Comparable[] arrayBubble = Sort.bubbleSort(arrayComp);
		Comparable[] arrayHeap = Sort.heapSort(arrayComp);
		Comparable[] arrayTree = Sort.treeSort(arrayComp);
		int[] arrayRadix = Sort.radixSort(array);
		int[] arrayBucket = Sort.bucketSort(array);
		
		//System.out.println(arrayQSR.toString());
		//System.out.println(arrayQSI.toString());
		System.out.println(arrayMerge.toString());
		System.out.println(arrayInser.toString());
		System.out.println(arrayBubble.toString());
		System.out.println(arrayBucket.toString());
		System.out.println(arrayHeap.toString());
		System.out.println(arrayTree.toString());
		System.out.println(arrayRadix.toString());
	}

}
