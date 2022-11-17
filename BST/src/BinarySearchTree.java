/* CS 314 STUDENTS: FILL IN THIS HEADER.
 *
 * Student information for assignment:
 *
 *  On my honor, Aaroh Sharma, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID: as225925
 *  email address: aaroh.sh@gmail.com
 *  TA name: Brad
 *  Number of slip days I am using: 0
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Shell for a binary search tree class.
 * @author scottm
 * @param <E> The data type of the elements of this BinarySearchTree.
 * Must implement Comparable or inherit from a class that implements
 * Comparable.
 *
 */
public class BinarySearchTree<E extends Comparable<? super E>> {

    private BSTNode<E> root;
    // CS314 students. Add any other instance variables you want here
    private int size;

    // CS314 students. Add a default constructor here if you feel it is necessary.

    /**
     *  Add the specified item to this Binary Search Tree if it is not already present.
     *  <br>
     *  pre: <tt>value</tt> != null<br>
     *  post: Add value to this tree if not already present. Return true if this tree
     *  changed as a result of this method call, false otherwise.
     *  @param value the value to add to the tree
     *  @return false if an item equivalent to value is already present
     *  in the tree, return true if value is added to the tree and size() = old size() + 1
     */
    public boolean add(E value) {
        int oldSize = size;
        root = addHelper(root, value);
        return oldSize != size;
    }

    /**
     * Helper method for adding node to tree
     * @param node current node the value is being compared to
     * @param value the value that is being added to the tree
     * @return a node that will be the new left or right child of the node in
     * the previous recursive call
     */
    private BSTNode<E> addHelper(BSTNode<E> node, E value) {
        if (node == null) {
            size++;
            return new BSTNode<>(value);
        } else {
            int compare = value.compareTo(node.getData());
            if (compare > 0) {
                node.right = addHelper(node.getRight(), value);
            } else if (compare < 0) {
                node.left = addHelper(node.getLeft(), value);
            }
            return node;
        }
    }

    /**
     *  Remove a specified item from this Binary Search Tree if it is present.
     *  <br>
     *  pre: <tt>value</tt> != null<br>
     *  post: Remove value from the tree if present, return true if this tree
     *  changed as a result of this method call, false otherwise.
     *  @param value the value to remove from the tree if present
     *  @return false if value was not present
     *  returns true if value was present and size() = old size() - 1
     */
    public boolean remove(E value) {
        if (value == null) {
            throw new IllegalArgumentException("E value cannot be null");
        }
        int oldSize = size;
        root = removeHelper(root, value);
        return size != oldSize;
    }

    /**
     * Helper method to remove a value from the tree
     * @param cur the current node being whose data is being comapred to the
     *            value
     * @param value the value being removed
     * @return the new left or right child of cur in the previous recursive call
     */
    private BSTNode<E> removeHelper(BSTNode<E> cur, E value) {
        if (cur != null) {
            int compare = value.compareTo(cur.getData());
            if (compare > 0) {
                cur.right = removeHelper(cur.right, value);
            } else if (compare < 0) {
                cur.left = removeHelper(cur.left, value);
            } else {
                // We found the element to remove
                size--;
                if (cur.right == null && cur.left == null) {
                    cur = null;
                } else if (cur.right == null) {
                    cur = cur.left;
                } else if (cur.left == null) {
                    cur = cur.right;
                } else {
                    // The element to remove has both a right and left child,
                    // replace this element's data with the data in the
                    // leftmost child of the right subtree
                    cur.right = removeReplace(cur.right, cur);
                }
            }
        }
        return cur;
    }

    /**
     * Helper method to find the leftmost child of the right subtree of the
     * node to be removed
     * @param cur the current node being traversed
     * @param replace the node whose value we are replacing
     * @return the new left child of the cur node in the previous recursive call
     */
    private BSTNode<E> removeReplace(BSTNode<E> cur, BSTNode<E> replace) {
        if (cur.left == null) {
            replace.setData(cur.getData());
            return cur.right;
        }
        cur.left = removeReplace(cur.left, replace);
        return cur;
    }


    /**
     *  Check to see if the specified element is in this Binary Search Tree.
     *  <br>
     *  pre: <tt>value</tt> != null<br>
     *  post: return true if value is present in tree, false otherwise
     *  @param value the value to look for in the tree
     *  @return true if value is present in this tree, false otherwise
     */
    public boolean isPresent(E value) {
        if (value == null) {
            throw new IllegalArgumentException("E value cannot be null");
        }
        return isPresentHelper(root, value);
    }

    /**
     * Helper method for checking is a value is present in the true
     * @param cur current node being checked
     * @param val the value we are trying to find in the tree
     * @return true is the value is present in the tree, false otherwise
     */
    private boolean isPresentHelper(BSTNode<E> cur, E val) {
        if (cur == null) {
            return false;
        } else if (val.equals(cur.getData())) {
            return true;
        }
        return isPresentHelper(cur.left, val) || isPresentHelper(cur.right,
                val);
    }


    /**
     *  Return how many elements are in this Binary Search Tree.
     *  <br>
     *  pre: none<br>
     *  post: return the number of items in this tree
     *  @return the number of items in this Binary Search Tree
     */
    public int size() {
        return size;
    }

    /**
     *  return the height of this Binary Search Tree.
     *  <br>
     *  pre: none<br>
     *  post: return the height of this tree.
     *  If the tree is empty return -1, otherwise return the
     *  height of the tree
     *  @return the height of this tree or -1 if the tree is empty
     */
    public int height() {
        if (root == null) {
            return -1;
        }
        return heightHelper(root, -1);
    }

    /**
     * Helper method to find the height of the tree
     * @param current current node being traversed
     * @param height the height of the tree so far
     * @return the maximum of height of the subtree with current as the root
     */
    private int heightHelper(BSTNode<E> current, int height) {
        if (current == null) {
            return height;
        }
        return Math.max(heightHelper(current.left, height + 1),
                heightHelper(current.right, height + 1));
    }

    /**
     *  Return a list of all the elements in this Binary Search Tree.
     *  <br>
     *  pre: none<br>
     *  post: return a List object with all data from the tree in ascending order.
     *  If the tree is empty return an empty List
     *  @return a List object with all data from the tree in sorted order
     *  if the tree is empty return an empty List
     */
    public List<E> getAll() {
        List<E> data = new ArrayList<>();
        getAllHelper(data, root);
        return data;
    }

    /**
     * Helper method to collect the data in the tree into a list in ascending
     * order
     * @param data the list containing the data in the tree in ascending order
     * @param node the current node being traversed
     */
    private void getAllHelper(List<E> data, BSTNode<E> node) {
        if (node != null) {
            getAllHelper(data, node.left);
            data.add(node.getData());
            getAllHelper(data, node.right);
        }
    }

    /**
     * return the maximum value in this binary search tree.
     * <br>
     * pre: <tt>size()</tt> > 0<br>
     * post: return the largest value in this Binary Search Tree
     * @return the maximum value in this tree
     */
    public E max() {
        if (size == 0) {
            throw new IllegalStateException("Cannot find max in empty tree");
        }
        return maxHelper(root);
    }

    /**
     * Helper method to find the max value in the tree
     * @param cur the current node being traversed
     * @return the max value in the subtree with the root of cur
     */
    private E maxHelper(BSTNode<E> cur) {
        if (cur.right == null) {
            return cur.getData();
        }
        return maxHelper(cur.right);
    }

    /**
     * return the minimum value in this binary search tree.
     * <br>
     * pre: <tt>size()</tt> > 0<br>
     * post: return the smallest value in this Binary Search Tree
     * @return the minimum value in this tree
     */
    public E min() {
        if (size == 0) {
            throw new IllegalStateException("Cannot find min in empty tree");
        }
        return minHelper(root);
    }

    /**
     * Helper method to find the min value in the tree
     * @param cur the current node being traversed
     * @return the min value in the subtree with the root of cur
     */
    private E minHelper(BSTNode<E> cur) {
        if (cur.left == null) {
            return cur.getData();
        }
        return minHelper(cur.left);
    }

    /**
     * An add method that implements the add algorithm iteratively 
     * instead of recursively.
     * <br>pre: data != null
     * <br>post: if data is not present add it to the tree, 
     * otherwise do nothing.
     * @param data the item to be added to this tree
     * @return true if data was not present before this call to add, 
     * false otherwise.
     */
    public boolean iterativeAdd(E data) {
        if (data == null) {
            throw new IllegalArgumentException("E data cannot be null");
        }

        if (root == null) {
            root = new BSTNode<>(data);
            return true;
        }

        BSTNode<E> prev = iterativeAddHelper(data);

        if (prev == null) {
            return false;
        } else if (data.compareTo(prev.getData()) < 0) {
            prev.setLeft(new BSTNode<>(data));
        } else {
            prev.setRight(new BSTNode<>(data));
        }

        size++;
        return true;
    }

    /**
     * Iterative add helper method
     * @param data the data being added to this tree
     * @return the leaf that the data will be added to the left or right of.
     * Returns null if the data is already present in the tree
     */
    private BSTNode<E> iterativeAddHelper(E data) {
        BSTNode<E> prev = null;
        BSTNode<E> current = root;

        // Iteratively replace the current node with the right or left node
        // depending on whether it is currently less than or greater than the
        // data we are looking for
        while (current != null) {
            int compare = data.compareTo(current.getData());
            if (compare > 0) {
                prev = current;
                current = current.right;
            } else if (compare < 0) {
                prev = current;
                current = current.left;
            } else {
                return null;
            }
        }
        return prev;
    }


    /**
     * Return the "kth" element in this Binary Search Tree. If kth = 0 the
     * smallest value (minimum) is returned.
     * If kth = 1 the second smallest value is returned, and so forth.
     * <br>pre: 0 <= kth < size()
     * @param kth indicates the rank of the element to get
     * @return the kth value in this Binary Search Tree
     */
    public E get(int kth) {
        if (kth < 0 || kth >= size) {
            throw new IllegalArgumentException("int kth must be between 0 and" +
                    " size() - 1 inclusive");
        }

        curK = 0;
        return getHelper(root, kth);
    }

    private int curK = 0;

    /**
     * Helper method to get kth smallest element in tree
     * @param cur current node being searched
     * @param k the rank of the element to be returned
     * @return the kth smallest element in the tree
     */
    private E getHelper(BSTNode<E> cur, int k) {

        // Perform an in order traversal, incrementing the counter by one
        // everytime the current element has been checked
        if (cur != null){
            E ans = getHelper(cur.left, k);
            if (ans != null) {
                return ans;
            }
            if (curK == k) {
                return cur.getData();
            }
            curK++;
            ans = getHelper(cur.right, k);
            return ans;
        }
        return null;
    }


    /**
     * Return a List with all values in this Binary Search Tree 
     * that are less than the parameter <tt>value</tt>.
     * <tt>value</tt> != null<br>
     * @param value the cutoff value
     * @return a List with all values in this tree that are less than 
     * the parameter value. If there are no values in this tree less 
     * than value return an empty list. The elements of the list are 
     * in ascending order.
     */
    public List<E> getAllLessThan(E value) {
        if (value == null) {
            throw new IllegalArgumentException("E value cannot be null");
        }
        List<E> less = new ArrayList<>();
        getAllLessThanHelper(root, less, value);
        return less;
    }

    /**
     * Helper method for getAllLessThan, recursively adds all elements
     * less than value to list less
     * @param cur current node being traversed
     * @param less list of all values
     * @param value value being comapred to
     */
    private void getAllLessThanHelper(BSTNode<E> cur, List<E> less, E value) {
        if (cur != null){
            getAllLessThanHelper(cur.left, less, value);
            if (value.compareTo(cur.getData()) > 0) {
                less.add(cur.getData());
                getAllLessThanHelper(cur.right, less, value);
            }
        }
    }


    /**
     * Return a List with all values in this Binary Search Tree 
     * that are greater than the parameter <tt>value</tt>.
     * <tt>value</tt> != null<br>
     * @param value the cutoff value
     * @return a List with all values in this tree that are greater
     *  than the parameter value. If there are no values in this tree
     * greater than value return an empty list. 
     * The elements of the list are in ascending order.
     */
    public List<E> getAllGreaterThan(E value) {
        if (value == null) {
            throw new IllegalArgumentException("E value cannot be null");
        }
        List<E> greater = new ArrayList<>(size);
        getAllGreaterThanHelper(root, greater, value);
        return greater;
    }

    /**
     * Helper method for getAllGreaterThan, recursively adds all elements
     * greater than value to list greater
     * @param cur current node being traversed
     * @param greater list of all values
     * @param value value being compared to
     */
    private void getAllGreaterThanHelper(BSTNode<E> cur, List<E> greater,
                                         E value) {
        if (cur != null){
            getAllGreaterThanHelper(cur.right, greater, value);
            if (value.compareTo(cur.getData()) < 0) {
                greater.add(0, cur.getData());
                getAllGreaterThanHelper(cur.left, greater, value);
            }
        }
    }

    /**
     * Find the number of nodes in this tree at the specified depth.
     * <br>pre: none
     * @param d The target depth.
     * @return The number of nodes in this tree at a depth equal to
     * the parameter d.
     */
    public int numNodesAtDepth(int d) {
        return numNodesAtDepthHelper(root, d, 0);
    }

    /**
     * Helper method for numNodesAtDepth
     * @param node the current node being traversed
     * @param d the depth we are trying to find nodes at
     * @param curD the depth of the current node
     * @return the number of nodes at depth d in BSTNode<E> node's subtree
     */
    private int numNodesAtDepthHelper(BSTNode<E> node, int d, int curD) {
        if (node == null) {
            return 0;
        } else if (curD == d) {
            return 1;
        }
        return numNodesAtDepthHelper(node.left, d, curD + 1) +
                numNodesAtDepthHelper(node.right, d, curD + 1);
    }

    /**
     * Prints a vertical representation of this tree.
     * The tree has been rotated counter clockwise 90
     * degrees. The root is on the left. Each node is printed
     * out on its own row. A node's children will not necessarily
     * be at the rows directly above and below a row. They will
     * be indented three spaces from the parent. Nodes indented the
     * same amount are at the same depth.
     * <br>pre: none
     */
    public void printTree() {
        printTree(root, "");
    }

    private void printTree(BSTNode<E> n, String spaces) {
        if(n != null){
            printTree(n.getRight(), spaces + "  ");
            System.out.println(spaces + n.getData());
            printTree(n.getLeft(), spaces + "  ");
        }
    }

    private static class BSTNode<E extends Comparable<? super E>> {
        private E data;
        private BSTNode<E> left;
        private BSTNode<E> right;

        public BSTNode() {
            this(null);
        }

        public BSTNode(E initValue) {
            this(null, initValue, null);
        }

        public BSTNode(BSTNode<E> initLeft,
                       E initValue,
                       BSTNode<E> initRight) {
            data = initValue;
            left = initLeft;
            right = initRight;
        }

        public E getData() {
            return data;
        }

        public BSTNode<E> getLeft() {
            return left;
        }

        public BSTNode<E> getRight() {
            return right;
        }

        public void setData(E theNewValue) {
            data = theNewValue;
        }

        public void setLeft(BSTNode<E> theNewLeft) {
            left = theNewLeft;
        }

        public void setRight(BSTNode<E> theNewRight) {
            right = theNewRight;
        }
    }
}