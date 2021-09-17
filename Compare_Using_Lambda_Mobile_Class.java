package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;



class Mobile1 implements Comparable<Mobile1>{
	String name,camera;
	int ram;
	double price;
	public String getName() {
		return name;
	}
	
	public int getId() {
		return ram;
	}
	public double getprice() {
		return price;
	}
	public String getCamera() {
		return camera;
	}
	public Mobile1(String name, int ram, double price,String camera) {
		super();
		this.name = name;
		this.camera=camera;
		this.ram = ram;
		this.price = price;
	}
	@Override
	public String toString() {
		return ",\tname = " + name +"Ram = " + ram + ",\tPrice = " + price+"\tCamera = "+camera  ;
	}
	@Override
	public int compareTo(Mobile1 o) {
		return 0;
	}
	
}
public class Compare_Using_Lambda_Mobile_Class {

	public static void main(String[] args) {
List<Mobile1> e1=new ArrayList<Mobile1>();
		
		e1.add(new Mobile1("Iphone 7", 2, 34000.50,"08px" ));
		e1.add(new Mobile1("Readmi Note5", 4, 15000, "32px"));
		e1.add(new Mobile1("Samsung M31", 6 , 18200, "64px"));
		e1.add(new Mobile1("Iphone 8s", 4, 40000, "12px"));
		e1.add(new Mobile1("Vivo 9pro", 6, 26000, "48px"));
		e1.add(new Mobile1("Samsung j7", 4, 11000, "32px"));
		e1.add(new Mobile1("Oppo F9", 6, 28000, "48px"));
		
		System.out.println("Before Sorting");
		for(Mobile1 e:e1)
			System.out.println(e);
		
		System.out.println("----------------------------------------------------------------------------------------------------");
		Comparator<Mobile1> Name=( o1,  o2)-> {return o1.name.compareTo(o2.name);};	//Lambda Expression
		
		Comparator<Mobile1> ram=( o1,  o2)-> {return o1.ram-o2.ram;};	//Lambda Expression
				
		Comparator<Mobile1>price=( o1,  o2)-> {return (int) (o2.price-o1.price);};	//Lambda Expression
				
		Comparator<Mobile1>camera=( m1,m2)-> {return m1.camera.compareTo(m2.camera);};	//Lambda Expression
						
		System.out.println("--------------------- After Sorting using Name -------------------------------------------------------------------------------");
		Collections.sort(e1,Name);
		System.out.println("\nBy Using Enhanced For Loop");
		for(Mobile1 e:e1) {
			System.out.println(e);
		}
		
		System.out.println("--------------------- After Sorting using Ram -------------------------------------------------------------------------------");
		Collections.sort(e1,ram);
		System.out.println("\nBy Using Iterator while Loop");
		Iterator<Mobile1> it=e1.iterator();
		while(it.hasNext())
			System.out.println(it.next().getId());
		
		System.out.println("--------------------- After Sorting using price -------------------------------------------------------------------------------");
		Collections.sort(e1,price);
		System.out.println("\nBy Using ListIterator while Loop");
		ListIterator<Mobile1> lit=e1.listIterator();
		while(lit.hasNext())
			System.out.println(lit.next().getprice());
		
		System.out.println("--------------------- After Sorting using Camera -------------------------------------------------------------------------------");
		Collections.sort(e1,camera);
		System.out.println("\nBy Using Enumeration while Loop");
		Enumeration<Mobile1> enu=Collections.enumeration(e1);
		while(enu.hasMoreElements())
			System.out.println(enu.nextElement().camera);
	}

}

/*
	OutPut:

Before Sorting
,	name = Iphone 7Ram = 2,	Price = 34000.5	Camera = 08px
,	name = Readmi Note5Ram = 4,	Price = 15000.0	Camera = 32px
,	name = Samsung M31Ram = 6,	Price = 18200.0	Camera = 64px
,	name = Iphone 8sRam = 4,	Price = 40000.0	Camera = 12px
,	name = Vivo 9proRam = 6,	Price = 26000.0	Camera = 48px
,	name = Samsung j7Ram = 4,	Price = 11000.0	Camera = 32px
,	name = Oppo F9Ram = 6,	Price = 28000.0	Camera = 48px
----------------------------------------------------------------------------------------------------
--------------------- After Sorting using Name -------------------------------------------------------------------------------

By Using Enhanced For Loop
,	name = Iphone 7Ram = 2,	Price = 34000.5	Camera = 08px
,	name = Iphone 8sRam = 4,	Price = 40000.0	Camera = 12px
,	name = Oppo F9Ram = 6,	Price = 28000.0	Camera = 48px
,	name = Readmi Note5Ram = 4,	Price = 15000.0	Camera = 32px
,	name = Samsung M31Ram = 6,	Price = 18200.0	Camera = 64px
,	name = Samsung j7Ram = 4,	Price = 11000.0	Camera = 32px
,	name = Vivo 9proRam = 6,	Price = 26000.0	Camera = 48px
--------------------- After Sorting using Ram -------------------------------------------------------------------------------

By Using Iterator while Loop
2
4
4
4
6
6
6
--------------------- After Sorting using price -------------------------------------------------------------------------------

By Using ListIterator while Loop
40000.0
34000.5
28000.0
26000.0
18200.0
15000.0
11000.0
--------------------- After Sorting using Camera -------------------------------------------------------------------------------

By Using Enumeration while Loop
08px
12px
32px
32px
48px
48px
64px

*/