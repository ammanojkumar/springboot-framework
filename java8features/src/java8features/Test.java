package java8features;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

@FunctionalInterface
interface Calc {
	public int sum(int a, int b);
}

class Student {
	
}

public class Test {

	public static void functionTest() {
		Function<Integer, Boolean> func1 = (t) -> (t % 2 == 0) ? true : false;
		System.out.println(func1.apply(12));
	}

	public static void biFunctionTest() {
		BiFunction<Integer, Integer, Integer> func1 = (i1, i2) -> i1 + i2;
		System.out.println(func1.apply(12, 12));
	}

	public static void binaryTest() {
		BinaryOperator<Integer> func1 = (i1, i2) -> i1 + i2;
		System.out.println(func1.apply(12, 12));
	}

	public static void unaryTest() {
		UnaryOperator<Integer> func1 = (i1) -> i1;
		System.out.println(func1.apply(12));
	}

	public static void predicateTest() {
		Predicate<Integer> pre = (i) -> i > 0;
		System.out.println(pre.test(12));

		BiPredicate<Integer, Float> bipre = (i, f) -> i > 0 && f > 0;
		System.out.println(bipre.test(-1, 1f));
	}

	public static void consumerTest() {
		Consumer<String> con = (str) -> System.out.println("Hello " + str);
		con.accept("manoj");

		BiConsumer<String, Integer> bicon = (str, i) -> {
			for (int j = 0; j < i; j++) {
				System.out.println("Hello " + str);
			}
		};
		bicon.accept("india", 5);
		bicon.accept("US", 2);
	}

	public static void supplierTest() {
		Supplier<Student> suplier = () -> new Student();
		Student student = suplier.get();
	}

	public static void main(String[] args) {
//		functionTest();
//		biFunctionTest();
//		binaryTest();
//		unaryTest();
//		predicateTest();
//		consumerTest();
	}
}
