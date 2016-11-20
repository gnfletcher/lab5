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
		boolean unordered = false;
		do{
			
		}while (unordered);
		return array;
	}

	public static Comparable[] mergeSort(Comparable[] array) {
		return array;
	}

	public static Comparable[] radixSort(Comparable[] array) {
		return array;
	}

	public static Comparable[] treeSort(Comparable[] array) {
		return array;
	}
}
