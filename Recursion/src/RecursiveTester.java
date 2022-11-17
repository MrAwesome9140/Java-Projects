/*  Student information for assignment:
 *
 *  On MY honor, Aaroh Sharma, this programming assignment is MY
 own work
 *  and I have not provided this code to any other student.
 *
 *  Number of slip days used: 0
 *
 *  Student 1 (Student whose Canvas account is being used)
 *  UTEID: as225925
 *  email address: aaroh.sh@gmail.com
 *  Grader name: Brad
 *  Section number: 52600
 */

/**
 * Tester class for the methods in Recursive.java
 * @author scottm
 *
 */
public class RecursiveTester {

    // run the tests
    public static void main(String[] args) {
        studentTests();
    }

    // pre: r != null
    // post: run student test
    private static void studentTests() {
        // CS314 students put your tests here

        String[] testMethods = new String[] {"getBinary()", "revString()",
                "nextIsDouble()", "listMnemonics()", "canFlowOffMap()",
                "minDifference()", "canEscapeMaze()"};

        // Test 1 and 2, getBinary()
        int test = 1;
        int curMethodInd = 0;
        int testNum = 128;
        String expected = "10000000";
        String actual = Recursive.getBinary(testNum);
        System.out.print("test " + test + ", " + testMethods[curMethodInd] +
                ": expected = " + expected + ", actual = " + actual + ": ");
        if (expected.equals(actual)) {
            System.out.println("passed test");
        } else {
            System.out.println("failed test");
        }

        test++;
        testNum = 127;
        expected = "1111111";
        actual = Recursive.getBinary(testNum);
        System.out.print("test " + test + ", " + testMethods[curMethodInd] +
                ": expected = " + expected + ", actual = " + actual + ": ");
        if (expected.equals(actual)) {
            System.out.println("passed test");
        } else {
            System.out.println("failed test");
        }

        System.out.println();

        // Test 3 and 4, revString()
        test++;
        curMethodInd = (test - 1) / 2;
        String testString = "The Weeknd";
        expected = "dnkeeW ehT";
        actual = Recursive.revString(testString);
        System.out.print("test " + test + ", " + testMethods[curMethodInd] +
                ": expected = " + expected + ", actual = " + actual + ": ");
        if (expected.equals(actual)) {
            System.out.println("passed test");
        } else {
            System.out.println("failed test");
        }

        test++;
        curMethodInd = (test - 1) / 2;
        testString = "House of Balloons / Glass Table Girls";
        expected = "slriG elbaT ssalG / snoollaB fo esuoH";
        actual = Recursive.revString(testString);
        System.out.print("test " + test + ", " + testMethods[curMethodInd] +
                ": expected = " + expected + ", actual = " + actual + ": ");
        if (expected.equals(actual)) {
            System.out.println("passed test");
        } else {
            System.out.println("failed test");
        }

        System.out.println();

        // Test 5 and 6, nextIsDouble()
        test++;
        curMethodInd = (test - 1) / 2;
        int[] testArray = new int[] {16, 8, 4, 2, 1};
        int expectNum = 0;
        int actualNum = Recursive.nextIsDouble(testArray);
        System.out.print("test " + test + ", " + testMethods[curMethodInd] +
                ": expected = " + expectNum + ", actual = " + actualNum + ": ");
        if (expectNum == actualNum) {
            System.out.println("passed test");
        } else {
            System.out.println("failed test");
        }

        test++;
        curMethodInd = (test - 1) / 2;
        testArray = new int[] {12, 24, 22, 44, 45, 46, 92, 1, 2};
        expectNum = 4;
        actualNum = Recursive.nextIsDouble(testArray);
        System.out.print("test " + test + ", " + testMethods[curMethodInd] +
                ": expected = " + expectNum + ", actual = " + actualNum + ": ");
        if (expectNum == actualNum) {
            System.out.println("passed test");
        } else {
            System.out.println("failed test");
        }

        System.out.println();

        // Test 7 and 8, listMnemonics()
        test++;
        curMethodInd = (test - 1) / 2;
        testString = "398";
        expected = "[DWT, DWU, DWV, DXT, DXU, DXV, DYT, DYU, DYV, DZT, DZU, DZV, EWT, EWU, EWV, EXT, EXU, EXV, EYT, EYU, EYV, EZT, EZU, EZV, FWT, FWU, FWV, FXT, FXU, FXV, FYT, FYU, FYV, FZT, FZU, FZV]";
        actual = String.valueOf(Recursive.listMnemonics(testString));
        System.out.print("test " + test + ", " + testMethods[curMethodInd] +
                ": expected = " + expected + ", actual = " + actual + ": ");
        if (expected.equals(actual)) {
            System.out.println("passed test");
        } else {
            System.out.println("failed test");
        }

        test++;
        curMethodInd = (test - 1) / 2;
        testString = "27";
        expected = "[AP, AQ, AR, AS, BP, BQ, BR, BS, CP, CQ, CR, CS]";
        actual = String.valueOf(Recursive.listMnemonics(testString));
        System.out.print("test " + test + ", " + testMethods[curMethodInd] +
                ": expected = " + expected + ", actual = " + actual + ": ");
        if (expected.equals(actual)) {
            System.out.println("passed test");
        } else {
            System.out.println("failed test");
        }

        System.out.println();

        // Test 9 and 10, canFlowOffFlap
        test++;
        curMethodInd = (test - 1) / 2;
        int startRow = 1;
        int startCol = 2;
        int[][] testMap = new int[][] {
                {10, 10, 10, 10},
                {10, 10, 9, 10},
                {10, 8, 7, 10},
                {10, 2, 3, 4},
                {10, 1, 11, 4}};
        boolean expectBool = true;
        boolean actualBool = Recursive.canFlowOffMap(testMap, startRow,
                startCol);
        System.out.print("test " + test + ", " + testMethods[curMethodInd] +
                ": expected = " + expectBool + ", actual = " + actualBool + ": ");
        if (expectBool == actualBool) {
            System.out.println("passed test");
        } else {
            System.out.println("failed test");
        }

        test++;
        curMethodInd = (test - 1) / 2;
        startRow = 2;
        startCol = 2;
        testMap = new int[][] {
                {10, 10, 10, 10, 10},
                {10, 5, 5, 5, 10},
                {10, 5, 6, 5, 10},
                {10, 5, 5, 5, 10},
                {10, 10, 10, 10, 10}};
        expectBool = false;
        actualBool = Recursive.canFlowOffMap(testMap, startRow,
                startCol);
        System.out.print("test " + test + ", " + testMethods[curMethodInd] +
                ": expected = " + expectBool + ", actual = " + actualBool + ": ");
        if (expectBool == actualBool) {
            System.out.println("passed test");
        } else {
            System.out.println("failed test");
        }

        System.out.println();

        // test 11 and 12, minDifference()
        test++;
        curMethodInd = (test - 1) / 2;
        testArray = new int[] {1, 2, 3, 4, 5, 6};
        testNum = 3;
        expectNum = 0;
        actualNum = Recursive.minDifference(testNum, testArray);
        System.out.print("test " + test + ", " + testMethods[curMethodInd] +
                ": expected = " + expectNum + ", actual = " + actualNum + ": ");
        if (expectNum == actualNum) {
            System.out.println("passed test");
        } else {
            System.out.println("failed test");
        }

        test++;
        curMethodInd = (test - 1) / 2;
        testArray = new int[] {19, 2, 23, 4, 35, 6, 10, 11, 14};
        testNum = 6;
        expectNum = 20;
        actualNum = Recursive.minDifference(testNum, testArray);
        System.out.print("test " + test + ", " + testMethods[curMethodInd] +
                ": expected = " + expectNum + ", actual = " + actualNum + ": ");
        if (expectNum == actualNum) {
            System.out.println("passed test");
        } else {
            System.out.println("failed test");
        }

        System.out.println();

        // test 13 and 14, canEscapeMaze()
        test++;
        curMethodInd = (test - 1) / 2;
        char[][] testMaze = new char[][] {
                {'S', '$', 'Y'},
                {'$', '*', '$'},
                {'E', 'G', 'Y'}};
        expectNum = 2;
        actualNum = Recursive.canEscapeMaze(testMaze);
        System.out.print("test " + test + ", " + testMethods[curMethodInd] +
                ": expected = " + expectNum + ", actual = " + actualNum + ": ");
        if (expectNum == actualNum) {
            System.out.println("passed test");
        } else {
            System.out.println("failed test");
        }

        test++;
        curMethodInd = (test - 1) / 2;
        testMaze = new char[][] {
                {'S', '$', 'Y'},
                {'$', '*', '*'},
                {'E', 'G', '$'}};
        expectNum = 1;
        actualNum = Recursive.canEscapeMaze(testMaze);
        System.out.print("test " + test + ", " + testMethods[curMethodInd] +
                ": expected = " + expectNum + ", actual = " + actualNum + ": ");
        if (expectNum == actualNum) {
            System.out.println("passed test");
        } else {
            System.out.println("failed test");
        }

    }

}