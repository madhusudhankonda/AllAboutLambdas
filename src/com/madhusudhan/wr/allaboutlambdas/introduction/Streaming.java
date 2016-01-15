package com.madhusudhan.wr.allaboutlambdas.introduction;

import java.util.List;
import java.util.stream.Collectors;

import com.madhusudhan.wr.allaboutlambdas.domain.Trade;
import com.madhusudhan.wr.allaboutlambdas.util.TradeUtil;
/**
 * This class shows the usage of basic streams functionality.
 * 
 * @author mkonda
 *
 */
public class Streaming {
	private int ONE_MILLION = 1000000;
	
	/**
	 * Finding large trades 
	 * @param trades
	 */
	private void findLargeTrades(List<Trade> trades) {
		trades.stream()
			.filter(trade -> trade.getQuantity() > ONE_MILLION)
			.forEach(System.out::println);;
	}
	/**
	 * Finding large trades - execution is run in parallel mode
	 * @param trades
	 * @return
	 */
	private List<Trade> findLargeTradesInParallel(List<Trade> trades) {
		List<Trade> bigTrades = trades
			.stream()
			.parallel()
			.filter(trade -> trade.getQuantity() > ONE_MILLION)
			.collect(Collectors.toList());
		
		return bigTrades;
	}
	
	
	public static void main(String[] args) {
		List<Trade> trades = TradeUtil.createTrades();
		new Streaming().findLargeTrades(trades);
		List<Trade> bigTrades = new Streaming().findLargeTradesInParallel(trades);
		bigTrades.forEach(System.out::println);
		
	}
}
