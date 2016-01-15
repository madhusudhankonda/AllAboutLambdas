package com.madhusudhan.wr.allaboutlambdas.interfaces;

import com.madhusudhan.wr.allaboutlambdas.domain.Patient;
import com.madhusudhan.wr.allaboutlambdas.domain.Vehicle;

/**
 * A functional interface for admitting a patient. 
 * @author mkonda
 *
 */
@FunctionalInterface
interface Hospital {
	void admit(Patient patient);
}

/**
 * An interface that may or may be not used as a functional interface
 * @author mkonda
 *
 */
//@FunctionalInterface
interface Factory {
	Vehicle create(int id);
	
	// Additional abstract method
	// uncomment this method to find out that all lambda expressions will be broken
	// boolean scrap(int id);

}

public class Interfaces {
	
	// Lambda for a general patient
	Hospital generalAdmittance = (p) -> {
		System.out.println("Admitting patient to a general ward: "+p);
		general(p);
	};
	
	// Same as above lambda, this time using method ref
	Hospital generalAdmittanceMethodRef = this::general;
	
	// Lambda for an emergency admittance
	Hospital emergencyAddmittance = (p) -> System.out.println("Admitting patient to A&E: "+p);
	Factory factory = id -> new Vehicle(id);
	
	
	private void general(Patient p) {
		System.out.println("General ward admitted patient: "+p);
	}
	
	private void emergency(Patient p) {
		System.out.println("Patient admitted to A&E: "+p);
	}
	

}
