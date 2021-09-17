package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;



class Student2 implements Comparable<Student2>{
	String name,add;
	int rn;
	double salary;
	public String getName() {
		return name;
	}
	public String getAdd() {
		return add;
	}
	public int getId() {
		return rn;
	}
	public double getSalary() {
		return salary;
	}
	public Student2(String name, int rn, double salary,String add ) {
		super();
		this.name = name;
		this.add = add;
		this.rn = rn;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Rollno=" + rn + ",\tname=" + name + ",\tmarks=" + salary + ",\tadd=" + add ;
	}
	@Override
	public int compareTo(Student2 o) {
		return 0;
	}
	
}
public class Compare_Using_Lambda_Student_Class {

	public static void main(String[] args) {
List<Student2> e1=new ArrayList<Student2>();
		
		e1.add(new Student2("Akash", 11, 54000, "Pune"));
		e1.add(new Student2("Santosh", 41, 50000, "Baramati"));
		e1.add(new Student2("Amar", 07 , 48200, "Satara"));
		e1.add(new Student2("Harshal", 51, 43000, "Wagholi"));
		e1.add(new Student2("Jayesh", 30, 60000, "Hadapsar"));
		e1.add(new Student2("Mengesh", 21, 62000, "Viman nagar"));
		e1.add(new Student2("mayur", 05, 48000, "Indapur"));
		
		System.out.println("Before Sorting");
		for(Student2 e:e1)
			System.out.println(e);
		
		System.out.println("----------------------------------------------------------------------------------------------------");
		Comparator<Student2> Name=( o1,  o2)-> {return o1.name.compareTo(o2.name);};	//Lambda Expression
		
		Comparator<Student2> rn=( o1,  o2)-> {return o1.rn-o2.rn;};	//Lambda Expression
				
		Comparator<Student2>Salary=( o1,  o2)-> {return (int) (o2.salary-o1.salary);};	//Lambda Expression
				
		Comparator<Student2> Address=( o1,  o2)-> {return o1.add.compareTo(o2.add);};	//Lambda Expression
						
		System.out.println("--------------------- After Sorting using Name -------------------------------------------------------------------------------");
		Collections.sort(e1,Name);
		System.out.println("\nBy Using Enhanced For Loop");
		for(Student2 e:e1) {
			System.out.println(e);
		}
		
		System.out.println("--------------------- After Sorting using Rollno -------------------------------------------------------------------------------");
		Collections.sort(e1,rn);
		System.out.println("\nBy Using Iterator while Loop");
		Iterator<Student2> it=e1.iterator();
		while(it.hasNext())
			System.out.println(it.next().getId());
		
		System.out.println("--------------------- After Sorting using Salary -------------------------------------------------------------------------------");
		Collections.sort(e1,Salary);
		System.out.println("\nBy Using ListIterator while Loop");
		ListIterator<Student2> lit=e1.listIterator();
		while(lit.hasNext())
			System.out.println(lit.next().getSalary());
		
		System.out.println("--------------------- After Sorting using Address -------------------------------------------------------------------------------");
		Collections.sort(e1,Address);
		System.out.println("\nBy Using Enumeration while Loop");
		Enumeration<Student2> E=Collections.enumeration(e1);
		while(E.hasMoreElements())
			System.out.println(E.nextElement().getAdd());
	}

}

/*
	OutPut:

Before Sorting
Rollno=11,	name=Akash,	marks=54000.0,	add=Pune
Rollno=41,	name=Santosh,	marks=50000.0,	add=Baramati
Rollno=7,	name=Amar,	marks=48200.0,	add=Satara
Rollno=51,	name=Harshal,	marks=43000.0,	add=Wagholi
Rollno=30,	name=Jayesh,	marks=60000.0,	add=Hadapsar
Rollno=21,	name=Mengesh,	marks=62000.0,	add=Viman nagar
Rollno=5,	name=mayur,	marks=48000.0,	add=Indapur
----------------------------------------------------------------------------------------------------
--------------------- After Sorting using Name -------------------------------------------------------------------------------

By Using Enhanced For Loop
Rollno=11,	name=Akash,	marks=54000.0,	add=Pune
Rollno=7,	name=Amar,	marks=48200.0,	add=Satara
Rollno=51,	name=Harshal,	marks=43000.0,	add=Wagholi
Rollno=30,	name=Jayesh,	marks=60000.0,	add=Hadapsar
Rollno=21,	name=Mengesh,	marks=62000.0,	add=Viman nagar
Rollno=41,	name=Santosh,	marks=50000.0,	add=Baramati
Rollno=5,	name=mayur,	marks=48000.0,	add=Indapur
--------------------- After Sorting using Rollno -------------------------------------------------------------------------------

By Using Iterator while Loop
5
7
11
21
30
41
51
--------------------- After Sorting using Salary -------------------------------------------------------------------------------

By Using ListIterator while Loop
62000.0
60000.0
54000.0
50000.0
48200.0
48000.0
43000.0
--------------------- After Sorting using Address -------------------------------------------------------------------------------

By Using Enumeration while Loop
Baramati
Hadapsar
Indapur
Pune
Satara
Viman nagar
Wagholi

*/
