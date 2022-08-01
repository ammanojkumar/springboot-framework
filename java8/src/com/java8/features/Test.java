package com.java8.features;

@FunctionalInterface
interface Calculator {
	int operate(int a, int b);

	static <T> void print(T a) {
		System.out.println(a);
	}

	default <V> void printit(V v) {
		System.out.println(v);
	}
}

public class Test {

	public static void main(String[] args) {
		Calculator sum = (a, b) -> a + b;
		Calculator substract = (a, b) -> a - b;
		Calculator.print(sum.operate(1, 2));
		sum.printit(substract.operate(2, 2));
	}
}
