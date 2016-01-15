package com.madhusudhan.wr.allaboutlambdas.workingwithlambdas;

/**
 * A class to demonstrate effectively final variable access
 * 
 * @author mkonda
 *
 */
public class EffectivelyFinalLambda {

	// Instance variable
	private String instanceVariable = "Instance Variable";
	
	/**
	 * Method to test the local variable's effective final state.
	 * 
	 * 
	 */
	private void modifyLocalVariable() {
		// Local non-final variable
		int count = 0;

		// The Lambda which tries to modify the count
		// The code throws error as compiler won't allow (it must be effectively final)
		// new Thread(() -> System.out.println(count++) ).start();
	}

	/**
	 * Method that shows overriding the instance variable in a lambda
	 */
	private void modifyClassInstanceVariable() {
		// Local non-final variable
		instanceVariable = "Modified Instance Variable";
		// We can't modify (it must be effectively final)

		 new Thread(() -> System.out.println(instanceVariable) ).start();

	}

	
	public static void main(String[] args) {
		new EffectivelyFinalLambda().modifyLocalVariable();
		new EffectivelyFinalLambda().modifyClassInstanceVariable();
	}
}
