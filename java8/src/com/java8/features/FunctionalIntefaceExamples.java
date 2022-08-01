package com.java8.features;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class FunctionalIntefaceExamples {

	// Function, Predicate, Consumer, Supplier
	public static void main(String[] args) {
		Function<Integer, Boolean> evenNumbers = (i) -> i % 2 == 0;
		UnaryOperator<Integer> SquareUnaryOperator = (i) -> i * i;

		BiFunction<Integer, String, Boolean> biFunction;
		BinaryOperator<Integer> binaryOperator;

		Predicate<String> predicate = (str) -> str.length() > 5;
		BiPredicate<Integer, Integer> biPredicate;

		Consumer<String> consumer = (a) -> System.out.println();
		;
	}
}
