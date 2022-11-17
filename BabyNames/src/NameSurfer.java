/*
 * Student information for assignment: Replace <NAME> in the following with your
 * name. You are stating, on your honor you did not copy any other code on this
 * assignment and have not provided your code to anyone.
 *
 * On my honor, Aaroh Sharma, this programming assignment is my own work
 * and I have not provided this code
 * to any other student.
 *
 * UTEID: as225925
 * email address: aaroh.sh@gmail.com
 * Number of slip days I am using: 0
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class NameSurfer {

    // CS314 students, explain your menu option 7 here:
    // My menu option 7 returns all the names which have been
    // ranked within the top 1000 during every decade and have a
    // difference of 200 or less between their worst and best rank.
    // This search helps identify names which have been consistent in
    // popularity over the decades as they have stayed with the top
    // 1000 names and haven't had much of a change in their rank

    // CS314 students, Explain your interesting search / trend here:
    // The name Walter stayed at the same rank or moved to a worse (higher
    // number) rank in every decade from 1890 to 2000, going from 12th in the
    // 1890s to 372 in the 2000s. However, this trend was suddenly broken in
    // 2010s as the name Walter improved 55 spots in the rankings from 372 in
    // the 2000s to 317 in the 2010s. This sudden change is strongly
    // correlated to the release of the highly acclaimed and popular TV show
    // Breaking Bad, a show in the which the main character's name was Walter
    // White. This show began airing in 2008 and concluded in 2013, when it
    // was at its peak popularity. This trend shows the influence that pop
    // culture, including TV shows, can have on the way people name their
    // children.

    // CS314 students, add test code for NameRecord class here:
    public static void nameRecordTest() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("names"));
        String sp = sc.nextLine();
        int baseDec = Integer.parseInt(sp);
        int numDecs = Integer.parseInt(sc.nextLine());

        String[] s = sc.nextLine().split(" ");
        String name = s[0];
        int[] ranks = new int[numDecs];
        for (int i = 0; i < numDecs; i++) {
            ranks[i] = Integer.parseInt(s[i + 1]);
        }
        NameRecord test1 = new NameRecord(name, baseDec, ranks);
        sc.nextLine();

        s = sc.nextLine().split(" ");
        name = s[0];
        ranks = new int[numDecs];
        for (int i = 0; i < numDecs; i++) {
            ranks[i] = Integer.parseInt(s[i + 1]);
        }
        NameRecord test2 = new NameRecord(name, baseDec, ranks);

        s = sc.nextLine().split(" ");
        name = s[0];
        ranks = new int[numDecs];
        for (int i = 0; i < numDecs; i++) {
            ranks[i] = Integer.parseInt(s[i + 1]);
        }
        NameRecord test3 = new NameRecord(name, baseDec, ranks);

        s = sc.nextLine().split(" ");
        name = s[0];
        ranks = new int[numDecs];
        for (int i = 0; i < numDecs; i++) {
            ranks[i] = Integer.parseInt(s[i + 1]);
        }
        NameRecord test4 = new NameRecord(name, baseDec, ranks);
        sc.close();

        NameRecord test5 = new NameRecord("test", 1900,
                new int[]{0, 932, 245, 222, 200, 198, 175, 164, 123, 100, 50});
        NameRecord test6 = new NameRecord("test", 1900,
                new int[]{100, 232, 345, 422, 500, 698, 775, 864, 923, 999, 0});

        // Test #1, getName()
        String expected = "A";
        String actual = test1.getName();
        if (expected.equals(actual)) {
            System.out.println("Passed test #1.1, getName()");
        } else {
            System.out.println("Failed test #1.1, getName()");
        }
        expected = "Aaliyah";
        actual = test2.getName();
        if (expected.equals(actual)) {
            System.out.println("Passed test #1.2, getName()");
        } else {
            System.out.println("Failed test #1.2, getName()");
        }

        // Test #2, getBaseDec()
        int expected2 = 1900;
        int actual2 = test1.getBaseDec();
        if (expected2 == actual2) {
            System.out.println("Passed test #2.1, getBaseDec()");
        } else {
            System.out.println("Passed test #2.1, getBaseDec()");
        }
        actual2 = test2.getBaseDec();
        if (expected2 == actual2) {
            System.out.println("Passed test #2.2, getBaseDec()");
        } else {
            System.out.println("Failed test #2.2, getBaseDec()");
        }

        // Test #3, getRank()
        int expected3 = 0;
        int actual3 = test1.getRank(10);
        if (expected3 == actual3) {
            System.out.println("Passed test #3.1, getRank()");
        } else {
            System.out.println("Failed test #3.1, getRank()");
        }
        expected3 = 380;
        actual3 = test2.getRank(9);
        if (expected3 == actual3) {
            System.out.println("Passed test #3.2, getRank()");
        } else {
            System.out.println("Failed test #3.2, getRank()");
        }

        // Test #4, getBestDecade()
        int expected4 = 1900;
        int actual4 = test1.getBestDecade();
        if (expected4 == actual4) {
            System.out.println("Passed test #4.1, getBestDecade()");
        } else {
            System.out.println("Failed test #4.1, getBestDecade()");
        }
        expected4 = 2000;
        actual4 = test2.getBestDecade();
        if (expected4 == actual4) {
            System.out.println("Passed test #4.2, getBestDecade()");
        } else {
            System.out.println("Failed test #4.2, getBestDecade()");
        }

        // Test #5, numDecsTop1000()
        int expected5 = 9;
        int actual5 = test1.numDecsTop1000();
        if (expected5 == actual5) {
            System.out.println("Passed test #5.1, numDecsTop1000()");
        } else {
            System.out.println("Failed test #5.1, numDecsTop1000()");
        }
        expected5 = 2;
        actual5 = test2.numDecsTop1000();
        if (expected5 == actual5) {
            System.out.println("Passed test #5.2, numDecsTop1000()");
        } else {
            System.out.println("Failed test #5.2, numDecsTop1000()");
        }

        // Test #6, allTop1000()
        boolean expected6 = false;
        boolean actual6 = test1.allTop1000();
        if (expected6 == actual6) {
            System.out.println("Passed test #6.1, allTop1000()");
        } else {
            System.out.println("Failed test #6.1, allTop1000()");
        }
        expected6 = true;
        actual6 = test3.allTop1000();
        if (expected6 == actual6) {
            System.out.println("Passed test #6.2, allTop1000()");
        } else {
            System.out.println("Failed test #6.2, allTop1000()");
        }

        // Test #7, oneTop1000()
        boolean expected7 = false;
        boolean actual7 = test1.oneTop1000();
        if (expected7 == actual7) {
            System.out.println("Passed test #7.1, oneTop1000()");
        } else {
            System.out.println("Failed test #7.1, oneTop1000()");
        }
        expected7 = true;
        actual7 = test4.oneTop1000();
        if (expected7 == actual7) {
            System.out.println("Passed test #7.2, oneTop1000()");
        } else {
            System.out.println("Failed test #7.2, oneTop1000()");
        }

        // Test #8, morePopular()
        boolean expected8 = false;
        boolean actual8 = test1.morePopular();
        if (expected8 == actual8) {
            System.out.println("Passed test #8.1, morePopular()");
        } else {
            System.out.println("Failed test #8.1, morePopular()");
        }
        expected8 = true;
        actual8 = test5.morePopular();
        if (expected8 == actual8) {
            System.out.println("Passed test #8.2, morePopular()");
        } else {
            System.out.println("Failed test #8.2, morePopular()");
        }

        // Test #9, lessPopular()
        boolean expected9 = false;
        boolean actual9 = test1.lessPopular();
        if (expected9 == actual9) {
            System.out.println("Passed test #9.1, morePopular()");
        } else {
            System.out.println("Failed test #9.1, morePopular()");
        }
        expected9 = true;
        actual9 = test6.lessPopular();
        if (expected9 == actual9) {
            System.out.println("Passed test #9.2, morePopular()");
        } else {
            System.out.println("Failed test #9.2, morePopular()");
        }

        // Test #10, toString()
        String expected10 = "A\n" +
                "1900: 83\n" +
                "1910: 140\n" +
                "1920: 228\n" +
                "1930: 286\n" +
                "1940: 426\n" +
                "1950: 612\n" +
                "1960: 486\n" +
                "1970: 577\n" +
                "1980: 836\n" +
                "1990: 0\n" +
                "2000: 0\n";
        String actual10 = test1.toString();
        if (expected10.equals(actual10)) {
            System.out.println("Passed test #10.1, toString()");
        } else {
            System.out.println("Failed test #10.1, toString()");
        }
        expected10 = "Aaliyah\n" +
                "1900: 0\n" +
                "1910: 0\n" +
                "1920: 0\n" +
                "1930: 0\n" +
                "1940: 0\n" +
                "1950: 0\n" +
                "1960: 0\n" +
                "1970: 0\n" +
                "1980: 0\n" +
                "1990: 380\n" +
                "2000: 215\n";
        actual10 = test2.toString();
        if (expected10.equals(actual10)) {
            System.out.println("Passed test #10.2, toString()");
        } else {
            System.out.println("Failed test #10.2, toString()");
        }

    }

    // A few simple tests for the Names and NameRecord class.
    public static void simpleTest() {
        // raw data for Jake. Alter as necessary for your NameRecord
        String jakeRawData = "Jake 262 312 323 479 484 630 751 453 225 117 97";
        String[] s = jakeRawData.split(" ");
        String name = s[0];
        int[] ranks = new int[11];
        for (int i = 0; i < 11; i++) {
            ranks[i] = Integer.parseInt(s[i + 1]);
        }
        int baseDecade = 1900;
        NameRecord jakeRecord = new NameRecord(name, baseDecade, ranks);
        // complete with your constructor
        String expected = "Jake\n1900: 262\n1910: 312\n1920: 323\n1930: " +
                "479\n1940: "
                + "484\n1950: 630\n1960: 751\n1970: 453\n1980: 225\n1990: "
                + "117\n2000: 97\n";
        String actual = jakeRecord.toString();
        System.out.println("expected string:\n" + expected);
        System.out.println("actual string:\n" + actual);
        if (expected.equals(actual)) {
            System.out.println("passed Jake toString test.");
        } else {
            System.out.println("FAILED Jake toString test.");
        }

        // Some getName Tests

//        Names names = new Names(getFileScannerForNames(NAME_FILE));
//        String[] testNames = {"Isabelle", "isabelle", "sel",
//                "X1178", "ZZ", "via", "kelly"};
//        boolean[] expectNull = {false, false, true, true, true, true, false};
//        for (int i = 0; i < testNames.length; i++) {
//            performGetNameTest(names, testNames[i], expectNull[i]);
//        }
    }

    // Checks if given name is present in Names.
    private static void performGetNameTest(Names names, String name,
                                           boolean expectNull) {

        System.out.println("Performing test for this name: " + name);
        if (expectNull) {
            System.out.println("Expected return value is null");
        } else {
            System.out.println("Expected return value is not null");
        }
        NameRecord result = names.getName(name);
        if ((expectNull && result == null) || (!expectNull && result != null)) {
            System.out.println("PASSED TEST.");
        } else {
            System.out.println("Failed test");
        }
    }

    // main method. Driver for the whole program
    public static void main(String[] args) throws FileNotFoundException {
        // Alter name of file to try different data sources.
        final String NAME_FILE = "names4";
        Scanner fileScanner = getFileScannerForNames(NAME_FILE);
        Names namesDatabase = new Names(fileScanner);
        fileScanner.close();
        runOptions(namesDatabase);
    }

    /* pre: namesDatabase != null
     * Ask user for options to perform on the given Names object.
     * Creates a Scanner connected to System.in.
     */
    private static void runOptions(Names namesDatabase) {
        Scanner keyboard = new Scanner(System.in);
        MenuChoices[] menuChoices = MenuChoices.values();
        MenuChoices menuChoice;
        do {
            showMenu();
            int userChoice = getChoice(keyboard) - 1;
            menuChoice = menuChoices[userChoice];
            if (menuChoice == MenuChoices.SEARCH) {
                search(namesDatabase, keyboard);
            } else if (menuChoice == MenuChoices.ONE_NAME) {
                oneName(namesDatabase, keyboard);
            } else if (menuChoice == MenuChoices.APPEAR_ONCE) {
                appearOnce(namesDatabase);
            } else if (menuChoice == MenuChoices.APPEAR_ALWAYS) {
                appearAlways(namesDatabase);
            } else if (menuChoice == MenuChoices.ALWAYS_MORE) {
                alwaysMore(namesDatabase);
            } else if (menuChoice == MenuChoices.ALWAYS_LESS) {
                alwaysLess(namesDatabase);
            } else if (menuChoice == MenuChoices.STUDENT_SEARCH) {
                rankRange200(namesDatabase);
            }
        } while (menuChoice != MenuChoices.QUIT);
        keyboard.close();
    }

    /* Create a Scanner and return connected to a File with the given name.
     * pre: fileName != null
     * post: Return a Scanner connected to the file or null
     * if the File does not exist in the current directory.
     */
    private static Scanner getFileScannerForNames(String fileName) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("\n***** ERROR IN READING FILE ***** ");
            System.out.println("Can't find this file "
                    + fileName + " in the current directory.");
            System.out.println("Error: " + e);
            String currentDir = System.getProperty("user.dir");
            System.out
                    .println("Be sure " + fileName + " is in this directory: ");
            System.out.println(currentDir);
            System.out.println("\nReturning null from method.");
            sc = null;
        }
        return sc;
    }

    /**
     * Display the names that have been ranked every decade and
     * have a difference of less than 201 between their best and
     * worst ranks
     *
     * @param namesDatabase != null
     *                      post: print out the names that have been ranked every decade
     *                      and have a difference of less than 201 between their best and
     *                      worst ranks
     */
    private static void rankRange200(Names namesDatabase) {
        if (namesDatabase == null) {
            throw new IllegalArgumentException(
                    "The parameter namesDatabase cannot be null");
        }

        ArrayList<String> within200 = namesDatabase.ranksWithin200();
        System.out.println(within200.size() + " names have a difference " +
                "of 200 or " +
                "less between their best and worst rank. The names are:");
        for (String s : within200) {
            System.out.println(s);
        }
    }

    /* Display the names that have appeared in every decade.
     * pre: n != null
     * post: print out names that have appeared in ever decade
     */
    private static void appearAlways(Names namesDatabase) {
        if (namesDatabase == null) {
            throw new IllegalArgumentException(
                    "The parameter namesDatabase cannot be null");
        }

        ArrayList<String> everyDec = namesDatabase.rankedEveryDecade();
        System.out.println(everyDec.size() + " names appear in every " +
                "decade. The names are:");
        for (String s : everyDec) {
            System.out.println(s);
        }
    }

    /* Display the names that have appeared in only one decade.
     * pre: n != null
     * post: print out names that have appeared in only one decade
     */
    private static void appearOnce(Names namesDatabase) {
        if (namesDatabase == null) {
            throw new IllegalArgumentException("The parameter"
                    + " namesDatabase cannot be null");
        }

        ArrayList<String> oneDec = namesDatabase.rankedOnlyOneDecade();
        System.out.println(oneDec.size() + " names appear in exactly one " +
                "decade. The names are:");
        for (String s : oneDec) {
            System.out.println(s);
        }
    }

    /* Display the names that have gotten more popular
     * in each successive decade.
     * pre: n != null
     * post: print out names that have gotten more popular in each decade
     */
    private static void alwaysMore(Names namesDatabase) {
        if (namesDatabase == null) {
            throw new IllegalArgumentException("The parameter"
                    + " namesDatabase cannot be null");
        }

        ArrayList<String> morePop = namesDatabase.alwaysMorePopular();
        System.out
                .println(morePop.size() + " names are more popular in every " +
                        "decade.");
        for (String s : morePop) {
            System.out.println(s);
        }
    }

    /* Display the names that have gotten less popular
     * in each successive decade.
     * pre: n != null
     * post: print out names that have gotten less popular in each decade
     */
    private static void alwaysLess(Names namesDatabase) {
        if (namesDatabase == null) {
            throw new IllegalArgumentException("The parameter"
                    + " namesDatabase cannot be null");
        }

        ArrayList<String> lessPop = namesDatabase.alwaysLessPopular();
        System.out
                .println(lessPop.size() + " names are less popular in every " +
                        "decade.");
        for (String s : lessPop) {
            System.out.println(s);
        }
    }

    /* Display the data for one name or state that name has never been ranked.
     * pre: n != null, keyboard != null and is connected to System.in
     * post: print out the data for n or a message that n has never been in the
     * top 1000 for any decade
     */
    private static void oneName(Names namesDatabase, Scanner keyboard) {
        // Note, no way to check if keyboard actually connected to System.in
        // so we simply assume it is.
        if (namesDatabase == null || keyboard == null) {
            throw new IllegalArgumentException("The parameters cannot be null");
        }

        System.out.print("Enter a name: ");
        String name = keyboard.nextLine();
        System.out.println();
        NameRecord match = namesDatabase.getName(name);
        if (match == null) {
            System.out.println(name + " does not appear in any decade.");
        } else {
            System.out.println(match);
        }
    }

    /* Display all names that contain a substring from the user
     * and the decade they were most popular.
     * pre: n != null, keyboard != null and is connected to System.in
     * post: display the data for each name.
     */
    private static void search(Names namesDatabase, Scanner keyboard) {
        // Note, no way to check if keyboard actually connected to System.in
        // so we simply assume it is.
        if (namesDatabase == null || keyboard == null) {
            throw new IllegalArgumentException("The parameters cannot be null");
        }

        System.out.print("Enter a partial name: ");
        String partial = keyboard.nextLine();
        System.out.println();
        ArrayList<NameRecord> matches = namesDatabase.getMatches(partial);
        System.out.println(
                "There are " + matches.size() + " matches for " + partial +
                        ".");
        System.out.println(
                "\nThe matches with their highest ranking decade are:");
        for (NameRecord rec : matches) {
            System.out.println(rec.getName() + " " + rec.getBestDecade());
        }
    }

    /* Get choice from the user keyboard != null and is connected to System.in
     * return an int that is >= MenuChoices.SEARCH.ordinal()
     *  and <= MenuChoices.QUIT.ordinal().
     */
    private static int getChoice(Scanner keyboard) {
        // Note, no way to check if keyboard actually connected to System.in
        // so we simply assume it is.
        if (keyboard == null) {
            throw new IllegalArgumentException(
                    "The parameter keyboard cannot be null");
        }
        int choice = getInt(keyboard, "Enter choice: ");
        keyboard.nextLine();
        // Add one due to zero based indexing of enums, but 1 based indexing of menu.
        final int MAX_CHOICE = MenuChoices.QUIT.ordinal() + 1;
        while (choice < 1 || choice > MAX_CHOICE) {
            System.out.println();
            System.out.println(choice + " is not a valid choice");
            choice = getInt(keyboard, "Enter choice: ");
            keyboard.nextLine();
        }
        return choice;
    }

    /* Ensure an int is entered from the keyboard.
     * pre: s != null and is connected to System.in
     * post: return the int typed in by the user.
     */
    private static int getInt(Scanner s, String prompt) {
        // Note, no way to check if keyboard actually connected to System.in
        // so we simply assume it is.
        if (s == null) {
            throw new IllegalArgumentException(
                    "The parameter s cannot be null");
        }
        System.out.print(prompt);
        while (!s.hasNextInt()) {
            s.next();
            System.out.println("That was not an int.");
            System.out.print(prompt);
        }
        return s.nextInt();
    }

    // Show the user the menu.
    private static void showMenu() {
        System.out.println();
        System.out.println("Options:");
        System.out.println("Enter 1 to search for names.");
        System.out.println("Enter 2 to display data for one name.");
        System.out.println("Enter 3 to display all names that appear in only "
                + "one decade.");
        System.out.println("Enter 4 to display all names that appear in all "
                + "decades.");
        System.out.println("Enter 5 to display all names that are more popular "
                + "in every decade.");
        System.out.println("Enter 6 to display all names that are less popular "
                + "in every decade.");
        System.out
                .println("Enter 7 to display all names that have a difference "
                        + "of 200 or less between their best and worst ranks");
        System.out.println("Enter 8 to quit.");
        System.out.println();
    }

    /**
     * An enumerated type to hold the menu choices
     * for the NameSurfer program.
     */
    private enum MenuChoices {
        SEARCH,
        ONE_NAME,
        APPEAR_ONCE,
        APPEAR_ALWAYS,
        ALWAYS_MORE,
        ALWAYS_LESS,
        STUDENT_SEARCH,
        QUIT
    }
}