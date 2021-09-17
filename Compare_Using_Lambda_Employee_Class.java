package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;



class Empl implements Comparable<Empl>{
	String name,add;
	int id;
	double salary;
	public String getName() {
		return name;
	}
	public String getAdd() {
		return add;
	}
	public int getId() {
		return id;
	}
	public double getSalary() {
		return salary;
	}
	public Empl(String name, int id, double salary,String add ) {
		super();
		this.name = name;
		this.add = add;
		this.id = id;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "id=" + id + ",\tname=" + name + ",\tmarks=" + salary + ",\tadd=" + add ;
	}
	@Override
	public int compareTo(Empl o) {
		return 0;
	}
	
}
public class Compare_Using_Lambda_Employee_Class {

	public static void main(String[] args) {
List<Empl> e1=new ArrayList<Empl>();
		
		e1.add(new Empl("Akash", 11, 54000, "Pune"));
		e1.add(new Empl("Santosh", 41, 50000, "Baramati"));
		e1.add(new Empl("Amar", 07 , 48200, "Satara"));
		e1.add(new Empl("Harshal", 51, 43000, "Wagholi"));
		e1.add(new Empl("Jayesh", 30, 60000, "Hadapsar"));
		e1.add(new Empl("Mengesh", 21, 62000, "Viman nagar"));
		e1.add(new Empl("mayur", 05, 48000, "Indapur"));
		
		System.out.println("Before Sorting");
		for(Empl e:e1)
			System.out.println(e);
		
		System.out.println("----------------------------------------------------------------------------------------------------");
		Comparator<Empl> Name=(o1,  o2) ->{return o1.name.compareTo(o2.name);};// Lambda Expression
		
		Comparator<Empl> Id=(o1,  o2) ->{return o1.id-o2.id;};// Lambda Expression
				
		Comparator<Empl>Salary=(o1,  o2) ->{return (int) (o2.salary-o1.salary);};// Lambda Expression
				
		Comparator<Empl> Address=new Comparator<Empl>() {
			public int compare(Empl o1,Empl o2) {
				return o1.add.compareTo(o2.add);
			}
		};
		
		System.out.println("--------------------- After Sorting using Name -------------------------------------------------------------------------------");
		Collections.sort(e1,Name);
		System.out.println("\nBy Using Enhanced For Loop");
		for(Empl e:e1) {
			System.out.println(e);
		}
		
		System.out.println("--------------------- After Sorting using Id -------------------------------------------------------------------------------");
		Collections.sort(e1,Id);
		System.out.println("\nBy Using Iterator while Loop");
		Iterator<Empl> it=e1.iterator();
		while(it.hasNext())
			System.out.println(it.next().getId());
		
		System.out.println("--------------------- After Sorting using Salary -------------------------------------------------------------------------------");
		Collections.sort(e1,Salary);
		System.out.println("\nBy Using ListIterator while Loop");
		ListIterator<Empl> lit=e1.listIterator();
		while(lit.hasNext())
			System.out.println(lit.next().getSalary());
		
		System.out.println("--------------------- After Sorting using Address -------------------------------------------------------------------------------");
		Collections.sort(e1,Address);
		System.out.println("\nBy Using Enumeration while Loop");
		Enumeration<Empl> E=Collections.enumeration(e1);
		while(E.hasMoreElements())
			System.out.println(E.nextElement().getAdd());
	}

}

/*
 OutPUt :
   	Before Sorting
id=11,	name=Akash,	marks=54000.0,	add=Pune
id=41,	name=Santosh,	marks=50000.0,	add=Baramati
id=7,	name=Amar,	marks=48200.0,	add=Satara
id=51,	name=Harshal,	marks=43000.0,	add=Wagholi
id=30,	name=Jayesh,	marks=60000.0,	add=Hadapsar
id=21,	name=Mengesh,	marks=62000.0,	add=Viman nagar
id=5,	name=mayur,	marks=48000.0,	add=Indapur
----------------------------------------------------------------------------------------------------
--------------------- After Sorting using Name -------------------------------------------------------------------------------

By Using Enhanced For Loop
id=11,	name=Akash,	marks=54000.0,	add=Pune
id=7,	name=Amar,	marks=48200.0,	add=Satara
id=51,	name=Harshal,	marks=43000.0,	add=Wagholi
id=30,	name=Jayesh,	marks=60000.0,	add=Hadapsar
id=21,	name=Mengesh,	marks=62000.0,	add=Viman nagar
id=41,	name=Santosh,	marks=50000.0,	add=Baramati
id=5,	name=mayur,	marks=48000.0,	add=Indapur
--------------------- After Sorting using Id -------------------------------------------------------------------------------

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
