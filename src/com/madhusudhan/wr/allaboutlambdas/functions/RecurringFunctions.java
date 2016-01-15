package com.madhusudhan.wr.allaboutlambdas.functions;

import java.util.List;
import java.util.Properties;

import com.madhusudhan.wr.allaboutlambdas.domain.Patient;


public class RecurringFunctions {

	// Check if the movies belongs to thriller genre
	interface Movie{
	  boolean isThriller(int movieId);
	}

	// Get an employee given an id
	interface Employee{
	  Employee fetch(int empId);
	}

	// Admit the patient
	interface Hospital{
	  void admit(Patient patient);
	}

	// Supply  the properties required to seed the system
	interface Seeder{
	  List<Properties> seed(String system);
	}
	
	// Custom functions
	
	// Interface for checking conditionality
	interface Tester<T>{
	  boolean test(T t);
	}

	// Interface for Producing objects
	interface Producer<T>{
	  T produce(int id);
	}

	// Interface for consuming elements
	interface Consumer<T>{
	  void consume(T t);
	}
	
}
