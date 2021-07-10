// Lab35st.java
// This is the student version of the Lab 35 assignment.


import java.io.*;
import java.util.ArrayList;

      
public class Chp35Lab1st
{
	

	public static void main(String args[]) throws IOException
	{
		System.out.println("LAB35 100 POINT VERSION\n");
		ArrayList studentArray = new ArrayList(); 
		getList(studentArray);
		displayArray(studentArray);
		pause();
		

		NameTree tree1 = new NameTree(studentArray);
		AgeTree tree2 = new AgeTree(studentArray);		
		GPATree tree3 = new GPATree(studentArray);
		
		displayTree(tree1);
		pause();
		displayTree(tree2);
		pause();
		displayTree(tree3);
	}


	

	
	public static void getList(ArrayList students) throws IOException
	{
		System.out.println("\nRetrieving Students.dat\n");
		FileReader inFile = new FileReader("MyStudents.txt");
		BufferedReader inStream = new BufferedReader(inFile);	     
		String s1,s2,s3;

		while( ((s1 = inStream.readLine()) != null) && 
			((s2 = inStream.readLine()) != null) && ((s3 = inStream.readLine()) != null) )	
		{
			String name = s1;
			int age = Integer.parseInt(s2);
			double gpa = Double.parseDouble(s3);
			students.add(new Person(name,age,gpa));       
		}   
		inStream.close();   					
	}
	
	
	public static void displayArray(ArrayList students)
	{
		System.out.println("\nDISPLAYING STUDENT ARRAY ELEMENTS");
		for (int k = 0; k < students.size(); k++)
		{
			Person currPer = (Person) students.get(k);
			System.out.print(currPer.getName());
			int reached = currPer.name.length();
			while(reached<24) {
				reached++;
				System.out.print(" ");
			}
			System.out.print(currPer.age+"              ");
			System.out.println(currPer.gpa);
		}
	} 
	

	public static void displayTree(Object studentTree)
	{
		// Call display method on tree
   		if(studentTree instanceof NameTree)
			((NameTree)studentTree).display();
   		else if(studentTree instanceof GPATree)
			((GPATree)studentTree).display();
   		else
			((AgeTree)studentTree).display();
	}  



	public static void pause() throws IOException
	{   
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));	 
		String dummy;
		System.out.print("\nPress <Enter> to continue  ===>>  ");						
		dummy = input.readLine();
		System.out.println();
	}

}




class Person
{
	public String name;
	public int age;
	public double gpa;
   
	Person(String n, int a,double g)
	{
		name = n;
		age = a;
		gpa = g;
	}
	
	public String getName() { return name; }
	public int getAge()		{ return age;  }
	public double getGpa()	{ return gpa;  }
}




class TreeNode
{
	private Object value;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(Object initValue, TreeNode initLeft, TreeNode initRight)
	{
	   value = initValue;
	   left = initLeft;
	   right = initRight;
	}
	
	public Object getValue()					{ return value; 		}
	public TreeNode getLeft()					{ return left; 			}
	public TreeNode getRight()					{ return right; 		}
	public void setValue(Object theNewValue)	{ value = theNewValue; 	}
	public void setLeft(TreeNode theNewLeft)	{ left = theNewLeft; 	}
	public void setRight(TreeNode theNewRight)	{ right = theNewRight; 	}
	
}




class NameTree
{

	private TreeNode root;
	private boolean first;

	public NameTree(ArrayList students){
		root = new TreeNode((Person)students.get(0), null, null);
		for(int i = 1; i<students.size(); i++){
			add(students.get(i)); // Add each student to the tree
		}
	}

	public void add(Object value){
		Person current = (Person) value;
		TreeNode curNode = new TreeNode(current, null, null); // Create new node
		TreeNode temp = root; // Start at the root
		boolean done = false;
		while(!done){
			Person cur = (Person) temp.getValue();
			if(cur.name.compareTo(current.name)<0){ // Go to right node if name is later in alphabet
				if(temp.getRight()==null){
					temp.setRight(curNode); // Set right node to current student
					done = true; // Student is sorted in to tree
				}
				else
					temp = temp.getRight();
			}
			else{ // Go to left node if name is earlier in alphabet
				if(temp.getLeft()==null){
					temp.setLeft(curNode); // Set left node to current student
					done = true; // Student is sorted in to tree
				}
				else
					temp = temp.getLeft();
			}
		}
	}

	public void display(){
		System.out.println("DISPLAYING STUDENT TREE ORDERED BY NAME");
		traverseInOrder(root);
	}

	private void traverseInOrder(TreeNode cur){
		if(cur == null)
			return;

		traverseInOrder(cur.getLeft()); // Go to left node

		// Print out current node
		Person currPer = (Person) cur.getValue();
		System.out.print(currPer.getName());
		int reached = currPer.name.length();
		while(reached<24) {
			reached++;
			System.out.print(" ");
		}
		System.out.print(currPer.age+"              ");
		System.out.println(currPer.gpa);

		traverseInOrder(cur.getRight()); // Go to right node
	}

}	

class AgeTree
{

	private TreeNode root;
	private boolean first;

	public AgeTree(ArrayList students){
		root = new TreeNode((Person)students.get(0), null, null);
		for(int i = 1; i<students.size(); i++){
			add(students.get(i)); // Add each student to the tree
		}
	}

	public void add(Object value){
		Person current = (Person) value;
		TreeNode curNode = new TreeNode(current, null, null); // Create new node
		TreeNode temp = root; // Start at the root
		boolean done = false;
		while(!done){
			Person cur = (Person) temp.getValue();
			if(current.age>cur.age){ // Go to right node if current's age is larger
				if(temp.getRight()==null){
					temp.setRight(curNode); // Set right node to current student
					done = true; // Student is sorted in to tree
				}
				else
					temp = temp.getRight();
			}
			else{ // Go to left node if current's age is smaller
				if(temp.getLeft()==null){
					temp.setLeft(curNode); // Set left node to current student
					done = true; // Student is sorted in to tree
				}
				else
					temp = temp.getLeft();
			}
		}
	}

	public void display(){
		System.out.println("DISPLAYING STUDENT TREE ORDERED BY AGE");
		traverseInOrder(root);
	}

	private void traverseInOrder(TreeNode cur){
		if(cur == null)
			return;

		traverseInOrder(cur.getLeft()); // Go to left node

		// Print out current node
		Person currPer = (Person) cur.getValue();
		System.out.print(currPer.getName());
		int reached = currPer.name.length();
		while(reached<24) {
			reached++;
			System.out.print(" ");
		}
		System.out.print(currPer.age+"              ");
		System.out.println(currPer.gpa);

		traverseInOrder(cur.getRight()); // Go to right node
	}

}

class GPATree
{

	private TreeNode root;
	private boolean first;

	public  GPATree(ArrayList students){
		root = new TreeNode((Person)students.get(0), null, null);
		for(int i = 1; i<students.size(); i++){
			add(students.get(i)); // Add each student to the tree
		}
	}

	public void add(Object value){
		Person current = (Person) value;
		TreeNode curNode = new TreeNode(current, null, null); // Create new node
		TreeNode temp = root; // Start at the root
		boolean done = false;
		while(!done){
			Person cur = (Person) temp.getValue();
			if(current.gpa>cur.gpa){ // Go to right node if current's gpa is larger
				if(temp.getRight()==null){
					temp.setRight(curNode); // Set right node to current student
					done = true; // Student is sorted in to tree
				}
				else
					temp = temp.getRight();
			}
			else{ // Go to left node if current's gpa is smaller
				if(temp.getLeft()==null){
					temp.setLeft(curNode); // Set left node to current student
					done = true; // Student is sorted in to tree
				}
				else
					temp = temp.getLeft();
			}
		}
	}

	public void display(){
		System.out.println("DISPLAYING STUDENT TREE ORDERED BY GPA");
		traverseInOrder(root);
	}

	private void traverseInOrder(TreeNode cur){
		if(cur == null)
			return;

		traverseInOrder(cur.getLeft()); // Go to left node

		// Print out current node
		Person currPer = (Person) cur.getValue();
		System.out.print(currPer.getName());
		int reached = currPer.name.length();
		while(reached<24) {
			reached++;
			System.out.print(" ");
		}
		System.out.print(currPer.age+"              ");
		System.out.println(currPer.gpa);

		traverseInOrder(cur.getRight()); // Go to right node
	}

}		