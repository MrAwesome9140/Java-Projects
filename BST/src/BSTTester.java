/* CS 314 STUDENTS: FILL IN THIS HEADER.
 *
 * Student information for assignment:
 *
 *  On my honor, Aaroh Sharma, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID: as225925
 *  email address: aaroh.sh@gmail.com
 *  TA name: Brad
 *  Number of slip days I am using: 0
 */

/* Experiment Results:
 *
 * Adding Random Integers
 * - Binary Search Tree Results:
    Average time to add 1000 random ints: 6.0E-4s
    Average height of the tree with 1000 random ints: 21.2
    Average size of the tree with 1000 random ints: 1000.0

    Average time to add 2000 random ints: 3.0E-4s
    Average height of the tree with 2000 random ints: 23.7
    Average size of the tree with 2000 random ints: 2000.0

    Average time to add 4000 random ints: 9.0E-4s
    Average height of the tree with 4000 random ints: 27.9
    Average size of the tree with 4000 random ints: 4000.0

    Average time to add 8000 random ints: 0.0016s
    Average height of the tree with 8000 random ints: 28.5
    Average size of the tree with 8000 random ints: 8000.0

    Average time to add 16000 random ints: 0.0032s
    Average height of the tree with 16000 random ints: 32.1
    Average size of the tree with 16000 random ints: 16000.0

    Average time to add 32000 random ints: 0.0084s
    Average height of the tree with 32000 random ints: 34.5
    Average size of the tree with 32000 random ints: 31999.7

    Average time to add 64000 random ints: 0.0165s
    Average height of the tree with 64000 random ints: 37.9
    Average size of the tree with 64000 random ints: 63999.8

    Average time to add 128000 random ints: 0.0431s
    Average height of the tree with 128000 random ints: 39.4
    Average size of the tree with 128000 random ints: 127998.2

    Average time to add 256000 random ints: 0.0888s
    Average height of the tree with 256000 random ints: 42.6
    Average size of the tree with 256000 random ints: 255991.8

    Average time to add 512000 random ints: 0.2522s
    Average height of the tree with 512000 random ints: 46.4
    Average size of the tree with 512000 random ints: 511972.3

    Average time to add 1024000 random ints: 0.5779s
    Average height of the tree with 1024000 random ints: 48.8
    Average size of the tree with 1024000 random ints: 1023882.6
 *
 * Min possible heights:
 * N = 2000: 11
 * N = 4000: 12
 * N = 8000: 13
 * N = 16000: 14
 * N = 32000: 15
 * N = 64000: 16
 * N = 128000: 17
 * N = 256000: 18
 * N = 512000: 19
 * N = 1024000: 20
 *
 * Java TreeSet Results:
    Average time to add 1000 random ints: 6.0E-4s
    Average time to add 2000 random ints: 6.0E-4s
    Average time to add 4000 random ints: 0.001s
    Average time to add 8000 random ints: 0.002s
    Average time to add 16000 random ints: 0.0027s
    Average time to add 32000 random ints: 0.0067s
    Average time to add 64000 random ints: 0.015s
    Average time to add 128000 random ints: 0.0328s
    Average time to add 256000 random ints: 0.0803s
    Average time to add 512000 random ints: 0.2308s
    Average time to add 1024000 random ints: 0.5905s
 *
 * The times to add N elements for the Java TreeSet and our BinaryTreeSet are
 * roughly the same, with our BinaryTreeSet maybe even being slightly faster
 *
 *
 *
 * Adding Integers in Ascending Order
 * - Binary Search Tree Results
    Average time to add 1000 ascending ints: 0.0018s
    Average height of the tree with 1000 ascending ints: 1000.0
    Average size of the tree with 1000 ascending ints: 1000.0

    Average time to add 2000 ascending ints: 0.0041s
    Average height of the tree with 2000 ascending ints: 2000.0
    Average size of the tree with 2000 ascending ints: 2000.0

    Average time to add 4000 ascending ints: 0.017s
    Average height of the tree with 4000 ascending ints: 4000.0
    Average size of the tree with 4000 ascending ints: 4000.0

    Average time to add 8000 ascending ints: 0.0666s
    Average height of the tree with 8000 ascending ints: 8000.0
    Average size of the tree with 8000 ascending ints: 8000.0

    Average time to add 16000 ascending ints: 0.247s
    Average height of the tree with 16000 ascending ints: 16000.0
    Average size of the tree with 16000 ascending ints: 16000.0

    Average time to add 32000 ascending ints: 0.9899s
    Average height of the tree with 32000 ascending ints: 32000.0
    Average size of the tree with 32000 ascending ints: 32000.0

    Average time to add 64000 ascending ints: 4.0494s
    Average height of the tree with 64000 ascending ints: 64000.0
    Average size of the tree with 64000 ascending ints: 64000.0
 *
 * - Java TreeSet Results
    Average time to add 1000 ascending ints: 9.0E-4s
    Average time to add 2000 ascending ints: 3.0E-4s
    Average time to add 4000 ascending ints: 5.0E-4s
    Average time to add 8000 ascending ints: 0.0011s
    Average time to add 16000 ascending ints: 0.002s
    Average time to add 32000 ascending ints: 0.0037s
    Average time to add 64000 ascending ints: 0.007s
 *
 * The times to add ascending elements in the Java TreeSet are much faster
 * than the times to add ascending elements in my BinarySearchTree class.
 * This is likely because the Java TreeSet class uses a Red-Black tree which
 * automatically balances itself out as elements are added to prevent the tree
 * from becoming unbalanced. My BinarySearchTree on the other hand uses a
 * naive add implementation, which means that elements being inserted in
 * ascending order will cause the tree to look like a linked list and become
 * extremely unbalanced, slowing down the time to add new elements.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

/**
 * Some test cases for CS314 Binary Search Tree assignment.
 *
 */
public class BSTTester {

    /**
     * The main method runs the tests.
     * @param args Not used
     */
    public static void main(String[] args) {
        studentTests();
    }

    private static void experimentTests() {

        int numToAdd = 1000;

        for (int add = numToAdd; add <= 1_024_000; add *= 2) {
            double avgTime = 0;
            double avgHeight = 0;
            double avgSize = 0;
            for (int i = 0; i < 10; i++) {
                Random r = new Random();
                BinarySearchTree<Integer> b = new BinarySearchTree<>();
                Stopwatch s = new Stopwatch();
                s.start();
                for (int k = 0; k < add; k++) {
                    b.add(r.nextInt());
                }
                s.stop();
                avgTime += s.time();
                avgHeight += b.height();
                avgSize += b.size();
            }
            avgTime = Math.round((avgTime / 10) * 10000) / 10000.0;
            System.out.println("Average time to add " + add + " random ints: " +
                    avgTime + "s");
            avgHeight = Math.round((avgHeight / 10) * 10000) / 10000.0;
            System.out.println("Average height of the tree with " + add + " " +
                    "random ints: " + avgHeight);
            avgSize = Math.round((avgSize / 10) * 10000) / 10000.0;
            System.out.println("Average size of the tree with " + add + " " +
                    "random ints: " + avgSize + "\n");
        }

        for (int add = numToAdd; add <= 1_024_000; add *= 2) {
            double avgTime = 0;
            for (int i = 0; i < 10; i++) {
                Random r = new Random();
                TreeSet<Integer> b = new TreeSet<>();
                Stopwatch s = new Stopwatch();
                s.start();
                for (int k = 0; k < add; k++) {
                    b.add(r.nextInt());
                }
                s.stop();
                avgTime += s.time();
            }
            avgTime = Math.round((avgTime / 10) * 10000) / 10000.0;
            System.out.println("Average time to add " + add + " random ints: " +
                    avgTime + "s");
        }

        for (int add = numToAdd; add <= 64_000; add *= 2) {
            double avgTime = 0;
            double avgHeight = 0;
            double avgSize = 0;
            for (int i = 0; i < 10; i++) {
                BinarySearchTree<Integer> b = new BinarySearchTree<>();
                Stopwatch s = new Stopwatch();
                s.start();
                for (int k = 1; k <= add; k++) {
                    b.iterativeAdd(k);
                }
                s.stop();
                avgTime += s.time();
                avgHeight += add;
                avgSize += add;
            }
            avgTime = Math.round((avgTime / 10) * 10000) / 10000.0;
            System.out.println("Average time to add " + add + " ascending " +
                    "ints: " +
                    avgTime + "s");
            avgHeight = Math.round((avgHeight / 10) * 10000) / 10000.0;
            System.out.println("Average height of the tree with " + add + " " +
                    "ascending ints: " + avgHeight);
            avgSize = Math.round((avgSize / 10) * 10000) / 10000.0;
            System.out.println("Average size of the tree with " + add + " " +
                    "ascending ints: " + avgSize + "\n");
        }

        System.out.println("\n\n\n");

        for (int add = numToAdd; add <= 64_000; add *= 2) {
            double avgTime = 0;
            for (int i = 0; i < 10; i++) {
                TreeSet<Integer> b = new TreeSet<>();
                Stopwatch s = new Stopwatch();
                s.start();
                for (int k = 1; k <= add; k++) {
                    b.add(k);
                }
                s.stop();
                avgTime += s.time();
            }
            avgTime = Math.round((avgTime / 10) * 10000) / 10000.0;
            System.out.println("Average time to add " + add + " ascending " +
                    "ints: " +
                    avgTime + "s");
        }
    }

    private static void studentTests() {
        BinarySearchTree<String> t = new BinarySearchTree<>();

        //test 1 and 2, add()
        System.out.println("Test 1: add()");
        showTestResults(t.add("Nights"), 1);

        System.out.println("Test 2: add()");
        showTestResults(!t.add("Nights"), 2);

        t.add("Blonde");
        t.add("Bad Religion");
        t.add("Pyramids");
        t.add("Monks");

        //test 3 and 4, remove()
        System.out.println("Test 3: remove()");
        t.remove("Blonde");
        showTestResults(t.size() == 4, 3);

        System.out.println("Test 4: remove()");
        showTestResults(t.remove("Nights") && t.size() == 3, 4);

        //test 5 and 6, isPresent()
        System.out.println("Test 5: isPresent()");
        showTestResults(t.isPresent("Pyramids"), 5);

        System.out.println("Test 6: isPresent()");
        showTestResults(!t.isPresent("Self Control"), 6);

        //test 7 and 8, isSize()
        System.out.println("Test 7: size()");
        t.add("Self Control");
        t.add("Nikes");
        showTestResults(t.size() == 5, 7);

        System.out.println("Test 8: size()");
        t.add("Pink Matter");
        showTestResults(t.size() == 6, 8);

        //test 9 and 10, height()
        System.out.println("Test 9: height()");
        showTestResults(t.height() == 3, 9);

        System.out.println("Test 10: height()");
        t.remove("Pink Matter");
        showTestResults(t.height() == 2, 10);

        //test 11 and 12, getAll()
        System.out.println("Test 11: getAll()");
        List<String> tester = new ArrayList<>();
        tester.add("Bad Religion");
        tester.add("Monks");
        tester.add("Nikes");
        tester.add("Pyramids");
        tester.add("Self Control");
        showTestResults(t.getAll().equals(tester), 11);

        System.out.println("Test 12: getAll()");
        t.remove("Nikes");
        tester.remove("Nikes");
        showTestResults(t.getAll().equals(tester), 12);

        //test 13 and 14, max()
        System.out.println("Test 13: max()");
        showTestResults(t.max().equals("Self Control"), 13);

        System.out.println("Test 14: max()");
        t.remove("Self Control");
        showTestResults(t.max().equals("Pyramids"), 14);

        //test 15 and 16, min()
        System.out.println("Test 15: min()");
        showTestResults(t.min().equals("Bad Religion"), 15);

        System.out.println("Test 16: min()");
        t.remove("Bad Religion");
        showTestResults(t.min().equals("Monks"), 16);

        //test 17 and 18, iterativeAdd()
        System.out.println("Test 17: iterativeAdd()");
        t.iterativeAdd("Skyline To");
        showTestResults(t.size() == 3, 17);

        System.out.println("Test 18: iterativeAdd()");
        showTestResults(!t.iterativeAdd("Skyline To"), 18);

        //test 19 and 20, get()
        System.out.println("Test 19: get()");
        t.add("Solo");
        t.add("Seigfried");
        showTestResults(t.get(4).equals("Solo"), 19);

        System.out.println("Test 20: get()");
        showTestResults(t.get(2).equals("Seigfried"), 20);

        //test 21 and 22, getAllLessThan()
        System.out.println("Test 21: getAllLessThan()");
        tester.clear();
        tester.add("Monks");
        tester.add("Pyramids");
        showTestResults(t.getAllLessThan("Reminder").equals(tester), 21);


        System.out.println("Test 22: getAllLessThan()");
        tester.add("Seigfried");
        tester.add("Skyline To");
        tester.add("Solo");
        showTestResults(t.getAllLessThan("Valerie").equals(tester), 22);

        //test 23 and 24, getAllGreaterThan
        System.out.println("Test 23: getAllGreaterThan()");
        showTestResults(t.getAllGreaterThan("Call Out My Name").equals(tester),
                23);

        System.out.println("Test 24: getAllGreaterThan()");
        tester.remove("Monks");
        tester.remove("Pyramids");
        showTestResults(t.getAllGreaterThan("Reminder").equals(tester), 24);

        //test 25 and 26, numNodesAtDepth()
        System.out.println("Test 25: numNodesAtDepth()");
        showTestResults(t.numNodesAtDepth(2) == 2, 25);

        System.out.println("Test 26: numNodesAtDepth()");
        showTestResults(t.numNodesAtDepth(1) == 2, 26);
    }

    private static void showTestResults(boolean passed, int testNum) {
        if (passed) {
            System.out.println("Test " + testNum + " passed.");
        } else {
            System.out.println("TEST " + testNum + " FAILED.");
        }
    }
}