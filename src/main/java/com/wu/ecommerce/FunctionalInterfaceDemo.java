package com.wu.ecommerce;

@FunctionalInterface
public interface FunctionalInterfaceDemo {
	public int add(int a, int b);

	default void test() {
		System.out.println("Hi");
	}

	default void test1() {
		System.out.println("Hello");
	}

	default void test2() {
		System.out.println("Bye");
	}
}

class Test{
	public static void getResult( FunctionalInterfaceDemo demo) {
	     int result=demo.add(10, 20);
	     System.out.println(result);
	}
	public static void main(String[] args) {
		getResult((a,b)->a+b);
	}
}
