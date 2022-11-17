import java.util.Random;

/*  Student information for assignment:
 *
 *  UTEID: as225925
 *  email address: aaroh.sh@gmail.com
 *  Grader name: Brad
 *  Number of slip days I am using: 0
 */



/* CS314 Students. Put your experiment results and
 * answers to questions here.
 *
 * Experiment 1, Addition, Results:
 * Size: 1000x1000, Time elapsed: 1.8723664
 * Size: 2000x2000, Time elapsed: 7.4189243
 * Size: 4000x4000, Time elapsed: 30.587569
 *
 * Experiment 2, Multiplication, Results:
 * Size: 120x120, Time elapsed: 1.0334184
 * Size: 240x240, Time elapsed: 10.4100186
 * Size: 480x480, Time elapsed: 124.6418462
 *
 * Questions:
 * 1. The results of experiment 1 suggest that doubling the dimensions of the matrix
 *    quadruple the time to complete the operations. Based on these results, it follows
 *    that doubling the dimensions once again would lead to the experiment taking
 *    approximately 120 seconds.
 *
 * 2. By analysis of my code, the Big O of the addition function is O(N^2). This is supported
 *    by the timing data as doubling the dimensions approximately quadrupled the time to
 *    complete the operation, which is expected for an O(N^2) function.
 *
 * 3. The results of experiment 2 suggest that doubling the dimensions of the matrix
 *    lead to an 8 times increase in time elapsed. Based on these results, it follows
 *    that doubling the dimensions once again would lead to the experiment taking
 *    approximately 1000 seconds.
 *
 * 4. By analysis of my code, the Big O of the multiply function is O(N^3). This is supported
 *    by the timing data as doubling the dimensions cause the time the experiment takes to
 *    roughly increase by 8 times, which is expected for an O(N^3) function.
 *
 * 5. I could create a 22,200 by 22,200 matrix before running out of heap memory. This matrix
 *    takes up approximately 1971 megabytes. This is approximately 12.5% of my computer's RAM
 */

/**
 * A class to run tests on the MathMatrix class
 */
public class MathMatrixTester {

    /**
     * main method that runs simple test on the MathMatrix class
     *
     * @param args not used
     */
    public static void main(String[] args) {
        int[][] data1 = { {9, 0, 3},
                {7, 5, 2}};
        int[][] data2 = { {2, 4, 6, 7, 9},
                {8, 1, 9, 0, 1},
                {1, 3, 9, 2, 5}};
        int[][] data3 = { {7, 2, 6},
                {0, 1, 2}};
        int[][] data4 = { {4, 9},
                {1, 5},
                {0, 3}};
        int[][] data5 = { {-2, -4, -6, -7, -9},
                {-8, -1, -9, 0, -1},
                {-1, -3, -9, -2, -5}};
        int[][] e1;

        // test 1 and 2, getNumRows()
        MathMatrix mat1 = new MathMatrix(data1);
        int numRows = 2;
        if(mat1.getNumRows() == numRows){
            System.out.println("Passed test 1, getNumRows");
        }
        else {
            System.out.println("Failed test 1, getNumRows");
        }
        mat1 = new MathMatrix(new int[21][7]);
        numRows = 21;
        if(mat1.getNumRows() == numRows){
            System.out.println("Passed test 2, getNumRows");
        }
        else {
            System.out.println("Failed test 2, getNumRows");
        }

        // test 3 and 4, getNumColumns()
        mat1 = new MathMatrix(data1);
        int numCols = 3;
        if(mat1.getNumColumns() == numCols){
            System.out.println("Passed test 3, getNumColumns");
        }
        else {
            System.out.println("Failed test 3, getNumColumns");
        }
        mat1 = new MathMatrix(data2);
        numCols = 5;
        if(mat1.getNumColumns() == numCols){
            System.out.println("Passed test 4, getNumColumns");
        }
        else {
            System.out.println("Failed test 4, getNumColumns");
        }

        // test 5 and 6, getVal()
        int val = 9;
        int row = 2, col = 2;
        if(mat1.getVal(row, col) == val){
            System.out.println("Passed test 5, getVal");
        }
        else {
            System.out.println("Failed test 5, getVal");
        }
        val = 5;
        row = 2;
        col = 4;
        if(mat1.getVal(row, col) == val){
            System.out.println("Passed test 6, getVal");
        }
        else {
            System.out.println("Failed test 6, getVal");
        }

        // test 7 and 8, add()
        mat1 = new MathMatrix(data1);
        MathMatrix mat2 = new MathMatrix(data3);
        MathMatrix mat3 = mat1.add(mat2);
        MathMatrix mat5 = new MathMatrix(data5), mat6 = new MathMatrix(data2);
        MathMatrix mat7 = mat5.add(mat6);
        e1 = new int[][] {{16, 2, 9}, {7, 6, 4} };
        printTestResult(get2DArray(mat3), e1, 7, "add(), data1 + data3");
        e1 = new int[][] {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        printTestResult(get2DArray(mat7), e1, 8, "add method. data5 + data2");

        // test 9 and 10, subtract()
        mat3 = mat2.subtract(mat1);
        mat7 = mat6.subtract(mat5);
        e1 = new int[][] {{-2, 2, 3}, {-7, -4, 0} };
        printTestResult(get2DArray(mat3), e1, 9, "subtract(), data3 - data1");
        e1 = new int[][] {{4, 8, 12, 14, 18}, {16, 2, 18, 0, 2}, {2, 6, 18, 4, 10}};
        printTestResult(get2DArray(mat7), e1, 10, "subtract(), data2 - data5");

        // test 11 and 12, multiply()
        MathMatrix mat8 = new MathMatrix(data4);
        MathMatrix mult1 = mat8.multiply(mat1);
        MathMatrix mult2 = mat2.multiply(mat8);
        e1 = new int[][] {{99, 45, 30}, {44, 25, 13}, {21, 15, 6}};
        printTestResult(get2DArray(mult1), e1, 11, "multiply method, data4 * data1");
        e1 = new int[][] {{30, 91}, {1, 11}};
        printTestResult(get2DArray(mult2), e1, 12, "multiply method, data3 * data4");

        // test 13 and 14, getScaledMatrix()
        MathMatrix scale1 = mat1.getScaledMatrix(3);
        MathMatrix scale2 = mat5.getScaledMatrix(-9);
        e1 = new int[][] {{27, 0, 9}, {21, 15, 6}};
        printTestResult(get2DArray(scale1), e1, 13, "scale method, scale data1 by 3");
        e1 = new int[][] {{18, 36, 54, 63, 81}, {72, 9, 81, 0, 9}, {9, 27, 81, 18, 45}};
        printTestResult(get2DArray(scale2), e1, 14, "scale method, scale data5 by -9");

        // test 15 and 16, getTranspose()
        MathMatrix trans1 = mat2.getTranspose();
        MathMatrix trans2 = mat5.getTranspose();
        e1 = new int[][] {{7, 0}, {2, 1}, {6, 2}};
        printTestResult(get2DArray(trans1), e1, 15, "transpose method on data3");
        e1 = new int[][] {{-2, -8, -1}, {-4, -1, -3}, {-6, -9, -9}, {-7, 0, -2}, {-9, -1, -5}};
        printTestResult(get2DArray(trans2), e1, 16, "transpose method on data5");

        // test 17 and 18, equals()
        MathMatrix matr1 = new MathMatrix(data1);
        boolean result = mat1.equals(matr1);
        boolean expected = true;
        if(result == expected){
            System.out.println("Test number 17 tests the equal method" +
                    ". The test passed");
        }
        else {
            System.out.println("Test number 17 tests the equal method" +
                    ". The test failed");
        }
        result = mat2.equals(mat5);
        expected = false;
        if(result == expected){
            System.out.println("Test number 18 tests the equal method" +
                    ". The test passed");
        }
        else {
            System.out.println("Test number 18 tests the equal method" +
                    ". The test failed");
        }

        // test 19 and 20, toString()
        String display1 = mat1.toString();
        String expect = "| 9 0 3|\n" +
                "| 7 5 2|\n";
        if(display1.equals(expect)){
            System.out.println("Test number 19 tests the toString method" +
                    ". The test passed");
        }
        else {
            System.out.println("Test number 19 tests the toString method" +
                    ". The test failed");
        }
        String display2 = mat5.toString();
        expect = "| -2 -4 -6 -7 -9|\n" +
                "| -8 -1 -9  0 -1|\n" +
                "| -1 -3 -9 -2 -5|\n";
        if(display2.equals(expect)){
            System.out.println("Test number 20 tests the toString method" +
                    ". The test passed");
        }
        else {
            System.out.println("Test number 20 tests the toString method" +
                    ". The test failed");
        }

        // test 21 and 22, isUpperTriangular
        int[][] temp1 = new int[][] {{2, 1}, {0, 3}};
        MathMatrix upTri1 = new MathMatrix(temp1);
        if (upTri1.isUpperTriangular()) {
            System.out.println("Test number 21 tests the upperTriangular method" +
                    ". The test passed");
        } else {
            System.out.println("Test number 21 tests the upperTriangular method" +
                    ". The test failed");
        }
        data1 = new int[][] {{0, 6, 7, 3}, {9, 3, 4, 1}, {0, 0, 0, 9}, {2, 2, 9, 5}};
        mat1 = new MathMatrix(data1);
        if (!mat1.isUpperTriangular()) {
            System.out.println("Test number 22 tests the upperTriangular method" +
                    ". The test passed");
        } else {
            System.out.println("Test number 22 tests the upperTriangular method" +
                    ". The test failed");
        }

    }

//    private static void experiment1(){
//        System.out.println("\n\n");
//        for(int i = 0; i < 3; i++) {
//            int size = (int) (1000 * Math.pow(2, i));
//            int[][] matrix1 = new int[size][size];
//            int[][] matrix2 = new int[size][size];
//            for (int k = 0; k < size; k++) {
//                for (int j = 0; j < size; j++) {
//                    matrix1[k][j] = (int) (Math.random() * 1001);
//                    matrix2[k][j] = (int) (Math.random() * 1001);
//                }
//            }
//            MathMatrix m1 = new MathMatrix(matrix1);
//            MathMatrix m2 = new MathMatrix(matrix2);
//
//            Stopwatch stp = new Stopwatch();
//            stp.start();
//            for (int p = 0; p < 1000; p++) {
//                m1.add(m2);
//            }
//            stp.stop();
//            System.out.println("Size: " + size + "x" + size + ", Time elapsed: " + stp.time());
//        }
//    }
//
//    private static void experiment2(){
//        System.out.println("\n\n");
//        for(int i = 0; i < 3; i++) {
//            int size = (int) (120 * Math.pow(2, i));
//            int[][] matrix1 = new int[size][size];
//            int[][] matrix2 = new int[size][size];
//            for (int k = 0; k < size; k++) {
//                for (int j = 0; j < size; j++) {
//                    matrix1[k][j] = (int) (Math.random() * 1001);
//                    matrix2[k][j] = (int) (Math.random() * 1001);
//                }
//            }
//            MathMatrix m1 = new MathMatrix(matrix1);
//            MathMatrix m2 = new MathMatrix(matrix2);
//
//            Stopwatch stp = new Stopwatch();
//            stp.start();
//            for (int p = 0; p < 1000; p++) {
//                m1.multiply(m2);
//            }
//            stp.stop();
//            System.out.println("Size: " + size + "x" + size + ", Time elapsed: " + stp.time());
//        }
//    }

    // method that sums elements of mat, may overflow int!
    // pre: mat != null
    private static int sumVals(MathMatrix mat) {
        if (mat == null) {
            throw new IllegalArgumentException("mat may not be null");
        }
        int result = 0;
        final int ROWS =  mat.getNumRows();
        final int COLS = mat.getNumColumns();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                result += mat.getVal(r, c); // likely to overflow, but can still do simple check
            }
        }
        return result;
    }

    // create a matrix with random values
    // pre: rows > 0, cols > 0, randNumGen != null
    public static MathMatrix createMat(Random randNumGen, int rows,
                                       int cols, final int LIMIT) {

        if (randNumGen == null) {
            throw new IllegalArgumentException("randomNumGen variable may no be null");
        } else if(rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("rows and columns must be greater than 0. " +
                    "rows: " + rows + ", cols: " + cols);
        }

        int[][] temp = new int[rows][cols];
        final int SUB = LIMIT / 4;
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                temp[r][c] = randNumGen.nextInt(LIMIT) - SUB;
            }
        }

        return new MathMatrix(temp);
    }

    private static void printTestResult(int[][] data1, int[][] data2, int testNum,
                                        String testingWhat) {
        System.out.print("Test number " + testNum + " tests the " + testingWhat +". The test ");
        String result = equals(data1, data2) ? "passed" : "failed";
        System.out.println(result);
    }

    // pre: m != null, m is at least 1 by 1 in size
    // return a 2d array of ints the same size as m and with
    // the same elements
    private static int[][] get2DArray(MathMatrix m) {
        //check precondition
        if  ((m == null) || (m.getNumRows() == 0)
                || (m.getNumColumns() == 0)) {
            throw new IllegalArgumentException("Violation of precondition: get2DArray");
        }

        int[][] result = new int[m.getNumRows()][m.getNumColumns()];
        for(int r = 0; r < result.length; r++) {
            for(int c = 0; c < result[0].length; c++) {
                result[r][c] = m.getVal(r,c);
            }
        }
        return result;
    }

    // pre: data1 != null, data2 != null, data1 and data2 are at least 1 by 1 matrices
    //      data1 and data2 are rectangular matrices
    // post: return true if data1 and data2 are the same size and all elements are
    //      the same
    private static boolean equals(int[][] data1, int[][] data2) {
        //check precondition
        if((data1 == null) || (data1.length == 0)
                || (data1[0].length == 0) || !rectangularMatrix(data1)
                ||  (data2 == null) || (data2.length == 0)
                || (data2[0].length == 0) || !rectangularMatrix(data2)) {
            throw new IllegalArgumentException( "Violation of precondition: " +
                    "equals check on 2d arrays of ints");
        }
        boolean result = (data1.length == data2.length) && (data1[0].length == data2[0].length);
        int row = 0;
        while (result && row < data1.length) {
            int col = 0;
            while (result && col < data1[0].length) {
                result = (data1[row][col] == data2[row][col]);
                col++;
            }
            row++;
        }

        return result;
    }


    // method to ensure mat is rectangular
    // pre: mat != null, mat is at least 1 by 1
    private static boolean rectangularMatrix( int[][] mat ) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            throw new IllegalArgumentException("Violation of precondition: "
                    + " Parameter mat may not be null"
                    + " and must be at least 1 by 1");
        }
        return MathMatrix.rectangularMatrix(mat);
    }
}
