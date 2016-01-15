package com.madhusudhan.wr.allaboutlambdas.introducinglambdas;

import com.madhusudhan.wr.allaboutlambdas.domain.Trade;

/**
 * This class defines few lambda expressions.
 * @author mkonda
 *
 */
public class LambdaTasters {
	
	interface Quote{
		void quoteOfTheDay();
	}
	
	interface Instrument<T>{
		String extract(T t);
	}
	
	// Lambda printing out a quote
	Quote quoteLambda = () ->System.out.println("Hello, Lambdas!");
	
	// Lambda fetching the instrument of a Trade
	Instrument<Trade> instrumentLambda = ( t ) -> t.getInstrument();

	public static void main(String[] args) {
	
	}

}
