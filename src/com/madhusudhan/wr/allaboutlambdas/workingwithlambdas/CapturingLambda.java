package com.madhusudhan.wr.allaboutlambdas.workingwithlambdas;


public class CapturingLambda {

	private String defaultGreeting = "Howdy, ";

	interface Greeting {
		void sayHello(String name);
	}

	private void accessLambdaVariables() {
		Greeting g = (name) -> {
			System.out.println(name);
		};
		
		// Cannot access lamdba's input variable
       // System.out.println("Can I access lambda's variable:"+name);
	}

	private void accessInstanceVariables() {
		Greeting g = (name) -> {
			// Accessing an instance variable 
			System.out.println(defaultGreeting + name);
		};
	}


	public static void main(String[] args) {
		CapturingLambda cl = new CapturingLambda();

	}

}
