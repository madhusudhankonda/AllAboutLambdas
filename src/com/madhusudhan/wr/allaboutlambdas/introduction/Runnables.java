package com.madhusudhan.wr.allaboutlambdas.introduction;

/**
 * Class demonstrating the various approaches of developing a Runnable and 
 * executing it in a new Thread. The point of interest is the lambda approach.
 *  
 * @author mkonda
 *
 */
public class Runnables {
	
	public static void main(String[] args) {
		Runnables client = new Runnables();
//		client.instanceRunnable();
//		client.anonymousRunnable();
		client.usingLambda();
	}

	/**
	 * This method demonstrates the executing the logic 
	 * via an instance of a Runnable provided to a Thread  
	 */
	public void instanceRunnable() {
		Runnable oldRunnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("Using traditional Runnable!");
				runErrands();
			}
		};

		new Thread(oldRunnable).start();
	}
	/**
	 * We create the runnable in-line	
	 */
	public void anonymousRunnable() {

		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Using anonymous Runnable!");
				runErrands();
			}
		}).start();
	}

	public void usingLambda() {
		Runnable runnableLambdaSimple = () -> runErrands();
		Runnable runnableLambda = () -> {
			System.out.println("Using a Lambda Expression");
			runErrands();
		};
		
		new Thread(runnableLambdaSimple).start();
		
		new Thread(() -> {
			System.out.println("Using a Lambda Expression");
			listErrands();
			runErrands();
		}).start();
		// Or using method references
		new Thread(this::runErrands).start();
		
		// Or chilling off
		new Thread(() -> stayRelax()).start();
		
		// Chilling off using method references
		new Thread(this::stayRelax).start();
		
	}

	private void listErrands() {
		System.out.println("Listing the errands!");
	}

	private void runErrands() {
		System.out.println("Running errands!");
	}

	private void stayRelax() {
		System.out.println("Chilling off!");
	}

}
