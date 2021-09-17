package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;



class Laptop implements Comparable<Laptop>{
	
	int price;
	int ram,generation;
	String brand;
	
	public Laptop( String brand,int price, int ram, int generation) {
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
	public int compareTo(Laptop o) {
		return 0;
	}
	
}
public class Compare_Inner_Anno_Laptop_Class {

	public static void main(String[] args) {
List<Laptop> e1=new ArrayList<Laptop>();
		
		e1.add(new Laptop("Hp", 34000,4,7 ));
		e1.add(new Laptop("Dell", 44000,8,8 ));
		e1.add(new Laptop("Mac", 54000,4,7 ));
		e1.add(new Laptop("Hp", 40000,6,8 ));
		e1.add(new Laptop("ROG", 58000,8,7 ));
		e1.add(new Laptop("Dell", 39000,6,9 ));
		
		System.out.println("Before Sorting");
		for(Laptop e:e1)
			System.out.println(e);
		
		System.out.println("----------------------------------------------------------------------------------------------------");
		Comparator<Laptop> brand=new Comparator<Laptop>() {
			public int compare(Laptop o1, Laptop o2) {
				return o1.brand.compareTo(o2.brand);
			}
		};
		Comparator<Laptop> ram=new Comparator<Laptop>() {
			public int compare(Laptop o1,Laptop o2) {
				return o1.ram-o2.ram;
			}
		};
		Comparator<Laptop>price=new Comparator<Laptop>() {
			public int compare(Laptop o1,Laptop o2) {
				return (int) (o2.price-o1.price);
			}
		};
		Comparator<Laptop>generation=new Comparator<Laptop>() {
			public int compare(Laptop m1,Laptop m2) {
				return m1.generation-m2.generation;
			}
		};
		
		
		System.out.println("--------------------- After Sorting using brand -------------------------------------------------------------------------------");
		Collections.sort(e1,brand);
		System.out.println("\nBy Using Enhanced For Loop");
		for(Laptop e:e1) {
			System.out.println(e);
		}
		
		System.out.println("--------------------- After Sorting using Ram -------------------------------------------------------------------------------");
		Collections.sort(e1,ram);
		System.out.println("\nBy Using Iterator while Loop");
		Iterator<Laptop> it=e1.iterator();
		while(it.hasNext())
			System.out.println(it.next().getRam());
		
		System.out.println("--------------------- After Sorting using price -------------------------------------------------------------------------------");
		Collections.sort(e1,price);
		System.out.println("\nBy Using ListIterator while Loop");
		ListIterator<Laptop> lit=e1.listIterator();
		while(lit.hasNext())
			System.out.println(lit.next().getPrice());
		
		System.out.println("--------------------- After Sorting using generation -------------------------------------------------------------------------------");
		Collections.sort(e1,generation);
		System.out.println("\nBy Using Enumeration while Loop");
		Enumeration<Laptop> enu=Collections.enumeration(e1);
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
