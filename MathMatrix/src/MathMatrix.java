import java.util.Arrays;

// MathMatrix.java - CS314 Assignment 2

/*  Student information for assignment:
 *
 *  On my honor, Aaroh Sharma, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID: as225925
 *  email address: aaroh.sh@gmail.com
 *  Unique section number: 52600
 *  Number of slip days I am using: 0
 */

/**
 * A class that models systems of linear equations (Math Matrices)
 * as used in linear algebra.
 */
public class MathMatrix {

    // instance variable
    private final int[][] matrix;

    /**
     * create a MathMatrix with cells equal to the values in mat.
     * A "deep" copy of mat is made.
     * Changes to mat after this constructor do not affect this
     * Matrix and changes to this MathMatrix do not affect mat
     * @param  mat  mat !=null, mat.length > 0, mat[0].length > 0,
     * mat is a rectangular matrix
     */
    public MathMatrix(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0 || !rectangularMatrix(mat)) {
            throw new IllegalArgumentException("2d array mat cannot be null, " +
                    "mat must have at least 1 row and at least 1 column");
        }

        // Create deep copy of int[][] mat
        matrix = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            matrix[i] = Arrays.copyOf(mat[i], mat[0].length);
        }
    }


    /**
     * create a MathMatrix of the specified size with all cells set to the intialValue.
     * <br>pre: numRows > 0, numCols > 0
     * <br>post: create a matrix with numRows rows and numCols columns.
     * All elements of this matrix equal initialVal.
     * In other words after this method has been called getVal(r,c) = initialVal
     * for all valid r and c.
     * @param numRows numRows > 0
     * @param numCols numCols > 0
     * @param initialVal all cells of this Matrix are set to initialVal
     */
    public MathMatrix(int numRows, int numCols, int initialVal) {
        if (numRows <= 0 || numCols <= 0) {
            throw new IllegalArgumentException("numRows and numCols must be at least 1");
        }

        matrix = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            matrix[i] = new int[numCols];
            Arrays.fill(matrix[i], initialVal);
        }
    }

    /**
     * Get the number of rows.
     * @return the number of rows in this MathMatrix
     */
    public int getNumRows() {
        return matrix.length;
    }


    /**
     * Get the number of columns.
     * @return the number of columns in this MathMatrix
     */
    public int getNumColumns(){
        return matrix[0].length;
    }


    /**
     * get the value of a cell in this MathMatrix.
     * <br>pre: row  0 <= row < getNumRows(), col  0 <= col < getNumColumns()
     * @param  row  0 <= row < getNumRows()
     * @param  col  0 <= col < getNumColumns()
     * @return the value at the specified position
     */
    public int getVal(int row, int col) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) {
            throw new IllegalArgumentException("int row must be greater than or equal to 0 and less than " +
                    "getNumRows(), int col must be greater than or equal to 0 and less than getNumColumns()");
        }

        return matrix[row][col];
    }


    /**
     * implements MathMatrix addition, (this MathMatrix) + rightHandSide.
     * <br>pre: rightHandSide != null, rightHandSide.getNumRows() = getNumRows(),
     * rightHandSide.numCols() = getNumColumns()
     * <br>post: This method does not alter the calling object or rightHandSide
     * @param rightHandSide rightHandSide.getNumRows() = getNumRows(),
     * rightHandSide.numCols() = getNumColumns()
     * @return a new MathMatrix that is the result of adding this Matrix to rightHandSide.
     * The number of rows in the returned Matrix is equal to the number of rows in this MathMatrix.
     * The number of columns in the returned Matrix is equal to the number of columns
     * in this MathMatrix.
     */
    public MathMatrix add(MathMatrix rightHandSide){
        if (rightHandSide == null || rightHandSide.getNumRows() != getNumRows()
            || rightHandSide.getNumColumns() != getNumColumns()) {
            throw new IllegalArgumentException("MathMatrix rightHandSide cannot be null; " +
                    "rightHandSide.getNumRows() must equal getNumRows(); rightHandSide.getNumColumns()" +
                    " must equal getNumColumns()");
        }

        int[][] sum = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++){
                sum[i][j] = matrix[i][j] + rightHandSide.getVal(i, j);
            }
        }

        return new MathMatrix(sum);
    }


    /**
     * implements MathMatrix subtraction, (this MathMatrix) - rightHandSide.
     * <br>pre: rightHandSide != null, rightHandSide.getNumRows() = getNumRows(),
     * rightHandSide.numCols() = getNumColumns()
     * <br>post: This method does not alter the calling object or rightHandSide
     * @param rightHandSide rightHandSide.getNumRows() = getNumRows(),
     * rightHandSide.numCols() = getNumColumns()
     * @return a new MathMatrix that is the result of subtracting rightHandSide
     * from this MathMatrix. The number of rows in the returned MathMatrix is equal to the number
     * of rows in this MathMatrix.The number of columns in the returned MathMatrix is equal to
     * the number of columns in this MathMatrix.
     */
    public MathMatrix subtract(MathMatrix rightHandSide){
        if (rightHandSide == null || rightHandSide.getNumRows() != getNumRows()
                || rightHandSide.getNumColumns() != getNumColumns()) {
            throw new IllegalArgumentException("MathMatrix rightHandSide cannot be null; " +
                    "rightHandSide.getNumRows() must equal getNumRows(); rightHandSide.getNumColumns() " +
                    "must equal this.getNumColumns()");
        }

        int[][] diff = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                diff[i][j] = matrix[i][j] - rightHandSide.getVal(i, j);
            }
        }

        return new MathMatrix(diff);
    }


    /**
     * implements matrix multiplication, (this MathMatrix) * rightHandSide.
     * <br>pre: rightHandSide != null, rightHandSide.getNumRows() = getNumColumns()
     * <br>post: This method should not alter the calling object or rightHandSide
     * @param rightHandSide rightHandSide.getNumRows() = getNumColumns()
     * @return a new MathMatrix that is the result of multiplying 
     * this MathMatrix and rightHandSide.
     * The number of rows in the returned MathMatrix is equal to the number of rows
     * in this MathMatrix. The number of columns in the returned MathMatrix is equal to the number
     * of columns in rightHandSide.
     */
    public MathMatrix multiply(MathMatrix rightHandSide){
        if (rightHandSide == null || rightHandSide.getNumRows() != matrix[0].length) {
            throw new IllegalArgumentException("MathMatrix rightHandSide cannot be null; " +
                    "rightHandSide.getNumRows() must equal this.getNumColumns()");
        }

        int[][] sol = new int[matrix.length][rightHandSide.getNumColumns()];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < rightHandSide.getNumColumns(); j++){
                int temp = 0;
                for(int k = 0; k < matrix[0].length; k++){
                    temp += matrix[i][k] * rightHandSide.getVal(k, j);
                }
                sol[i][j] = temp;
            }
        }
        return new MathMatrix(sol);
    }


    /**
     * Create and return a new Matrix that is a copy
     * of this matrix, but with all values multiplied by a scale
     * value.
     * <br>pre: none
     * <br>post: returns a new Matrix with all elements in this matrix
     * multiplied by factor.
     * In other words after this method has been called
     * returned_matrix.getVal(r,c) = original_matrix.getVal(r, c) * factor
     * for all valid r and c.
     * @param factor the value to multiply every cell in this Matrix by.
     * @return a MathMatrix that is a copy of this MathMatrix, but with all
     * values in the result multiplied by factor.
     */
    public MathMatrix getScaledMatrix(int factor) {
        int[][] scaled = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                scaled[i][j] = matrix[i][j] * factor;
            }
        }
        return new MathMatrix(scaled);
    }


    /**
     * accessor: get a transpose of this MathMatrix.
     * This Matrix is not changed.
     * <br>pre: none
     * @return a transpose of this MathMatrix
     */
    public MathMatrix getTranspose() {
        int[][] transpose = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return new MathMatrix(transpose);
    }


    /**
     * override equals.
     * @return true if rightHandSide is the same size as this MathMatrix and all values in the
     * two MathMatrix objects are the same, false otherwise
     */
    public boolean equals(Object rightHandSide){

        if (rightHandSide == null || this.getClass() != rightHandSide.getClass()) {
            return false;
        }
        // We know rightHandSide refers to a non-null MathMatrix object, safe to cast.
        MathMatrix otherMathMatrix = (MathMatrix) rightHandSide;
        // Now we can access the private instance variables of otherMathMatrix
        // and / or call MathMatrix methods on otherMathMatrix.

        if (otherMathMatrix.getNumRows() != matrix.length
                || otherMathMatrix.getNumColumns() != matrix[0].length) {
            return false;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != otherMathMatrix.getVal(i, j)) {
                    return false;
                }
            }
        }

        return true;
    }


    /**
     * override toString.
     * @return a String with all elements of this MathMatrix.
     * Each row is on a separate line.
     * Spacing based on longest element in this Matrix.
     */
    public String toString() {

        // Assign maxLength to the maximum length of an int in the matrix
        int maxLength = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                maxLength = Math.max(maxLength, String.valueOf(matrix[i][j]).length());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            sb.append("|");
            for (int j = 0; j < matrix[0].length; j++) {

                // Format each int in the matrix into a String with length maxLength+1
                sb.append(String.format("%"+(maxLength+1)+"s", matrix[i][j]));
            }
            sb.append("|\n");
        }
        return sb.toString();
    }



    /**
     * Return true if this MathMatrix is upper triangular. To
     * be upper triangular all elements below the main
     * diagonal must be 0.<br>
     * pre: this is a square matrix. getNumRows() == getNumColumns()
     * @return <tt>true</tt> if this MathMatrix is upper triangular,
     * <tt>false</tt> otherwise.
     */
    public boolean isUpperTriangular() {
        if (matrix.length == 1 && matrix[0].length == 1 && matrix[0][0] == 0) {
            return true;
        }

        // Iterate through all elements in the matrix below the top left
        // diagonal to check for non-zero elements
        boolean isUpTri = true;
        for (int i = 0; i < matrix.length && isUpTri; i++) {
            for (int j = 0; j < i && isUpTri; j++) {
                if (matrix[i][j] != 0) {
                    isUpTri = false;
                }
            }
        }
        return isUpTri;
    }

    // method to ensure mat is rectangular. It is public so that
    // tester classes can use it.
    // pre: mat != null, mat has at least one row
    // return true if all rows in mat have the same
    // number of columns false otherwise.
    public static boolean rectangularMatrix(int[][] mat) {
        if (mat == null || mat.length == 0) {
            throw new IllegalArgumentException("argument mat may not be null and must "
                    + " have at least one row. mat = " + Arrays.toString(mat));
        }
        boolean isRectangular = true;
        int row = 1;
        final int COLUMNS = mat[0].length;
        while (isRectangular && row < mat.length) {
            isRectangular = (mat[row].length == COLUMNS);
            row++;
        }
        return isRectangular;
    }

}