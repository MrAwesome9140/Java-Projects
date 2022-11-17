/*  Student information for assignment:
 *
 *  On MY honor, Aaroh Sharma,
 *  this programming assignment is MY own work
 *  and I have not provided this code to any other student.
 *
 *  Number of slip days used: 2
 *
 *  Student 1 (Student whose Canvas account is being used)
 *  UTEID: as225925
 *  email address: aaroh.sh@gmail.com
 *  TA name: Brad
 */

import java.util.Iterator;
import java.util.ArrayList;

/**
 * In this implementation of the ISet interface the elements in the Set are
 * maintained in ascending order.
 * <p>
 * The data type for E must be a type that implements Comparable.
 * <p>
 * Implement methods that were not implemented in AbstractSet
 * and override methods that can be done more efficiently. An ArrayList must
 * be used as the internal storage container. For methods involving two set,
 * if that method can be done more efficiently if the other set is also a
 * SortedSet, then do so.
 */
public class SortedSet<E extends Comparable<? super E>> extends AbstractSet<E> {

    private ArrayList<E> myCon;

    /**
     * create an empty SortedSet
     */
    public SortedSet() {
        myCon = new ArrayList<>();
    }

    /**
     * create a SortedSet out of an unsorted set. <br>
     *
     * @param other != null
     */
    public SortedSet(ISet<E> other) {
        myCon = new ArrayList<>();
        for (E item : other) {
            add(item);
        }
    }

    /**
     * Return the smallest element in this SortedSet.
     * <br> pre: size() != 0
     *
     * @return the smallest element in this SortedSet.
     */
    public E min() {
        if (myCon.size() == 0) {
            throw new IllegalStateException("Cannot find min element of empty" +
                    " set");
        }

        return myCon.get(0);
    }

    /**
     * Return the largest element in this SortedSet.
     * <br> pre: size() != 0
     *
     * @return the largest element in this SortedSet.
     */
    public E max() {
        if (myCon.size() == 0) {
            throw new IllegalStateException("Cannot find max element of empty" +
                    " set");
        }

        return myCon.get(myCon.size() - 1);
    }

    /**
     * Determine if item is in this set.
     * <br>pre: item != null
     *
     * @param item element whose presence is being tested.
     *             Item may not equal null.
     * @return true if this set contains the specified item, false otherwise.
     */
    @Override
    public boolean contains(E item) {
        if (item == null) {
            throw new IllegalArgumentException("E item cannot be null");
        }

        int index = addHelper(item, 0, myCon.size());
        return index == -1;
    }

    /**
     * Determine if all of the elements of otherSet are in this set.
     * <br> pre: otherSet != null
     *
     * @param otherSet != null
     * @return true if this set contains all of the elements in otherSet,
     * false otherwise.
     */
    @Override
    public boolean containsAll(ISet<E> otherSet) {
        if (otherSet == null) {
            throw new IllegalArgumentException("ISet otherSet cannot be null");
        }

        return difference(otherSet).size() == this.size() - otherSet.size();
    }

    /**
     * A union operation. Add all items of otherSet that
     * are not already present in this set to this set.
     *
     * @param otherSet != null
     * @return true if this set changed as a result of this operation,
     * false otherwise.
     */
    @Override
    public boolean addAll(ISet<E> otherSet) {
        if (otherSet == null) {
            throw new IllegalArgumentException("ISet otherSet cannot be null");
        }

        int initialSize = myCon.size();
        SortedSet<E> otherSorted;
        if (otherSet instanceof SortedSet) {
            otherSorted = (SortedSet<E>) otherSet;
        } else {
            otherSorted = new SortedSet<>(otherSet);
        }

        addAllHelper(otherSorted);

        return initialSize != this.myCon.size();
    }

    /**
     * Helper method for addAll
     *
     * @param otherSorted the SortedSet to be added to this one
     */
    private void addAllHelper(SortedSet<E> otherSorted) {
        ArrayList<E> otherCon = otherSorted.myCon;
        ArrayList<E> con = new ArrayList<>();
        int thisInd = 0;
        int otherInd = 0;

        // Merge this set and the other set using mergesort-like merge
        while (thisInd < myCon.size() && otherInd < otherSorted.size()) {
            int compare = myCon.get(thisInd).compareTo(otherCon.get(otherInd));
            if (compare <= 0) {
                con.add(myCon.get(thisInd));
                thisInd++;
            } else {
                con.add(otherCon.get(otherInd));
                otherInd++;
            }
        }

        addRemaining(thisInd, otherInd, con, otherCon);

        myCon = con;
    }

    /**
     * Add remaining elements to the ArrayList con
     *
     * @param thisInd  current index in this arraylist
     * @param otherInd current index in other arraylist
     * @param con      merged arraylist being added to
     * @param otherCon arraylist container for other set
     */
    private void addRemaining(int thisInd, int otherInd, ArrayList<E> con,
                              ArrayList<E> otherCon) {
        while (thisInd < myCon.size()) {
            con.add(myCon.get(thisInd));
            thisInd++;
        }

        while (otherInd < otherCon.size()) {
            con.add(otherCon.get(otherInd));
            otherInd++;
        }
    }

    /**
     * Add an item to this set.
     * <br> item != null
     *
     * @param item the item to be added to this set. item may not equal null.
     * @return true if this set changed as a result of this operation,
     * false otherwise.
     */
    @Override
    public boolean add(E item) {
        if (item == null) {
            throw new IllegalArgumentException("E item cannot be null");
        }

        int index = addHelper(item, 0, myCon.size());
        if (index != -1) {
            myCon.add(index, item);
            return true;
        }
        return false;
    }

    /**
     * Binary search to find the position in this set to insert E item to
     * maintain sorted order
     *
     * @param item  the item to be inserted, item != null
     * @param start the lowest position in the range of positions to search
     *              between
     * @param end   the highest position in the range of positions to search
     *              between
     * @return the position in this set to insert E item to maintain sorted
     * order
     */
    private int addHelper(E item, int start, int end) {
        if (start == end) {
            if (size() == 0 || start == size() ||
                    !item.equals(myCon.get(start))) {
                return start;
            }
            return -1;
        } else {
            int mid = (start + end) / 2;
            int comparison = item.compareTo(myCon.get(mid));
            if (comparison == 0) {
                return -1;
            } else if (comparison < 0) {
                return addHelper(item, start, mid);
            } else {
                return addHelper(item, mid + 1, end);
            }
        }
    }

    /**
     * Create a new set that is the difference of this set and otherSet.
     * Return an ISet of elements that are in this Set but not in otherSet.
     * Also called the relative complement.
     * <br>Example: If ISet A contains [X, Y, Z] and ISet B contains [W, Z]
     * then A.difference(B) would return an ISet with elements [X, Y] while
     * B.difference(A) would return an ISet with elements [W].
     * <br>pre: otherSet != null
     * <br>post: returns a set that is the difference of this set and otherSet.
     * Neither this set or otherSet are altered as a result of this operation.
     * <br> pre: otherSet != null
     *
     * @param otherSet != null
     * @return a set that is the difference of this set and otherSet
     */
    @Override
    public ISet<E> difference(ISet<E> otherSet) {
        if (otherSet == null) {
            throw new IllegalArgumentException("ISet otherSet cannot be null");
        }

        SortedSet<E> otherSorted;
        if (otherSet instanceof SortedSet) {
            otherSorted = (SortedSet<E>) otherSet;
        } else {
            otherSorted = new SortedSet<>(otherSet);
        }

        return differenceHelper(otherSorted);
    }

    /**
     * Helper method for difference
     *
     * @param otherSorted the SortedSet to be subtracted from this one
     */
    private ISet<E> differenceHelper(SortedSet<E> otherSorted) {
        ArrayList<E> otherCon = otherSorted.myCon;
        ISet<E> ret = new SortedSet<>();
        int thisInd = 0;
        int otherInd = 0;
        while (thisInd < myCon.size() && otherInd < otherSorted.size()) {
            int compare = myCon.get(thisInd).compareTo(otherCon.get(otherInd));
            if (compare < 0) {
                // Current element must not be in other set, add it to the set
                ret.add(myCon.get(thisInd));
                thisInd++;
            } else if (compare == 0) {
                thisInd++;
                otherInd++;
            } else {
                otherInd++;
            }
        }
        // Add all leftover elements to set
        while (thisInd < myCon.size()) {
            ret.add(myCon.get(thisInd));
            thisInd++;
        }

        return ret;
    }

    /**
     * Return an Iterator object for the elements of this set.
     * pre: none
     *
     * @return an Iterator object for the elements of this set
     */
    @Override
    public Iterator<E> iterator() {
        return myCon.iterator();
    }

    /**
     * Return the number of elements of this set.
     * pre: none
     *
     * @return the number of items in this set
     */
    @Override
    public int size() {
        return myCon.size();
    }

    /**
     * Create a new set that is the union of this set and otherSet.
     * <br>pre: otherSet != null
     * <br>post: returns a set that is the union of this set and otherSet.
     * Neither this set or otherSet are altered as a result of this operation.
     * <br> pre: otherSet != null
     *
     * @param otherSet != null
     * @return a set that is the union of this set and otherSet
     */
    @Override
    public ISet<E> union(ISet<E> otherSet) {
        if (otherSet == null) {
            throw new IllegalArgumentException("ISet otherSet cannot be null");
        }

        SortedSet<E> otherSorted;
        if (otherSet instanceof SortedSet) {
            otherSorted = (SortedSet<E>) otherSet;
        } else {
            otherSorted = new SortedSet<>(otherSet);
        }

        return unionHelper(otherSorted);
    }

    /**
     * Helper method for union
     *
     * @param otherSorted the SortedSet to be subtracted from this one
     */
    private ISet<E> unionHelper(SortedSet<E> otherSorted) {
        ArrayList<E> otherCon = otherSorted.myCon;
        ISet<E> ret = new SortedSet<>();
        int thisInd = 0;
        int otherInd = 0;

        // Merge this set and the other set using mergesort-like merge
        while (thisInd < myCon.size() && otherInd < otherSorted.size()) {
            int compare = myCon.get(thisInd).compareTo(otherCon.get(otherInd));
            if (compare <= 0) {
                ret.add(myCon.get(thisInd));
                thisInd++;
            } else {
                ret.add(otherCon.get(otherInd));
                otherInd++;
            }
        }

        addRemainingUnion(thisInd, otherInd, ret, otherCon);

        return ret;
    }

    /**
     * Add remaining elements to the ISet<E> con
     *
     * @param thisInd  current index in this arraylist
     * @param otherInd current index in other arraylist
     * @param con      union set being added to
     * @param otherCon arraylist container for other set
     */
    private void addRemainingUnion(int thisInd, int otherInd, ISet<E> con,
                                   ArrayList<E> otherCon) {
        while (thisInd < myCon.size()) {
            con.add(myCon.get(thisInd));
            thisInd++;
        }

        while (otherInd < otherCon.size()) {
            con.add(otherCon.get(otherInd));
            otherInd++;
        }
    }
}