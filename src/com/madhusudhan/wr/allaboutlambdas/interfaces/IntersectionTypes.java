package com.madhusudhan.wr.allaboutlambdas.interfaces;

import java.io.Serializable;

/**
 * Class demonstrating the intersection types.
 * @author mkonda
 *
 */
public class IntersectionTypes {

	// Marker interface (no methods)
	interface Shape {
	}

	/**
	 * A functional interface
	 * @author mkonda
	 *
	 */
	@FunctionalInterface
	interface Ball {
		void bounce();
	}
	
	Ball b = () -> System.out.println("Bouncing..");
	
	Ball ball = 
			 (Ball & Shape)() -> System.out.println("Bouncing shape..");
			 
	Ball serializableBallLambda = (Ball&Serializable)() -> System.out.println("Bouncing serializable ball"); 
}
