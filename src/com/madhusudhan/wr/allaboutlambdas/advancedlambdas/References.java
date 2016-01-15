package com.madhusudhan.wr.allaboutlambdas.advancedlambdas;

/**
 * Class to demonstrate the usage of method and constructor references
 * @author mkonda
 *
 */
public class References {

	/**
	 * Movie checker functional interface
	 * @author mkonda
	 *
	 */
	interface MovieChecker {
		boolean check(int movieId);
	}


	interface Greeting {
		public String sayHello(String g);
	}
	
	/**
	 * To check instance method reference
	 */
	private void instanceMethodRef() {
		ReferenceUtil util = new ReferenceUtil();
		// Lambda version
		MovieChecker isClassic = movieId -> util.isClassic(movieId);
		// Instance Method Ref version
		MovieChecker isClassicLambda = util::isClassic;
		
		
	}
	
	private String greet(String s) {
		return null;
	}

	/**
	 * Examples of method references
	 */
	private void exampleMethodReferences() {
		// Another example of a normal lambda
				Greeting greetingLambdaReference = s -> {
					return greet(s);
				};

				// Lambda using a method reference.
				Greeting greetingLambdaReference2 = this::greet;

				// Or 
			
				Runnable r = () -> print();
				
				// using method references
				r = this::print;
	}

	private void print() {
		System.out.println();
	}

	/**
	 * To check static method
	 */
	private void staticMethodRef() {
		// Lambda version
		MovieChecker isClassic = movieId -> ReferenceUtil.isHorror(movieId);
		// Static Method Ref version
		MovieChecker isClassicLambda = ReferenceUtil::isHorror;
	}
	
	/**
	 * To check arbitrary method reference functionality
	 */
	private void arbitraryMethodRef() {
		// Lambda version
		MovieChecker boxofficeHit = ArbitraryClass::isBoxOfficeHit;
		// Static Method Ref version
		MovieChecker isClassicLambda = ReferenceUtil::isHorror;

	}

	/**
	 * An existing instance method to check if the movie falls in classic
	 * category
	 * 
	 * @param movieId
	 * @return
	 */
	public boolean isClassic(int movieId) {
		boolean isClassic = false;
		if (movieId < 1000) {
			isClassic = true;
		}
		return isClassic;
	}

	/**
	 * An existing instance method for checking if the movie is a horror movie
	 * 
	 * @param movieId
	 * @return
	 */
	
}

/**
 * Some arbitrary class that gets used by a lambda 
 * @author mkonda
 *
 */
class ArbitraryClass {

	public static boolean isBoxOfficeHit(int movieId) {
		// logic in finding the box office collections goes here.
		return true;
	}
}
