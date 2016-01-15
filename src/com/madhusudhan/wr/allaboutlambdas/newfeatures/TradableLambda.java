package com.madhusudhan.wr.allaboutlambdas.newfeatures;

import java.util.List;
import java.util.concurrent.Callable;

import com.madhusudhan.wr.allaboutlambdas.domain.Employee;
import com.madhusudhan.wr.allaboutlambdas.domain.Manager;
import com.madhusudhan.wr.allaboutlambdas.domain.Movie;
import com.madhusudhan.wr.allaboutlambdas.domain.Trade;
import com.madhusudhan.wr.allaboutlambdas.util.MovieUtil;

/**
 * This class defines few lambda expressions.
 * @author mkonda
 *
 */
public class TradableLambda {

	/**
	 * a functional interface for checking conditions on a given trade, 
	 * returning boolean value
	 *
	 * @param <Trade>
	 */
	interface Tradable<Trade>{
		boolean check(Trade t);
	}
	
	/**
	 * A method that accepts a Tradable (lambda) along with a Trade instance
	 * @param tradable
	 * @param trade
	 */
	public void checkTrade(Tradable<Trade> tradable, Trade trade){
		System.out.println("Check: "+tradable.check(trade));
	}
	
	public static void main(String[] args) {
	
		Trade trade = new Trade(1,"APPLE",15000000,"NEW");
		
		// Check for a big trade
		Tradable<Trade> bigTradeLambda = (t)-> t.isBigTrade();
		new TradableLambda().checkTrade(bigTradeLambda, trade);
		
		// Check for a cancelled trade
		Tradable<Trade> cancelledLambda = (t)-> t.isCancelledTrade();
		new TradableLambda().checkTrade(cancelledLambda, trade);
		
		// Check for a new or unknown trade
		Tradable<Trade> newOrUnknownTrade = (t)-> {
			return t.getStatus().equals("NEW") || t.getStatus().equals("UNKNOWN");
		};
		new TradableLambda().checkTrade(newOrUnknownTrade, trade);
	}
}
