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

/* Experiment results. CS314 students, place your experiment
 *  results here:
 *
 * Adding to the end: LinkedList is faster than ArrayList
 * Adding to the front: LinkedList is much faster than ArrayList
 * Removing from front: LinkedList is much faster than ArrayList
 * Getting random element: ArrayList is much faster than LinkedList
 * Getting all using iterator: ArrayList is faster than LinkedList
 * Getting all using get method: ArrayList is much faster than LinkedList
 *
 * Big Os:
 * Adding to the end - The timing data suggests this operation is O(1)
 * because the total time roughly doubles as the amount of elements being
 * added doubles
 *
 * Adding to the front - This operation also looks to be O(1) based on the
 * timing data because the total time roughly doubles as the amount of
 * elements being added to the front doubles
 *
 * Removing from the front - This operation is also O(1) based on the timing
 * data as the total time roughly doubles as the amount of elements being
 * removed from the front doubles
 *
 * Getting random - This operation looks to be O(N) based on the timing data
 * as the time quadruples every time we double the size of the LinkedList and
 * double the amount of elements we are retrieving
 *
 * Getting all using iterator - This operation is O(N) based on the timing
 * data as doubling the amount of elements being retrieved roughly doubles
 * the time taken
 *
 * Getting all using get method - This operation is O(N^2) based on the
 * timing data as doubling the amount of data being retrieved roughly
 * quadruples the the time taken
 */


import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.util.HashSet;

public class LinkedListTester {

    public static void main(String[] args) {

        //CS314 students. Add your tests here:

        LinkedList<String> list = new LinkedList<>();

        // test 1 - 3, add()
        System.out.println("\nTest 1: Adding");
        list.add("B");
        list.add("K");
        Object[] actual = toArray(list);
        Object[] expected = new Object[] {"B", "K"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 1");
        } else {
            System.out.println("Failed test 1");
        }

        System.out.println("\nTest 2: Adding");
        list.makeEmpty();
        list.add("/$#(&%($*%&(");
        actual = toArray(list);
        expected = new Object[] {"/$#(&%($*%&("};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 2");
        } else {
            System.out.println("Failed test 2");
        }

        System.out.println("\nTest 3: Adding");
        list.add("");
        actual = toArray(list);
        expected = new Object[] {"/$#(&%($*%&(", ""};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 3");
        } else {
            System.out.println("Failed test 3");
        }

        // test 4 - 6, makeEmpty()
        System.out.println("\nTest 4: making empty");
        list.makeEmpty();
        actual = toArray(list);
        expected = new Object[] {};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 4");
        } else {
            System.out.println("Failed test 4");
        }

        System.out.println("\nTest 5: making empty");
        list.addLast("POPPY");
        list.addFirst("HOW");
        list.makeEmpty();
        actual = toArray(list);
        expected = new Object[] {};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 5");
        } else {
            System.out.println("Failed test 5");
        }

        System.out.println("\nTest 6: making empty");
        list.insert(0, "poppin");
        list.insert(0, "test");
        list.makeEmpty();
        actual = toArray(list);
        expected = new Object[] {};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 6");
        } else {
            System.out.println("Failed test 6");
        }


        // test 7 - 9, insert()
        System.out.println("\nTest 7: Inserting at pos 3 in a list");
        list.add("2");
        list.add("R");
        list.add("OP");
        list.add("core");
        list.insert(2, "A");
        actual = toArray(list);
        expected = new Object[] {"2", "R", "A", "OP", "core"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 7");
        } else {
            System.out.println("Failed test 7");
        }

        System.out.println("\nTest 8: Inserting at front of a list");
        list.makeEmpty();
        list.insert(0, "QWERTY");
        actual = toArray(list);
        expected = new Object[] {"QWERTY"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 8");
        } else {
            System.out.println("Failed test 8");
        }

        System.out.println("\nTest 9: Inserting at end of a list");
        list.add("The Weeknd is the GOAT");
        list.insert(2, "IT'S LIT");
        actual = toArray(list);
        expected = new Object[] {"QWERTY", "The Weeknd is the GOAT", "IT'S " +
                "LIT"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 9");
        } else {
            System.out.println("Failed test 9");
        }


        //test 10 - 12, addFirst()
        System.out.println("\nTest 10: Adding at front");
        list.makeEmpty();
        list.addFirst("Aaroh");
        actual = toArray(list);
        expected = new Object[] {"Aaroh"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 10");
        } else {
            System.out.println("Failed test 10");
        }

        System.out.println("\nTest 11: Adding at front");
        list.addFirst("Bob");
        actual = toArray(list);
        expected = new Object[] {"Bob", "Aaroh"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 11");
        } else {
            System.out.println("Failed test 11");
        }

        System.out.println("\nTest 12: Adding at front");
        list.addFirst("3498");
        actual = toArray(list);
        expected = new Object[] {"3498", "Bob", "Aaroh"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 12");
        } else {
            System.out.println("Failed test 12");
        }

        // test 13 - 15, removeFirst()
        System.out.println("\nTest 13: Removing from front");
        list.removeFirst();
        actual = toArray(list);
        expected = new Object[] {"Bob", "Aaroh"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 13");
        } else {
            System.out.println("Failed test 13");
        }

        System.out.println("\nTest 14: Removing from front");
        list.removeFirst();
        actual = toArray(list);
        expected = new Object[] {"Aaroh"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 14");
        } else {
            System.out.println("Failed test 14");
        }

        System.out.println("\nTest 15: Removing from front");
        list.removeFirst();
        actual = toArray(list);
        expected = new Object[] {};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 15");
        } else {
            System.out.println("Failed test 15");
        }


        // test 16 - 18, addLast()
        System.out.println("\nTest 16: Adding at end");
        list.addLast("P");
        actual = toArray(list);
        expected = new Object[] {"P"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 16");
        } else {
            System.out.println("Failed test 16");
        }

        System.out.println("\nTest 17: Adding at end");
        list.addLast("PORT");
        actual = toArray(list);
        expected = new Object[] {"P", "PORT"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 17");
        } else {
            System.out.println("Failed test 17");
        }

        System.out.println("\nTest 18: Adding at end");
        list.addLast("corn");
        actual = toArray(list);
        expected = new Object[] {"P", "PORT", "corn"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 18");
        } else {
            System.out.println("Failed test 18");
        }

        // test 19 - 21, removeLast()
        System.out.println("\nTest 19: Removing from back");
        list.removeLast();
        actual = toArray(list);
        expected = new Object[] {"P", "PORT"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 19");
        } else {
            System.out.println("Failed test 19");
        }

        System.out.println("\nTest 20: Removing from back");
        list.removeLast();
        actual = toArray(list);
        expected = new Object[] {"P"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 20");
        } else {
            System.out.println("Failed test 20");
        }

        System.out.println("\nTest 21: Removing from back");
        list.removeLast();
        actual = toArray(list);
        expected = new Object[] {};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 21");
        } else {
            System.out.println("Failed test 21");
        }


        // test 22 - 24, set()
        System.out.println("\nTest 22: Setting");
        list.add("23094");
        list.add("????");
        list.add("#$*(R");
        String oldValue = list.set(1, "!!!!");
        actual = toArray(list);
        expected = new Object[] {"23094", "!!!!", "#$*(R"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected) ) {
            System.out.println("Passed test 22.1");
        } else {
            System.out.println("Failed test 22.1");
        }
        if (oldValue.equals("????")) {
            System.out.println("Passed test 22.2");
        } else {
            System.out.println("Failed test 22.2");
        }

        System.out.println("\nTest 23: Setting");
        oldValue = list.set(0, "1");
        actual = toArray(list);
        expected = new Object[] {"1", "!!!!", "#$*(R"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected) ) {
            System.out.println("Passed test 23.1");
        } else {
            System.out.println("Failed test 23.1");
        }
        if (oldValue.equals("23094")) {
            System.out.println("Passed test 23.2");
        } else {
            System.out.println("Failed test 23.2");
        }

        System.out.println("\nTest 24: Setting");
        oldValue = list.set(2, "@");
        actual = toArray(list);
        expected = new Object[] {"1", "!!!!", "@"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected) ) {
            System.out.println("Passed test 24.1");
        } else {
            System.out.println("Failed test 24.1");
        }
        if (oldValue.equals("#$*(R")) {
            System.out.println("Passed test 24.2");
        } else {
            System.out.println("Failed test 24.2");
        }

        // test 25 - 27, remove(int pos)
        System.out.println("\nTest 25: Removing based on position");
        list.makeEmpty();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.remove(3);
        actual = toArray(list);
        expected = new Object[] {"1", "2", "3"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 25");
        } else {
            System.out.println("Failed test 25");
        }

        System.out.println("\nTest 26: Removing based on position");
        list.remove(0);
        actual = toArray(list);
        expected = new Object[] {"2", "3"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 26");
        } else {
            System.out.println("Failed test 26");
        }

        System.out.println("\nTest 27: Removing based on position");
        list.remove(1);
        actual = toArray(list);
        expected = new Object[] {"2"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 27");
        } else {
            System.out.println("Failed test 27");
        }

        // test 28 - 30, equals()
        System.out.println("\nTest 28: Equality of LinkedLists");
        LinkedList<String> test = new LinkedList<>();
        test.add("2");
        boolean act = test.equals(list);
        boolean exp = true;
        System.out.println("Expected result: " + exp);
        System.out.println("Actual result: " + act);
        if (act == exp) {
            System.out.println("Passed test 28");
        } else {
            System.out.println("Failed test 28");
        }

        System.out.println("\nTest 29: Equality of LinkedLists");
        test = new LinkedList<>();
        act = test.equals(list);
        exp = false;
        System.out.println("Expected result: " + exp);
        System.out.println("Actual result: " + act);
        if (act == exp) {
            System.out.println("Passed test 29");
        } else {
            System.out.println("Failed test 29");
        }

        System.out.println("\nTest 30: Equality of LinkedLists");
        list.makeEmpty();
        act = test.equals(list);
        exp = true;
        System.out.println("Expected result: " + exp);
        System.out.println("Actual result: " + act);
        if (act == exp) {
            System.out.println("Passed test 30");
        } else {
            System.out.println("Failed test 30");
        }

        // test 31 - 33, get()
        System.out.println("\nTest 31: Get element");
        list.makeEmpty();
        list.add("1");
        list.add("2");
        String actua = list.get(0);
        String expect = "1";
        System.out.println("Expected result: " + expect);
        System.out.println("Actual result: " + actua);
        if (actua.equals(expect)) {
            System.out.println("Passed test 31");
        } else {
            System.out.println("Failed test 31");
        }

        System.out.println("\nTest 32: Get element");
        list.addLast("90210");
        actua = list.get(2);
        expect = "90210";
        System.out.println("Expected result: " + expect);
        System.out.println("Actual result: " + actua);
        if (actua.equals(expect)) {
            System.out.println("Passed test 32");
        } else {
            System.out.println("Failed test 32");
        }

        System.out.println("\nTest 33: Get element");
        list.insert(1, "");
        actua = list.get(1);
        expect = "";
        System.out.println("Expected result: " + expect);
        System.out.println("Actual result: " + actua);
        if (actua.equals(expect)) {
            System.out.println("Passed test 33");
        } else {
            System.out.println("Failed test 3");
        }

        // test 34 - 36, getSublist()
        System.out.println("\nTest 34: Retrieving sublist of a LinkedList");
        list.makeEmpty();
        list.add("Often");
        list.add("Wicked Games");
        list.add("D.D");
        actual = toArray2(list.getSubList(0, 2));
        expected = new Object[] {"Often", "Wicked Games"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 34");
        } else {
            System.out.println("Failed test 34");
        }

        System.out.println("\nTest 35: Retrieving sublist of a LinkedList");
        list.makeEmpty();
        list.add("Often");
        list.add("Wicked Games");
        list.add("D.D");
        actual = toArray2(list.getSubList(3, 3));
        expected = new Object[] {};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 35");
        } else {
            System.out.println("Failed test 35");
        }

        System.out.println("\nTest 36: Retrieving sublist of a LinkedList");
        list.makeEmpty();
        list.add("Often");
        list.add("Wicked Games");
        list.add("D.D");
        actual = toArray2(list.getSubList(0, 3));
        expected = new Object[] {"Often", "Wicked Games", "D.D"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 36");
        } else {
            System.out.println("Failed test 36");
        }

        // test 37 - 39, indexOf(E item)
        System.out.println("\nTest 37: Index of an element");
        list.makeEmpty();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        int indActual = list.indexOf("3");
        int indExpected = 2;
        System.out.println("Expected result: " + indExpected);
        System.out.println("Actual result: " + indActual);
        if (indExpected == indActual) {
            System.out.println("Passed test 37");
        } else {
            System.out.println("Failed test 37");
        }

        System.out.println("\nTest 38: First index of an element");
        indActual = list.indexOf("5");
        indExpected = -1;
        System.out.println("Expected result: " + indExpected);
        System.out.println("Actual result: " + indActual);
        if (indExpected == indActual) {
            System.out.println("Passed test 38");
        } else {
            System.out.println("Failed test 38");
        }

        System.out.println("\nTest 39: Index of an element");
        indActual = list.indexOf("1");
        indExpected = 0;
        System.out.println("Expected result: " + indExpected);
        System.out.println("Actual result: " + indActual);
        if (indExpected == indActual) {
            System.out.println("Passed test 39");
        } else {
            System.out.println("Failed test 39");
        }

        // test 40 - 42, indexOf(E item, int pos)
        System.out.println("\nTest 40: First index of an element past a " +
                "position");
        list.makeEmpty();
        list.add("4");
        list.add("2");
        list.add("3");
        list.add("4");
        indActual = list.indexOf("4", 1);
        indExpected = 3;
        System.out.println("Expected result: " + indExpected);
        System.out.println("Actual result: " + indActual);
        if (indExpected == indActual) {
            System.out.println("Passed test 40");
        } else {
            System.out.println("Failed test 40");
        }

        System.out.println("\nTest 41: First index of an element past a " +
                "position");
        list.makeEmpty();
        list.add("Gone");
        list.add("House of Balloons");
        list.add("XO/The Host");
        list.add("Thursday");
        indActual = list.indexOf("Gone", 1);
        indExpected = -1;
        System.out.println("Expected result: " + indExpected);
        System.out.println("Actual result: " + indActual);
        if (indExpected == indActual) {
            System.out.println("Passed test 41");
        } else {
            System.out.println("Failed test 41");
        }

        System.out.println("\nTest 42: First index of an element past a " +
                "position");
        list.makeEmpty();
        list.add("Gone");
        list.add("House of Balloons");
        list.add("XO/The Host");
        list.add("XO/The Host");
        indActual = list.indexOf("Gone", 2);
        indExpected = 2;
        System.out.println("Expected result: " + indExpected);
        System.out.println("Actual result: " + indActual);
        if (indExpected == indActual) {
            System.out.println("Passed test 42");
        } else {
            System.out.println("Failed test 42");
        }

        // test 43 - 45, remove(E obj)
        System.out.println("\nTest 43: Remove element if present");
        list.makeEmpty();
        list.add("After Hours");
        list.add("Alone Again");
        list.add("Snowchild");
        list.add("Faith");
        act = list.remove("Faith");
        exp = true;
        actual = toArray(list);
        expected = new Object[] {"After Hours", "Alone Again", "Snowchild"};
        System.out.println("Expected result: " + Arrays.toString(actual));
        System.out.println("Actual result: " + Arrays.toString(expected));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 43.1");
        } else {
            System.out.println("Failed test 43.1");
        }
        if (act == exp) {
            System.out.println("Passed test 43.2");
        } else {
            System.out.println("Failed test 43.2");
        }

        System.out.println("\nTest 44: Remove element if present");
        act = list.remove("Faith");
        exp = false;
        actual = toArray(list);
        expected = new Object[] {"After Hours", "Alone Again", "Snowchild"};
        System.out.println("Expected result: " + Arrays.toString(actual));
        System.out.println("Actual result: " + Arrays.toString(expected));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 44.1");
        } else {
            System.out.println("Failed test 44.1");
        }
        if (act == exp) {
            System.out.println("Passed test 44.2");
        } else {
            System.out.println("Failed test 44.2");
        }

        System.out.println("\nTest 45: Remove element if present");
        act = list.remove("After Hours");
        exp = true;
        actual = toArray(list);
        expected = new Object[] {"Alone Again", "Snowchild"};
        System.out.println("Expected result: " + Arrays.toString(actual));
        System.out.println("Actual result: " + Arrays.toString(expected));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 45.1");
        } else {
            System.out.println("Failed test 45.1");
        }
        if (act == exp) {
            System.out.println("Passed test 45.2");
        } else {
            System.out.println("Failed test 45.2");
        }

        // test 46 - 48, removeRange()
        System.out.println("\nTest 46: Remove range of elements");
        list.makeEmpty();
        list.add("Call Out My Name");
        list.add("Wasted Times");
        list.add("I Was Never There");
        list.add("Try Me");
        list.removeRange(0, 4);
        actual = toArray(list);
        expected = new Object[] {};
        System.out.println("Expected result: " + Arrays.toString(actual));
        System.out.println("Actual result: " + Arrays.toString(expected));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 46");
        } else {
            System.out.println("Failed test 46");
        }

        System.out.println("\nTest 47: Remove range of elements");
        list.makeEmpty();
        list.add("Call Out My Name");
        list.add("Wasted Times");
        list.add("I Was Never There");
        list.add("Try Me");
        list.removeRange(0, 0);
        actual = toArray(list);
        expected = new Object[] {"Call Out My Name", "Wasted Times", "I Was " +
                "Never There", "Try Me"};
        System.out.println("Expected result: " + Arrays.toString(actual));
        System.out.println("Actual result: " + Arrays.toString(expected));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 47");
        } else {
            System.out.println("Failed test 47");
        }

        System.out.println("\nTest 48: Remove range of elements");
        list.removeRange(2, 3);
        actual = toArray(list);
        expected = new Object[] {"Call Out My Name", "Wasted Times", "Try Me"};
        System.out.println("Expected result: " + Arrays.toString(actual));
        System.out.println("Actual result: " + Arrays.toString(expected));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 48");
        } else {
            System.out.println("Failed test 48");
        }

        // test 49 - 51, size()
        System.out.println("\nTest 49: Size of list");
        indActual = list.size;
        indExpected = 3;
        System.out.println("Expected result: " + indExpected);
        System.out.println("Actual result: " + indActual);
        if (indExpected == indActual) {
            System.out.println("Passed test 49");
        } else {
            System.out.println("Failed test 49");
        }

        System.out.println("\nTest 50: Size of list");
        list.makeEmpty();
        indActual = list.size;
        indExpected = 0;
        System.out.println("Expected result: " + indExpected);
        System.out.println("Actual result: " + indActual);
        if (indExpected == indActual) {
            System.out.println("Passed test 50");
        } else {
            System.out.println("Failed test 50");
        }

        System.out.println("\nTest 51: Size of list");
        list.insert(0, "test");
        indActual = list.size;
        indExpected = 1;
        System.out.println("Expected result: " + indExpected);
        System.out.println("Actual result: " + indActual);
        if (indExpected == indActual) {
            System.out.println("Passed test 51");
        } else {
            System.out.println("Failed test 51");
        }

        // test 52 - 54, toString()
        System.out.println("\nTest 52: Print list as a String");
        list.makeEmpty();
        list.add("Starboy");
        list.add("Ordinary Life");
        list.add("Party Monster");
        list.add("Reminder");
        actua = list.toString();
        expect = Arrays.toString(new Object[] {"Starboy", "Ordinary Life",
                "Party Monster", "Reminder"});
        System.out.println("Expected result: " + expect);
        System.out.println("Actual result: " + actua);
        if (actua.equals(expect)) {
            System.out.println("Passed test 52");
        } else {
            System.out.println("Failed test 52");
        }

        System.out.println("\nTest 53: Print list as a String");
        list.makeEmpty();
        list.add("King of the Fall");
        actua = list.toString();
        expect = Arrays.toString(new Object[] {"King of the Fall"});
        System.out.println("Expected result: " + expect);
        System.out.println("Actual result: " + actua);
        if (actua.equals(expect)) {
            System.out.println("Passed test 53");
        } else {
            System.out.println("Failed test 53");
        }

        System.out.println("\nTest 54: Print list as a String");
        list.makeEmpty();
        actua = list.toString();
        expect = Arrays.toString(new Object[] {});
        System.out.println("Expected result: " + expect);
        System.out.println("Actual result: " + actua);
        if (actua.equals(expect)) {
            System.out.println("Passed test 54");
        } else {
            System.out.println("Failed test 54");
        }

        // test 55 - 64, iterator(), next(), hasNext(), remove()
        System.out.println("\nTest 55: Create an iterator()");
        list.add("Sacrifice");
        list.add("Out of Time");
        list.add("I Heard You're Married");
        Iterator<String> iterator = list.iterator();
        if (iterator != null) {
            System.out.println("Passed test 55");
        } else {
            System.out.println("Failed test 55");
        }

        System.out.println("\nTest 56: Iterator hasNext()");
        act = iterator.hasNext();
        exp = true;
        if (act == exp) {
            System.out.println("Passed test 56");
        } else {
            System.out.println("Failed test 56");
        }

        System.out.println("\nTest 57: Iterator next()");
        actua = iterator.next();
        expect = "Sacrifice";
        System.out.println("Expected result: " + expect);
        System.out.println("Actual result: " + actua);
        if (actua.equals(expect)) {
            System.out.println("Passed test 57");
        } else {
            System.out.println("Failed test 57");
        }

        System.out.println("\nTest 58: Iterator remove()");
        iterator.remove();
        actual = toArray(list);
        expected = new Object[] {"Out of Time", "I Heard You're Married"};
        System.out.println("Expected result: " + Arrays.toString(actual));
        System.out.println("Actual result: " + Arrays.toString(expected));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 58");
        } else {
            System.out.println("Failed test 58");
        }

        System.out.println("\nTest 59: Iterator hasNext()");
        act = iterator.hasNext();
        exp = true;
        System.out.println("Expected result: " + exp);
        System.out.println("Actual result: " + act);
        if (act == exp) {
            System.out.println("Passed test 59");
        } else {
            System.out.println("Failed test 59");
        }

        System.out.println("\nTest 60: Iterator next()");
        actua = iterator.next();
        expect = "Out of Time";
        System.out.println("Expected result: " + expect);
        System.out.println("Actual result: " + actua);
        if (actua.equals(expect)) {
            System.out.println("Passed test 60");
        } else {
            System.out.println("Failed test 60");
        }

        System.out.println("\nTest 61: Iterator remove()");
        iterator.remove();
        actual = toArray(list);
        expected = new Object[] {"I Heard You're Married"};
        System.out.println("Expected result: " + Arrays.toString(actual));
        System.out.println("Actual result: " + Arrays.toString(expected));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 61");
        } else {
            System.out.println("Failed test 61");
        }

        System.out.println("\nTest 62: Iterator hasNext()");
        act = iterator.hasNext();
        exp = true;
        System.out.println("Expected result: " + exp);
        System.out.println("Actual result: " + act);
        if (act == exp) {
            System.out.println("Passed test 62");
        } else {
            System.out.println("Failed test 62");
        }

        System.out.println("\nTest 63: Iterator next()");
        actua = iterator.next();
        expect = "I Heard You're Married";
        System.out.println("Expected result: " + expect);
        System.out.println("Actual result: " + actua);
        if (actua.equals(expect)) {
            System.out.println("Passed test 63");
        } else {
            System.out.println("Failed test 63");
        }

        System.out.println("\nTest 64: Iterator remove()");
        iterator.remove();
        actual = toArray(list);
        expected = new Object[] {};
        System.out.println("Expected result: " + Arrays.toString(actual));
        System.out.println("Actual result: " + Arrays.toString(expected));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 64");
        } else {
            System.out.println("Failed test 64");
        }

        System.out.println("\nTest 65: Iterator hasNext()");
        act = iterator.hasNext();
        exp = false;
        System.out.println("Expected result: " + exp);
        System.out.println("Actual result: " + act);
        if (act == exp) {
            System.out.println("Passed test 65");
        } else {
            System.out.println("Failed test 65");
        }

        // test 66 - 67, iterator()
        System.out.println("\nTest 66: Create an iterator()");
        list.makeEmpty();
        iterator = list.iterator();
        if (iterator != null) {
            System.out.println("Passed test 66");
        } else {
            System.out.println("Failed test 66");
        }

        System.out.println("\nTest 67: Create an iterator()");
        list = new LinkedList<>();
        iterator = list.iterator();
        if (iterator != null) {
            System.out.println("Passed test 67");
        } else {
            System.out.println("Failed test 67");
        }

    }

    /*
     * Runs very basic tests on the LinkedList class for
     * CS314 assignment 4.
     */
    private static void basicTests() {

        System.out.println("****** BASIC TESTS *******\n");
        LinkedList<String> list = new LinkedList<>();

        // test 0
        System.out.println("\nTest 0: initial list is empty");
        if (list.toString().equals("[]")) {
            System.out.println("Passed test 0");
        } else {
            System.out.println("Failed test 0");
        }

        // test 0.1
        System.out.println("\nTest 0.1: add to end");
        list.add("A");
        if (list.get(0).equals("A")) {
            System.out.println("Passed test 0.1");
        } else {
            System.out.println("Failed test 0.1");
        }

        // test 0.2
        System.out.println("\nTest 0.2: size");
        if (list.size() == 1) {
            System.out.println("Passed test 0.2");
        } else {
            System.out.println("Failed test 0.2");
        }

        // test 0.3
        System.out.println("\nTest 0.3: remove from position 0");
        String removed = list.remove(0);
        if (removed.equals("A")) {
            System.out.println("Passed test 0.31");
        } else {
            System.out.println("Failed test 0.31");
        }

        System.out.println("\nTest 0.31: toString after remove");

        // test 0.31
        if (list.toString().equals("[]")) {
            System.out.println("Passed test 0.3");
        } else {
            System.out.println("Failed test 0.3");
        }

        // test 0.4
        System.out.println("\nTest 0.4: size");
        if (list.size() == 0) {
            System.out.println("Passed test 0.4");
        } else {
            System.out.println("Failed test 0.4");
        }

        // test 0.5
        System.out.println("\nTest 0.5: add and toString");
        list.add("A");
        list.add("B");
        String s = list.toString();
        if (list.toString().equals("[A, B]")) {
            System.out.println("Passed test 0.5");
        } else {
            System.out.println("Failed test 0.5");
        }

        // test 0.6
        System.out.println("\nTest 0.6: size");
        if (list.size() == 2) {
            System.out.println("Passed test 0.6");
        } else {
            System.out.println("Failed test 0.6");
        }

        // test 0.7
        System.out.println("\nTest 0.7: makeEmpty");
        list.makeEmpty();
        if (list.size() == 0) {
            System.out.println("Passed test 0.7");
        } else {
            System.out.println("Failed test 0.7");
        }

        // test 0.8
        System.out.println("\nTest 0.8: makeEmpty on empty list");
        list.makeEmpty();
        if (list.size() == 0) {
            System.out.println("Passed test 0.8");
        } else {
            System.out.println("Failed test 0.8");
        }


        // test 1
        System.out.println("\nTest 1: Adding at end");
        list = new LinkedList<>();
        list.add("A");
        Object[] actual = toArray(list);
        Object[] expected = new Object[] {"A"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 1");
        } else {
            System.out.println("Failed test 1");
        }


        // test 2
        System.out.println("\nTest 2: making empty");
        list.makeEmpty();
        actual = toArray(list);
        expected = new Object[] {};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 2");
        } else {
            System.out.println("Failed test 2");
        }


        // test 3
        System.out.println("\nTest 3: Adding at pos 0 in empty list");
        list.insert(0, "A");
        actual = toArray(list);
        expected = new Object[] {"[A]"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 3");
        } else {
            System.out.println("Failed test 3");
        }


        //test 4
        System.out.println("\nTest 4: Adding at front");
        list = new LinkedList<>();
        list.addFirst("A");
        actual = toArray(list);
        expected = new Object[] {"A"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 4");
        } else {
            System.out.println("Failed test 4");
        }


        // test 5
        System.out.println("\nTest 5: Removing from front");
        list.removeFirst();
        actual = toArray(list);
        expected = new Object[] {};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 5");
        } else {
            System.out.println("Failed test 5");
        }


        // test 6
        list = new LinkedList<>();
        System.out.println("\nTest 6: Adding at end");
        list.addLast("A");
        actual = toArray(list);
        expected = new Object[] {"A"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 6");
        } else {
            System.out.println("Failed test 6");
        }


        // test 7
        System.out.println("\nTest 7: Removing from back");
        list.removeLast();
        actual = toArray(list);
        expected = new Object[] {};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 7");
        } else {
            System.out.println("Failed test 7");
        }

        // test 8
        System.out.println("\nTest 8: Adding at middle");
        list = new LinkedList<>();
        list.add("A");
        list.add("C");
        list.insert(1, "B");
        actual = toArray(list);
        expected = new Object[] {"A", "B", "C"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 8");
        } else {
            System.out.println("Failed test 8");
        }


        // test 9
        System.out.println("\nTest 9: Setting");
        list = new LinkedList<>();
        list.add("A");
        list.add("D");
        list.add("C");
        String oldValue = list.set(1, "B");
        actual = toArray(list);
        expected = new Object[] {"A", "B", "C"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected) ) {
            System.out.println("Passed test 9.1");
        } else {
            System.out.println("Failed test 9.1");
        }
        if (oldValue.equals("D")) {
            System.out.println("Passed test 9.2");
        } else {
            System.out.println("Failed test 9.2");
        }


        // test 10
        System.out.println("\nTest 10: Removing");
        list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.remove(0);
        list.remove( list.size() - 1 );
        actual = toArray(list);
        expected = new Object[] {"B", "C"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 10");
        } else {
            System.out.println("Failed test 10");
        }
    }


    // constants for the maximum length of the lists used in the tests as well as
    // the number of times each method should be tested
    private static final int MAX_LENGTH = 15;
    private static final int NUM_TESTS_PER_METHOD = 50;

    // From Spring 2021 students:
    // Tests use randomness to find edge cases, 
    // so the test numbering is irrelevant, each test being different every time the 
    // program is run.
    private static void spring2021StressTests() {
        System.out.println("\n****** SPRING 2021 RANDOM STRESS TESTS *******\n");

        // performs all the tests. The console displays some private methods I have as
        // well, but it isn't actually directly calling those private methods. It merely
        // sets the conditions to where those methods would be called in my personal
        // program. It still is useful to test for edge cases

        final String methodNamesRaw = "void addFirst(E item)\r\n" + "void addLast(E item)\r\n" + "E removeFirst()\r\n"
                + "E removeLast()\r\n" + "void add(E item)\r\n" + "void insert(int pos, E item)\r\n"
                + "void insertBeforeLast(E item)\r\n" + "void insertAfterFirst(E item)\r\n" + "E set(pos, E item)\r\n"
                + "E get(int pos)\r\n" + "E remove(int pos)\r\n" + "E removeAFterFirst()\r\n"
                + "E removeBeforeLast()\r\n" + "boolean remove(E obj)\r\n"
                + "Ilist<E> getSubList(int start, int stop)\r\n" + "int size()\r\n" + "int indexOf(E item)\r\n"
                + "int indexOf(E item, int pos)\r\n" + "void makeEmpty()\r\n"
                + "void removeRange(int start, int stop)\r\n" + "string tosString()\r\n" + "boolean equals(other)\r\n"
                + "ITERATOR LLIterator()\r\n" + "ITERATOR boolean hasNext()\r\n" + "ITERATOR E next()\r\n"
                + "ITERATOR void remove()\r\n";
        final String[] methodNames = methodNamesRaw.split("\r\n");
        String methodName = methodNames[0];
        int methodNum = 0;
        LinkedList<String> testList = new LinkedList<>();
        int numTestsFailed = 0;
        HashSet<String> failedTests = new HashSet<>();
        // void addFirst(E item)
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);
            testList.addFirst(methodName);
            toCompare.add(0, methodName);
            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // void addLast(E item)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            // perform actions here
            testList.addLast(methodName);
            toCompare.add(methodName);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // E removeFirst()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            // perform actions here
            testList.removeFirst();
            toCompare.remove(0);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // E removeLast()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            // perform actions here
            testList.removeLast();
            toCompare.remove(toCompare.size() - 1);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();

        // void add(E item)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            // perform actions here
            testList.add(methodName);
            toCompare.add(methodName);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // void insert(int pos, E item)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int randomPos = (int) (Math.random() * toCompare.size());

            // perform actions here
            testList.insert(randomPos, methodName);
            toCompare.add(randomPos, methodName);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();

        // void insertBeforeLast(E item)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int pos = toCompare.size() - 1;

            // perform actions here
            testList.insert(pos, methodName);
            toCompare.add(pos, methodName);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // void insertAfterFirst(E item)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int pos = 1;

            // perform actions here
            testList.insert(pos, methodName);
            toCompare.add(pos, methodName);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();

        // E set(pos, E item)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int pos = (int) (Math.random() * toCompare.size());

            // perform actions here
            testList.set(pos, methodName);
            toCompare.set(pos, methodName);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();

        // E get(int pos)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int pos = (int) (Math.random() * toCompare.size());

            // perform actions here

            String expected = toCompare.get(pos);
            String actual = testList.get(pos);

            if (expected.equals(actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: " + expected
                        + " Actual Output = " + actual);
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // E remove(int pos)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int pos = (int) (Math.random() * toCompare.size());

            // perform actions here
            testList.remove(pos);
            toCompare.remove(pos);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // E removeAFterFirst()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);
            if (toCompare.size() == 1) {
                toCompare.add("Item " + 2);
                testList.add("Item " + 2);
            }
            // perform actions here
            testList.remove(1);
            toCompare.remove(1);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // E removeBeforeLast()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int pos = toCompare.size() - 2;
            if (pos == -1) {
                pos = 0;
            }
            // perform actions here

            String expected = toCompare.remove(pos);
            String actual = testList.remove(pos);

            if (expected.equals(actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: " + expected
                        + " Actual Output = " + actual);
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // boolean remove(E obj)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            String objToRemove = toCompare.get((int) (Math.random() * toCompare.size()));

            // perform actions here
            testList.remove(objToRemove);
            toCompare.remove(objToRemove);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // Ilist<E> getSubList(int start, int stop)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int start = (int) (Math.random() * toCompare.size());
            int stop = (int) (Math.random() * (toCompare.size() - start) + start);
            // perform actions here
            IList<String> actualA = testList.getSubList(start, stop);
            List<String> expectedB = toCompare.subList(start, stop);
            String[] expected = expectedB.toArray(new String[expectedB.size()]);
            String[] actual = toArray2(actualA);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // int size()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int start = (int) (Math.random() * toCompare.size());
            int stop = (int) (Math.random() * (toCompare.size() - start) + start);
            // perform actions here
            IList<String> actualA = testList.getSubList(start, stop);
            List<String> expectedB = toCompare.subList(start, stop);
            String[] expected = expectedB.toArray(new String[expectedB.size()]);
            String[] actual = toArray2(actualA);
            if (actualA.size() == expectedB.size()) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // int indexOf(E item)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int pos = (int) (Math.random() * toCompare.size());
            toCompare.add(pos, methodName);
            testList.insert(pos, methodName);
            // perform actions here

            int expected = toCompare.indexOf(methodName);
            int actual = testList.indexOf(methodName);

            if (expected == actual) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: " + expected
                        + " Actual Output = " + actual);
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();

        // int indexOf(E item, int pos)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int pos2 = (int) (Math.random() * toCompare.size()) + 1;
            int pos1 = (int) (Math.random() * pos2);
            toCompare.add(pos1, methodName);
            toCompare.add(pos2, methodName);
            testList.insert(pos1, methodName);
            testList.insert(pos2, methodName);

            int posToCheckFrom = (int) (Math.random() * toCompare.size());
            // perform actions here
            int expected;
            if (posToCheckFrom > pos2) {
                expected = -1;
            } else if (posToCheckFrom > pos1 && posToCheckFrom <= pos2) {
                expected = pos2;
            } else {
                expected = pos1;
            }

            int actual = testList.indexOf(methodName, posToCheckFrom);

            if (expected == actual) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: " + expected
                        + " Actual Output = " + actual + "  toCompare Array: " + toCompare.toString()
                        + " testList array " + testList.toString() + "  POS1: " + pos1 + " POS2: " + pos2
                        + " POSTTOCHECK: " + posToCheckFrom);
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // void makeEmpty()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            // perform actions here
            testList.makeEmpty();
            toCompare.clear();

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();

        // void removeRange(int start, int stop)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);
            int start = (int) (Math.random() * toCompare.size());
            int stop = (int) (Math.random() * (toCompare.size() - start) + start);
            // perform actions here
            testList.removeRange(start, stop);
            for (int j = stop - 1; j >= start; j--) {
                toCompare.remove(j);
            }
            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual) + " START: " + start
                        + " STOP: " + stop);
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // string tosString()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            // perform actions here

            String expected = toCompare.toString();
            String actual = testList.toString();
            if (expected.equals(actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: " + expected
                        + " Actual Output = " + actual);
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // boolean equals(other)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);
            LinkedList<String> toCompareLinkedList = arrayListToLinkedList(toCompare);
            // perform actions here

            if (testList.equals(toCompareLinkedList)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + toCompare.toString() + " Actual Output = " + testList.toString());
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // ITERATOR LLIterator()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);
            // perform actions here

            if (testList.iterator().hasNext() && testList.iterator().next().equals(testList.get(0))) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + toCompare.toString() + " Actual Output = " + testList.toString());
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();

        // ITERATOR boolean hasNext()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            // perform actions here
            Iterator<String> testListIterator = testList.iterator();
            Iterator<String> toCompareIterator = toCompare.iterator();
            int count1 = 0;
            int count2 = 0;
            while (testListIterator.hasNext()) {
                count1++;
                testListIterator.next();
            }
            while (toCompareIterator.hasNext()) {
                count2++;
                toCompareIterator.next();
            }

            if (count1 == count2) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: ");
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // ITERATOR E next()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            // perform actions here
            Iterator<String> testListIterator = testList.iterator();
            Iterator<String> toCompareIterator = toCompare.iterator();
            boolean pass = true;
            while (testListIterator.hasNext() && toCompareIterator.hasNext() && pass) {
                if (!testListIterator.next().equals(toCompareIterator.next())) {
                    pass = false;
                }
            }
            if (testListIterator.hasNext() != toCompareIterator.hasNext()) {
                pass = false;
            }

            if (pass) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: ");
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // ITERATOR void remove()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            // perform actions here
            Iterator<String> testListIterator = testList.iterator();
            Iterator<String> toCompareIterator = toCompare.iterator();
            int random = (int) (Math.random() * toCompare.size()) + 1;
            for (int j = 0; j < random; j++) {
                if (testListIterator.hasNext()) {
                    testListIterator.next();
                }
                if (toCompareIterator.hasNext()) {
                    toCompareIterator.next();
                }
            }
            toCompareIterator.remove();
            testListIterator.remove();
            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        System.out.println("RESULTS:");
        System.out.println("TOTAL TESTS: " + (NUM_TESTS_PER_METHOD * methodNames.length) + " | TOTAL FAILED: "
                + numTestsFailed + " | FAILED METHODS: " + failedTests.toString() + " |");
    }


    private static LinkedList<String> newResetedTestList(LinkedList<String> a) {
        a.makeEmpty();
        int random = (int) (Math.random() * MAX_LENGTH) + 1;
        for (int j = 0; j < random; j++) {
            a.add("Item " + (j));
        }
        return a;
    }

    private static ArrayList<String> linkedListToArrayList(LinkedList<String> testList) {
        ArrayList<String> result = new ArrayList<>();
        Iterator<String> s = testList.iterator();
        while (s.hasNext()) {
            result.add(s.next());
        }
        return result;
    }

    private static LinkedList<String> arrayListToLinkedList(ArrayList<String> toCompare) {
        LinkedList<String> result = new LinkedList<>();
        Iterator<String> s = toCompare.iterator();
        while (s.hasNext()) {
            result.add(s.next());
        }
        return result;
    }

    private static String[] toArray2(IList<String> actualA) {
        String[] result = new String[actualA.size()];
        Iterator<String> it = actualA.iterator();
        int index = 0;
        while (it.hasNext()) {
            result[index] = it.next();
            index++;
        }
        return result;
    }

    private static void itRemoveStressTests() {
        /*
         *  Test that the iterator remove is O(1).
         *  Total time to remove half of list should roughly double
         *  when size of list is doubled.
         */
        final int SEED = 19431215;
        Random r = new Random(SEED);
        Stopwatch st = new Stopwatch();
        int n = 50_000;
        for (int i = 0; i < 6; i++) {
            LinkedList<Double> list = new LinkedList<>();
            for (int j =0; j < n; j++) {
                list.add(r.nextDouble());
            }
            Iterator<Double> it = list.iterator();
            final int LIMIT = n / 2;
            for (int j = 0; j < LIMIT; j++) {
                it.next();
            }
            st.start();
            while(it.hasNext()) {
                it.next();
                it.remove();
            }
            st.stop();
            System.out.println("number of elements = " + n
                    + " time to remove half of list with iterator = " + st);
            n *= 2;
        }
    }

    // Convert elements of list to an array. Uses the list
    // size method and iterator.
    private static Object[] toArray(LinkedList<String> list) {
        Object[] result = new Object[list.size()];
        Iterator<String> it = list.iterator();
        int index = 0;
        while(it.hasNext()){
            result[index] = it.next();
            index++;
        }
        return result;
    }

    //pre: none
    private static boolean arraysSame(Object[] one, Object[] two)  {
        boolean same;
        if( one == null || two == null ) {
            same = (one == two);
        }
        else {
            //neither one or two are null
            assert one != null && two != null;
            same = one.length == two.length;
            if( same ) {
                int index = 0;
                while( index < one.length && same ) {
                    same = ( one[index].equals(two[index]) );
                    index++;
                }
            }
        }
        return same;
    }


    private static final int NUM_DOUBLINGS_OF_N = 5;
    private static final int NUM_REPEATS_OF_TEST = 100;

    // A method to be run to compare the LinkedList you are completing and the Java ArrayList class
    private static void comparison(){
        Stopwatch s = new Stopwatch();

        int initialN = 30000;
        addEndArrayList(s, initialN, NUM_DOUBLINGS_OF_N);
        addEndLinkedList(s, initialN, NUM_DOUBLINGS_OF_N);

        initialN = 2000;
        addFrontArrayList(s, initialN, NUM_DOUBLINGS_OF_N);
        initialN = 10000;
        addFrontLinkedList(s, initialN, NUM_DOUBLINGS_OF_N);

        initialN = 2000;
        removeFrontArrayList(s, initialN, NUM_DOUBLINGS_OF_N);
        initialN = 5000;
        removeFrontLinkedList(s, initialN, NUM_DOUBLINGS_OF_N);

        initialN = 10000;
        getRandomArrayList(s, initialN, NUM_DOUBLINGS_OF_N);
        initialN = 1000;
        getRandomLinkedList(s, initialN, NUM_DOUBLINGS_OF_N);

        initialN = 50000;
        getAllArrayListUsingIterator(s, initialN, NUM_DOUBLINGS_OF_N);
        getAllLinkedListUsingIterator(s, initialN, NUM_DOUBLINGS_OF_N);

        initialN = 100000;
        getAllArrayListUsingGetMethod(s, initialN, NUM_DOUBLINGS_OF_N);
        initialN = 1000;
        getAllLinkedListUsingGetMethod(s, initialN, NUM_DOUBLINGS_OF_N);

    }

    // These pairs of methods illustrate a failure to use polymorphism
    // If the students had implemented the Java list interface there
    // could be a single method. Also we could use function objects to
    // reduce the awful repitition of code.
    private static void addEndArrayList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                ArrayList<Integer> javaList = new ArrayList<>();
                s.start();
                for (int j = 0; j < n; j++) {
                    javaList.add(j);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Adding at end: ArrayList", totalTimes, initialN);
    }

    private static void showResults(String title, double[] times, int initialN) {
        System.out.println();
        System.out.println("Number of times test run: " + NUM_REPEATS_OF_TEST);
        System.out.println(title);
        for (double time : times) {
            System.out.print("N = " + initialN + ", total time: ");
            System.out.printf("%7.4f\n", time);
            initialN *= 2;
        }
        System.out.println();
    }

    private static void addEndLinkedList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                LinkedList<Integer> studentList = new LinkedList<>();
                s.start();
                for (int j = 0; j < n; j++) {
                    studentList.add(j);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Adding at end: LinkedList", totalTimes, initialN);
    }

    private static void addFrontArrayList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                ArrayList<Integer> javaList = new ArrayList<>();
                s.start();
                for (int j = 0; j < n; j++) {
                    javaList.add(0, j);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Adding at front: ArrayList", totalTimes, initialN);
    }

    private static void addFrontLinkedList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                LinkedList<Integer> studentList = new LinkedList<>();
                s.start();
                for (int j = 0; j < n; j++) {
                    studentList.insert(0, j);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Adding at front: LinkedList", totalTimes, initialN);
    }

    private static void removeFrontArrayList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                ArrayList<String> javaList = new ArrayList<>();
                for(int j = 0; j < n; j++)
                    javaList.add(j + "");
                s.start();
                while (!javaList.isEmpty()) {
                    javaList.remove(0);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Removing from front: ArrayList", totalTimes, initialN);
    }

    private static void removeFrontLinkedList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                LinkedList<String> studentList = new LinkedList<>();
                for (int j = 0; j < n; j++) {
                    studentList.add(j + "");
                }
                s.start();
                while (studentList.size() != 0) {
                    studentList.removeFirst();
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("removing from front: LinkedList", totalTimes, initialN);
    }

    private static void getRandomArrayList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            int total = 0;
            Random r = new Random();
            for (int i = 0; i < numTests; i++) {
                ArrayList<Integer> javaList = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    javaList.add(j);
                }
                s.start();
                for (int j = 0; j < n; j++) {
                    total += javaList.get(r.nextInt(javaList.size()));
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting random: ArrayList", totalTimes, initialN);
    }

    private static void getRandomLinkedList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            Random r = new Random();
            for (int i = 0; i < numTests; i++) {
                LinkedList<Integer> studentList = new LinkedList<>();
                for (int j = 0; j < n; j++) {
                    studentList.add(j);
                }
                int total = 0;
                s.start();
                for (int j = 0; j < n; j++) {
                    total += studentList.get(r.nextInt(studentList.size()));
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting random: LinkedList", totalTimes, initialN);
    }

    private static void getAllArrayListUsingIterator(Stopwatch s, int initialN, int numTests){

        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for(int i = 0; i < numTests; i++){
                ArrayList<Integer> javaList = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    javaList.add(j);
                }
                Iterator<Integer> it = javaList.iterator();
                s.start();
                int total = 0;
                while (it.hasNext()) {
                    total += it.next();
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting all using iterator: ArrayList", totalTimes, initialN);
    }

    private static void getAllLinkedListUsingIterator(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                LinkedList<Integer> studentList = new LinkedList<>();
                for (int j = 0; j < n; j++) {
                    studentList.add(j);
                }
                Iterator<Integer> it = studentList.iterator();
                s.start();
                int total = 0;
                while (it.hasNext()) {
                    total += it.next();
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting all using iterator: LinkedList", totalTimes, initialN);
    }

    private static void getAllArrayListUsingGetMethod(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                ArrayList<Integer> javaList = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    javaList.add(j);
                }
                s.start();
                int x = 0;
                for (int j = 0; j < javaList.size(); j++) {
                    x += javaList.get(j);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting all using get method: ArrayList", totalTimes, initialN);
    }

    private static void getAllLinkedListUsingGetMethod(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                LinkedList<Integer> studentList = new LinkedList<>();
                for (int j = 0; j < n; j++) {
                    studentList.add(j);
                }
                s.start();
                int x = 0;
                for (int j = 0; j < studentList.size(); j++) {
                    x += studentList.get(j);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting all using get method: LinkedList", totalTimes, initialN);
    }
}