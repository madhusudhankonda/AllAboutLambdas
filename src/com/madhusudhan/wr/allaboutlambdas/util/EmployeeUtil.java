package com.madhusudhan.wr.allaboutlambdas.util;

import java.util.ArrayList;
import java.util.List;

import com.madhusudhan.wr.allaboutlambdas.domain.Employee;
import com.madhusudhan.wr.allaboutlambdas.domain.Manager;


public class EmployeeUtil {
	public static List<Employee> createEmployees() {

		List<Employee> employees = new ArrayList<>();
		
		Manager manager1 = new Manager("Sarah James");
		Manager manager2 = new Manager("Elizabeth Williamson");
		
		Employee emp1 = new Employee(0,"Harry Barry", "Finance", true);
		emp1.setManager(manager1);
		emp1.setSenior(true);
		employees.add(emp1);
		
		
		Employee emp2 = new Employee(1,"Hasro Biko", "IT", false);
		emp2.setSenior(true);
		employees.add(emp2);
		
		emp2.setManager(manager2);
		
		Employee emp3 = new Employee(2,"Ram Nivas", "Strategy", true);
		employees.add(emp3);
		emp3.setManager(manager1);
		
		Employee emp4 = new Employee(3,"John Bhaijan", "Marketing", true);
		emp4.setSenior(true);
		employees.add(emp4);
		emp4.setManager(manager2);
		
		Employee emp5 = new Employee(3,"Kirk Carlos", "Marketing", false);
		employees.add(emp5);
		emp5.setManager(manager2);
		
		Employee emp6 = new Employee(3,"Kirk Carlos", "Marketing", false);
		employees.add(emp5);
		emp5.setManager(manager2);
		
		return employees;

	}
	
	public static List<Employee> createDetailedEmployees() {

		List<Employee> employees = new ArrayList<>();
		
		Manager manager1 = new Manager("Sarah James");
		Manager manager2 = new Manager("Elizabeth Williamson");
		
		Employee emp1 = new Employee(0,"Harry Barry", "Finance", "London");
		emp1.setExecutive(true);
		emp1.setSenior(true);
		emp1.setManager(manager1);
		employees.add(emp1);
		
		Employee emp2 = new Employee(1,"Hasro Biko", "IT", "New York");
		emp2.setExecutive(false);
		emp2.setSenior(false);
		employees.add(emp2);
		emp2.setManager(manager2);
		
		Employee emp3 = new Employee(2,"Ram Nivas", "Strategy", "London");
		employees.add(emp3);
		emp3.setExecutive(true);
		emp3.setSenior(true);
		emp3.setManager(manager1);
		
		Employee emp4 = new Employee(3,"John Bhaijan", "Marketing", "Hyderabad");
		employees.add(emp4);
		emp4.setExecutive(true);
		emp4.setSenior(true);
		emp4.setManager(manager2);
		
		Employee emp5 = new Employee(3,"Kirk Carlos", "Marketing", "New York");
		employees.add(emp5);
		emp5.setExecutive(false);
		emp5.setSenior(true);
		emp5.setManager(manager2);
		
		Employee emp6 = new Employee(3,"Kirk Carlos", "Marketing", "New York");
		employees.add(emp5);
		emp6.setExecutive(false);
		emp6.setSenior(true);
		emp5.setManager(manager2);
		
		return employees;

	}

	
}
