/**
 * 
 */
package sortingLab;

/**
 * @author FletcherG
 *
 */
public class MyNode<T> {
  private MyNode<T> next;
  private T value;

  public MyNode(T value) {
    this.value = value;
    this.next = null;
  }
  public MyNode(T value, MyNode<T> next) {
    this.value = value;
    this.next = next;
  }

  public MyNode<T> getNext() {
    return next;
  }

  public void setNext(MyNode<T> next) {
    this.next = next;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }


}
