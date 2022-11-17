import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// CodeCamp.java - CS314 Assignment 1 - Tester class

/*
 * Student information for assignment:
 * Name: Aaroh Sharma
 * email address: aaroh.sh@gmail.com
 * UTEID: as225925
 * Section 5 digit ID: 52600
 * Grader name: Brad
 * Number of slip days used on this assignment: 0
 */

/*
 * Shared Birthdays Experiment:
 *
 * The average number number of pairs of people with shared birthdays given
 * 182 people and 365 days in a year is 45
 *
 * I believe it will take 25 people to have a 50% chance of having at least
 * one pair of people with a shared birthday.
 *
 * The experiment shows that the percentage of experiments with at least one
 * pair of birthdays first exceeds 50% at 23 people. This does not particularly
 * surprise me because I predicted the percentage to exceed 50% at 25 people,
 * which is close to the true value of 23 people.
 *
 * Table:
 * Num people: 2, number of experiments with one or more shared birthday: 139, percentage: 0.28
 * Num people: 3, number of experiments with one or more shared birthday: 403, percentage: 0.81
 * Num people: 4, number of experiments with one or more shared birthday: 833, percentage: 1.67
 * Num people: 5, number of experiments with one or more shared birthday: 1365, percentage: 2.73
 * Num people: 6, number of experiments with one or more shared birthday: 2000, percentage: 4.00
 * Num people: 7, number of experiments with one or more shared birthday: 2781, percentage: 5.56
 * Num people: 8, number of experiments with one or more shared birthday: 3778, percentage: 7.56
 * Num people: 9, number of experiments with one or more shared birthday: 4621, percentage: 9.24
 * Num people: 10, number of experiments with one or more shared birthday: 5799, percentage: 11.60
 * Num people: 11, number of experiments with one or more shared birthday: 7063, percentage: 14.13
 * Num people: 12, number of experiments with one or more shared birthday: 8390, percentage: 16.78
 * Num people: 13, number of experiments with one or more shared birthday: 9614, percentage: 19.23
 * Num people: 14, number of experiments with one or more shared birthday: 11175, percentage: 22.35
 * Num people: 15, number of experiments with one or more shared birthday: 12741, percentage: 25.48
 * Num people: 16, number of experiments with one or more shared birthday: 14116, percentage: 28.23
 * Num people: 17, number of experiments with one or more shared birthday: 15572, percentage: 31.14
 * Num people: 18, number of experiments with one or more shared birthday: 17307, percentage: 34.61
 * Num people: 19, number of experiments with one or more shared birthday: 18933, percentage: 37.87
 * Num people: 20, number of experiments with one or more shared birthday: 20613, percentage: 41.23
 * Num people: 21, number of experiments with one or more shared birthday: 22128, percentage: 44.26
 * Num people: 22, number of experiments with one or more shared birthday: 23876, percentage: 47.75
 * Num people: 23, number of experiments with one or more shared birthday: 25271, percentage: 50.54
 * Num people: 24, number of experiments with one or more shared birthday: 27071, percentage: 54.14
 * Num people: 25, number of experiments with one or more shared birthday: 28389, percentage: 56.78
 * Num people: 26, number of experiments with one or more shared birthday: 29988, percentage: 59.98
 * Num people: 27, number of experiments with one or more shared birthday: 31477, percentage: 62.95
 * Num people: 28, number of experiments with one or more shared birthday: 32595, percentage: 65.19
 * Num people: 29, number of experiments with one or more shared birthday: 34080, percentage: 68.16
 * Num people: 30, number of experiments with one or more shared birthday: 35270, percentage: 70.54
 * Num people: 31, number of experiments with one or more shared birthday: 36613, percentage: 73.23
 * Num people: 32, number of experiments with one or more shared birthday: 37710, percentage: 75.42
 * Num people: 33, number of experiments with one or more shared birthday: 38691, percentage: 77.38
 * Num people: 34, number of experiments with one or more shared birthday: 39703, percentage: 79.41
 * Num people: 35, number of experiments with one or more shared birthday: 40605, percentage: 81.21
 * Num people: 36, number of experiments with one or more shared birthday: 41493, percentage: 82.99
 * Num people: 37, number of experiments with one or more shared birthday: 42344, percentage: 84.69
 * Num people: 38, number of experiments with one or more shared birthday: 43175, percentage: 86.35
 * Num people: 39, number of experiments with one or more shared birthday: 43915, percentage: 87.83
 * Num people: 40, number of experiments with one or more shared birthday: 44523, percentage: 89.05
 * Num people: 41, number of experiments with one or more shared birthday: 45194, percentage: 90.39
 * Num people: 42, number of experiments with one or more shared birthday: 45744, percentage: 91.49
 * Num people: 43, number of experiments with one or more shared birthday: 46256, percentage: 92.51
 * Num people: 44, number of experiments with one or more shared birthday: 46608, percentage: 93.22
 * Num people: 45, number of experiments with one or more shared birthday: 47105, percentage: 94.21
 * Num people: 46, number of experiments with one or more shared birthday: 47315, percentage: 94.63
 * Num people: 47, number of experiments with one or more shared birthday: 47811, percentage: 95.62
 * Num people: 48, number of experiments with one or more shared birthday: 47994, percentage: 95.99
 * Num people: 49, number of experiments with one or more shared birthday: 48300, percentage: 96.60
 * Num people: 50, number of experiments with one or more shared birthday: 48448, percentage: 96.90
 * Num people: 51, number of experiments with one or more shared birthday: 48696, percentage: 97.39
 * Num people: 52, number of experiments with one or more shared birthday: 48885, percentage: 97.77
 * Num people: 53, number of experiments with one or more shared birthday: 49052, percentage: 98.10
 * Num people: 54, number of experiments with one or more shared birthday: 49239, percentage: 98.48
 * Num people: 55, number of experiments with one or more shared birthday: 49293, percentage: 98.59
 * Num people: 56, number of experiments with one or more shared birthday: 49408, percentage: 98.82
 * Num people: 57, number of experiments with one or more shared birthday: 49499, percentage: 99.00
 * Num people: 58, number of experiments with one or more shared birthday: 49620, percentage: 99.24
 * Num people: 59, number of experiments with one or more shared birthday: 49650, percentage: 99.30
 * Num people: 60, number of experiments with one or more shared birthday: 49679, percentage: 99.36
 * Num people: 61, number of experiments with one or more shared birthday: 49763, percentage: 99.53
 * Num people: 62, number of experiments with one or more shared birthday: 49804, percentage: 99.61
 * Num people: 63, number of experiments with one or more shared birthday: 49830, percentage: 99.66
 * Num people: 64, number of experiments with one or more shared birthday: 49855, percentage: 99.71
 * Num people: 65, number of experiments with one or more shared birthday: 49889, percentage: 99.78
 * Num people: 66, number of experiments with one or more shared birthday: 49903, percentage: 99.81
 * Num people: 67, number of experiments with one or more shared birthday: 49926, percentage: 99.85
 * Num people: 68, number of experiments with one or more shared birthday: 49933, percentage: 99.87
 * Num people: 69, number of experiments with one or more shared birthday: 49953, percentage: 99.91
 * Num people: 70, number of experiments with one or more shared birthday: 49957, percentage: 99.91
 * Num people: 71, number of experiments with one or more shared birthday: 49971, percentage: 99.94
 * Num people: 72, number of experiments with one or more shared birthday: 49971, percentage: 99.94
 * Num people: 73, number of experiments with one or more shared birthday: 49977, percentage: 99.95
 * Num people: 74, number of experiments with one or more shared birthday: 49985, percentage: 99.97
 * Num people: 75, number of experiments with one or more shared birthday: 49987, percentage: 99.97
 * Num people: 76, number of experiments with one or more shared birthday: 49994, percentage: 99.99
 * Num people: 77, number of experiments with one or more shared birthday: 49995, percentage: 99.99
 * Num people: 78, number of experiments with one or more shared birthday: 49994, percentage: 99.99
 * Num people: 79, number of experiments with one or more shared birthday: 49999, percentage: 100.00
 * Num people: 80, number of experiments with one or more shared birthday: 49993, percentage: 99.99
 * Num people: 81, number of experiments with one or more shared birthday: 49998, percentage: 100.00
 * Num people: 82, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 83, number of experiments with one or more shared birthday: 49999, percentage: 100.00
 * Num people: 84, number of experiments with one or more shared birthday: 49999, percentage: 100.00
 * Num people: 85, number of experiments with one or more shared birthday: 49999, percentage: 100.00
 * Num people: 86, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 87, number of experiments with one or more shared birthday: 49999, percentage: 100.00
 * Num people: 88, number of experiments with one or more shared birthday: 49999, percentage: 100.00
 * Num people: 89, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 90, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 91, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 92, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 93, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 94, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 95, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 96, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 97, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 98, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 99, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 * Num people: 100, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 */

public class CodeCampTester {

    public static void main(String[] args) {
        final String newline = System.getProperty("line.separator");

        // test 1, hamming distance
        int[] h1 = {4, 10, 9, 8, 7, 6, 4, 3, 2, 110};
        int[] h2 = {4, 10, 1, 8, 210, 6, 4, 3, 25, 110};
        int expected = 3;
        int actual = CodeCamp.hammingDistance(h1, h2);
        System.out.println("Test 1 hamming distance: expected value: " + expected
                + ", actual value: " + actual);
        if (expected == actual) {
            System.out.println(" passed test 1, hamming distance");
        } else {
            System.out.println(" ***** FAILED ***** test 1, hamming distance");
        }

        // test 2, hamming distance
        h1 = new int[] {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        h2 = new int[] {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6};
        expected = 12;
        actual = CodeCamp.hammingDistance(h1, h2);
        System.out.println(newline + "Test 2 hamming distance: expected value: " + expected
                + ", actual value: " + actual);
        if (expected == actual) {
            System.out.println("passed test 2, hamming distance");
        } else {
            System.out.println("***** FAILED ***** test 2, hamming distance");
        }

        // test 3, isPermutation
        int[] a = {4, 7, 21, 6, 3};
        int[] b = {3, 7, 6, 22, 4};
        boolean expectedBool = false;
        boolean actualBool = CodeCamp.isPermutation(a, b);
        System.out.println(newline + "Test 3 isPermutation: expected value: " + expectedBool
                + ", actual value: " + actualBool);
        if (expectedBool == actualBool) {
            System.out.println("passed test 3, isPermutation");
        } else {
            System.out.println("***** FAILED ***** test 3, isPermutation");
        }

        // test 4, is Permutation
        a = new int[] {210_001, 41, 672, 9876, 100_000_000, 3, 768, 9010};
        b = new int[] {9876, 768, 41, 210_001, 672, 100_000_000, 9010, 3};
        expectedBool = true;
        actualBool = CodeCamp.isPermutation(a, b);
        System.out.println(newline + "Test 4 isPermutation: expected value: " + expectedBool
                + ", actual value: " + actualBool);
        if (expectedBool == actualBool) {
            System.out.println("passed test 4, isPermutation");
        } else {
            System.out.println("***** FAILED ***** test 4, isPermutation");
        }

        // test 5, mostVowels
        String[] arrayOfStrings = {"oiedjf", "banana", "guisipo", "cursed", "aeiouaeiou"};
        int expectedResult = 4;
        int actualResult = CodeCamp.mostVowels(arrayOfStrings);
        System.out.println(newline + "Test 5 mostVowels: expected result: " + expectedResult
                + ", actual result: " + actualResult);
        if (actualResult == expectedResult) {
            System.out.println("passed test 5, mostVowels");
        } else {
            System.out.println("***** FAILED ***** test 5, mostVowels");
        }

        // test 6, mostVowels
        arrayOfStrings = new String[] {null, null, "a", null, "qwrtypsdfghjklzxcvbnm",
                "e", "i", null, null, "o", "@#$(&@(#*&@#@#(&$*@#(*&io"};
        expectedResult = 10;
        actualResult = CodeCamp.mostVowels(arrayOfStrings);
        System.out.println(newline + "Test 6 mostVowels: expected result: " + expectedResult
                + ", actual result: " + actualResult);
        if (actualResult == expectedResult) {
            System.out.println("passed test 6, mostVowels");
        } else {
            System.out.println("***** FAILED ***** test 6, mostVowels");
        }

        // test 7, sharedBirthdays
        int pairs = CodeCamp.sharedBirthdays(731, 365);
        System.out.println(newline + "Test 7 shared birthdays: expected: " +
                "a value of at least 3, actual: " + pairs);
        if (pairs > 2) {
            System.out.println("passed test 7, shared birthdays");
        } else {
            System.out.println("***** FAILED ***** test 7, shared birthdays");
        }

        // test 8, sharedBirthdays
        pairs = CodeCamp.sharedBirthdays(10_000, 10);
        System.out.println(newline + "Test 8 shared birthdays: expected: "
                + "a value of 1 or more, actual: " + pairs);
        if (pairs > 0) {
            System.out.println("passed test 8, shared birthdays");
        } else {
            System.out.println("***** FAILED ***** test 8, shared birthdays");
        }

        // test 9, queensAreASafe
        char[][] board = { { 'q', 'q', 'q' },
                { 'q', 'q', 'q' },
                { 'q', 'q', 'q' } };

        expectedBool = false;
        actualBool = CodeCamp.queensAreSafe(board);
        System.out.println(newline + "Test 9 queensAreSafe: expected value: " + expectedBool
                + ", actual value: " + actualBool);
        if (expectedBool == actualBool) {
            System.out.println("passed test 9, queensAreSafe");
        } else {
            System.out.println("***** FAILED ***** test 9, queensAreSafe");
        }

        // test 10, queensAreASafe
        board = new char[][] { { '.', 'q', '.', '.' },
                { '.', '.', '.', '.' },
                { '.', '.', 'q', '.' },
                { 'q', '.', '.', '.' } };
        expectedBool = true;
        actualBool = CodeCamp.queensAreSafe(board);
        System.out.println(newline + "Test 10 queensAreSafe: expected value: " + expectedBool
                + ", actual value: " + actualBool);
        if (expectedBool == actualBool) {
            System.out.println("passed test 10, queensAreSafe");
        } else {
            System.out.println("***** FAILED ***** test 10, queensAreSafe");
        }

        // test 11, getValueOfMostValuablePlot
        int[][] city = { {-123, -473894, -9},
                {9, 2, 7},
                {-3, -91, 3}};

        expected = 18;
        actual = CodeCamp.getValueOfMostValuablePlot(city);
        System.out.println(newline + "Test 11 getValueOfMostValuablePlot: expected value: "
                + expected + ", actual value: " + actual);
        if (expected == actual) {
            System.out.println("passed test 11, getValueOfMostValuablePlot");
        } else {
            System.out.println("***** FAILED ***** test 11, getValueOfMostValuablePlot");
        }

        // test 12, getValueOfMostValuablePlot
        city = new int[][] {{0, 1, 2, 3, 4, 5, 6, 7, 8},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {100, 200, 300, 400, 500, 600, 700, 800, 900},
                {9, 7, 5, 3, 1, 2, 4, 6, 8},
                {-1, 0, 0, 0, 0, 2, 17, 9, 0},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1},
                {1000, 2000, 3, 4, 5, 6, 7, 8, 9}};
        expected = 7623;
        actual = CodeCamp.getValueOfMostValuablePlot(city);
        System.out.println(newline + "Test 12 getValueOfMostValuablePlot: expected value: "
                + expected + ", actual value: " + actual);
        if (expected == actual) {
            System.out.println("passed test 12, getValueOfMostValuablePlot");
        } else {
            System.out.println("***** FAILED ***** test 12, getValueOfMostValuablePlot");
        }

    } // end of main method

    // pre: list != null
    private static int[] intListToArray(List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("list parameter may not be null.");
        }
        int[] result = new int[list.size()];
        int arrayIndex = 0;
        for (int x : list) {
            result[arrayIndex++] = x;
        }
        return result;
    }
}