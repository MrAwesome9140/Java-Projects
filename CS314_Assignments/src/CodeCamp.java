//  CodeCamp.java - CS314 Assignment 1

/*  Student information for assignment:
 *
 *  replace <NAME> with your name.
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

import java.util.Random;

public class CodeCamp {

    /**
     * Determine the Hamming distance between two arrays of ints. 
     * Neither the parameter <tt>aData</tt> or
     * <tt>bData</tt> are altered as a result of this method.<br>
     * @param aData != null, aData.length == aData.length
     * @param bData != null
     * @return the Hamming Distance between the two arrays of ints.
     */
    public static int hammingDistance(int[] aData, int[] bData) {
        // check preconditions
        if (aData == null || bData == null || aData.length != bData.length) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "hammingDistance. neither parameter may equal null, arrays" +
                    " must be equal length.");
        }

        int difs = 0;
        for(int i = 0; i<aData.length; i++){
            if(aData[i] != bData[i])
                difs++;
        }

        return difs;
    }


    /**
     * Determine if one array of ints is a permutation of another.
     * Neither the parameter <tt>aData</tt> or 
     * the parameter <tt>bData</tt> are altered as a result of this method.<br>
     * @param aData != null
     * @param bData != null
     * @return <tt>true</tt> if aData is a permutation of bData, 
     * <tt>false</tt> otherwise
     *
     */
    public static boolean isPermutation(int[] aData, int[] bData) {
        // check preconditions
        if (aData == null || bData == null) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "isPermutation. neither parameter may equal null.");
        }

        if(aData.length != bData.length)
            return false;

        // Copy contents of aData and bData to new arrays
        int[] aCopy = new int[aData.length], bCopy = new int[bData.length];
        for(int i = 0; i<aData.length; i++){
            aCopy[i] = aData[i];
            bCopy[i] = bData[i];
        }

        // Sort copied arrays and compare for differences
        sort(aCopy);
        sort(bCopy);

        boolean perm = true;
        for(int i = 0; i<aData.length && perm; i++){
            if(aCopy[i] != bCopy[i])
                perm = false;
        }

        return perm;
    }


    /**
     * Sorts an array of integers in increasing order
     * pre: a != null
     * post: a[i+1] >= a[i] for all integers 0 <= i < a.length
     * @param a the array to sort
     */
    private static void sort(int[] a){
        //check preconditions
        if(a == null){
            throw new IllegalArgumentException("Integer array a cannot be null");
        }

        for(int i = 0; i<a.length-1; i++){

            // Find the index of the minimum int at a position greater than i
            int minIndex = i;
            for(int j = i+1; j<a.length; j++){
                if(a[j]<a[minIndex])
                    minIndex = j;
            }

            // Swap integer at i and the smallest integer at an index greater than i
            if(minIndex != i){
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }
    }

    /**
     * Determine the index of the String that 
     * has the largest number of vowels. 
     * Vowels are defined as <tt>'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 
     * 'U', and 'u'</tt>.
     * The parameter <tt>arrayOfStrings</tt> is not altered as a result of this method.
     * <p>pre: <tt>arrayOfStrings != null</tt>, <tt>arrayOfStrings.length > 0</tt>, 
     * there is an least 1 non null element in arrayOfStrings.
     * <p>post: return the index of the non-null element in arrayOfStrings that has the 
     * largest number of characters that are vowels.
     * If there is a tie return the index closest to zero. 
     * The empty String, "", has zero vowels.
     * It is possible for the maximum number of vowels to be 0.<br>
     * @param arrayOfStrings the array to check
     * @return the index of the non-null element in arrayOfStrings that has 
     * the largest number of vowels.
     */
    public static int mostVowels(String[] arrayOfStrings) {
        // check preconditions
        if (arrayOfStrings == null || arrayOfStrings.length == 0 || !atLeastOneNonNull(arrayOfStrings)) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "mostVowels. parameter may not equal null and must contain " +
                    "at least one none null value.");
        }

        int lowIndex = 0;
        int mVowels = -1;
        for(int i = 0; i<arrayOfStrings.length; i++){
            if(arrayOfStrings[i] != null) {
                String copy = arrayOfStrings[i].toLowerCase();
                int numVowels = 0;

                // Iterate through the characters in String copy and count the number of vowels
                for (int j = 0; j < copy.length(); j++) {
                    char c = copy.charAt(j);
                    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                        numVowels++;
                }
                if (numVowels > mVowels) {
                    lowIndex = i;
                    mVowels = numVowels;
                }
            }
        }

        return lowIndex;
    }



    /**
     * Perform an experiment simulating the birthday problem.
     * Pick random birthdays for the given number of people. 
     * Return the number of pairs of people that share the
     * same birthday.<br>
     * @param numPeople The number of people in the experiment.
     * This value must be > 0
     * @param numDaysInYear The number of days in the year for this experiement.
     * This value must be > 0
     * @return The number of pairs of people that share a birthday 
     * after running the simulation.
     */
    public static int sharedBirthdays(int numPeople, int numDaysInYear) {
        // check preconditions
        if (numPeople <= 0 || numDaysInYear <= 0) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "sharedBirthdays. both parameters must be greater than 0. " +
                    "numPeople: " + numPeople +
                    ", numDaysInYear: " + numDaysInYear);
        }

        // Create an array to store the birthdays and generate a random int
        // less between and including 0 and numDaysInYear-1 to represent each
        // person's birthday
        int[] birthdays = new int[numPeople];
        for(int i = 0; i<numPeople; i++){
            birthdays[i] = (int) (Math.random() * numDaysInYear);
        }

        // Iterate through all people at an index greater than i to check for
        // birthday pairs
        int numPairs = 0;
        for(int i = 0; i<numPeople-1; i++){
            for(int j = i+1; j<numPeople; j++){
                if(birthdays[i] == birthdays[j])
                    numPairs++;
            }
        }

        return numPairs;
    }


    /**
     * Determine if the chess board represented by board is a safe set up.
     * <p>pre: board != null, board.length > 0, board is a square matrix.
     * (In other words all rows in board have board.length columns.),
     * all elements of board == 'q' or '.'. 'q's represent queens, '.'s
     * represent open spaces.<br>
     * <p>post: return true if the configuration of board is safe,
     * that is no queen can attack any other queen on the board.
     * false otherwise.
     * the parameter <tt>board</tt> is not altered as a result of 
     * this method.<br>
     * @param board the chessboard
     * @return true if the configuration of board is safe,
     * that is no queen can attack any other queen on the board.
     * false otherwise.
     */
    public static boolean queensAreSafe(char[][] board) {
        char[] validChars = {'q', '.'};
        // check preconditions
        if (board == null || board.length == 0 || !isSquare(board)
                || !onlyContains(board, validChars)) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "queensAreSafe. The board may not be null, must be square, " +
                    "and may only contain 'q's and '.'s");
        }

        // Look for spaces on the board with a queen and check if
        // each queen is safe through the isSafe method
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board.length; j++){
                if(board[i][j] == 'q'){
                    boolean safe = isSafe(board, i, j);
                    if(!safe)
                        return false;
                }
            }
        }

        return true;
    }

    /**
     * pre: board != null, 0 <= row < board.length, 0 <= col < board.length
     * @param board the chessboard being checked
     * @param row the row that the queen is on
     * @param col the column that the queen is on
     * @return true if the queen a position board[row][col] is safe, and false otherwise
     */
    private static boolean isSafe(char[][] board, int row, int col){
        if(!(row >= 0 && row < board.length && col >= 0 && col < board.length && board != null)){
            throw new IllegalArgumentException("Violation of pre-conditions, row and col must both " +
                    "be greater than or equal to 0 and less than the number of rows in board");
        }

        // Find the row and column at which to start the upper left diagonal
        int startRow1 = Math.max(0, row-col), startCol1 = Math.max(0, col-row);

        // Find the row and column at which to start the bottom left diagonal
        int startRow2 = Math.min(board.length-1, row+col), startCol2 = Math.max(0, col-(board.length-1-row));

        // Check the row, column, and diagonals that the queen is on to see
        // if there is another queen on any of them
        for(int i = 0; i<board.length; i++){
            if(i != row && board[i][col] == 'q')
                return false;
            if(i != col && board[row][i] == 'q')
                return false;
            if(startRow1+i != row && startRow1+i < board.length && startCol1+i != col && startCol1+i < board.length && board[startRow1+i][startCol1+i] == 'q')
                return false;
            if(startRow2-i != row && startRow2-i >= 0 && startCol2+i != col && startCol2+i < board.length && board[startRow2-i][startCol2+i] == 'q')
                return false;
        }

        return true;
    }

    /**
     * Given a 2D array of ints return the value of the
     * most valuable contiguous sub rectangle in the 2D array.
     * The sub rectangle must be at least 1 by 1. 
     * <p>pre: <tt>mat != null, mat.length > 0, mat[0].length > 0,
     * mat</tt> is a rectangular matrix.
     * <p>post: return the value of the most valuable contiguous sub rectangle
     * in <tt>city</tt>.<br>
     * @param city The 2D array of ints representing the value of
     * each block in a portion of a city.
     * @return return the value of the most valuable contiguous sub rectangle
     * in <tt>city</tt>.
     */
    public static int getValueOfMostValuablePlot(int[][] city) {
        // check preconditions
        if (city == null || city.length == 0 || city[0].length == 0
                || !isRectangular(city) ) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "getValueOfMostValuablePlot. The parameter may not be null," +
                    " must value at least one row and at least" +
                    " one column, and must be rectangular.");
        }

        int sol = Integer.MIN_VALUE;

        // Create int array that stores the sum of all ints towards the left and above any given pair of indices
        int[][] vals = new int[city.length][];

        for(int i = 0; i<city.length; i++){
            vals[i] = new int[city[i].length];
            for(int j = 0; j<city[i].length; j++){

                // value stores the sum of all ints towards the left of and above position
                // city[i][j] including the value of city[i][j] itself
                int value = city[i][j];
                if(i>0)
                    value += vals[i-1][j];
                if(j>0)
                    value += vals[i][j-1];
                if(i>0 && j>0)
                    value -= vals[i-1][j-1];
                vals[i][j] = value;

                // Replace sol with a greater value if a sub-rectangle with a greater total value
                // is found
                sol = Math.max(sol, Math.max(mostValSubPlot(vals, i, j, sol), Math.max(value, city[i][j])));
            }
        }
        return sol;
    }

    /**
     * pre: vals != null, 0 <= i < vals.length, 0 <= j < vals[0].length
     * @param vals the matrix storing the sums of all ints towards the left and above any given pair of indices
     * @param i the current row
     * @param j the current column
     * @param curSol the value of the most valuable sub-rectangle found so far
     * @return the most valuable sub-rectangle with a bottom right vertex of city[i][j]
     */
    private static int mostValSubPlot(int[][] vals, int i, int j, int curSol){
        if(vals == null || i < 0 || i >= vals.length || j < 0 || j > vals[0].length){
            throw new IllegalArgumentException("Integer matrix vals cannot be null, integer i must be" +
                    "between 0 and vals.length-1, and integer j must be between 0 and vals[0].length-1");
        }

        int sol = curSol;
        int value = vals[i][j];

        // Compute the values of all sub-rectangles with a bottom right vertex of
        // vals[i][j] and assign the largest val to sol
        for(int k = i; k>=0; k--){
            for(int p = j; p>=0; p--){
                if(k != i || p != j) {
                    if (k > 0 && p > 0) {
                        sol = Math.max(value + vals[k - 1][p - 1] - vals[i][p - 1] - vals[k - 1][j], sol);
                    }
                    else if (k > 0) {
                        sol = Math.max(sol, value - vals[k - 1][j]);
                    }
                    else if (p > 0) {
                        sol = Math.max(sol, value - vals[i][p - 1]);
                    }
                }
            }
        }
        return sol;
    }

    // !!!!! ***** !!!!! ***** !!!!! ****** !!!!! ****** !!!!! ****** !!!!!!
    // CS314 STUDENTS: Put your birthday problem experiment code here:

    public static void birthdaysExperiment(){

        // Compute and print the average number of pairs with 182 people and 365 days in
        // a year
        long totPairs = 0;
        for(int i = 0; i < 1_000_000; i++){
            totPairs += sharedBirthdays(182, 365);
        }
        System.out.println("The average # of pairs is: " + (totPairs/1_000_000.0)+"\n");

        // Compute and print the number of experiments with at least one pair assuming
        // 365 days in a year and 2 to 100 people
        totPairs = 0;
        for(int i = 2; i <= 100; i++){
            int numAtLeastOne = 0;
            for(int k = 0; k < 50_000; k++){
                int pairs = sharedBirthdays(i, 365);
                if(pairs > 0)
                    numAtLeastOne++;
                totPairs += pairs;
            }
            double percentage = Math.round(numAtLeastOne/50_000.0*100*100)/100.0;
            System.out.println(" * " + "Num people: " + i
                    + ", number of experiments with one or more shared birthday: "
                    + numAtLeastOne + ", percentage: " + percentage);
        }
    }

    /*
     * pre: arrayOfStrings != null
     * post: return true if at least one element in arrayOfStrings is
     * not null, otherwise return false.
     */
    private static boolean atLeastOneNonNull(String[] arrayOfStrings) {
        // check precondition
        if (arrayOfStrings == null) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "atLeastOneNonNull. parameter may not equal null.");
        }
        boolean foundNonNull = false;
        int i = 0;
        while( !foundNonNull && i < arrayOfStrings.length ) {
            foundNonNull = arrayOfStrings[i] != null;
            i++;
        }
        return foundNonNull;
    }


    /*
     * pre: mat != null
     * post: return true if mat is a square matrix, false otherwise
     */
    private static boolean isSquare(char[][] mat) {
        if (mat == null) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "isSquare. Parameter may not be null.");
        }
        final int numRows = mat.length;
        int row = 0;
        boolean isSquare = true;
        while (isSquare && row < numRows) {
            isSquare = ( mat[row] != null) && (mat[row].length == numRows);
            row++;
        }
        return isSquare;
    }


    /*
     * pre: mat != null, valid != null
     * post: return true if all elements in mat are one of the
     * characters in valid
     */
    private static boolean onlyContains(char[][] mat, char[] valid) {
        // check preconditions
        if (mat == null || valid == null) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "onlyContains. Parameters may not be null.");
        }
        String validChars = new String(valid);
        int row = 0;
        boolean onlyContainsValidChars = true;
        while (onlyContainsValidChars && row < mat.length) {
            int col = 0;
            while(onlyContainsValidChars && col < mat[row].length) {
                int indexOfChar = validChars.indexOf(mat[row][col]);
                onlyContainsValidChars = indexOfChar != -1;
                col++;
            }
            row++;
        }
        return onlyContainsValidChars;
    }


    /*
     * pre: mat != null, mat.length > 0
     * post: return true if mat is rectangular
     */
    private static boolean isRectangular(int[][] mat) {
        // check preconditions
        if (mat == null || mat.length == 0) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "isRectangular. Parameter may not be null and must contain" +
                    " at least one row.");
        }
        boolean correct = mat[0] != null;
        int row = 0;
        while(correct && row < mat.length) {
            correct = (mat[row] != null)
                    && (mat[row].length == mat[0].length);
            row++;
        }
        return correct;
    }

    // make constructor private so no instances of CodeCamp can not be created
    private CodeCamp() {

    }
}