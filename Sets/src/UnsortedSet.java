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
 * A simple implementation of an ISet.
 * Elements are not in any particular order.
 * Students are to implement methods that
 * were not implemented in AbstractSet and override
 * methods that can be done more efficiently.
 * An ArrayList must be used as the internal storage container.
 */
public class UnsortedSet<E> extends AbstractSet<E> {

    private ArrayList<E> myCon;

    public UnsortedSet() {
        myCon = new ArrayList<>();
    }

    public UnsortedSet(UnsortedSet<E> add) {
        myCon = new ArrayList<>();
        addAll(add);
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

        if (contains(item)) {
            return false;
        }
        return myCon.add(item);
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

        ISet<E> dif = new UnsortedSet<>();
        for (E item : myCon) {
            if (!otherSet.contains(item)) {
                dif.add(item);
            }
        }
        return dif;
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

        ISet<E> union = new UnsortedSet<>();
        union.addAll(this);
        union.addAll(otherSet);
        return union;
    }
}