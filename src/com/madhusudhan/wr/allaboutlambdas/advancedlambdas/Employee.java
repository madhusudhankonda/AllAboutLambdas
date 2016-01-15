package com.madhusudhan.wr.allaboutlambdas.advancedlambdas;

/**
 * Class to demonstrate the usage of constructor references
 * 
 * @author mkonda
 *
 */
public class Employee {

	/**
	 * An Employee created using an id
	 * @param id
	 */
	public Employee(int id) {
		// Logic for creating an employee with an id
	}

	/**
	 * An Employee created using an id and a name
	 * @param id
	 * @param name
	 */
	public Employee(int id, String name) {
		// Logic for creating an employee with an id and name.
	}

	// Interface representing the first constructor
	interface EmployeeById {
		public Employee create(int id);
	}

	// Interface representing the second constructor
	interface EmployeeByName {
		public Employee create(int id, String employee);
	}
	
	public void normalLambdaExpressions(){
		// Lambda invoking the first constructor - no const refs
		EmployeeById empLambda = id -> new Employee(id);

		// Lambda invoking the second constructor - no const refs
		EmployeeByName empNameLambda = 
		  (id, name) -> new Employee(id, name);
	}
	
	public void constructorReferencedLambdas(){
		// Both have the same constructor reference

		// Constructor reference invocation for first constructor
		EmployeeById empLambdaConstRef = Employee::new;
		// Constructor reference invocation for second constructor
		EmployeeByName empNameLambdaConstRef = Employee::new;

	}
}
