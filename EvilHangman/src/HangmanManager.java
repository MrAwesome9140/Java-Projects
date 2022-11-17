/*  Student information for assignment:
 *
 *  On my honor, Aaroh Sharma, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  Name: Aaroh Sharma
 *  email address: aaroh.sh@gmail.com
 *  UTEID: as225925
 *  Section 5 digit ID: 52600
 *  Grader name: Brad
 *  Number of slip days used on this assignment: 0
 */

// add imports as necessary


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Manages the details of EvilHangman. This class keeps
 * tracks of the possible words from a dictionary during
 * rounds of hangman, based on guesses so far.
 */
public class HangmanManager {

    private boolean debug;
    private ArrayList<String> words;
    private int numGuesses;
    private HangmanDifficulty diff;
    private int numWrongGuesses;
    private ArrayList<String> eliWords;
    private ArrayList<Character> guessed;
    private String pattern;

    /**
     * Create a new HangmanManager from the provided set of words and phrases.
     * pre: words != null, words.size() > 0
     *
     * @param words   A set with the words for this instance of Hangman.
     * @param debugOn true if we should print out debugging to System.out.
     */
    public HangmanManager(Set<String> words, boolean debugOn) {
        debug = debugOn;
        this.words = new ArrayList<>(words);
        eliWords = new ArrayList<>();
        guessed = new ArrayList<>();
    }

    /**
     * Create a new HangmanManager from the provided set of words and phrases.
     * Debugging is off.
     * pre: words != null, words.size() > 0
     *
     * @param words A set with the words for this instance of Hangman.
     */
    public HangmanManager(Set<String> words) {
        this.words = new ArrayList<>(words);
        eliWords = new ArrayList<>();
        guessed = new ArrayList<>();
    }


    /**
     * Get the number of words in this HangmanManager of the given length.
     * pre: none
     *
     * @param length The given length to check.
     * @return the number of words in the original Dictionary
     * with the given length
     */
    public int numWords(int length) {
        int matchingWords = 0;
        for (String s : words) {
            if (s.length() == length) {
                matchingWords++;
            }
        }
        return matchingWords;
    }


    /**
     * Get for a new round of Hangman. Think of a round as a
     * complete game of Hangman.
     *
     * @param wordLen    the length of the word to pick this time.
     *                   numWords(wordLen) > 0
     * @param numGuesses the number of wrong guesses before the
     *                   player loses the round. numGuesses >= 1
     * @param diff       The difficulty for this round.
     */
    public void prepForRound(int wordLen, int numGuesses,
                             HangmanDifficulty diff) {
        this.numGuesses = numGuesses;
        this.diff = diff;
        guessed.clear();
        numWrongGuesses = 0;
        eliWords.clear();

        // Update list eliWords to only contain words of the given length
        for (String s : words) {
            if (s.length() == wordLen) {
                eliWords.add(s);
            }
        }
        char[] temp = new char[wordLen];
        Arrays.fill(temp, '-');
        this.pattern = new String(temp);
    }


    /**
     * The number of words still possible (live) based on the guesses so far.
     * Guesses will eliminate possible words.
     *
     * @return the number of words that are still possibilities based on the
     * original dictionary and the guesses so far.
     */
    public int numWordsCurrent() {
        return eliWords.size();
    }


    /**
     * Get the number of wrong guesses the user has left in
     * this round (game) of Hangman.
     *
     * @return the number of wrong guesses the user has left
     * in this round (game) of Hangman.
     */
    public int getGuessesLeft() {
        return numGuesses - numWrongGuesses;
    }


    /**
     * Return a String that contains the letters the user has guessed
     * so far during this round.
     * The characters in the String are in alphabetical order.
     * The String is in the form [let1, let2, let3, ... letN].
     * For example [a, c, e, s, t, z]
     *
     * @return a String that contains the letters the user
     * has guessed so far during this round.
     */
    public String getGuessesMade() {

        // Sort the list of guessed characters and convert it to String form
        // using a StringBuilder
        Collections.sort(guessed);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < guessed.size() - 1; i++) {
            sb.append(guessed.get(i)).append(", ");
        }
        if (guessed.size() > 0) {
            sb.append(guessed.get(guessed.size() - 1));
        }
        sb.append("]");
        return sb.toString();
    }


    /**
     * Check the status of a character.
     *
     * @param guess The characater to check.
     * @return true if guess has been used or guessed this round of Hangman,
     * false otherwise.
     */
    public boolean alreadyGuessed(char guess) {
        return guessed.contains(guess);
    }


    /**
     * Get the current pattern. The pattern contains '-''s for
     * unrevealed (or guessed) characters and the actual character
     * for "correctly guessed" characters.
     *
     * @return the current pattern.
     */
    public String getPattern() {
        return pattern;
    }


    /**
     * Update the game status (pattern, wrong guesses, word list),
     * based on the give guess.
     *
     * @param guess pre: !alreadyGuessed(ch), the current guessed character
     * @return return a tree map with the resulting patterns and the number of
     * words in each of the new patterns.
     * The return value is for testing and debugging purposes.
     */
    public TreeMap<String, Integer> makeGuess(char guess) {
        if (alreadyGuessed(guess)) {
            throw new IllegalStateException("This character has already been " +
                    "guessed");
        }

        // Add the latest guess to the list of guesses, find all patterns
        // that are possible with the given letters, sort the map entries
        // using a TreeSet with a custom Comparator
        guessed.add(guess);
        Map<String, ArrayList<String>> pattern = getNewPatterns();
        TreeSet<Map.Entry<String, ArrayList<String>>> sortVals =
                new TreeSet<>(new LengthComparator());
        sortVals.addAll(pattern.entrySet());
        updateVars(sortVals, guess);

        // Return a TreeMap of all the patterns mapped to the number of words
        // they match with
        TreeMap<String, Integer> pats = new TreeMap<>();
        for (Map.Entry<String, ArrayList<String>> s : sortVals) {
            pats.put(s.getKey(), s.getValue().size());
        }
        return pats;
    }

    /**
     * Select which pattern to use based on all the possible patterns and
     * update the relevant instance variables based on the new pattern
     *
     * @param sortVals != null, a sorted set of all the patterns and their
     *                 respective word lists
     * @param guess,   the character that the user guessed
     */
    private void updateVars(TreeSet<Map.Entry<String, ArrayList<String>>> sortVals,
            char guess) {
        if (sortVals == null) {
            throw new IllegalArgumentException("TreeMap sortVals can't be " +
                    "null");
        }

        Iterator<Map.Entry<String, ArrayList<String>>> iter =
                sortVals.iterator();

        // Decide which pattern to select based on the difficulty
        Map.Entry<String, ArrayList<String>> newOne = iter.next();
        final int easyDif = 2, midDif = 4;
        if (((diff == HangmanDifficulty.EASY && guessed.size() % easyDif == 0)
                || (diff == HangmanDifficulty.MEDIUM &&
                guessed.size() % midDif == 0))
                && iter.hasNext()) {
            newOne = iter.next();
        }

        // Update instance variables based on the new pattern
        pattern = newOne.getKey();
        eliWords = newOne.getValue();
        if (!pattern.contains(String.valueOf(guess))) {
            numWrongGuesses++;
        }
    }

    /**
     * Find all word patterns containing the letters guessed so far and
     * return them in the form of a map with the key being the pattern and
     * the value being a list of all strings that match the pattern
     *
     * @return a map with the key being the pattern and
     * the value being a list of all strings that match the pattern
     */
    private Map<String, ArrayList<String>> getNewPatterns() {
        Map<String, ArrayList<String>> pattern = new TreeMap<>();
        for (String s : eliWords) {

            // pat is the pattern for String s that contains the previously
            // guessed characters
            StringBuilder pat = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                pat.append(guessed.contains(s.charAt(i)) ? s.charAt(i) : '-');
            }

            // add the pattern to the map of all patterns
            String fin = pat.toString();
            if (pattern.containsKey(fin)) {
                pattern.get(fin).add(s);
            } else {
                pattern.put(fin, new ArrayList<>(Collections.singleton(s)));
            }
        }
        return pattern;
    }

    /**
     * Return the difference between the number of guessed characters in
     * String comp and String orig
     *
     * @param orig != null
     * @param comp != null
     * @return the difference between the number of guessed characters in
     * String comp and String orig
     */
    private int fewerChars(String orig, String comp) {
        if (orig == null || comp == null) {
            throw new IllegalArgumentException("String orig and comp cannot " +
                    "be null");
        }

        // Find the number of guessed characters in String orig and String comp
        int numOrig = 0;
        for (int i = 0; i < orig.length(); i++) {
            if (orig.charAt(i) != '-') {
                numOrig++;
            }
        }
        int numComp = 0;
        for (int i = 0; i < comp.length(); i++) {
            if (comp.charAt(i) != '-') {
                numComp++;
            }
        }
        return numComp - numOrig;
    }

    /**
     * Return the secret word this HangmanManager finally ended up
     * picking for this round.
     * If there are multiple possible words left one is selected at random.
     * <br> pre: numWordsCurrent() > 0
     *
     * @return return the secret word the manager picked.
     */
    public String getSecretWord() {
        if (numWordsCurrent() == 0) {
            throw new IllegalStateException("0 words remaining");
        }

        String retWord = eliWords.get(0);

        // Return a random word if there are 2 or words left in the list of
        // valid words
        if (numWordsCurrent() > 1) {
            int randNum = (int) (Math.random() * numWordsCurrent());
            retWord = eliWords.get(randNum);
        }
        return retWord;
    }

    /**
     * Private class to implement a comparator that can be applied to a
     * TreeSet containing Map entries to sort them based on the assignment
     * specifications
     */
    private class LengthComparator implements Comparator<Map.Entry<String,
                ArrayList<String>>> {

        /**
         * Return a positive integer if o1's list of words is smaller than
         * o2's list of words, or if they are equal in size and o1 has more
         * guessed characters than o2, and a negative integer otherwise
         *
         * @param o1 the first Map.Entry to be compared.
         * @param o2 the second Map.Entry to be compared.
         * @return a positive integer if o1's list of words is smaller than
         * o2's list of words, or if they are equal in size and o1 has more
         * guessed characters than o2, and a negative integer
         * otherwise
         */
        public int compare(Map.Entry<String, ArrayList<String>> o1,
                           Map.Entry<String, ArrayList<String>> o2) {

            // Compare the sizes of o1's list of words and o2's list of words
            // and return a positive integer is o1's is smaller than o2's
            if (o1.getValue().size() < o2.getValue().size()) {
                return 1;
            } else if (o1.getValue().size() == o2.getValue().size()) {
                int difChars = fewerChars(o1.getKey(), o2.getKey());
                int comp = o1.getKey().compareTo(o2.getKey());

                // Return a positive integer if o1 has more guessed
                // characters than o2, and if those values are equal, return
                // a positive integer if o1's key is lexicographically greater
                // than o2's key
                if (difChars < 0 || (difChars == 0 && comp > 0)) {
                    return 1;
                }
            }
            return -1;
        }
    }
}