package com.madhusudhan.wr.allaboutlambdas.specialisedfunctions;

import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import com.madhusudhan.wr.allaboutlambdas.domain.Trade;

/**
 * Class that demonstrates Predicate function usage
 * 
 * @author mkonda
 *
 */
public class Primitives {

	int tradeQuantity = 0;
	
	// Two types must be specified
	Function<Integer, Integer> tradeQuantityLambda = id -> {
		// Fetch the quantity
		Trade t = getTrade(id);
		return t.getQuantity();
	};
	
	// The redundant type vanishes
	private UnaryOperator<Integer> unaryOperator = (id) -> {
		 return tradeQuantity;
	};

	private Trade getTrade(Integer id) {
		return new Trade(id);
	}

	
	private void binaryOp() {
		BinaryOperator<Integer> sumOfQuantities = (quantity1, quantity2) -> quantity1+quantity2;
		int result = sumOfQuantities.apply(30000, 44000);
		System.out.println("Sum total: "+result);
	}
	
	public static void main(String[] args) {
		new Primitives().binaryOp();
	}
}
