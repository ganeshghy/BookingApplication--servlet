package com.classes.dao;

class Car {

	Car() {
		System.out.println("car construct");
	}

	void m1() {
		System.out.println("method-1");
	}

	void m2() {
		System.out.println("mehtod-2");
	}
}

class Bike extends Car {

	Bike(int i) {
		System.out.println("Bike constructor" + i);
	}

	void m3() {
		System.out.println("method-3");
	}

	void m4() {
		System.out.println("method-4");
	}
}

public class Doubt {
	public static void main(String args[]) {
		System.out.println("hello");

		Bike b = new Bike(19);

		Car c = new Bike(10);

		Car c1 = new Car();

//		c.m2();
//		b.m1();
//		b.m2();
//		

	}
}
