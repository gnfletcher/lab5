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
		return array;
	}

	public static Comparable[] radixSort(Comparable[] array) {
		return array;
	}

	public static Comparable[] treeSort(Comparable[] array) {
		return array;
	}
}
