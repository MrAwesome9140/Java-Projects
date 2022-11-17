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


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class AnagramSolver {
    private final static AnagramsSorter sorter = new AnagramsSorter();
    private final int SIZE_OF_ALPHABET = 26;
    TreeMap<String, LetterInventory> letters;

    /*
     * pre: list != null
     * @param list Contains the words to form anagrams from.
     */
    public AnagramSolver(Set<String> dictionary) {
        letters = new TreeMap<>();
        for (String s : dictionary) {
            letters.put(s, new LetterInventory(s));
        }
    }

    /*
     * pre: maxWords >= 0, s != null, s contains at least one
     * English letter.
     * Return a list of anagrams that can be formed from s with
     * no more than maxWords, unless maxWords is 0 in which case
     * there is no limit on the number of words in the anagram
     */
    public List<List<String>> getAnagrams(String s, int maxWords) {
        LetterInventory temp = new LetterInventory(s);
        if (s == null || temp.size() == 0 || maxWords < 0) {
            throw new IllegalArgumentException("String s cannot be null and " +
                    "must have at least one valid letter. int maxWords must " +
                    "be non-negative.");
        }

        ArrayList<String> valid = new ArrayList<>();
        List<List<String>> anagrams = new ArrayList<>();
        List<HashMap<Integer, String>> validLength = new ArrayList<>();
        int[] lengths = setupValid(valid, validLength, temp);
        solve(temp, maxWords, anagrams, valid, lengths[0], lengths[1],
                validLength);
        return anagrams;
    }

    /**
     * Helper method to create the list of valid words and words of valid
     * lengths
     *
     * @param valid       list of valid words, valid != null
     * @param validLength list of maps from index to string with the index of
     *                    the Hashmap representing the minimum length of
     *                    strings in the Hashmap, validLength != null
     * @param temp        the LetterInventory for the word we are searching for
     *                    anagrams for, temp != null
     * @return an int[] with index 0 being the maxLength and index 1 being
     * the minLength string in the list of valid words
     */
    private int[] setupValid(ArrayList<String> valid, List<HashMap<Integer,
            String>> validLength, LetterInventory temp) {
        if (valid == null || validLength == null || temp == null) {
            throw new IllegalArgumentException("Parameters valid, " +
                    "validLength, and temp cannot be null");
        }

        int maxLength = Integer.MIN_VALUE;
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < temp.size() + 1; i++) {
            validLength.add(new HashMap<>());
        }
        for (String word : letters.keySet()) {
            if (temp.subtract(letters.get(word)) != null) {
                // Add all valid words to valid and add them to the HashMaps
                // containing Strings of word.length() or less
                for (int i = word.length(); i >= 1; i--) {
                    validLength.get(i).put(valid.size(), word);
                }
                valid.add(word);
                maxLength = Math.max(maxLength, word.length());
                minLength = Math.min(minLength, word.length());
            }
        }
        return new int[]{maxLength, minLength};
    }

    /**
     * Binary search for proper place to put List<String> search into the
     * list of anagrams and insert it there. Calls helper method to do the
     * insertion
     *
     * @param anagrams list of anagrams, anagrams != null
     * @param search   the anagram to insert, search != null
     */
    private void binaryInsert(List<List<String>> anagrams,
                              List<String> search) {
        if (anagrams == null || search == null) {
            throw new IllegalArgumentException("Lists anagrams and search " +
                    "cannot be null");
        }

        binaryInsertHelper(anagrams, search, 0, anagrams.size());
    }

    /**
     * Calls the correct recursive solve method based on whether maxWords is
     * bounded or not.
     *
     * @param word        word to search for anagrams of, word != null
     * @param maxWords    maximum number of words allowed in an anagram
     * @param anagrams    list of all anagrams of word with maxWords or less,
     *                    anagrams != null
     * @param valid       list of words that only contain valid letters, valid != null
     * @param maxLength   maximum length of a word in the list
     * @param minLength   mimimum length of a word in the list
     * @param validLength list of maps from index to string with the index of
     *                    the Hashmap representing the minimum length of
     *                    strings in the Hashmap, validLength != null
     */
    private void solve(LetterInventory word, int maxWords,
                       List<List<String>> anagrams,
                       ArrayList<String> valid, int maxLength,
                       int minLength,
                       List<HashMap<Integer, String>> validLength) {
        if (word == null || anagrams == null || valid == null ||
                validLength == null) {
            throw new IllegalArgumentException("Paramters word, anagrams, " +
                    "valid, and validLength cannot be null");
        }

        if (maxWords == 0) {
            solve(word, new ArrayList<>(), anagrams, valid, 0, minLength);
        } else {
            solve(word, maxWords, new ArrayList<>(), anagrams, valid,
                    maxLength, 0, minLength, validLength);
        }
    }

    /**
     * Helper method for binaryInsert(). Searches for proper position in list
     * of anagrams to put new anagram search and inserts it there.
     *
     * @param anagrams list of anagrams, anagrams != null
     * @param search   the anagram to insert, search != null
     * @param start    the beginning of the range of indices to search within
     * @param end      the end of the range of indices to search within
     */
    private void binaryInsertHelper(List<List<String>> anagrams,
                                    List<String> search, int start, int end) {
        if (start == end) {
            anagrams.add(start, search);
        } else {
            int mid = (start + end) / 2;
            int comparison = sorter.compare(search, anagrams.get(mid));
            if (comparison == 0) {
                anagrams.add(mid, search);
            } else if (comparison > 0) {
                binaryInsertHelper(anagrams, search, mid + 1, end);
            } else {
                binaryInsertHelper(anagrams, search, start, mid);
            }
        }
    }

    /**
     * Recursively finds the anagrams of the word passed as LetterInventory
     * word assuming there is a limit on the number of words
     *
     * @param word        word to search for anagrams of, word != null
     * @param maxWords    maximum number of words allowed in an anagram
     * @param anagrams    list of all anagrams of word with maxWords or less,
     *                    anagrams != null
     * @param valid       list of words that only contain valid letters, valid != null
     * @param maxLength   maximum length of a word in the list
     * @param minLength   mimimum length of a word in the list
     * @param validLength list of maps from index to string with the index of
     *                    the Hashmap representing the minimum length of
     *                    strings in the Hashmap, validLength != null
     * @param curInd      the index of the last word added to the anagram
     * @param sentence    the list of words added so far to create an anagram
     */
    private void solve(LetterInventory word, int maxWords,
                       List<String> sentence, List<List<String>> anagrams,
                       ArrayList<String> valid, int maxLength, int curInd,
                       int minLength,
                       List<HashMap<Integer, String>> validLength) {
        int minLeft = Math.max(1, word.size() - maxLength * (maxWords - 1));
        if (word.size() == 0) {
            binaryInsert(anagrams, new ArrayList<>(sentence));
        } else if (maxWords > 0 && curInd < valid.size()) {

            // Only look through words that are of the minimum necessary
            // length or greater
            HashMap<Integer, String> validStrings = validLength.get(minLeft);
            for (int i : validStrings.keySet()) {
                if (i >= curInd) {
                    String curWord = validStrings.get(i);
                    LetterInventory other = word.subtract(letters.get(curWord));
                    if (consMet(other, maxLength, maxWords, minLength)) {

                        // Add curWord to anagram and see if an anagram is
                        // possible
                        sentence.add(curWord);
                        solve(other, maxWords - 1, sentence, anagrams,
                                valid, maxLength, i, minLength, validLength);
                        sentence.remove(sentence.size() - 1);
                    }
                }
            }
        }
    }

    /**
     * Returns true if the LetterInventory other is valid to be added to the
     * anagram
     *
     * @param other     word to be added to anagram
     * @param maxLength max length of a word in list of valid words
     * @param maxWords  max number of words allowed in an anagram
     * @param minLength min length of a word in list of valid words
     * @return true if the LetterInventory other is valid to be added to the
     * anagram
     */
    private boolean consMet(LetterInventory other, int maxLength, int maxWords,
                            int minLength) {

        return other != null && maxLength * (maxWords - 1) >= other.size() &&
                (other.size() == 0 || other.size() >= minLength);
    }

    /**
     * Returns true if the LetterInventory other is valid to be added to the
     * anagram
     *
     * @param other     word to be added to anagram
     * @param minLength min length of a word in list of valid words
     * @param curInd    index of the word currently being checked
     * @param valid     list of valid words as part of anagram, valid != null
     * @return true if the LetterInventory other is valid to be added to the
     * anagram
     */
    private boolean consMet(LetterInventory other, int minLength,
                            ArrayList<String> valid,
                            int curInd) {
        if (valid == null) {
            throw new IllegalArgumentException("ArrayList valid cannot be " +
                    "null");
        }

        return other != null &&
                (other.size() == 0 || (other.size() >= minLength &&
                        maxCharLeft(other, valid.get(curInd))));
    }

    /**
     * Recursively finds the anagrams of the word passed as LetterInventory
     * word assuming there is no limit on the number of words
     *
     * @param word      word to search for anagrams of, word != null
     * @param anagrams  list of all anagrams of word with maxWords or less,
     *                  anagrams != null
     * @param valid     list of words that only contain valid letters, valid != null
     * @param minLength mimimum length of a word in the list
     * @param curInd    the index of the last word added to the anagram
     * @param sentence  the list of words added so far to create an anagram
     */
    private void solve(LetterInventory word, List<String> sentence,
                       List<List<String>> anagrams, ArrayList<String> valid,
                       int curInd, int minLength) {
        if (word.size() == 0) {
            binaryInsert(anagrams, new ArrayList<>(sentence));
        } else if (curInd < valid.size()) {

            // Go through all words at index curInd and greater
            for (int i = curInd; i < valid.size(); i++) {
                String curWord = valid.get(i);
                LetterInventory other = word.subtract(letters.get(curWord));
                if (consMet(other, minLength, valid, curInd)) {

                    // If curWord is valid then see if an anagram can be made
                    // by adding it
                    sentence.add(curWord);
                    solve(other, sentence, anagrams, valid, i, minLength);
                    sentence.remove(sentence.size() - 1);
                }
            }
        }
    }

    /**
     * Returns true if the maximum letter left is less than the first letter
     * of the current word being searched. Returns false otherwise
     *
     * @param other   word anagrams are being found for, other != null
     * @param curWord current word being checked, curWord != null
     * @return true if the maximum letter left is less than the first letter
     * of the current word being searched. Returns false otherwise
     */
    private boolean maxCharLeft(LetterInventory other, String curWord) {
        if (other == null || curWord == null) {
            throw new IllegalArgumentException("Paramters other and curWord " +
                    "cannot be null");
        }

        char c = 'a';
        for (char temp = 'a'; temp <= 'z'; temp++) {
            if (other.get(temp) != 0) {
                c = temp;
            }
        }
        return c >= curWord.charAt(0);
    }

    /**
     * Private class to compare anagrams as Lists of strings with each other
     */
    private static class AnagramsSorter implements Comparator<List<String>> {

        /**
         * Returns a number less than 0 if o1 is less than o2 in size or
         * less than o2 lexicographically and returns a number greater than 0
         * if o1 is
         * greater than o2 in size or greater
         * lexicographically
         *
         * @param o1 the first object to be compared.
         * @param o2 the second object to be compared.
         * @return a number less than 0 if o1 is less than o2 in size or
         * less than o2 lexicographically and returns a number greater than 0
         * if o1 is
         */
        @Override
        public int compare(List<String> o1, List<String> o2) {
            if (o1.size() == o2.size()) {
                int dif = 0;
                int index = 0;
                while (index < o1.size() && dif == 0) {
                    dif = o1.get(index).compareTo(o2.get(index));
                    index++;
                }
                return dif;
            }
            return o1.size() - o2.size();
        }
    }

}