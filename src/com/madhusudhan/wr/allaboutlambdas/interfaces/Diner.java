package com.madhusudhan.wr.allaboutlambdas.interfaces;

@FunctionalInterface
public interface Diner {

	String order(String order);

	default String getCoffee() {
		return "Cappuccino ";
	}

	default String getIndianBreakfast() {
		return "Idly, Sambar and a Dosa";
	}

	default String getEnglishBreakfast() {
		return "Eggs, Sausages, Beans and a Toast";
	}

	static String payBill(double billAmount) {
		return "Thank you for your custom, see you next time!";
	}
}
