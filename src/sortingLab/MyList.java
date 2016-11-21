/**
 * 
 */
package sortingLab;

/**
 * @author FletcherG
 *
 */
public interface MyList<T> {

  /**
   * @param index
   * @param object
   * @return
   */
  public boolean add(int index, T object);

  /**
   * @param object
   * @return
   */
  public boolean add(T object);

  /**
   * @return
   */
  public boolean clear();

  /**
   * @param object
   * @return
   */
  public boolean contains(T object);

  /**
   * @param index
   * @return
   */
  public T get(int index);

  /**
   * @param type
   * @return
   */
  public int indexOf(T object);

  /**
   * @return
   */
  public boolean isEmpty();

  /**
   * @param index
   * @return
   */
  public T remove(int index);

  /**
   * @param object
   * @return
   */
  public T remove(T object);

  /**
   * @param index
   * @param element
   * @return
   */
  public boolean set(int index, T element);

  /**
   * @return
   */
  public int size();

  /**
   * @param fromIndex
   * @param toIndex
   * @return
   */
  public T[] subList(int fromIndex, int toIndex);

  /**
   * @return
   */
  public T[] toArray();

  /**
   * @param position1
   * @param position2
   * @return
   */
  public boolean swap(int position1, int position2);

  /**
   * @param positions
   * @return
   */
  public boolean shift(int positions);

}
