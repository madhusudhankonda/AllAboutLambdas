package com.madhusudhan.wr.allaboutlambdas.interfaces;

public class DinerImpl implements Diner{
	
	public String order(String order, Diner lambda) {
		return lambda.order(order);
	}
	
	@Override
	public String order(String order) {
		
		StringBuilder breakfastCoffeeOrder = new StringBuilder();
		
		String coffee = getCoffee();
		String breakfast = getEnglishBreakfast();
		return breakfastCoffeeOrder
				.append(coffee)
				.append(" with ")
				.append(breakfast).toString();
	}
	
	public static void main(String[] args) {
		DinerImpl impl = new DinerImpl();
		String breakfast = impl.order("Breakfast");
		System.out.println(breakfast);
	
		Diner dineOrder = s -> {
			return "Breakfast on its way for "+s;
		};
		String lambdaOrder = impl.order("Mr Harry", dineOrder);
		Diner.payBill(24.50);
		System.out.println(lambdaOrder);
	}
}
