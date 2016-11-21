/**
 * 
 */
package sortingLab;

/**
 * @author FletcherG
 *
 */
public class MyLinkedList<T> implements MyList<T> {
	private int size;
	private MyNode<T> head;
	private MyNode<T> tail;

	/**
	 * 
	 */

	public MyLinkedList() {
		this.size = 0;
		this.head = new MyNode<T>(null, null);
		this.tail = new MyNode<T>(null, null);
	}

	@Override
	public boolean add(int index, T object) {
		MyNode<T> previous = (MyNode<T>) head;
		for (int i = 0; i < index; i++) {
			previous = (MyNode<T>) previous.getNext();
		}
		MyNode<T> next = (MyNode<T>) previous.getNext();
		MyNode<T> newNode = new MyNode<T>(object, next);
		previous.setNext(newNode);
		this.size++;
		return true;
	}

	@Override
	public boolean add(T object) {
		if (head.getValue() == null) {
			head = new MyNode<T>(object, null);
		} else {
			MyNode<T> next = (MyNode<T>) head;
			while (next.getNext() != null) {
				next = (MyNode<T>) next.getNext();
			}
			tail = new MyNode<T>(object, null);
			next.setNext(tail);
		}
		this.size++;
		return true;
	}

	@Override
	public boolean clear() {
		this.head = null;
		this.size = 0;
		return true;
	}

	@Override
	public boolean contains(T object) {
		MyNode<T> next = (MyNode<T>) head;
		for (int i = 0; i < this.size; i++) {
			if (next.getValue().equals(object)) {
				return true;
			}
			next = (MyNode<T>) next.getNext();
		}
		return false;
	}

	@Override
	public T get(int index) {
		MyNode<T> next = (MyNode<T>) head;
		for (int i = 0; i < index; i++) {
			next = (MyNode<T>) next.getNext();
		}
		return (T) next.getValue();
	}

	@Override
	public int indexOf(T object) {
		MyNode<T> next = (MyNode<T>) head;
		for (int i = 0; i < this.size; i++) {
			if (next.getValue().equals(object)) {
				return i;
			}
			next = (MyNode<T>) next.getNext();
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove(int index) {
		MyNode<T> previous = (MyNode<T>) head;
		for (int i = 0; i < index - 1; i++) {
			previous = (MyNode<T>) previous.getNext();
		}
		MyNode<T> next = (MyNode<T>) previous.getNext();
		previous.setNext(next.getNext());
		return (T) next;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove(Object object) {
		MyNode<T> previous = (MyNode<T>) head;
		for (int i = 0; i < this.size; i++) {
			if (previous.getNext().getValue().equals(object)) {
				MyNode<T> next = (MyNode<T>) previous.getNext();
				previous.setNext(next.getNext());
				return (T) next;
			}
			previous = (MyNode<T>) previous.getNext();
		}
		return null;
	}

	@Override
	public boolean set(int index, T object) {
		MyNode<T> next = (MyNode<T>) head;
		for (int i = 0; i < index; i++) {
			next = (MyNode<T>) next.getNext();
		}
		next.setValue(object);
		return true;
	}

	@Override
	public int size() {
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] subList(int fromIndex, int toIndex) {
		T[] newArray = (T[]) new Object[toIndex - fromIndex + 1];
		MyNode<T> next = (MyNode<T>) head;
		for (int i = 0; i < fromIndex; i++) {
			next = (MyNode<T>) next.getNext();
		}
		for (int i = 0; i < fromIndex - toIndex; i++) {
			next = (MyNode<T>) next.getNext();
			newArray[i] = (T) next;
		}
		return newArray;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		T[] newArray = (T[]) new Object[size];
		MyNode<T> next = (MyNode<T>) head;
		for (int i = 0; i < size; i++) {
			newArray[i] = (T) next;
			next = (MyNode<T>) next.getNext();
		}
		return newArray;
	}

	@Override
	public boolean swap(int position1, int position2) {
	    MyNode<T> firstPrevious = (MyNode<T>) head.getNext();
	    for(int i = 0; i < position1; i++){
	      firstPrevious = (MyNode<T>) firstPrevious.getNext();
	    }
	    MyNode<T> first = (MyNode<T>) firstPrevious.getNext();
	    MyNode<T> secondPrevious = (MyNode<T>) first.getNext();
	    for(int i = position1; i < position2-1; i++){
	      secondPrevious = (MyNode<T>) secondPrevious.getNext();
	    }
	    MyNode<T> second = (MyNode<T>) secondPrevious.getNext();
	    MyNode<T> firstNext = (MyNode<T>) first.getNext();
	    MyNode<T> secondNext = (MyNode<T>) second.getNext();
	    firstPrevious.setNext(second);
	    first.setNext(secondNext);
	    secondPrevious.setNext(first);
	    second.setNext(firstNext);
	    return true;
	  }

	@Override
	public boolean shift(int positions) {
		tail.setNext(head);
		MyNode<T> next = (MyNode<T>) head;
		if (positions > 0) {
			for (int i = 0; i < positions; i++) {
				next = (MyNode<T>) next.getNext();
			}
			head = (MyNode<T>) next.getNext();
			next.setNext(null);
			tail = next;
		} else if (positions < 0) {
			for (int i = 0; i < size + positions -1; i++) {
				next = (MyNode<T>) next.getNext();
			}
			head = (MyNode<T>) next.getNext();
			next.setNext(null);
			tail = next;
		} else {
			
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public T getHead() {
		return (T) head;
	}

	@SuppressWarnings("unchecked")
	public T getTail() {
		return (T) tail;
	}

	@SuppressWarnings("unchecked")
	public void setHead(T head) {
		this.head = (MyNode<T>) head;
	}

	@SuppressWarnings("unchecked")
	public void setTail(T tail) {
		this.tail = (MyNode<T>) tail;
	}

	public int getSize() {
		return size;
	}
}
