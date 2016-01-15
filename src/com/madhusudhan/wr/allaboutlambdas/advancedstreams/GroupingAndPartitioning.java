package com.madhusudhan.wr.allaboutlambdas.advancedstreams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;

import com.madhusudhan.wr.allaboutlambdas.domain.Employee;
import com.madhusudhan.wr.allaboutlambdas.util.EmployeeUtil;

/**
 * This class demonstrates the usage of groupingBy function
 * 
 * @author mkonda
 *
 */
public class GroupingAndPartitioning {

	List<Employee> employees = EmployeeUtil.createDetailedEmployees();

	/**
	 * Grouping by department function
	 */
	private void groupingByDepartment() {
		Map<String, List<Employee>> deptEmployees = employees
			.stream()
			.collect(groupingBy(e -> e.getDepartment()));
		
		System.out.println(deptEmployees);
	}

	/**
	 * Grouping by city
	 */
	private void groupingByCity() {
		Map<String, List<Employee>> cityEmployees = employees
			.stream()
			.collect(Collectors.groupingBy(Employee::getCity));
		System.out.println(cityEmployees);
	}
	
	/**
	 * Multi-level grouping usage: group employees by department and city
	 */
	private void groupingByDeptAndCity() {
		Map<String, Map<String, List<Employee>>> deptAndCityEmployees =
				employees.stream()
		.collect(groupingBy((Employee::getDepartment), groupingBy(Employee::getCity)));
		System.out.println(deptAndCityEmployees);
	}
	
	private void partitionByExecutives() {
		Map<Boolean, List<Employee>> empPartition = employees
				.stream()
				.collect(Collectors.partitioningBy(Employee::isExecutive));
	
		System.out.println(empPartition);
	}
	
	private void partitioningAndGrouping() {
		Map<Boolean, Map<String, List<Employee>>> execEmployees = employees
			.stream()
			.collect(partitioningBy((Employee::isExecutive), groupingBy(Employee::getDepartment)));
		
		for(Boolean b: execEmployees.keySet()){
			System.out.println(b+" --> "+execEmployees.get(b));
		}
	}
	
	private void multiLevelPartitioning() {
		Map<Boolean, Map<Boolean, List<Employee>>> execEmployees = employees
			.stream()
			.collect(
				partitioningBy((Employee::isExecutive), 
				partitioningBy(Employee::isSenior)));
		
		for(Boolean b: execEmployees.keySet()){
			System.out.println(b+":"+execEmployees.get(b));
		}

	}
	public static void main(String[] args) {
//		new GroupingAndPartitioning().groupingByDepartment();
//		new GroupingAndPartitioning().groupingByCity();
//		new GroupingAndPartitioning().groupingByDeptAndCity();
//		new GroupingAndPartitioning().partitionByExecutives();
//		new GroupingAndPartitioning().partitioningAndGrouping();
		new GroupingAndPartitioning().multiLevelPartitioning();
	}
}
