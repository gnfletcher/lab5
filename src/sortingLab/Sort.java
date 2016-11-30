/**
 * 
 */
package sortingLab;

/**
 * @author FletcherG
 *
 */
public class Sort {

<<<<<<< HEAD
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
    MyHeap heap = new MyHeap();
    heap.makeHeap(array[0]);
    for(int i = 1; i < array.length; i ++){
      heap.insert(array[i]);
    }
    int i = 0;
    while(!heap.isEmpty()){
      array[0] = (Comparable) heap.deleteMin();
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
    for (int i = 0; i < array.length; i++) {
      if (first[j].compareTo(second[k]) < 0) {
        array[i] = first[j];
        j++;
      } else {
        array[i] = second[k];
        k++;
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
          if((array[l] / Math.pow(10, 1)) % 10 == j){
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
    
    return array;
  }
=======
	public Sort() {

	}

	public static Comparable[] quickSortRecur(Comparable[] array) {
		Comparable partition = array[0];
		Comparable[] lessThan = new Comparable[array.length];
		Comparable[] greaterThan = new Comparable[array.length];
		int i = 0;
		if (array.length > 0) {
			while (array[i].compareTo(partition) <= 0) {
				lessThan[i] = array[i];
				i++;
			}
			while (i < array.length) {
				greaterThan[i] = array[i];
				i++;
			}
			quickSortRecur(greaterThan);
			return lessThan;
		}
		Comparable[] sorted = new Comparable[array.length];
		for(int j = 0; j < lessThan.length; j++){
			if
		}
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
		Comparable[] first = new Comparable[array.length / 2];
		Comparable[] second = new Comparable[array.length / 2];
		if (array.length > 2) {
			first = new Comparable[array.length / 2];
			second = new Comparable[array.length / 2];
			System.arraycopy(array, 0, first, 0, first.length);
			System.arraycopy(array, first.length, second, 0, second.length);
			first = mergeSort(first);
			second = mergeSort(second);
		} else {
			if (array.length == 2) {
				if (array[0].compareTo(array[1]) > 0) {
					Comparable[] sorted = new Comparable[array.length];
					sorted[0] = array[1];
					sorted[1] = array[0];
					return sorted;
				} else {
					return array;
				}
			}
		}
		Comparable[] newArray = new Comparable[array.length];
		int i = 0;
		int j = 0;
		for (int k = 0; k < newArray.length; k++) {
			if (first[i].compareTo(second[j]) > 0) {
				newArray[k] = first[i];
				i++;
			} else {
				newArray[k] = second[j];
				j++;
			}
		}
		return newArray;
	}

	public static int[] radixSort(int[] array) {
		int[] groups = new int[10];
		int[] sorted = new int[array.length];
		int max = 0;
		for (int i = 0; i < array.length; i++) {
			if (max < array[i]) {
				max = array[i];
			}
		}
		int exp = String.valueOf(max).length();
		for (int i = 0; i < exp; i++) {
			for (int j = 0; j < array.length; j++) {

			}
		}
		return array;
	}

	public static Comparable[] treeSort(Comparable[] array) {
		return array;
	}
>>>>>>> a60963491c4f918f41aec0361affcb7eea8b986f
}
