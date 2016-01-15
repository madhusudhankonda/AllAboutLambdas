package com.madhusudhan.wr.allaboutlambdas.introducinglambdas;

public class GreetingExample {

	interface Greeting {
		public String sayHello(String g);
	}

//	Greeting greetingLambda = s -> {
//		return "Hello, " + s;
//	};

	Greeting greetingLambdaReference = s -> {
		return greet(s);
	};

	Greeting greetingLambdaReference2 = this::greet;
	
	private void invokeAGreeting(Greeting greeting){
		
	}
	
	private String greet(String s) {
		return "Hello, "+s;
	}

	public static void main(String[] args) {

	}

}
