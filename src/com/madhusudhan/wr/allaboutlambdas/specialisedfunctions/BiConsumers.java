package com.madhusudhan.wr.allaboutlambdas.specialisedfunctions;

import java.util.function.BiConsumer;

import com.madhusudhan.wr.allaboutlambdas.domain.Employee;

/**
 * Class that demonstrates Predicate function usage
 * 
 * @author mkonda
 *
 */
public class BiConsumers {
	
	BiConsumer<Employee, Integer> empBonusConsumer = 
			(emp, bonus) -> System.out.printf("Employee %s is set of %d pct of bonus:", emp, bonus);
			
	BiConsumer<Employee, Integer> empSalHikeConsumer = (emp, sal) ->
		System.out.printf("Employee %s is receiving %d hike in salary", emp, sal);
		
	
	
	private void testBiConsumer(Employee emp, Integer bonus, Integer salaryHike) {
		empBonusConsumer.accept(emp, bonus);
	}

	private void usingAndThen() {
		// BiConsumer
		BiConsumer<Employee, Integer> empBonusAndHikeConsumer = empBonusConsumer.andThen(empSalHikeConsumer);
	}
	
	public static void main(String[] args) {
		Employee emp = new Employee(10);
		int bonus = 5;
		int salaryHike = 15;
		new BiConsumers().testBiConsumer(emp, bonus, salaryHike);
	}

}
