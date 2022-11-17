/*  Student information for assignment:
 *
 *  On MY honor, Aaroh Sharma,
 *  this programming assignment is MY own work
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


//imports

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Various recursive methods to be implemented.
 * Given shell file for CS314 assignment.
 */
public class Recursive {

    static final int CARPET_DIVISION = 3;
    static final int[][] aroundPoint = new int[][]{{0, 1}, {1, 0}, {0, -1},
            {-1, 0}};
    final static char COIN = '$';


    // CS314 students, add your nextIsDouble helper method here
    final static char START = 'S';
    final static char EXIT = 'E';
    final static char YELLOW = 'Y';
    final static char GREEN = 'G';
    final static char IMPASSABLE = '*';
    // used by method digitLetters
    /* Static code blocks are run once when this class is loaded.
     * Here we create an unmoddifiable list to use with the phone
     * mnemonics method.
     */
    private static final List<String> LETTERS_FOR_NUMBER;

    static {
        String[] letters = {"0", "1", "ABC",
                "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
        ArrayList<String> lettersAsList = new ArrayList<>();
        for (String s : letters) {
            lettersAsList.add(s);
        }
        LETTERS_FOR_NUMBER = Collections.unmodifiableList(lettersAsList);

    }

    /**
     * Problem 1: convert a base 10 int to binary recursively.
     * <br>pre: n != Integer.MIN_VALUE<br>
     * <br>post: Returns a String that represents N in binary.
     * All chars in returned String are '1's or '0's.
     * Most significant digit is at position 0
     *
     * @param n the base 10 int to convert to base 2
     * @return a String that is a binary representation of the parameter n
     */
    public static String getBinary(int n) {
        if (n == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "getBinary. n cannot equal "
                    + "Integer.MIN_VALUE. n: " + n);
        }

        // Base Case: n is between -1 and 1, we are at the last digit of the
        // binary number
        if (n == 0) {
            return "0";
        } else if (n == 1) {
            return "1";
        } else if (n == -1) {
            return "-1";
        }

        // Recursive Step: Get the digits of the binary number that come
        // before this digit
        String sol = getBinary(n / 2);
        if (Math.abs(n) % 2 == 1) {
            sol += "1";
        } else {
            sol += "0";
        }


        return sol;
    }

    /**
     * Problem 2: reverse a String recursively.<br>
     * pre: stringToRev != null<br>
     * post: returns a String that is the reverse of stringToRev
     *
     * @param stringToRev the String to reverse.
     * @return a String with the characters in stringToRev
     * in reverse order.
     */
    public static String revString(String stringToRev) {
        if (stringToRev == null) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "revString. parameter may not be null.");
        }

        // Base Case: String stringToRev is empty, return an empty String
        if (stringToRev.length() == 0) {
            return "";
        }

        // Recursive Step: Get the rest of the String after this
        // character reversed and add the current character to the end of the
        // String
        return revString(stringToRev.substring(1)) + stringToRev.charAt(0);
    }

    /**
     * Problem 3: Returns the number of elements in data
     * that are followed directly by value that is
     * double that element.
     * pre: data != null
     * post: return the number of elements in data
     * that are followed immediately by double the value
     *
     * @param data The array to search.
     * @return The number of elements in data that
     * are followed immediately by a value that is double the element.
     */
    public static int nextIsDouble(int[] data) {
        if (data == null) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "revString. parameter may not be null.");
        }
        return doubleHelper(data, 1); // Change as necessary. Write a helper
        // method.
    }

    /**
     * Returns the number of ints in int[] data that are exactly double of
     * the int that precedes it through recursive calls that check all the
     * ints from curInd + 1 to data.length - 1
     *
     * @param data   the int array to check; data != null
     * @param curInd the current index being checked
     * @return the number of ints in int[] data that are exactly double of
     * the int that precedes it
     */
    private static int doubleHelper(int[] data, int curInd) {

        // Base case, reached the end of the int[] data
        if (curInd == data.length) {
            return 0;
        }

        // Recursive step, check the indices following curInd for any doubles
        // and add 1 to the result if the current index is double of the
        // previous index afterwards
        int sum = doubleHelper(data, curInd + 1);
        sum += data[curInd - 1] * 2 == data[curInd] ? 1 : 0;
        return sum;
    }

    /**
     * Problem 4: Find all combinations of mnemonics
     * for the given number.<br>
     * pre: number != null, number.length() > 0,
     * all characters in number are digits<br>
     * post: see tips section of assignment handout
     *
     * @param number The number to find mnemonics for
     * @return An ArrayList<String> with all possible mnemonics
     * for the given number
     */
    public static ArrayList<String> listMnemonics(String number) {
        if (number == null || number.length() == 0 || !allDigits(number)) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "listMnemonics");
        }

        ArrayList<String> results = new ArrayList<>(); // to store the mnemonics
        recursiveMnemonics(results, "", number);
        return results;
    }

    /*
     * Helper method for listMnemonics
     * mnemonics stores completed mnemonics
     * mneominicSoFar is a partial (possibly complete) mnemonic
     * digitsLeft are the digits that have not been used
     * from the original number.
     */
    private static void recursiveMnemonics(ArrayList<String> mnemonics,
                                           String mnemonicSoFar,
                                           String digitsLeft) {

        // Base Case: All the digits in the string have been checked, the
        // mnemonic is complete
        if (digitsLeft.length() == 0) {
            mnemonics.add(mnemonicSoFar);
        } else {
            String options = digitLetters(digitsLeft.charAt(0));
            for (int i = 0; i < options.length(); i++) {
                String temp = mnemonicSoFar + options.charAt(i);

                // Recursive Step: Pass the mnenonic made from the character
                // checked in this method call and pass the string of
                // digitsLeft without the character just checked
                recursiveMnemonics(mnemonics, temp, digitsLeft.substring(1));
            }
        }
    }

    /* helper method for recursiveMnemonics
     * pre: ch is a digit '0' through '9'
     * post: return the characters associated with
     * this digit on a phone keypad
     */
    private static String digitLetters(char ch) {
        if (ch < '0' || ch > '9') {
            throw new IllegalArgumentException("parameter "
                    + "ch must be a digit, 0 to 9. Given value = " + ch);
        }
        int index = ch - '0';
        return LETTERS_FOR_NUMBER.get(index);
    }

    /* helper method for listMnemonics
     * pre: s != null
     * post: return true if every character in s is
     * a digit ('0' through '9')
     */
    private static boolean allDigits(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "allDigits. String s cannot be null.");
        }
        boolean allDigits = true;
        int i = 0;
        while (i < s.length() && allDigits) {
            allDigits = s.charAt(i) >= '0' && s.charAt(i) <= '9';
            i++;
        }
        return allDigits;
    }

    /**
     * Problem 5: Draw a Sierpinski Carpet.
     *
     * @param size  the size in pixels of the window
     * @param limit the smallest size of a square in the carpet.
     */
    public static void drawCarpet(int size, int limit) {
        DrawingPanel p = new DrawingPanel(size, size);
        Graphics g = p.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, size, size);
        g.setColor(Color.WHITE);
        drawSquares(g, size, limit, 0, 0);
    }

    /* Helper method for drawCarpet
     * Draw the individual squares of the carpet.
     * @param g The Graphics object to use to fill rectangles
     * @param size the size of the current square
     * @param limit the smallest allowable size of squares
     * @param x the x coordinate of the upper left corner of the current square
     * @param y the y coordinate of the upper left corner of the current square
     */
    private static void drawSquares(Graphics g, int size, int limit,
                                    double x, double y) {

        // Base Case: The current size is less than the limit, do nothing
        if (size > limit) {
            int newSize = size / CARPET_DIVISION;
            for (int i = 0; i < CARPET_DIVISION; i++) {
                for (int j = 0; j < CARPET_DIVISION; j++) {
                    if (i != 1 || j != 1) {

                        // Recursive Step: Call this method on each of the 8
                        // squares created from dividing the current square
                        // into a 3 by 3 grid
                        drawSquares(g, size / CARPET_DIVISION, limit,
                                x + i * newSize,
                                y + j * newSize);
                    } else {
                        g.fillRect((int) (x + newSize), (int) (y + newSize),
                                newSize, newSize);
                    }
                }
            }
        }
    }

    /**
     * Problem 6: Determine if water at a given point
     * on a map can flow off the map.
     * <br>pre: map != null, map.length > 0,
     * map is a rectangular matrix, 0 <= row < map.length,
     * 0 <= col < map[0].length
     * <br>post: return true if a drop of water starting at the location
     * specified by row, column can reach the edge of the map,
     * false otherwise.
     *
     * @param map The elevations of a section of a map.
     * @param row The starting row of a drop of water.
     * @param col The starting column of a drop of water.
     * @return return true if a drop of water starting at the location
     * specified by row, column can reach the edge of the map, false otherwise.
     */
    public static boolean canFlowOffMap(int[][] map, int row, int col) {
        if (map == null || map.length == 0 || !isRectangular(map)
                || !inbounds(row, col, map)) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "canFlowOffMap");
        }

        return canFlowOffMapHelper(map, row, col);
    }

    /*
     * Helper method for canFlowOffMap, returns true if water can flow off
     * map starting from position (row, col) and false otherwise
     */
    private static boolean canFlowOffMapHelper(int[][] map, int row, int col) {

        // Base Case: We are off the grid, meaning we have flowed off the
        // map, return true
        if (row <= 0 || row >= map.length - 1 || col <= 0 ||
                col >= map[0].length - 1) {
            return true;
        }

        for (int i = 0; i < 4; i++) {
            if (map[row + aroundPoint[i][0]][col + aroundPoint[i][1]] <
                    map[row][col]) {
                // Recursive Step: Check if we can flow off the map by moving
                // to each cell around the current cell at a lower elevation
                boolean result = canFlowOffMap(map, row + aroundPoint[i][0],
                        col + aroundPoint[i][1]);
                if (result) {
                    return true;
                }
            }
        }

        return false;
    }

    /*
     * Helper method for canFlowOfMap - CS314 students you should not have to
     * call this method,
     * pre: mat != null,
     */
    private static boolean inbounds(int r, int c, int[][] mat) {
        if (mat == null) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "inbounds. The 2d array mat may not be null.");
        }
        return r >= 0 && r < mat.length && mat[r] != null
                && c >= 0 && c < mat[r].length;
    }

    /*
     * Helper method for canFlowOfMap - CS314 students you should not have to
     * call this method,
     * pre: mat != null, mat.length > 0
     * post: return true if mat is rectangular
     */
    private static boolean isRectangular(int[][] mat) {
        if (mat == null || mat.length == 0) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "inbounds. The 2d array mat may not be null "
                    + "and must have at least 1 row.");
        }
        boolean correct = true;
        final int numCols = mat[0].length;
        int row = 0;
        while (correct && row < mat.length) {
            correct = (mat[row] != null) && (mat[row].length == numCols);
            row++;
        }
        return correct;
    }

    /**
     * Problem 7: Find the minimum difference possible between teams
     * based on ability scores. The number of teams may be greater than 2.
     * The goal is to minimize the difference between the team with the
     * maximum total ability and the team with the minimum total ability.
     * <br> pre: numTeams >= 2, abilities != null, abilities.length >= numTeams
     * <br> post: return the minimum possible difference between the team
     * with the maximum total ability and the team with the minimum total
     * ability.
     *
     * @param numTeams  the number of teams to form.
     *                  Every team must have at least one member
     * @param abilities the ability scores of the people to distribute
     * @return return the minimum possible difference between the team
     * with the maximum total ability and the team with the minimum total
     * ability. The return value will be greater than or equal to 0.
     */
    public static int minDifference(int numTeams, int[] abilities) {
        ArrayList<Integer> tempAbilities = new ArrayList<>();
        for (int i : abilities) {
            tempAbilities.add(i);
        }
        ArrayList<Teams> teams = new ArrayList<>();
        for (int i = 0; i < numTeams; i++) {
            teams.add(new Teams());
        }
        return minDifHelper(numTeams, tempAbilities, teams, Integer.MAX_VALUE);
    }

    /*
     * Helper method for minDifference, returns the minimum possible value
     * for the maximum difference between two teams where every team has at
     * least one person and every person is on a team
     */
    private static int minDifHelper(int numTeams, ArrayList<Integer> abilities,
                                    ArrayList<Teams> teams, int curMin) {

        // Base Case: Everyone has been assigned to a team, return the
        // maximum difference in ability
        if (abilities.size() == 0) {
            return maxDif(teams);
        }

        int p = abilities.remove(0);
        for (int i = 0; i < numTeams; i++) {
            teams.get(i).add(p);

            // Recursive Step: Assign curMin to the value returned by
            // minDifHelper() if this combination of teams gives a lower
            // maximum difference
            curMin = Math.min(curMin,
                    minDifHelper(numTeams, abilities, teams, curMin));
            teams.get(i).remove(p);
        }
        abilities.add(0, p);

        return curMin;
    }

    /**
     * Return the maximum difference between two teams in ArrayList<Teams> teams
     *
     * @param teams a list of teams to find the maximum difference within
     * @return the maximum difference between two teams in ArrayList<Teams> teams
     */
    private static int maxDif(ArrayList<Teams> teams) {
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        for (Teams temp : teams) {
            if (temp.getNumPeople() == 0) {
                return Integer.MAX_VALUE;
            }
            maxSum = Math.max(maxSum, temp.getTotal());
            minSum = Math.min(minSum, temp.getTotal());
        }
        return maxSum - minSum;
    }

    /**
     * Problem 8: Maze solver.
     * <br>pre: board != null
     * <br>pre: board is a rectangular matrix
     * <br>pre: board only contains characters 'S', 'E', '$', 'G', 'Y', and '*'
     * <br>pre: there is a single 'S' character present
     * <br>post: rawMaze is not altered as a result of this method.
     * Return 2 if it is possible to escape the maze after
     * collecting all the coins.
     * Return 1 if it is possible to escape the maze
     * but without collecting all the coins.
     * Return 0 if it is not possible
     * to escape the maze. More details in the assignment handout.
     *
     * @param rawMaze represents the maze we want to escape.
     *                rawMaze is not altered as a result of this method.
     * @return per the post condition
     */
    public static int canEscapeMaze(char[][] rawMaze) {
        int numCoins = 0;
        int startRow = 0;
        int startCol = 0;

        // Find the number of coins in the maze and the start location
        for (int i = 0; i < rawMaze.length; i++) {
            for (int j = 0; j < rawMaze[0].length; j++) {
                char c = rawMaze[i][j];
                numCoins += c == COIN ? 1 : 0;
                if (c == START) {
                    startRow = i;
                    startCol = j;
                }
            }
        }
        return escapeMazeHelper(rawMaze, numCoins, startRow, startCol, 0);
    }

    /**
     * Helper method for the canEscapeMaze() method that returns 2 if the
     * maze can be escaped while collecting all coins, 1 if the maze can be
     * escaped without collecting all coins, and 0 otherwise
     */
    private static int escapeMazeHelper(char[][] rawMaze, int numCoins,
                                        int row, int col, int coinsFound) {

        // Base Case: Currently outside the maze (return 0) or at an exit
        // (return 2 if all coins have been found, return 1 otherwise)
        if (row < 0 || row >= rawMaze.length || col < 0 ||
                col >= rawMaze[0].length
                || rawMaze[row][col] == IMPASSABLE) {
            return 0;
        } else if (rawMaze[row][col] == EXIT) {
            if (numCoins == coinsFound) {
                return 2;
            } else {
                return 1;
            }
        }

        char prev = rawMaze[row][col];
        coinsFound = changeSpot(rawMaze, row, col, coinsFound);
        int ans = -1;
        for (int i = 0; i < 4 && ans != 2; i++) {
            int[] pos = aroundPoint[i];

            // Recursive Step: Assign ans to be the value returned by
            // escapeMazeHelper() if it is greater than the current value
            // because we want to return the maximum possible value
            ans = Math.max(ans, escapeMazeHelper(rawMaze, numCoins,
                    row + pos[0], col + pos[1], coinsFound));
        }
        rawMaze[row][col] = prev;
        return ans;
    }

    /**
     * Helper method for escapeMazeHelper() that changes the char at location
     * (row, col) assuming we are currently at that location and returns the
     * new number of coinsFound
     */
    private static int changeSpot(char[][] rawMaze, int row, int col,
                                  int coinsFound) {
        char prev = rawMaze[row][col];
        if (prev == START) {
            rawMaze[row][col] = GREEN;
        } else if (prev == GREEN) {
            rawMaze[row][col] = YELLOW;
        } else if (prev == YELLOW) {
            rawMaze[row][col] = IMPASSABLE;
        } else {
            coinsFound++;
            rawMaze[row][col] = YELLOW;
        }
        return coinsFound;
    }

    /**
     * A private class to store the number of people and the total ability of
     * a team
     */
    private static class Teams {

        private int numPeople;
        private int total;

        /**
         * Remove a person with ability n from the team
         *
         * @param n the ability of the person to be removed
         */
        public void remove(int n) {
            numPeople--;
            total -= n;
        }

        /**
         * Add a person with ability n to the team
         *
         * @param n the ability of the person added to the team
         */
        public void add(int n) {
            numPeople++;
            total += n;
        }

        /**
         * @return the number of people on this team
         */
        public int getNumPeople() {
            return numPeople;
        }

        /**
         * @return the total ability of this team
         */
        public int getTotal() {
            return total;
        }

    }
}