package com.madhusudhan.wr.allaboutlambdas.specialisedfunctions;

import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongSupplier;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.Predicate;

import com.madhusudhan.wr.allaboutlambdas.domain.Employee;
import com.madhusudhan.wr.allaboutlambdas.domain.Patient;

/**
 * Class that demonstrates specialised functions for primitives usage
 * 
 * @author mkonda
 *
 */
public class SpecialisedFunctions {

	/**
	 * Method to check an even number function
	 * @param number
	 */
	private void checkEvenNumber(int number) {
		Predicate<Integer> evenNumber = x -> x % 2 == 0;

		// Testing the lambda
		System.out.println("The number is even?: "+evenNumber.test(number));
	}

	private void checkEvenNumberUsingIntPredicate(int number) {
		IntPredicate evenNumber = x -> x % 2 == 0;

		// Testing the lambda
		System.out.println("The number is even?: "+evenNumber.test(number));
	}

	/** 
	 * Examples of double and long predicates
	 * 
	 */
	private void specialisedPredicates(){
		DoublePredicate doublePredicate = x -> x*0.01 < 1;
		LongPredicate longPredicate = x -> x < 10;
	}
	
	private void specialisedConsumers(){
		IntConsumer intConsumer = x -> doSomething(x);
		intConsumer.accept(10);
		DoubleConsumer doubleConsumer =  x -> doSomething(x);
		doubleConsumer.accept(20.50);
		LongConsumer longConsumer =  x -> doSomething(x);
		longConsumer.accept(100l);
	}
	
	private void specialisedSuppliers(){
		IntSupplier intSupplier= () -> 2;
		int value = intSupplier.getAsInt();
		System.out.println("Supplier supplied with (int)"+value);
		
		DoubleSupplier doubleSupplier =  () -> Math.PI;
		double piValue = doubleSupplier.getAsDouble();
		System.out.println("Supplier supplied with (double)"+piValue);
		
		LongSupplier lognSupplier =  () -> 100l;
		long longValue = lognSupplier.getAsLong();
		System.out.println("Supplier supplied with (long) "+longValue);
	}
	
	/**
	 * Functions specialised for primitives
	 */
	private void specialisedFunctions(){
		// Using non-specialised function
		Function<Integer, Employee> empFunction = null;
		// Converting to a specialised function
		IntFunction<Employee> empFunction2 = null;
		

		// A double is provided and a String is returned
		DoubleFunction<String> doubleFunction = d -> "PI is  "+d;
		doubleFunction.apply(3.14);
		
		// Given a long id, a patient is returned
		LongFunction<Patient> longFunction = id -> new Patient(id);
		longFunction.apply(10L);
	}
	
	private void primitiveConversionFunctions(){
		
		LongToIntFunction longToInt = x -> Math.round(x);
		
		// Given a double value, return an integer
		DoubleToIntFunction doubleToInt = x -> 1;
		IntToLongFunction intToLongFunction = id -> {
			// Populate long value
			long encryptedId = 385038204;// prepare an encrypted id
			return encryptedId;
		};
	}
	
	private void unitypeSpecialisedFunctions() {
		DoubleUnaryOperator doubleUnaryOperator = d -> d*0.01;
		IntUnaryOperator intUnaryOperator = i -> i*100;
		LongUnaryOperator longUnaryOperator = l-> l+l;
		
		double d = doubleUnaryOperator.applyAsDouble(10);
		int i = intUnaryOperator.applyAsInt(10);
		long l = longUnaryOperator.applyAsLong(10);
		
		System.out.println(d+","+i+", "+l);
	}
	
	IntSupplier intSupplier= () -> 2;
	private void doSomething(int x) {
		System.out.println("Consuming (int): "+x);
	}
	private void doSomething(double x) {
		System.out.println("Consuming (double): "+x);
	}
	private void doSomething(long x) {
		System.out.println("Consuming (long): "+x);
	}

	public static void main(String[] args) {
		new SpecialisedFunctions().checkEvenNumber(91);
		new SpecialisedFunctions().specialisedConsumers();
		new SpecialisedFunctions().unitypeSpecialisedFunctions();
	}
}
