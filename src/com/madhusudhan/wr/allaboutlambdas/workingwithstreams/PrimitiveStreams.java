package com.madhusudhan.wr.allaboutlambdas.workingwithstreams;

import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

import com.madhusudhan.wr.allaboutlambdas.domain.Trade;
import com.madhusudhan.wr.allaboutlambdas.util.TradeUtil;


/**
 * This class demonstrates the working of streams with primitives
 * 
 * @author mkonda
 *
 */
public class PrimitiveStreams {
	List<Trade> trades = TradeUtil.createTrades();
	
	/**
	 * Creating stream of ints - IntStream
	 */
	private void intStream() {
		int[] ints = new int[]{10,20,30,40,50};
		
		IntStream intStream = IntStream.of(ints);
		intStream.forEach(System.out::println);
		
		IntStream intStream2 = IntStream.of(10,20,30,40,50);
		intStream2.forEach(System.out::println);
	}

	/**
	 * Creating stream of doubles - DoubleStream
	 */
	private void doubleStream() {
		double[] doubles = new double[]{2.4, 4.2, 6.3, 8.5, 10.1};
		DoubleStream doubleStream1 = DoubleStream.of(doubles);
		doubleStream1.forEach(System.out::println);
		
		DoubleStream doubleStream2 = DoubleStream.of(1.1,22.33,3.4);
		doubleStream2.forEach(System.out::println);
	}
	/**
	 * Summing up the quantity using Object references. The quantity is boxed up.
	 */
	private void sumUsingObjectStream() {
		 Optional<Integer> sumQuantity = trades
				 .stream()
				 .map(Trade::getQuantity)
				 .reduce(Integer::sum);
		 
		 System.out.println("Total quantity (using object stream):"+sumQuantity.get());
		}
	
	/**
	 *  Summing up the quantity using primitive stream. The Object stream is converted to a primitive stream
	 */
	private void sumUsingPrimitiveStream() {
		int sumQuantity = trades
				.stream()
				.mapToInt(Trade::getQuantity)
				.sum();
		
		System.out.println("Total quantity (using primitive stream):"+sumQuantity);
	}

	public static void main(String[] args) {
		new PrimitiveStreams().intStream();
		new PrimitiveStreams().doubleStream();
		new PrimitiveStreams().sumUsingObjectStream();
		new PrimitiveStreams().sumUsingPrimitiveStream();
	}

}
