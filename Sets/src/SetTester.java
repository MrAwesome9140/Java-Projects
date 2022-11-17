/*
 * Student information for assignment:
 *
 * Number of slip days used: 2
 * Student 1 (Student whose turnin account is being used)
 *  UTEID: as225925
 *  email address: aaroh.sh@gmail.com
 *  Grader name: Brad
 */

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.*;

/*
 * CS 314 Students, put your results to the experiments and answers to questions
 * here: CS314 Students, why is it unwise to implement all three of the
 * intersection, union, and difference methods in the AbstractSet class:
 *
 * It is unwise to put intersection, union, and difference in the AbstractSet
 * because each of them are implemented by relying on the other two, calling
 * one of the methods will create an infinite loop
 *
 * Experiment Results:
 * - SortedSet
    | Title                   | Size  | Total Words | Distinct Words | Time  |
    |-------------------------|-------|-------------|----------------|-------|
    | 5 Paragraphs            | 2     | 309         | 186            | 0.005 |
    | 25 Paragraphs           | 5x    | 5.7x        | 4.0x           | 2x    |
    | High Class Cookery      | 9x    | 9.2x        | 4.1x           | 4.8x  |
    | Cassels Natural History | 13.8x | 13.0x       | 9.4x           | 5.6x  |
 * processText - O(N*log(M))
 * add - O(log(M))
 *
 * - UnsortedSet
    | Title                   | Size  | Total Words | Distinct Words | Time  |
    |-------------------------|-------|-------------|----------------|-------|
    | 5 Paragraphs            | 2     | 309         | 186            | 0.005 |
    | 25 Paragraphs           | 5x    | 5.7x        | 4.0x           | 2.4x  |
    | High Class Cookery      | 9x    | 9.2x        | 4.1x           | 6.1x  |
    | Cassels Natural History | 13.8x | 13.0x       | 9.4x           | 62.2x |
 * processText - O(N*M)
 * add - O(M)
 *
 * - HashSet
    | Title                   | Size  | Total Words | Distinct Words | Time  |
    |-------------------------|-------|-------------|----------------|-------|
    | 5 Paragraphs            | 2     | 309         | 186            | 0.001 |
    | 25 Paragraphs           | 5x    | 5.7x        | 4.0x           | 2.0x  |
    | High Class Cookery      | 9x    | 9.2x        | 4.1x           | 5.2x  |
    | Cassels Natural History | 13.8x | 13.0x       | 9.4x           | 11.3x |
 * processText - O(N)
 * add - O(1)
 *
 * - TreeSet
    | Title                   | Size  | Total Words | Distinct Words | Time  |
    |-------------------------|-------|-------------|----------------|-------|
    | 5 Paragraphs            | 2     | 309         | 186            | 0.002 |
    | 25 Paragraphs           | 5x    | 5.7x        | 4.0x           | 3x    |
    | High Class Cookery      | 9x    | 9.2x        | 4.1x           | 3.2x  |
    | Cassels Natural History | 13.8x | 13.0x       | 9.4x           | 7.77x |
 * processText - O(N*log(M))
 * add - O(log(M))
 *
 * The TreeSet prints out its contents in alphabetical order while HashSet
 * prints them out in no particular order
 */

public class SetTester {

    public static void main(String[] args) {
        studentTest();
    }

    private static void studentTest() {
        ISet<String> unsortedSet = new UnsortedSet<>();
        ISet<String> sortedSet = new SortedSet<>();
        int testNumber = 0;
        String testDescription = "";
        boolean expected = false;
        boolean actual = true;

        // test 1, add() unsorted
        actual = unsortedSet.add("XOTWOD");
        expected = true;
        testDescription = "add() on UnsortedSet";
        testNumber++;
        showTestResults(actual, expected, testNumber, unsortedSet, null,
                testDescription);

        // test 2, add() sorted
        actual = sortedSet.add("XOTWOD");
        expected = true;
        testDescription = "add() on SortedSet";
        testNumber++;
        showTestResults(actual, expected, testNumber, sortedSet, null,
                testDescription);

        // test 3, addAll() unsorted
        actual = unsortedSet.addAll(unsortedSet);
        expected = false;
        testDescription = "addAll() on UnsortedSet";
        testNumber++;
        showTestResults(actual, expected, testNumber, unsortedSet, null,
                testDescription);

        // test 4, addAll() sorted
        ISet<String> temp = new SortedSet<>();
        temp.add("The Fall");
        temp.add("KOTF");
        temp.add("Alla Dem");
        actual = sortedSet.addAll(temp);
        expected = true;
        testDescription = "addAll() on SortedSet";
        testNumber++;
        showTestResults(actual, expected, testNumber, sortedSet, temp,
                testDescription);

        // test 5, clear()
        unsortedSet.clear();
        actual = unsortedSet.size() == 0;
        expected = true;
        testDescription = "clear() on ISet";
        testNumber++;
        showTestResults(actual, expected, testNumber, unsortedSet, null,
                testDescription);

        // test 6, contains() unsorted
        actual = unsortedSet.contains("Weeknd");
        expected = false;
        testDescription = "contains() on UnsortedSet";
        testNumber++;
        showTestResults(actual, expected, testNumber, unsortedSet, null,
                testDescription);

        // test 7, contains() sorted
        actual = sortedSet.contains("The Fall");
        expected = true;
        testDescription = "contains() on SortedSet";
        testNumber++;
        showTestResults(actual, expected, testNumber, sortedSet, null,
                testDescription);

        // test 8, containsAll() unsorted
        unsortedSet.add("NWTS");
        unsortedSet.add("Take Care");
        unsortedSet.add("IYRTITL");
        ISet<String> tempUnsorted = new UnsortedSet<>();
        tempUnsorted.add("NWTS");
        tempUnsorted.add("IYRTITL");
        actual = unsortedSet.containsAll(tempUnsorted);
        expected = true;
        testDescription = "containsAll() on UnsortedSet";
        testNumber++;
        showTestResults(actual, expected, testNumber, unsortedSet, tempUnsorted,
                testDescription);

        // test 9, containsAll() sorted
        ISet<String> tempSorted = new SortedSet<>();
        tempSorted.add("Alla Dem");
        tempSorted.add("Wow");
        actual = sortedSet.containsAll(tempSorted);
        expected = false;
        testDescription = "containsAll() on SortedSet";
        testNumber++;
        showTestResults(actual, expected, testNumber, sortedSet, tempSorted,
                testDescription);

        // test 10, difference() unsorted
        tempUnsorted = unsortedSet.difference(tempUnsorted);
        ISet<String> tempExpected = new UnsortedSet<>();
        tempExpected.add("Take Care");
        actual = tempExpected.equals(tempUnsorted);
        expected = true;
        testDescription = "difference() on UnsortedSet";
        testNumber++;
        showTestResults(actual, expected, testNumber, unsortedSet, tempUnsorted,
                testDescription);

        // test 11, difference() sorted
        sortedSet.add("XOTWOD");
        sortedSet.add("Alla Dem");
        tempSorted = sortedSet.difference(tempSorted);
        tempExpected.clear();
        tempExpected.add("XOTWOD");
        tempExpected.add("The Fall");
        tempExpected.add("KOTF");
        actual = tempExpected.equals(tempSorted);
        expected = true;
        testDescription = "difference() on SortedSet";
        testNumber++;
        showTestResults(actual, expected, testNumber, sortedSet, tempSorted,
                testDescription);

        // test 12, equals() unsorted
        tempExpected.clear();
        tempExpected.add("Bob");
        tempExpected.add("Poppy");
        actual = tempUnsorted.equals(tempExpected);
        expected = false;
        testDescription = "equals() on UnsortedSet";
        testNumber++;
        showTestResults(actual, expected, testNumber, unsortedSet, tempExpected,
                testDescription);

        // test 13, equals() sorted
        tempSorted.clear();
        tempSorted.add("The Fall");
        tempSorted.add("XOTWOD");
        tempSorted.add("KOTF");
        tempSorted.add("Alla Dem");
        actual = tempSorted.equals(sortedSet);
        expected = true;
        testDescription = "equals() on SortedSet";
        testNumber++;
        showTestResults(actual, expected, testNumber, sortedSet, tempSorted,
                testDescription);

        // test 14, intersection() unsorted
        tempUnsorted.clear();
        tempUnsorted.add("Views");
        tempUnsorted.add("NWTS");
        tempUnsorted.add("Scorpion");
        tempUnsorted = unsortedSet.intersection(tempUnsorted);
        tempExpected.clear();
        tempExpected.add("NWTS");
        actual = tempUnsorted.equals(tempExpected);
        expected = true;
        testDescription = "intersection() on UnsortedSet";
        testNumber++;
        showTestResults(actual, expected, testNumber, unsortedSet, tempUnsorted,
                testDescription);

        // test 15, intersection() sorted
        tempSorted.clear();
        tempSorted.add("Insane");
        tempSorted = sortedSet.intersection(tempSorted);
        tempExpected.clear();
        actual = tempSorted.equals(tempExpected);
        expected = true;
        testDescription = "intersection() on SortedSet";
        testNumber++;
        showTestResults(actual, expected, testNumber, sortedSet, tempSorted,
                testDescription);

        // test 16, iterator() unsorted
        Iterator<String> iterator = unsortedSet.iterator();
        actual = iterator != null;
        expected = true;
        testDescription = "iterator() on UnsortedSet";
        testNumber++;
        showTestResults(actual, expected, testNumber, unsortedSet, null,
                testDescription);

        // test 17, iterator() sorted
        iterator = sortedSet.iterator();
        actual = iterator != null;
        expected = true;
        testDescription = "iterator() on SortedSet";
        testNumber++;
        showTestResults(actual, expected, testNumber, sortedSet, null,
                testDescription);

        // test 18, remove() unsorted
        actual = unsortedSet.remove("IYRTITL");
        expected = true;
        testDescription = "remove() on UnsortedSet";
        testNumber++;
        showTestResults(actual, expected, testNumber, unsortedSet, null,
                testDescription);

        // test 19, remove() sorted
        actual = sortedSet.remove("XOTWOD");
        expected = true;
        testDescription = "remove() on SortedSet";
        testNumber++;
        showTestResults(actual, expected, testNumber, sortedSet, null,
                testDescription);

        // test 20, size() unsorted
        actual = unsortedSet.size() == 2;
        expected = true;
        testDescription = "size() on UnsortedSet";
        testNumber++;
        showTestResults(actual, expected, testNumber, unsortedSet, null,
                testDescription);

        // test 21, size() sorted
        actual = sortedSet.size() == 3;
        expected = true;
        testDescription = "size() on SortedSet";
        testNumber++;
        showTestResults(actual, expected, testNumber, sortedSet, null,
                testDescription);

        // test 22, union() unsorted
        tempUnsorted.clear();
        tempUnsorted.add("CLB");
        tempUnsorted.add("Take Care");
        tempUnsorted = tempUnsorted.union(unsortedSet);
        tempExpected.clear();
        tempExpected.add("CLB");
        tempExpected.add("Take Care");
        tempExpected.add("NWTS");
        actual = tempExpected.equals(tempUnsorted);
        expected = true;
        testDescription = "union() on UnsortedSet";
        testNumber++;
        showTestResults(actual, expected, testNumber, unsortedSet, tempUnsorted,
                testDescription);

        // test 23, union() sorted
        tempSorted.clear();
        tempSorted.add("Trilogy");
        tempSorted.add("KOTF");
        tempSorted.add("After Hours");
        tempSorted = tempSorted.union(sortedSet);
        tempExpected.clear();
        tempExpected.add("Trilogy");
        tempExpected.add("KOTF");
        tempExpected.add("After Hours");
        tempExpected.add("Alla Dem");
        tempExpected.add("The Fall");
        actual = tempExpected.equals(tempSorted);
        expected = true;
        testDescription = "union() on SortedSet";
        testNumber++;
        showTestResults(actual, expected, testNumber, sortedSet, tempSorted,
                testDescription);

        // test 24, max() sorted
        SortedSet<Integer> sortTemp = new SortedSet<>();
        sortTemp.add(2);
        sortTemp.add(-23);
        sortTemp.add(490);
        sortTemp.add(3);
        actual = sortTemp.max() == 490;
        expected = true;
        testDescription = "max() on SortedSet";
        testNumber++;
        showTestResults(actual, expected, testNumber, sortTemp, null,
                testDescription);

        // test 25, min() sorted
        actual = sortTemp.min() == -23;
        expected = true;
        testDescription = "min() on SortedSet";
        testNumber++;
        showTestResults(actual, expected, testNumber, sortTemp, null,
                testDescription);
    }

    // print out results of test
    private static <E> void showTestResults(boolean actualResult, boolean expectedResult,
                                            int testNumber, ISet<E> set1, ISet<E> set2, String testDescription) {
        if (actualResult == expectedResult) {
            System.out.println("Passed test " + testNumber + ", " + testDescription);
        } else {
            System.out.print("Failed test ");
            System.out.println(testNumber + ": " + testDescription);
            System.out.println("Expected result: " + expectedResult);
            System.out.println("Actual result  : " + actualResult);
            System.out.println("Set 1: " + set1);
            if (set2 != null) {
                System.out.println("Set 2: " + set2);
            }
        }

    }

    /*
     * Method asks user for file and compares run times to add words from file
     * to various sets, including CS314 UnsortedSet and SortedSet and Java's
     * TreeSet and HashSet.
     */
    private static void largeTest() {
        System.out.println();
        System.out.println("Opening Window to select file. "
                + "You may have to minimize other windows.");
        String text = convertFileToString();
        Scanner keyboard = new Scanner(System.in);
        System.out.println();
        System.out.println("***** CS314 SortedSet: *****");
        processTextCS314Sets(new SortedSet<String>(), text, keyboard);
        System.out.println("****** CS314 UnsortedSet: *****");
        processTextCS314Sets(new UnsortedSet<String>(), text, keyboard);
        System.out.println("***** Java HashSet ******");
        processTextJavaSets(new HashSet<String>(), text, keyboard);
        System.out.println("***** Java TreeSet ******");
        processTextJavaSets(new TreeSet<String>(), text, keyboard);
        keyboard.close();
    }

    /*
     * pre: set != null, text != null Method to add all words in text to the
     * given set. Words are delimited by white space. This version for CS314
     * sets.
     */
    private static void processTextCS314Sets(ISet<String> set, String text, Scanner keyboard) {
        Stopwatch s = new Stopwatch();
        Scanner sc = new Scanner(text);
        int totalWords = 0;
        s.start();
        while (sc.hasNext()) {
            totalWords++;
            set.add(sc.next());
        }
        s.stop();

        showResultsAndWords(set, s, totalWords, set.size(), keyboard);
    }

    /*
     * pre: set != null, text != null Method to add all words in text to the
     * given set. Words are delimited by white space. This version for Java
     * Sets.
     */
    private static void processTextJavaSets(Set<String> set, String text,
                                            Scanner keyboard) {
        Stopwatch s = new Stopwatch();
        Scanner sc = new Scanner(text);
        int totalWords = 0;
        s.start();
        while (sc.hasNext()) {
            totalWords++;
            set.add(sc.next());
        }
        s.stop();
        sc.close();

        showResultsAndWords(set, s, totalWords, set.size(), keyboard);
    }

    /*
     * Show results of add words to given set.
     */
    private static <E> void showResultsAndWords(Iterable<E> set, Stopwatch s, int totalWords,
                                                int setSize, Scanner keyboard) {

        System.out.println("Time to add the elements in the text to this set: " + s.toString());
        System.out.println("Total number of words in text including duplicates: " + totalWords);
        System.out.println("Number of distinct words in this text " + setSize);

        System.out.print("Enter y to see the contents of this set: ");
        String response = keyboard.next();

        if (response != null && response.length() > 0
                && response.substring(0, 1).equalsIgnoreCase("y")) {
            for (Object o : set) {
                System.out.println(o);
            }
        }
        System.out.println();
    }

    /*
     * Ask user to pick a file via a file choosing window and convert that file
     * to a String. Since we are evaluating the file with many sets convert to
     * string once instead of reading through file multiple times.
     */
    private static String convertFileToString() {
        // create a GUI window to pick the text to evaluate
        JFileChooser chooser = new JFileChooser(".");
        StringBuilder text = new StringBuilder();
        int retval = chooser.showOpenDialog(null);

        chooser.grabFocus();

        // read in the file
        if (retval == JFileChooser.APPROVE_OPTION) {
            File source = chooser.getSelectedFile();
            Scanner s = null;
            try {
                s = new Scanner(new FileReader(source));

                while (s.hasNextLine()) {
                    text.append(s.nextLine());
                    text.append(" ");
                }

                s.close();
            } catch (IOException e) {
                System.out.println("An error occured while trying to read from the file: " + e);
            } finally {
                if (s != null) {
                    s.close();
                }
            }
        }

        return text.toString();
    }
}