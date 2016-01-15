package com.madhusudhan.wr.allaboutlambdas.interfaces;
/**
 * A class that shows us how we can inherit behavior implementing various default methods  
 * @author mkonda
 *
 */
public class InheritingBehaviour {

	/**
	 * An Engine interface
	 * @author mkonda
	 *
	 */
	interface Engine {
		default String make() {
			return "DEFAULT MAKE";
		}
	}

	interface Vehicle {
		default String model() {
			return "DEFAULT MODEL";
		}
	}

	class Car implements Engine, Vehicle {
		public String getMakeAndModel() {
			return Engine.super.make() + ":" + Vehicle.super.model();
		}
	}
}
