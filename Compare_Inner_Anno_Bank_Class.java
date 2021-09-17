package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.ListIterator;



class Bank implements Comparable<Bank>{
	
	int acno;
	int pincode;
	String holder;
	
	public Bank( String holder,int acno, int pincode) {
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
	public int compareTo(Bank o) {
		return 0;
	}
	
}
public class Compare_Inner_Anno_Bank_Class {

	public static void main(String[] args) {
List<Bank> e1=new ArrayList<Bank>();
		
		e1.add(new Bank("Akash",142514,411014));
		e1.add(new Bank("Omkar",142554,411006));
		e1.add(new Bank("Rajesh",142519,411004));
		e1.add(new Bank("Mayur",142529,411019));
		e1.add(new Bank("Sagar",142517,411010));
		e1.add(new Bank("Mohan",142543,411001));
		
		System.out.println("Before Sorting");
		for(Bank e:e1)
			System.out.println(e);
		
		System.out.println("----------------------------------------------------------------------------------------------------");
		Comparator<Bank> holder=new Comparator<Bank>() {
			public int compare(Bank o1, Bank o2) {
				return o1.holder.compareTo(o2.holder);
			}
		};
		
		Comparator<Bank>acno=new Comparator<Bank>() {
			public int compare(Bank o1,Bank o2) {
				return (int) (o1.acno-o2.acno);
			}
		};
		Comparator<Bank>pincode=new Comparator<Bank>() {
			public int compare(Bank m1,Bank m2) {
				return m1.pincode-m2.pincode;
			}
		};
		
		
		System.out.println("--------------------- After Sorting using holder -------------------------------------------------------------------------------");
		Collections.sort(e1,holder);
		System.out.println("\nBy Using Enhanced For Loop");
		for(Bank e:e1) {
			System.out.println(e);
		}
		
		
		System.out.println("--------------------- After Sorting using acno -------------------------------------------------------------------------------");
		Collections.sort(e1,acno);
		System.out.println("\nBy Using ListIterator while Loop");
		ListIterator<Bank> lit=e1.listIterator();
		while(lit.hasNext())
			System.out.println(lit.next().getacno());
		
		System.out.println("--------------------- After Sorting using pincode -------------------------------------------------------------------------------");
		Collections.sort(e1,pincode);
		System.out.println("\nBy Using Enumeration while Loop");
		Enumeration<Bank> enu=Collections.enumeration(e1);
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
