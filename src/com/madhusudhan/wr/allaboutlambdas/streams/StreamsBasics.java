package com.madhusudhan.wr.allaboutlambdas.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.madhusudhan.wr.allaboutlambdas.domain.Trade;
import com.madhusudhan.wr.allaboutlambdas.util.TradeUtil;

/**
 * This class is used to explain the differences in pre-Java8 and Java 8 style
 * of programming
 * 
 * @author mkonda
 *
 */
public class StreamsBasics {
	private int ONE_MILLION = 1000000;
	List<Trade> trades = TradeUtil.createTrades();

	private List<Trade> findLargeTradesPreJava8(List<Trade> trades) {
		List<Trade> largeTrades = new ArrayList<Trade>();

		for (Trade trade : trades) {
			if (trade.getQuantity() > ONE_MILLION && trade.isCancelledTrade()) {
				largeTrades.add(trade);
			}
		}
		return largeTrades;
	}

	private List<Trade> findLargeTradesUsingStreams(List<Trade> trades) {
		return trades.stream().filter(trade -> trade.getQuantity() > ONE_MILLION)
				.filter(Trade::isCancelledTrade).collect(Collectors.toList());
	}

	private List<Trade> findLargeTradesUsingParallelStreams(List<Trade> trades) {
		return trades.parallelStream()
				.filter(trade -> trade.getQuantity() > ONE_MILLION)
				.filter(Trade::isCancelledTrade)
				.collect(Collectors.toList());
	}
	
	private List<Trade> findLargeTradesUsingParallelStreams2(List<Trade> trades) {
		return trades.parallelStream()
				.filter(trade -> trade.getQuantity() > ONE_MILLION)
				.filter(trade -> trade.getInstrument().equals("IBM"))
				.collect(Collectors.toList());
	}

	public static void main(String[] args) {
		List<Trade> trades = TradeUtil.createTrades();
		List<Trade> largeTrades = new StreamsBasics()
				.findLargeTradesPreJava8(trades);
		System.out.println("Using pre-Java8:"+largeTrades);
		
		largeTrades = new StreamsBasics()
			.findLargeTradesUsingStreams(trades);
		
		System.out.println("Using streams:"+largeTrades);

		largeTrades = new StreamsBasics()
		.findLargeTradesUsingParallelStreams(trades);
	
		System.out.println("Using parallel streams:"+largeTrades);
	
	}

}
