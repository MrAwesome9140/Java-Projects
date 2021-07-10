package com.company;// Lab26ast
// This is the student version of the Lab26a assignment.
// The <main> method for both 80-point and 100-point version
// are provided.


import java.util.ArrayList;


public class Lab26ast
{
	
//	public static void main(String args[])
//	{
//		System.out.println("\nLAB26A 80-POINT VERSION\n");
//
//		Matrix m1 = new Matrix();
//		m1.displayMatrix("Matrix m1 Default Display");
//		System.out.println();
//
//		Matrix m2 = new Matrix(3,5);
//		m2.displayMatrix("Matrix m2 3 X 5 Display");
//		System.out.println();
//		int count = 100;
//		for (int r = 0; r < m2.getRows(); r++)
//		{
//			for (int c = 0; c < m2.getCols(); c++)
//			{
//				m2.setValue(r,c,count);
//				count++;
//			}
//		}
//		m2.displayMatrix("Matrix m2 3 X 5 Consecutive Integers Display");
//		System.out.println();
//
//		Matrix m3 = new Matrix(3,3,100);
//		m3.displayMatrix("Matrix m3 3 X 3 Initialized to 100 Display");
//		System.out.println();
//	}
	

	public static void main(String args[])
	{
		System.out.println("\nLAB24A 100-POINT VERSION\n");
		
		Matrix m1 = new Matrix();
		m1.displayMatrix("Matrix m1 Default Display");
		System.out.println();
		
		Matrix m2 = new Matrix(3,5);
		int count = 100;
		for (int r = 0; r < m2.getRows(); r++)
		{
			for (int c = 0; c < m2.getCols(); c++)
			{
				m2.setValue(r,c,count);
				count++;
			}
		}		
		m2.displayMatrix("Matrix m2 3 X 5 Consecutive Integers Display");
		System.out.println();
		
		m2.resize(4,4);
		m2.displayMatrix("Matrix m2 After 4 X 4 Resizing Display");
		System.out.println();
		
		Matrix m3 = new Matrix(3,3,100);				
		m3.displayMatrix("Matrix m3 3 X 3 Initialized to 100 Display");
		System.out.println();
	}

	
	
}


class Matrix
{

								
	private ArrayList list;		// one-dimensional array stores matrix values
	private int listSize;		// total number of elements in the matrix
	private int numRows;		// number of rows in the matrix
	private int numCols;		// number of cols in the matrix

	public Matrix(){
		list = new ArrayList();
		listSize = 0;
		numCols = 0;
		numRows = 0;
	}

	public Matrix(int r, int c){
		list = new ArrayList();
		for(int i = 0; i<r*c; i++)
			list.add(0);
		listSize = r*c;
		numRows = r;
		numCols = c;
	}

	public Matrix(int r, int c, int value){
		list = new ArrayList();
		for(int i = 0; i<r*c; i++)
			list.add(value);
		listSize = r*c;
		numRows = r;
		numCols = c;
	}

	public int getRows(){return numRows;}

	public int getCols(){return numCols;}

	public int getSize(){return listSize;}

	public int getValue(int r, int c){return (Integer)list.get(r*numCols+c);}

	public void setValue(int r, int c, int value){list.set(r*numCols+c, value);}

	public void displayMatrix(String s){
		System.out.println(s);
		if(listSize == 0){
			System.out.println("Matrix has no elements");
			return;
		}
		for(int i = 0; i<numRows; i++){
			for(int j = 0; j<numCols; j++){
				System.out.print(list.get(i*numCols+j)+" ");
			}
			System.out.println();
		}
	}

	public void resize(int rows, int cols){
		ArrayList temp =  new ArrayList();
		for(int i = 0; i<rows; i++){
			for(int j = 0; j<cols; j++){
				if(i<numRows && j<numCols)
					temp.add(list.get(i*numCols+j));
				else
					temp.add(0);
			}
		}
		list = temp;
		listSize = rows*cols;
		numRows = rows;
		numCols = cols;
	}
	
}
