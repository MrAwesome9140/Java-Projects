/*
 * Student information for assignment:
 * On my honor, Aaroh Sharma, this programming assignment is my own work
 * and I have not provided this code to any other student.
 * UTEID: as225925
 * email address: aaroh.sh@gmail.com
 * TA name: Brad
 * Number of slip days I am using: 0
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements IList<E> {
    // CS314 students. Add you instance variables here.
    // You decide what instance variables to use.
    // Must adhere to assignment requirements.
    // No ArrayLists or Java LinkedLists.
    DoubleListNode<E> first;
    DoubleListNode<E> last;
    int size;

    // CS314 students, add constructors here:
    public LinkedList() {
        first = null;
        last = null;
    }

    // CS314 students, add methods here:

    /**
     * Time Complexity: O(1)
     * <p>
     * Add an item to the end of this list.
     * <br>pre: item != null
     * <br>post: size() = old size() + 1, get(size() - 1) = item
     *
     * @param item the data to be added to the end of this list,
     *             item != null
     */
    @Override
    public void add(E item) {
        addLast(item);
    }

    /**
     * Time Complexity: O(N)
     * <p>
     * Returns whether this list is equal to another list
     *
     * @param obj the list that this list is being compared to
     * @return true is this list contains the same elements in the same order
     * as obj and false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof IList) {
            IList<?> temp = (IList<?>) obj;
            if (temp.size() == size) {
                boolean equal = true;
                Iterator<?> otherIt = temp.iterator();
                Iterator<E> thisIt = iterator();

                // Check if all the elements of both lists at the same
                // position are equal
                while (otherIt.hasNext() && thisIt.hasNext() && equal) {
                    if (!otherIt.next().equals(thisIt.next())) {
                        equal = false;
                    }
                }
                return equal;
            }
        }
        return false;
    }

    /**
     * Time Complexity: O(N)
     * <p>
     * Get an element from the list.
     * <br>pre: 0 <= pos < size()
     * <br>post: return the item at pos
     *
     * @param pos specifies which element to get
     * @return the element at the specified position in the list
     */
    @Override
    public E get(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IllegalArgumentException("int pos must be between 0 and" +
                    " size()-1 inclusive");
        }

        return getNode(pos).myData;
    }

    /**
     * Time Complexity: O(N)
     * Return a sublist of elements in this list
     * from <tt>start</tt> inclusive to <tt>stop</tt> exclusive.
     * This list is not changed as a result of this call.
     * <br>pre: <tt>0 <= start <= size(), start <= stop <= size()</tt>
     * <br>post: return a list whose size is stop - start
     * and contains the elements at positions start through stop - 1
     * in this list.
     *
     * @param start index of the first element of the sublist.
     * @param stop  stop - 1 is the index of the last element
     *              of the sublist.
     * @return a list with <tt>stop - start</tt> elements,
     * The elements are from positions <tt>start</tt> inclusive to
     * <tt>stop</tt> exclusive in this list.
     * If start == stop an empty list is returned.
     */
    @Override
    public IList<E> getSubList(int start, int stop) {
        if (start < 0 || start > size || stop < start || stop > size) {
            throw new IllegalArgumentException("int start must be between 0 " +
                    "and size() inclusive and int stop must be between " +
                    "start and size() inclusive");
        }

        IList<E> ret = new LinkedList<>();
        if (size == 0 || start == size) {
            return ret;
        }

        // Add all elements between start and stop to the new list
        DoubleListNode<E> star = getNode(start);
        int size = stop - start;
        while (ret.size() < size) {
            ret.add(star.myData);
            star = star.getNext();
        }
        return ret;
    }

    /**
     * Time Complexity: O(N)
     * Find the position of an element in the list.
     * <br>pre: item != null
     * <br>post: return the index of the first element equal to item
     * or -1 if item is not present
     *
     * @param item the element to search for in the list. item != null
     * @return return the index of the first element equal to item
     * or a -1 if item is not present
     */
    @Override
    public int indexOf(E item) {
        if (item == null) {
            throw new IllegalArgumentException("E item cannot be null");
        }

        return indexOf(item, 0);
    }

    /**
     * Time Complexity: O(N)
     * find the position of an element in the list starting
     * at a specified position.
     * <br>pre: 0 <= pos < size(), item != null
     * <br>post: return the index of the first element equal
     * to item starting at pos
     * or -1 if item is not present from position pos onward
     *
     * @param item the element to search for in the list. Item != null
     * @param pos  the position in the list to start searching from
     * @return starting from the specified position
     * return the index of the first element equal to item
     * or a -1 if item is not present between pos
     * and the end of the list
     */
    @Override
    public int indexOf(E item, int pos) {
        if (item == null || pos < 0 || pos >= size) {
            throw new IllegalArgumentException("E item cannot be null and int" +
                    " pos must be greater than 0 and less than size()-1 " +
                    "inclusive");
        }

        // Search for the first occurence of the element in a different way
        // depending on whether we start in the first half or the second half
        // of the list
        return pos >= (size / 2) ? indexSecondHalfHelper(item, pos) :
                indexFirstHalfHelper(item, pos);
    }

    /**
     * Time Complexity: O(N)
     * Search for item E starting from the end of the list
     *
     * @param item the element to search for. item != null
     * @param pos  the position to start looking for the element from
     * @return the index of the first occurence of E item or -1 if it is not
     * present in the list
     */
    private int indexSecondHalfHelper(E item, int pos) {
        if (item == null) {
            throw new IllegalArgumentException("E item cannot be null");
        }

        DoubleListNode<E> star = last;
        int ret = -1;
        int curInd = size - 1;

        // Traverse through the list starting from index size - 1 until pos
        // until we find E item
        while (curInd > pos) {
            if (item.equals(star.myData)) {
                ret = curInd;
            }
            curInd--;
            star = star.getPrev();
        }
        return ret;
    }

    /**
     * Time Complexity: O(N)
     * Search for item E starting from the position pos
     *
     * @param item the element to search for. item != null
     * @param pos  the position to start looking for the element from
     * @return the index of the first occurence of E item or -1 if it is not
     * present in the list
     */
    private int indexFirstHalfHelper(E item, int pos) {
        if (item == null) {
            throw new IllegalArgumentException("E item cannot be null");
        }

        int ret = -1;
        DoubleListNode<E> star = getNode(pos);
        int curInd = pos;

        // Traverse through the list starting from index pos until we find E
        // item
        while (star != null && ret == -1) {
            if (item.equals(star.myData)) {
                ret = curInd;
            }
            curInd++;
            star = star.getNext();
        }
        return ret;
    }

    /**
     * Time Complexity: O(N)
     * Insert an item at a specified position in the list.
     * <br>pre: 0 <= pos <= size(), item != null
     * <br>post: size() = old size() + 1, get(pos) = item,
     * all elements in the list with a positon >= pos have a
     * position = old position + 1
     *
     * @param pos  the position to insert the data at in the list
     * @param item the data to add to the list, item != null
     */
    @Override
    public void insert(int pos, E item) {
        if (item == null || pos < 0 || pos > size) {
            throw new IllegalArgumentException("E item cannot be null and int" +
                    " pos must be greater than 0 and less than size()-1 " +
                    "inclusive");
        }

        if (pos == 0) {
            addFirst(item);
        } else if (pos == size) {
            addLast(item);
        } else {

            // Update the node previously at pos-1 and pos to refer forward to
            // and back
            // to the new element respectively
            DoubleListNode<E> after = getNode(pos);
            DoubleListNode<E> addThis = new DoubleListNode<>(after.getPrev(),
                    item, after);
            after.getPrev().setNext(addThis);
            after.setPrev(addThis);
            size++;
        }
    }

    /**
     * Time Complexity: O(1)
     * return an Iterator for this list.
     * <br>pre: none
     * <br>post: return an Iterator object for this List
     */
    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    /**
     * Time Complexity: O(1)
     * return the list to an empty state.
     * <br>pre: none
     * <br>post: size() = 0
     */
    @Override
    public void makeEmpty() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Time Complexity: O(N)
     * Remove the first occurrence of obj in this list.
     * Return <tt>true</tt> if this list changed
     * as a result of this call, <tt>false</tt> otherwise.
     * <br>pre: obj != null
     * <br>post: if obj is in this list the first occurrence
     * has been removed and size() = old size() - 1.
     * If obj is not present the list is not altered in any way.
     *
     * @param obj The item to remove from this list. obj != null
     * @return Return <tt>true</tt> if this list changed
     * as a result of this call, <tt>false</tt> otherwise.
     */
    @Override
    public boolean remove(E obj) {
        if (obj == null) {
            throw new IllegalArgumentException("E obj cannot be null");
        }

        int curInd = 0;
        DoubleListNode<E> cur = first;

        // Traverse through the list and if we reach an element that is equal
        // to obj, remove it and return true
        while (cur != null) {
            if (cur.myData.equals(obj)) {
                if (curInd == 0) {
                    removeFirst();
                } else if (curInd == size - 1) {
                    removeLast();
                } else {
                    cur.getPrev().setNext(cur.getNext());
                    cur.getNext().setPrev(cur.getPrev());
                    size--;
                }
                return true;
            }
            cur = cur.getNext();
            curInd++;
        }

        return false;
    }

    /**
     * Time Complexity: O(N)
     * Remove an element in the list based on position.
     * <br>pre: 0 <= pos < size()
     * <br>post: size() = old size() - 1, all elements of
     * list with a position > pos have a position = old position - 1
     *
     * @param pos the position of the element to remove from the list
     * @return the data at position pos
     */
    @Override
    public E remove(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IllegalArgumentException("int pos must be greater than " +
                    "0 and less than size()-1 inclusive");
        }

        E removed;
        if (pos == 0) {
            removed = removeFirst();
        } else if (pos == size - 1) {
            removed = removeLast();
        } else {
            DoubleListNode<E> remove = getNode(pos);
            removed = remove.myData;
            remove.getPrev().setNext(remove.getNext());
            remove.getNext().setPrev(remove.getPrev());
            size--;
        }

        return removed;
    }

    /**
     * Time Complexity: O(N)
     * Remove all elements in this list from <tt>start</tt>
     * inclusive to <tt>stop</tt> exclusive.
     * <br>pre: <tt>0 <= start <= size(), start <= stop <= size()</tt>
     * <br>post: <tt>size() = old size() - (stop - start)</tt>
     *
     * @param start position at beginning of range of elements
     *              to be removed
     * @param stop  stop - 1 is the position at the end
     *              of the range of elements to be removed
     */
    @Override
    public void removeRange(int start, int stop) {
        if (start < 0 || start > size || stop < start || stop > size) {
            throw new IllegalArgumentException("int start must be between 0 " +
                    "and size() inclusive and int stop must be between " +
                    "start and size() inclusive");
        }

        if (start != stop) {
            if (start == size - 1) {

                // If we start at the last element, only remove the last element
                removeLast();
            } else if (start < size - 1) {

                // Method to find the nodes at position start and stop and
                // assign them to star and sto respectively
                DoubleListNode<E>[] ret = findStopAndStart(start, stop);

                // Method that removes the elements in the range
                removeRangeHelper(ret[0], ret[1], start, stop);
            }
        }
    }

    /**
     * Time Complexity: O(1)
     * Remove the range of elements in the optimal possible way based on the
     * start and stop index
     *
     * @param star  the list node representing the start of the range to be
     *              removed
     * @param sto   the list node representing the end of the range to be
     *              removed
     * @param start the index for the beginning of the range to be removed
     * @param stop  the index just after the last element to be removed
     */
    private void removeRangeHelper(DoubleListNode<E> star,
                                   DoubleListNode<E> sto, int start, int stop) {
        if (start == 0 && stop == size) {

            // Deleting the entire list
            makeEmpty();
        } else if (start == 0) {

            // Removing all elements up to stop
            sto.setPrev(null);
            first = sto;
            size -= (stop - start);
        } else if (stop == size) {

            // Removing all elements starting from start
            star.getPrev().setNext(null);
            last = star.getPrev();
            size -= (stop - start);
        } else {
            star.getPrev().setNext(sto);
            sto.setPrev(star.getPrev());
            size -= (stop - start);
        }
    }

    /**
     * Time Complexity: O(N)
     * Find the node at the beginning of the range (star) and the element
     * after the end of the range (sto) to be removed
     *
     * @param start the index for the beginning of the range to be removed
     * @param stop  the index just after the last element to be removed
     * @return An array of size 2 with first element being the starting node
     * and the second element being the stopping node
     */
    private DoubleListNode<E>[] findStopAndStart(int start, int stop) {

        // Array that will be returned, index 0 is the start node and index 1
        // is the stop node
        DoubleListNode<E>[] ret = new DoubleListNode[2];
        if (stop == size) {
            ret[0] = getNode(start);
        } else if (start >= size / 2) {

            // Start is in the second half of list, optimal to find start
            // from stop
            ret[1] = getNode(stop);
            ret[0] = getStartFromStop(ret[1], start, stop);
        } else {

            // Method to find start and stop optimally based on the case
            ret = startBeforeMiddleCase(start, stop);
        }
        return ret;
    }

    /**
     * Time Complexity: O(N)
     * Finds the nodes at positions start and stop respectively in the case
     * that the start node is in the first half of the list
     *
     * @param start the index for the beginning of the range to be removed
     * @param stop  the index just after the last element to be removed
     * @return An array of size 2 with first element being the starting node
     * and the second element being the stopping node
     */
    private DoubleListNode<E>[] startBeforeMiddleCase(int start, int stop) {
        DoubleListNode<E>[] ret = new DoubleListNode[2];
        int stopDist = size - stop;
        if (start > stopDist) {
            ret[1] = getNode(stop);
            int midPoint = stop / 2;
            if (start > midPoint) {

                // Get start from stop if it is closer to stop than index 0
                ret[0] = getStartFromStop(ret[1], start, stop);
            } else {
                ret[0] = getNode(start);
            }
        } else {
            ret[0] = getNode(start);
            int midPoint = (size + start) / 2;
            if (stop < midPoint) {

                // Get stop from start if it is closer to start than the last
                // element
                ret[1] = getStopFromStart(ret[0], start, stop);
            } else {
                ret[1] = getNode(stop);
            }
        }
        return ret;
    }

    /**
     * Time Complexity: O(N)
     * Find the node at position stop (sto) starting from the node at position
     * start (star)
     *
     * @param star  the list node representing the start of the range to be
     *              removed
     * @param start the index for the beginning of the range to be removed
     * @param stop  the index just after the last element to be removed
     */
    private DoubleListNode<E> getStopFromStart(DoubleListNode<E> star,
                                               int start, int stop) {
        DoubleListNode<E> temp = star;
        int curInd = start;

        // Traverse forward starting from node start till we reach index stop
        while (curInd < stop && temp != null) {
            temp = temp.getNext();
            curInd++;
        }
        return temp;
    }

    /**
     * Time Complexity: O(N)
     * Find the node at position start (star) starting from the node at
     * position stop (sto)
     *
     * @param sto   the list node representing the end of the range to be
     *              removed
     * @param start the index for the beginning of the range to be removed
     * @param stop  the index just after the last element to be removed
     * @return
     */
    private DoubleListNode<E> getStartFromStop(DoubleListNode<E> sto, int start,
                                               int stop) {
        DoubleListNode<E> temp = sto;
        int curInd = stop;

        // Traverse backwards starting from index stop until we reach index
        // start
        while (curInd > start && temp != null) {
            temp = temp.getPrev();
            curInd--;
        }
        return temp;
    }

    /**
     * Time Complexity: O(N)
     * Change the data at the specified position in the list.
     * the old data at that position is returned.
     * <br>pre: 0 <= pos < size(), item != null
     * <br>post: get(pos) = item, return the
     * old get(pos)
     *
     * @param pos  the position in the list to overwrite
     * @param item the new item that will overwrite the old item,
     *             item != null
     * @return the old data at the specified position
     */
    @Override
    public E set(int pos, E item) {
        if (pos < 0 || pos >= size || item == null) {
            throw new IllegalArgumentException("E item cannot be null and int" +
                    " pos must be between 0 and size()-1 inclusive");
        }

        DoubleListNode<E> temp = getNode(pos);
        E ret = temp.myData;
        temp.setData(item);

        return ret;
    }

    /**
     * Time Complexity: O(1)
     * Return the size of this list.
     * In other words the number of elements in this list.
     * <br>pre: none
     * <br>post: return the number of items in this list
     *
     * @return the number of items in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Time Complexity: O(N)
     * Return a String version of this list enclosed in
     * square brackets, []. Elements are in
     * order based on position in the
     * list with the first element
     * first. Adjacent elements are separated by comma's
     *
     * @return a String representation of this IList
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (size > 0) {
            sb.append(first.myData);
            DoubleListNode<E> temp = first.getNext();

            // Traverse through the list and add the data of each node to the
            // String
            while (temp != null) {
                sb.append(", ").append(temp.myData);
                temp = temp.getNext();
            }
        }
        return sb.append("]").toString();
    }

    /**
     * Time Complexity: O(1)
     * add item to the front of the list. <br>
     * pre: item != null <br>
     * post: size() = old size() + 1, get(0) = item
     *
     * @param item the data to add to the front of this list
     */
    public void addFirst(E item) {
        if (item == null) {
            throw new IllegalArgumentException("E item cannot be null");
        }

        DoubleListNode<E> add = new DoubleListNode<>(null, item, first);
        if (first != null) {
            first.setPrev(add);
        }
        first = add;

        // Set the element to be the last element if the list is empty
        if (last == null) {
            last = add;
        }
        size++;
    }

    /**
     * Time Complexity: O(1)
     * <p>
     * add item to the end of the list. <br>
     * pre: item != null <br>
     * post: size() = old size() + 1, get(size() -1) = item
     *
     * @param item the data to add to the end of this list
     */
    public void addLast(E item) {
        if (item == null) {
            throw new IllegalArgumentException("E item cannot be null");
        }

        DoubleListNode<E> add = new DoubleListNode<>(last, item, null);
        if (last != null) {
            last.setNext(add);
        }
        last = add;

        // Set the element to be the first element if the list is empty
        if (first == null) {
            first = add;
        }
        size++;
    }

    /**
     * Time Complexity: O(1)
     * remove and return the first element of this list. <br>
     * pre: size() > 0 <br>
     * post: size() = old size() - 1
     *
     * @return the old first element of this list
     */
    public E removeFirst() {
        if (size == 0) {
            throw new IllegalStateException("Cannot remove element from empty" +
                    " list");
        }
        E removed = first.myData;
        if (size == 1) {
            last = null;
        } else {
            first.getNext().setPrev(null);
        }
        first = first.getNext();
        size--;
        return removed;
    }

    /**
     * Time Complexity: O(1)
     * remove and return the last element of this list. <br>
     * pre: size() > 0 <br>
     * post: size() = old size() - 1
     *
     * @return the old last element of this list
     */
    public E removeLast() {
        if (size == 0) {
            throw new IllegalStateException("Cannot remove element from empty" +
                    " list");
        }
        E removed = last.myData;
        if (size == 1) {
            first = null;
        } else {
            last.getPrev().setNext(null);
        }
        last = last.getPrev();
        size--;
        return removed;
    }

    /**
     * Time Complexity: O(N)
     * Get a DoubleListNode from the list.
     * <br>pre: 0 <= pos < size()
     * <br>post: return the node at pos
     *
     * @param pos specifies which node to get
     * @return the node at the specified position in the list
     */
    private DoubleListNode<E> getNode(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IllegalArgumentException("int pos must be between 0 and" +
                    " size()-1 inclusive");
        }

        DoubleListNode<E> cur = first;

        // Start traversing from the front if the pos is in the first half
        // and start front the last node if pos is in the second half
        if (pos < size / 2) {
            int curPos = 0;
            while (curPos < pos) {
                cur = cur.getNext();
                curPos++;
            }
        } else {
            int curPos = size - 1;
            cur = last;
            while (curPos > pos) {
                cur = cur.getPrev();
                curPos--;
            }
        }
        return cur;
    }

    /**
     * A class that represents a node to be used in a linked list.
     * These nodes are doubly linked. All methods are O(1).
     *
     * @author Mike Scott
     * @version July 25, 2005
     */

    private static class DoubleListNode<E> {

        // instance variables

        // The data stored in this node.
        private E myData;

        // The link to the next node (presumably in a list).
        private DoubleListNode<E> myNext;

        // The link to the previous node (presumably in a list).
        private DoubleListNode<E> myPrev;

        /**
         * default constructor.
         * <br>pre: none
         * <br>post: getData() = null, getNext() = null, getPrev() = null
         */
        public DoubleListNode() {
            this(null, null, null);
        }

        /**
         * create a DoubleListNode that holds the specified data
         * and refers to the specified next and previous elements.
         * <br>pre: none
         * <br>post: getData() = data, getNext() = next, getPrev() = prev
         *
         * @param prev the previous node
         * @param data the  data this DoubleListNode should hold
         * @param next the next node
         */
        public DoubleListNode(DoubleListNode<E> prev, E data,
                              DoubleListNode<E> next) {

            myData = data;
            myNext = next;
            myPrev = prev;
        }

        /**
         * return the data in this node.
         * <br>pre: none
         *
         * @return the data this DoubleListNode holds
         */
        public E getData() {
            return myData;
        }

        /**
         * set the data in this node.
         * The old data is over written.
         * <br>pre: none
         * <br>post: getData() == data
         *
         * @param data the new data for this DoubleListNode to hold
         */
        public void setData(E data) {
            myData = data;
        }

        /**
         * return the DoubleListNode this ListNode refers to.
         * <br>pre: none
         *
         * @return the DoubleListNode this DoubleListNode refers to
         * (normally the next one in a list)
         */
        public DoubleListNode<E> getNext() {
            return myNext;
        }

        /**
         * set the next node this DoubleListNode refers to.
         * <br>pre: none
         * <br>post: getNext() = next
         *
         * @param next the next node this DoubleListNode should refer to
         */
        public void setNext(DoubleListNode<E> next) {
            myNext = next;
        }

        /**
         * return the DoubleListNode this DoubleListNode refers to.
         * <br>pre: none
         *
         * @return the DoubleListNode this DoubleListNode refers to
         * (normally the previous one in a list)
         */
        public DoubleListNode<E> getPrev() {
            return myPrev;
        }

        /**
         * set the previous node this DoubleListNode refers to.
         * <br>pre: none
         * <br>post: getPrev() = next
         *
         * @param prev the previous node this DoubleListNode should refer to
         */
        public void setPrev(DoubleListNode<E> prev) {
            myPrev = prev;
        }
    }

    /**
     * A helper class to create an iterator specific to this instance of the
     * LinkedList class
     */
    private class LinkedListIterator implements Iterator<E> {

        DoubleListNode<E> previous;
        DoubleListNode<E> current;
        int curInd;

        public LinkedListIterator() {
            previous = first;
            current = first;
        }

        /**
         * Time Complexity: O(1)
         * Check whether there are elements remaining in this list
         *
         * @return true is the current element has a next element, and false
         * otherwise
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Time Complexity: O(1)
         * Move the iterator over the next element if it exists and return
         * the element that was passed over. Will throw a
         * NoSuchElementException if called on an iterator at the end of a list
         *
         * @return the next element if it exists
         */
        @Override
        public E next() {
            if (current == null) {
                throw new NoSuchElementException("There are no elements " +
                        "remaining in the LinkedList");
            }
            E next = current.myData;

            // Store the value that was just passed over for ease in removal
            previous = current;
            current = current.getNext();
            curInd++;
            return next;
        }

        /**
         * Time Complexity: O(1)
         * Remove the last element that was passed over if an element has
         * already been passed over. Will throw a NoSuchElementException if
         * the iterator is at the beginning of a list.
         */
        @Override
        public void remove() {
            if (curInd == 0) {
                throw new NoSuchElementException("Currently on first element," +
                        " no previous element to remove");
            } else if (curInd == 1) {
                removeFirst();
            } else if (curInd == size) {
                removeLast();
            } else {

                // Eliminate all references to node that will be removed
                previous.getPrev().setNext(current);
                current.setPrev(previous.getPrev());
                size--;
            }
            curInd--;
        }

    }
}