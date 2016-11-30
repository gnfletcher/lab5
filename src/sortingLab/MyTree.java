package sortingLab;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Implementation of an AVL Tree that contains all necessary operations
 * 
 * @author Greg Fletcher
 * @author Sean O'Donnell
 */
public class MyTree {

  public Node root;

  /**
   * Default constructor that creates an empty tree
   */
  public MyTree() {
    this.root = null;

  }

  /**
   * Constructor to create a tree with the given value at the root Creates a new node and sets that
   * node to the root
   * 
   * @param Comparable value to become the root
   */
  public MyTree(Comparable value) {
    this.root = new Node(value);

  }

  /**
   * Searches tree for given element.
   * 
   * @param myTree to be searched
   * @param Comparable value to be searched for
   * @return boolean if operation was successful.
   */
  public static boolean search(MyTree myTree, Comparable value) {
    Node current = myTree.root;
    while (current.getData().compareTo(value) != 0 && current.hasChildren()) {
      if (current.getData().compareTo(value) < 0) {
        current = current.getRightChild();
      } else {
        current = current.getLeftChild();
      }
    }
    if (current.getData().compareTo(value) == 0) {
      return true;
    }
    return false;
  }

  /**
   * Returns the node containing the target value If no node has this value, null is returned
   * 
   * @param Comparable value to be searched for
   * @return Node containg target value
   */
  public Node getNode(Comparable value) {
    Node current = root;
    while (current.getData().compareTo(value) != 0 && current.hasChildren()) {
      if (current.getData().compareTo(value) < 0) {
        current = current.getRightChild();
      } else {
        current = current.getLeftChild();
      }
    }
    if (current.getData().compareTo(value) == 0) {
      return current;
    }
    return null;
  }

 
  public static MyTree insert(MyTree myTree, Comparable value) {
    Node insert = searchForOpen(myTree.root, value);
    Node newNode = new Node(value);
    if (insert.getData().compareTo(value) <= 0) {
      insert.setRightChild(newNode);
      newNode.setParent(insert);
    } else {
      insert.setLeftChild(newNode);
      newNode.setParent(insert);
    }
    balance(myTree.root);
    return myTree;
  }

  /**
   * Searches the given tree to find a place to insert the given value
   * 
   * @param AVLtree to be searched
   * @param Comparable value to find a spot for
   * @return Node that the value will be insrted after
   */
  public static Node searchForOpen(Node node, Comparable value) {
    if (node.getData().compareTo(value) <= 0) {
      if (node.getRightChild() != null) {
        return searchForOpen(node.getRightChild(), value);
      }
    } else if (node.getData().compareTo(value) > 0) {
      if (node.getLeftChild() != null) {
        return searchForOpen(node.getLeftChild(), value);
      }
    }
    return node;
  }

  /**
   * Deletes a given element from the tree and rebalances
   * 
   * @param MyTree to be deleted from
   * @param Comparable value to be deleted
   * @return AVLtree new tree with node deleted
   */

  public static MyTree delete(MyTree myTree, Comparable value) {
    Node node = myTree.getNode(value);
    Node successor;
    if (node.hasChildren()) {
      if (node.getLeftChild() != null) {
        successor = node.getLeftChild();
        if (successor.getRightChild() != null) {
          while (successor.getRightChild() != null) {
            successor = successor.getRightChild();
          }
          node.setData(successor.getData());
          successor.getParent().setRightChild(null);
          successor.setParent(null);
        } else {
          node.setData(successor.getData());
          node.setLeftChild(successor.getLeftChild());
          successor.setParent(null);
        }
      } else {
        successor = node.getRightChild();
        node.setData(successor.getData());
        node.setRightChild(successor.getRightChild());
        successor.getRightChild().setParent(successor);
        node.setLeftChild(successor.getLeftChild());
        successor.getLeftChild().setParent(successor);
      }
    } else {
      if (myTree.root.equals(node)) {
        myTree.root = null;
      } else {
        if (node.getParent().getLeftChild().equals(node)) {
          node.getParent().setLeftChild(null);
        } else {
          node.getParent().setRightChild(null);
        }
      }
    }
    balance(myTree.root);
    return myTree;
  }

  /**
   * Returns an ArrayList of the inorder representation of the given tree
   * 
   * @param MyTree to be represented
   * @return ArrayList<Comparable> of the nodes
   */
  public static ArrayList<Comparable> inorder(MyTree myTree) {
    return myTree.inorder(myTree.root);
  }

  /**
   * Returns an ArrayList of the inorder representation of the tree
   * 
   * @param Node to start at
   * @return ArrayList<Comparable> of the nodes
   */
  public ArrayList<Comparable> inorder(Node node) {
    ArrayList<Comparable> list = new ArrayList<>();
    if (node.hasChildren()) {
      if (node.getLeftChild() != null) {
        list.addAll(inorder(node.getLeftChild()));
      }
      list.add(node.getData());
      if (node.getRightChild() != null) {
        list.addAll(inorder(node.getRightChild()));
      }
    } else {
      list.add(node.getData());
    }
    return list;
  }

  /**
   * Recursively balances the tree so that each node's balancing factor does not exceed 1 or -1
   * 
   * @param node to be balanced
   * @return int resultant balancing factor
   */
  public static int balance(Node node) {
    node.setBalancingFactor(0);
    if (node.hasChildren()) {
      if (node.getLeftChild() != null) {
        node.setBalancingFactor(
            node.getBalancingFactor() + (Math.abs(balance(node.getLeftChild())) * -1) - 1);
      }
      if (node.getRightChild() != null) {
        node.setBalancingFactor(
            node.getBalancingFactor() + (Math.abs(balance(node.getRightChild()))) + 1);
      }
      if (node.getBalancingFactor() == -2) {
        if (node.getLeftChild().getBalancingFactor() == -1) {
          rotateRight(node);
        } else {
          rotateRightLeft(node);
        }
        node.setBalancingFactor(node.getBalancingFactor() + 1);
      } else if (node.getBalancingFactor() == 2) {
        if (node.getRightChild().getBalancingFactor() == 1) {
          rotateLeft(node);
        } else {
          rotateLeftRight(node);
        }
        node.setBalancingFactor(node.getBalancingFactor() - 1);
      }
    }
    return node.getBalancingFactor();
  }

  /**
   * Counts the number of values between the two given values
   * 
   * @param Comparable starting value
   * @param ending value
   * @return int number of values
   */
  public int count(Comparable xZero, Comparable xOne) {
    return countFromRoot(xZero, xOne, root);
  }

  /**
   * Counts the number of values between the given values from the root
   * 
   * @param Comparable starting value
   * @param ending value
   * @param Node starting node
   * @return int number of values
   */
  public int countFromRoot(Comparable xZero, Comparable xOne, Node node) {
    int i = 0;
    if (node.hasChildren()) {
      if (node.getLeftChild() != null) {
        if (node.getLeftChild().getData().compareTo(xZero) >= 0
            && node.getLeftChild().getData().compareTo(xOne) <= 0) {
          i = i + countFromRoot(xZero, xOne, node.getLeftChild());
        }
      }
      if (node.getRightChild() != null) {
        if (node.getRightChild().getData().compareTo(xZero) >= 0
            && node.getRightChild().getData().compareTo(xOne) <= 0) {
          i = i + countFromRoot(xZero, xOne, node.getRightChild());
        }
      }
      if (node.getData().compareTo(xZero) >= 0 && node.getData().compareTo(xOne) <= 0) {
        i++;
      }
    } else {
      if (node.getData().compareTo(xZero) >= 0 && node.getData().compareTo(xOne) <= 0) {
        i++;
      }
    }

    return i;
  }

  /**
   * Prints the nodes in the tree
   * 
   */
  public void print() {
    Queue<Node> queue = new LinkedList<Node>();
    if (root == null)
      return;
    queue.clear();
    queue.add(root);
    while (!queue.isEmpty()) {
      Node node = queue.remove();
      System.out.print(node.getData() + " ");
      if (node.getLeftChild() != null) {
        queue.add(node.getLeftChild());
      }
      if (node.getRightChild() != null) {
        queue.add(node.getRightChild());
      }
    }
    System.out.println("");
  }

  /**
   * Prints the inorder representation of the tree
   *
   */
  public void inOrderPrint() {
    ArrayList<Comparable> inorder = inorder(root);
    for (Comparable value : inorder) {
      System.out.print(value + ", ");
    }
    System.out.println("");
  }
}
