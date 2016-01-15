package com.madhusudhan.wr.allaboutlambdas.advancedstreams;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

import com.madhusudhan.wr.allaboutlambdas.domain.Trade;
import com.madhusudhan.wr.allaboutlambdas.util.TradeUtil;

/**
 * Class demonstrating the functionality to create custom collectors
 * @author mkonda
 *
 */
public class CustomCollector {
	List<Trade> trades = TradeUtil.createTrades();
	
	/**
	 * Create own collector of csv strings
	 */
	private void collectToCustomCollector() {
		// A supplier
		Supplier<StringBuilder> supplier = StringBuilder::new;

		// An accumulator
		BiConsumer<StringBuilder, Trade> accumulator = 
				(sb, trade) -> sb.append(trade.getInstrument()).append(",");
				
		// A combiner
		BiConsumer<StringBuilder, StringBuilder> combiner =
				(s1, s2) -> s1.append(s2.toString());
		
		// Putting all together
		StringBuilder results = trades
			.stream()
			.collect(supplier, accumulator, combiner);
		
		System.out.println(results);
		
  	}

	public static void main(String[] args) {
		new CustomCollector().collectToCustomCollector();
	}

}
