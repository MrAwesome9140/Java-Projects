// Lab18avst.java
// The Student Records Algorithm Program
// This is the student, starting version of the Lab18a lab assignment.


import java.io.*;
import java.util.*;
import java.text.DecimalFormat;


public class Lab18avst
{
    public static void main(String[] args) throws IOException
    {
        List studentArray = new List(100);
        studentArray.getList();
        studentArray.display("UNSORTED LIST OF STUDENTS");
        studentArray.pause();

        studentArray.gpaSort();
        studentArray.display("STUDENTS SORTED IN DESCENDING ORDER BY GPA");
        studentArray.pause();

        studentArray.ageSort();
        studentArray.display("STUDENTS SORTED IN ASCENDING ORDER BY AGE");
        studentArray.pause();

        studentArray.idSort();
        studentArray.display("STUDENTS SORTED IN ASCENDING ORDER BY ID#");
        studentArray.pause();

		int studentID = getID();
		int index = studentArray.search(studentID);

		if (index == -1)
		    System.out.println("There is no student with an ID# of "+studentID+".\n");
		else
		{
			studentArray.displayStudent(index);
			studentArray.delete(index);
			studentArray.display("STUDENTS SORTED IN ASCENDING ORDER BY ID# WITHOUT STUDENT# "+studentID);
			studentArray.pause();
		}
    }

    //Student #: 720097

    public static int getID()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter the 6-digit ID of the student.  { 100000 - 999999 }  -->  ");
        return input.nextInt();
    }
}


class Person
{
    public String name;
    public int id;
    public int age;
    public double gpa;

    Person(String n, int ID, int a,double g)
    {
        name = n;
        id = ID;
        age = a;
        gpa = g;
    }
}


class List {
    private Person student[];	// stores array elements
    private int capacity;		// actual array capacity
    private int size;			// number of elements in the array

    public List(int c) {
        capacity = c;
        size = 0;
        student = new Person[capacity];
    }

    public void getList() throws IOException {
        FileReader inFile = new FileReader("students.dat");
        BufferedReader inStream = new BufferedReader(inFile);
        String s1,s2,s3,s4;
        int age, id;
        double gpa;
        int index = 0;
        while( ((s1 = inStream.readLine()) != null) &&
                ((s2 = inStream.readLine()) != null) &&
                ((s3 = inStream.readLine()) != null) &&
                ((s4 = inStream.readLine()) != null) )
        {
            String name = s1;
            id = Integer.parseInt(s2);
            age = Integer.parseInt(s3);
            gpa = Double.parseDouble(s4);

            student[index] = new Person(name,id,age,gpa);
            index++;
        }
        inStream.close();
        size = index;
    }

    private String spaces(String name) {
        int tab = 24 - name.length();
        String temp = "";
        for (int j = 1; j <= tab; j++)
            temp += " ";
        return temp;
    }

    public void display(String listInfo) {
        DecimalFormat output = new DecimalFormat("0.000");
        System.out.println("\nDISPLAYING "+ listInfo);
        System.out.println("\nStudent ID#     Student Name            Age         GPA");
        System.out.println("============================================================");

        for (int k = 0; k < size; k++)
            System.out.println(student[k].id + "          "+student[k].name + spaces(student[k].name) + student[k].age + "          " + output.format(student[k].gpa));
    }

    public void pause() {
        Scanner input = new Scanner(System.in);
        String dummy;
        System.out.println("\nPress <Enter> to continue.");
        dummy = input.nextLine();
    }

    public void displayStudent(int index) {
        DecimalFormat output = new DecimalFormat("0.000");
        System.out.println("\n" + "REMOVING STUDENT:");
        System.out.println("\nStudent ID#     Student Name            Age         GPA");
        System.out.println("============================================================");
        System.out.println(student[index].id + "          "+student[index].name + spaces(student[index].name) + student[index].age + "          " + output.format(student[index].gpa) + "\n");
    }

    private void swap(int x, int y) {
        Person temp = student[x];
        student[x] = student[y];
        student[y] = temp;
    }

    public void gpaSort() {
        int index = 0;
        for(int i = index;i<size-1;i++){
            for(int x = i+1;x<size;x++){
                if(student[i].gpa != 0 && student[x].gpa != 0) {
                    if (student[i].gpa < student[x].gpa) {
                        swap(i, x);
                        index = x;
                    }
                }
                index++;
            }
        }
    }

    public void ageSort() {
        int index = 0;
        for(int i = index;i<size-1;i++){
            for(int x = i+1;x<size;x++){
                if(student[i].age != 0 && student[x].age != 0) {
                    if (student[i].age > student[x].age) {
                        swap(i, x);
                        index = x;
                    }
                }
                index++;
            }
        }
    }

    public void idSort() {
        int index = 0;
        for(int i = index;i<size-1;i++){
            for(int x = i+1;x<size;x++){
                System.out.println(i + "   " + x);
                if(student[i].id != 0 && student[x].id != 0) {
                    if (student[i].id > student[x].id) {
                        swap(i, x);
                        index = x;
                    }
                }
                index++;
            }
        }
    }

	public int search(int studentID) {
//        int mid = 1 + (size-1)/2;
//        if(student[mid].id == studentID) return mid;
//        if(){
//
//        }
        for(int i = 0;i<size;i++){
            if(student[i].id == studentID) return i;
        }
        return -1;
	}

    public void delete(int index) {
        student[index] = null;
        for(int i = index;i<size-1;i++){
            student[i] = student[i+1];
        }
    }

//    public void mergeSort(Person[] people, int n){
//        int mid = n/2;
//        Person[] left = new Person[mid];
//        Person[] right = new Person[n-mid];
//
//        for(int i = 0;i<mid;i++){
//            left[i] = people[i];
//        }
//
//        for(int i = mid; i<n; i++){
//            right[i-mid] = people[i];
//        }
//
//        mergeSort(left,mid);
//        mergeSort(right,n-mid);
//
//        merge(mid,n-mid,people,left,right);
//
//    }
//
//    public void merge(int left, int right, Person[] a, int[] l, int[] r){
//        int i = 0, j = 0, k = 0;
//        while(i<left && j<right){
//            if(l[i]<r[j]){
//                a[k++] = l[i++];
//            }
//            else{
//                a[k++] = r[j++];
//            }
//        }
//        while(i<left){
//            a[k++] = l[i++];
//        }
//        while(j<right){
//            a[k++] = r[j++];
//        }
//    }

}

