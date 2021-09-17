package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.ListIterator;



class Bank1 implements Comparable<Bank1>{
	
	int acno;
	int pincode;
	String holder;
	
	public Bank1( String holder,int acno, int pincode) {
		super();
		this.acno = acno;
	
		this.pincode = pincode;
		this.holder = holder;
	}

	public int getacno() {
		return acno;
	}

	
	public int getpincode() {
		return pincode;
	}

	public String getholder() {
		return holder;
	}
	
	@Override
	public String toString() {
		return "holder = " + holder+"\tacno = " + acno + "\tpincode = " + pincode ;
	}

	@Override
	public int compareTo(Bank1 o) {
		return 0;
	}
	
}
public class Compare_Using_Lambda_Bank_Class {

	public static void main(String[] args) {
List<Bank1> e1=new ArrayList<Bank1>();
		
		e1.add(new Bank1("Akash",142514,411014));
		e1.add(new Bank1("Omkar",142554,411006));
		e1.add(new Bank1("Rajesh",142519,411004));
		e1.add(new Bank1("Mayur",142529,411019));
		e1.add(new Bank1("Sagar",142517,411010));
		e1.add(new Bank1("Mohan",142543,411001));
		
		System.out.println("Before Sorting");
		for(Bank1 e:e1)
			System.out.println(e);
		
		System.out.println("----------------------------------------------------------------------------------------------------");
		Comparator<Bank1> holder=( o1,  o2)-> {return o1.holder.compareTo(o2.holder);}; //Lambda Expression
		
		Comparator<Bank1>acno=( o1,  o2)-> {return (int) (o1.acno-o2.acno);};//Lambda Expression
				
		Comparator<Bank1>pincode=( m1, m2)-> {return m1.pincode-m2.pincode;};//Lambda Expression
		
		
		System.out.println("--------------------- After Sorting using holder -------------------------------------------------------------------------------");
		Collections.sort(e1,holder);
		System.out.println("\nBy Using Enhanced For Loop");
		for(Bank1 e:e1) {
			System.out.println(e);
		}
		
		
		System.out.println("--------------------- After Sorting using acno -------------------------------------------------------------------------------");
		Collections.sort(e1,acno);
		System.out.println("\nBy Using ListIterator while Loop");
		ListIterator<Bank1> lit=e1.listIterator();
		while(lit.hasNext())
			System.out.println(lit.next().getacno());
		
		System.out.println("--------------------- After Sorting using pincode -------------------------------------------------------------------------------");
		Collections.sort(e1,pincode);
		System.out.println("\nBy Using Enumeration while Loop");
		Enumeration<Bank1> enu=Collections.enumeration(e1);
		while(enu.hasMoreElements())
			System.out.println(enu.nextElement().pincode);
	}

}

/*
  OutPut:
  
  Before Sorting
holder = Akash	acno = 142514	pincode = 411014
holder = Omkar	acno = 142554	pincode = 411006
holder = Rajesh	acno = 142519	pincode = 411004
holder = Mayur	acno = 142529	pincode = 411019
holder = Sagar	acno = 142517	pincode = 411010
holder = Mohan	acno = 142543	pincode = 411001
----------------------------------------------------------------------------------------------------
--------------------- After Sorting using holder -------------------------------------------------------------------------------

By Using Enhanced For Loop
holder = Akash	acno = 142514	pincode = 411014
holder = Mayur	acno = 142529	pincode = 411019
holder = Mohan	acno = 142543	pincode = 411001
holder = Omkar	acno = 142554	pincode = 411006
holder = Rajesh	acno = 142519	pincode = 411004
holder = Sagar	acno = 142517	pincode = 411010
--------------------- After Sorting using acno -------------------------------------------------------------------------------

By Using ListIterator while Loop
142514
142517
142519
142529
142543
142554
--------------------- After Sorting using pincode -------------------------------------------------------------------------------

By Using Enumeration while Loop
411001
411004
411006
411010
411014
411019

*/
