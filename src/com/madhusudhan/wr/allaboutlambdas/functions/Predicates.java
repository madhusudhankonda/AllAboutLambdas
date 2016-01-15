package com.madhusudhan.wr.allaboutlambdas.functions;

import java.util.List;
import java.util.function.Predicate;

import com.madhusudhan.wr.allaboutlambdas.domain.Employee;
import com.madhusudhan.wr.allaboutlambdas.domain.Patient;
import com.madhusudhan.wr.allaboutlambdas.domain.Trade;

/**
 * Class that demonstrates Predicate function usage
 * 
 * @author mkonda
 *
 */
public class Predicates {

	interface Triage{
		// Is the condition of the patient critical
		boolean evaluate(Patient patient);
	}
	
	interface Hospital{
		void admit(Patient patient);
	}

	/**
	 * Does the Employee has enough rating
	 */
	Predicate<Employee> bonusEligible = emp -> emp.getRatings() > 10;
	
	
	
	Triage t = patient -> patient.isSerious();
	Hospital h = p -> System.out.println(p);
	
	Predicate<Patient> hospital = patient -> {
		return patient.isSerious();
	};
	
	
	/**
	 *  AND function
	 */
	
	Predicate<Trade> cancelledTrade = Trade::isCancelledTrade;
	Predicate<Trade> bigTrade =Trade::isBigTrade;

	// A cancelled & big trade predicate
	Predicate<Trade>composedLambda = cancelledTrade.and(bigTrade);
	
	/**
	 *  OR function
	 */
	
	// Predicate for NEW status
	Predicate<Trade> newTrade =  Trade::isNew;

	// Predicate for PENDING status
	Predicate<Trade> pendingTrade = Trade::isPending;
	
	// Either new or pending trade
	Predicate<Trade> orLambda = newTrade.or(pendingTrade);
	
	// New or pending but big trade
	Predicate<Trade> newOrPendingButBigTrade = newTrade.or(pendingTrade).and(bigTrade);
	
	// We know there's a predicate for new trade: 
	//And this becomes a predicate for anything but new:
	Predicate<Trade> notNewTrade = newTrade.negate();

	private void isEqualMethod(List<Trade> trades) {
		// Reference trade
		Trade t1 = new Trade("GOOGLE", 200000, "CANCEL");
		Predicate<Trade> p1 = Predicate.isEqual(t1);
		// Predicate which compares the given trades
		for(Trade tr: trades){
		  if(p1.test(tr)){
		    System.out.println("Found a matching trade: "+tr);
		  }
		}
		// using streams
		if(trades.stream().anyMatch(p1)){
			
		}

	}
}
