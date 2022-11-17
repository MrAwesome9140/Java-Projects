/* CS 314 STUDENTS: FILL IN THIS HEADER AND THEN COPY AND PASTE IT TO YOUR
 * LetterInventory.java AND AnagramSolver.java CLASSES.
 *
 * Student information for assignment:
 *
 *  On my honor, Aaroh Sharma, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID: as225925
 *  email address: aaroh.sh@gmail.com
 *  TA name: Brad
 *  Number of slip days I am using: 2
 */

public class LetterInventory {

    private final int SIZE_OF_ALPHABET = 26;
    private final char FIRST_LOWER = 'a';
    private final char LAST_LOWER = 'z';
    private final char FIRST_UPPER = 'A';
    private final char LAST_UPPER = 'Z';
    private int[] letters;
    private int size;

    /**
     * Creates a new LetterInventory using the String word that is passed.
     * All letters are treated as lowercase.
     *
     * @param word the word to create a letter inventory for
     */
    public LetterInventory(String word) {
        letters = new int[SIZE_OF_ALPHABET];
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            char temp = word.charAt(i);
            if (temp >= FIRST_LOWER && temp <= LAST_LOWER) {
                size++;
                letters[temp - FIRST_LOWER]++;
            }
        }
    }

    /**
     * Returns the frequency of char letter in this LetterInventory
     *
     * @param letter must be a valid upper or lowercase letter
     * @return the frequency of char letter in this LetterInventory
     */
    public int get(char letter) {
        if (letter < FIRST_UPPER || letter > LAST_LOWER) {
            throw new IllegalArgumentException("Must pass a valid uppercase " +
                    "or lowercase letter");
        }

        int index = letter <= LAST_UPPER ? letter - FIRST_UPPER :
                letter - FIRST_LOWER;
        return letters[index];
    }

    /**
     * Returns the number of letters in this inventory
     *
     * @return the number of letters in this inventory
     */
    public int size() {
        return size;
    }

    /**
     * @return true if this LetterInventory is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return a String representation of this LetterInventory with all of
     * the letters in alphabetical order
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE_OF_ALPHABET; i++) {
            char temp = (char) (FIRST_LOWER + i);
            for (int j = 0; j < letters[i]; j++) {
                sb.append(temp);
            }
        }
        return sb.toString();
    }

    /**
     * Return a LetterInventory that combines the frequencies of this
     * LetterInventory and the LetterInventory that is passed as a parameter
     *
     * @param other the LetterInventory to add to this one; must not be null
     * @return a LetterInventory that combines the frequencies of this
     * LetterInventory and the LetterInventory that is passed as a parameter
     */
    public LetterInventory add(LetterInventory other) {
        if (other == null) {
            throw new IllegalArgumentException("LetterInventory other cannot " +
                    "be null");
        }

        int[] combined = new int[SIZE_OF_ALPHABET];
        int size = 0;

        // Add the letter frequencies of each letter in this and other
        for (int i = 0; i < SIZE_OF_ALPHABET; i++) {
            combined[i] = letters[i] + other.letters[i];
            size += combined[i];
        }
        LetterInventory comb = new LetterInventory("");
        comb.letters = combined;
        comb.size = size;
        return comb;
    }

    /**
     * Returns a LetterInventory containing the difference in frequencies
     * between this LetterInventory and the one passed as a parameter.
     *
     * @param other the LetterInventor whose frequencies are being subtracted
     *              from this one; other != null
     * @return a LetterInventory containing the difference in frequencies
     * between this LetterInventory and the one passed as a parameter.
     * Returns null if any of these differences result in a negative value.
     */
    public LetterInventory subtract(LetterInventory other) {
        if (other == null) {
            throw new IllegalArgumentException("LetterInventory other cannot " +
                    "be null");
        }

        if (size < other.size()) {
            return null;
        }
        int[] combined = new int[SIZE_OF_ALPHABET];
        int size = 0;

        // Return null if any of the other LetterInventory's letter
        // frequencies are greater than this LetterInventory's letter
        // frequencies
        for (int i = 0; i < SIZE_OF_ALPHABET; i++) {
            int dif = letters[i] - other.letters[i];
            if (dif < 0) {
                return null;
            }
            combined[i] = dif;
            size += combined[i];
        }
        LetterInventory comb = new LetterInventory("");
        comb.letters = combined;
        comb.size = size;
        return comb;
    }

    /**
     * Returns true if obj is a LetterInventory and has the same frequencies
     * of the same letters as this LetterInventory
     *
     * @param obj the object this LetterInventory is being compared to;
     * @return true if obj is a LetterInventory and has the same frequencies
     * of the same letters as this LetterInventory
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LetterInventory)) {
            return false;
        }

        LetterInventory let = (LetterInventory) obj;
        if (let.size == size) {
            for (int i = 0; i < SIZE_OF_ALPHABET; i++) {
                if (let.letters[i] != letters[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
