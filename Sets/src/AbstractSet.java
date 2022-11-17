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

/**
 * Students are to complete this class.
 * Students should implement as many methods
 * as they can using the Iterator from the iterator
 * method and the other methods.
 */
public abstract class AbstractSet<E> implements ISet<E> {

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

        boolean ret = false;
        for (E e : otherSet) {
            if (add(e)) {
                ret = true;
            }
        }
        return ret;
    }

    /**
     * Make this set empty.
     * <br>pre: none
     * <br>post: size() = 0
     */
    @Override
    public void clear() {
        Iterator<E> iterator = iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
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

        for (E e : this) {
            if (e.equals(item)) {
                return true;
            }
        }
        return false;
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

        for (E other : otherSet) {
            if (!contains(other)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Remove the specified item from this set if it is present.
     * pre: item != null
     *
     * @param item the item to remove from the set. item may not equal null.
     * @return true if this set changed as a result of this operation,
     * false otherwise
     */
    @Override
    public boolean remove(E item) {
        if (item == null) {
            throw new IllegalArgumentException("E item cannot be null");
        }

        Iterator<E> iterator = iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(item)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * Determine if this set is equal to other.
     * Two sets are equal if they have exactly the same elements.
     * The order of the elements does not matter.
     * <br>pre: none
     *
     * @param obj the object to compare to this set
     * @return true if other is a Set and has the same elements as this set
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ISet) {
            try {
                ISet<E> other = (ISet<E>) obj;
                if (other.size() == size()) {
                    for (E e : this) {
                        if (!other.contains(e)) {
                            return false;
                        }
                    }
                    return true;
                }
            } catch (ClassCastException e) {
                // Return false if other set does not contain objects of the
                // same type as this one
                return false;
            }
        }
        return false;
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
    public ISet<E> intersection(ISet<E> otherSet) {
        if (otherSet == null) {
            throw new IllegalArgumentException("ISet otherSet cannot be null");
        }

        ISet<E> ret = otherSet.difference(this);
        return otherSet.difference(ret);
    }

    /**
     * Return a String version of this set.
     * Format is (e1, e2, ... en)
     *
     * @return A String version of this set.
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        String seperator = ", ";
        result.append("(");

        Iterator<E> it = this.iterator();
        while (it.hasNext()) {
            result.append(it.next());
            result.append(seperator);
        }
        // get rid of extra separator
        if (this.size() > 0) {
            result.setLength(result.length() - seperator.length());
        }

        result.append(")");
        return result.toString();
    }
}