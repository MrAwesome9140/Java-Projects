// Lab33bst.java
// The student version of the Lab33b assignment.


import java.io.*;
import java.util.Scanner;


public class Lab33bst
{
	
	public static void main (String args[]) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("#####   ENTER-POLY METHOD   #####\n\nEnter the degree of the polynomial  ===>>  ");
		int degree = sc.nextInt(); // Degree of the polynomial
		System.out.println("");
		PolyNode prev = null; // Reference to previous node
		PolyNode front = null; // Reference to current node, ends on top of the stack, which is why it's called front
		for(int i = 0; i<=degree; i++){
			System.out.print("Enter coefficient for X^"+(degree-i)+" If no term exists, enter 0 ===>>  ");
			int coeff = sc.nextInt(); // Coefficient of X term
			front = new PolyNode(coeff, (degree-i), prev); // Create new node
			prev = front; // Set previous node to be current node
		}
		System.out.println("\n");
		System.out.print("#####   ENTER-XVALUE METHOD   #####\n\nEnter X value of the polynomial  ===>>  ");
		int x = sc.nextInt(); // X value that will be computed later
		System.out.println("\n");
		System.out.print("#####   DISPLAY-POLY METHOD   #####\n\nY = ");
		PolyNode temp = front; // Top of the stack
		while(temp!=null){
			if(temp.getDegree()!=0)
				System.out.print(temp.getCoeff()+"X^"+temp.getDegree()+"");
			else
				System.out.print(temp.getCoeff());

			if(temp.getDegree()!=degree)
				System.out.print(" + ");

			temp = temp.getNext(); // Set temp to be next node in the stack
		}
		System.out.println("\n\n");
		System.out.println("#####   COMPUTE-POLY METHOD   #####\n\n\n");
		temp = front; // Reset temp to be top of the stack again
		int sum = 0;
		while(temp!=null){
			sum+=temp.getCoeff()*Math.pow(x, temp.getDegree()); // Add the value of each term to sum
			temp = temp.getNext(); // Set temp to next node in the stack
		}
		System.out.print("#####   DISPLAY-POLY METHOD   #####\n\nY("+x+") = "+sum); // Print out value of function at given x value
	}
	
	
}			 

class PolyNode
{
	
	private int coeff;		// coefficient of each term
	private int degree;		// degree of each term
	private PolyNode next;	// link to the next term node
		
	public PolyNode (int c, int d, PolyNode initNext)
	{
		coeff = c;
		degree = d;
		next = initNext;
	}
	
	public int getCoeff()						
	{ 
		return coeff;			
	}
	
	public int getDegree()
	{
		return degree;
	}
	
	public PolyNode getNext()						
	{ 
		return next;			
	}
	
	public void setCoeff (int newCoeff)		
	{ 
		coeff = newCoeff;  
	}
	
	public void setDegree (int newDegree)
	{
		degree = newDegree;
	}
	
	public void setNext (PolyNode newNext)		
	{ 
		next = newNext; 	
	}
	
}


