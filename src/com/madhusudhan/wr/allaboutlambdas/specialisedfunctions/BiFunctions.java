package com.madhusudhan.wr.allaboutlambdas.specialisedfunctions;

import java.util.function.BiFunction;
import java.util.function.Function;

import com.madhusudhan.wr.allaboutlambdas.domain.Employee;
import com.madhusudhan.wr.allaboutlambdas.domain.Manager;

/**
 * Class that demonstrates Predicate function usage
 * 
 * @author mkonda
 *
 */
public class BiFunctions {
	
	
	BiFunction<Employee, Manager, Employee> empManagerBiFunction = (emp, manager) ->{
		Employee employee = null;
		if(emp.getManager().equals(manager)) 
			employee = manager.getPersonalAssistant();
		return employee;
	};
	
	Function<Employee, Employee> emplManagerFunction = emp -> emp.getManager().getPersonalAssistant();
	
	// Single argument function
	Function<Employee, Employee> empManagerFunction = emp -> emp.getManager().getPersonalAssistant();

	private void biFunction(Employee emp, Manager manager) {
		Employee employee = empManagerBiFunction.apply(emp, manager);
		System.out.println("Employee"+employee);
	}

	private void testAndThen(Employee emp, Manager manager) {
		BiFunction<Employee, Manager, Employee> personalAssistant=  empManagerBiFunction.andThen(empManagerFunction);	
	}

	public static void main(String[] args) {
		Employee emp = new Employee(99);
		Manager manager = new Manager();
		emp.setManager(manager);
		manager.setPersonalAssistant(emp);
		new BiFunctions().biFunction(emp, manager);
	}

}
