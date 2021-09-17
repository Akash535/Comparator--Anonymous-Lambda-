package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;



class Laptop1 implements Comparable<Laptop1>{
	
	int price;
	int ram,generation;
	String brand;
	
	public Laptop1( String brand,int price, int ram, int generation) {
		super();
		this.price = price;
		this.ram = ram;
		this.generation = generation;
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public int getRam() {
		return ram;
	}

	public int getGeneration() {
		return generation;
	}

	public String getBrand() {
		return brand;
	}
	
	@Override
	public String toString() {
		return "brand = " + brand+"\tprice = " + price + "\tram = " + ram + "\tgeneration = " + generation ;
	}

	@Override
	public int compareTo(Laptop1 o) {
		return 0;
	}
	
}
public class Compare_Using_Lambda_Laptop_Class {

	public static void main(String[] args) {
List<Laptop1> e1=new ArrayList<Laptop1>();
		
		e1.add(new Laptop1("Hp", 34000,4,7 ));
		e1.add(new Laptop1("Dell", 44000,8,8 ));
		e1.add(new Laptop1("Mac", 54000,4,7 ));
		e1.add(new Laptop1("Hp", 40000,6,8 ));
		e1.add(new Laptop1("ROG", 58000,8,7 ));
		e1.add(new Laptop1("Dell", 39000,6,9 ));
		
		System.out.println("Before Sorting");
		for(Laptop1 e:e1)
			System.out.println(e);
		
		System.out.println("----------------------------------------------------------------------------------------------------");
		Comparator<Laptop1> brand=( o1,  o2) ->{return o1.brand.compareTo(o2.brand);};	//Lambda Expression
		
		Comparator<Laptop1> ram=( o1,  o2) ->{return o1.ram-o2.ram;};	//Lambda Expression
				
		Comparator<Laptop1>price=( o1,  o2) ->{return (int) (o2.price-o1.price);};	//Lambda Expression
				
		Comparator<Laptop1>generation=(m1,m2) ->{return m1.generation-m2.generation;};	//Lambda Expression
					
		
		System.out.println("--------------------- After Sorting using brand -------------------------------------------------------------------------------");
		Collections.sort(e1,brand);
		System.out.println("\nBy Using Enhanced For Loop");
		for(Laptop1 e:e1) {
			System.out.println(e);
		}
		
		System.out.println("--------------------- After Sorting using Ram -------------------------------------------------------------------------------");
		Collections.sort(e1,ram);
		System.out.println("\nBy Using Iterator while Loop");
		Iterator<Laptop1> it=e1.iterator();
		while(it.hasNext())
			System.out.println(it.next().getRam());
		
		System.out.println("--------------------- After Sorting using price -------------------------------------------------------------------------------");
		Collections.sort(e1,price);
		System.out.println("\nBy Using ListIterator while Loop");
		ListIterator<Laptop1> lit=e1.listIterator();
		while(lit.hasNext())
			System.out.println(lit.next().getPrice());
		
		System.out.println("--------------------- After Sorting using generation -------------------------------------------------------------------------------");
		Collections.sort(e1,generation);
		System.out.println("\nBy Using Enumeration while Loop");
		Enumeration<Laptop1> enu=Collections.enumeration(e1);
		while(enu.hasMoreElements())
			System.out.println(enu.nextElement().generation);
	}

}

/*
  OutPut:
  
  Before Sorting
brand = Hp	price = 34000	ram = 4	generation = 7
brand = Dell	price = 44000	ram = 8	generation = 8
brand = Mac	price = 54000	ram = 4	generation = 7
brand = Hp	price = 40000	ram = 6	generation = 8
brand = ROG	price = 58000	ram = 8	generation = 7
brand = Dell	price = 39000	ram = 6	generation = 9
----------------------------------------------------------------------------------------------------
--------------------- After Sorting using brand -------------------------------------------------------------------------------

By Using Enhanced For Loop
brand = Dell	price = 44000	ram = 8	generation = 8
brand = Dell	price = 39000	ram = 6	generation = 9
brand = Hp	price = 34000	ram = 4	generation = 7
brand = Hp	price = 40000	ram = 6	generation = 8
brand = Mac	price = 54000	ram = 4	generation = 7
brand = ROG	price = 58000	ram = 8	generation = 7
--------------------- After Sorting using Ram -------------------------------------------------------------------------------

By Using Iterator while Loop
4
4
6
6
8
8
--------------------- After Sorting using price -------------------------------------------------------------------------------

By Using ListIterator while Loop
58000
54000
44000
40000
39000
34000
--------------------- After Sorting using generation -------------------------------------------------------------------------------

By Using Enumeration while Loop
7
7
7
8
8
9

*/
