package com.madhusudhan.wr.allaboutlambdas.parallellstreams;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.madhusudhan.wr.allaboutlambdas.domain.Trade;
import com.madhusudhan.wr.allaboutlambdas.util.TradeUtil;

//Parallel Streams
public class ParallelStreams {
	List<Trade> trades = TradeUtil.createTrades();
	
	// Filter predicate with print statement
	Predicate<Trade> filterPredicate = t -> {
		System.out.printf("Id: %d Filter Thread: %s:\n", t.getId(),
				Thread.currentThread().getName());
		return t.isBigTrade();
	};
	
	// Map function with print statement
	Function<Trade, Integer> mapFunction = t -> {
		System.out.printf("Id: %d Map Thread: %s:\n", t.getId(),
				Thread.currentThread().getName());
		return t.getQuantity();
	};

	/**
	 * The pipeline is executed in a single-thread (serial mode)
	 */
	private void serialStream() {
		
		Optional<Integer> sumOfTrades = trades
			.stream()
			.filter(filterPredicate)
			.map(mapFunction)
			.reduce(Integer::sum);

		System.out.println(sumOfTrades.get());

	}

	/**
	 * Executing the pipeline in parallel mode
	 */
	private void parallelStream() {
		Optional<Integer> sumOfTrades = trades
				.stream()
				.parallel()
				.filter(Trade::isBigTrade)
				.peek(t -> System.out.printf(
						"Trade Id=%d (Filter Thread Name=%s)\n", t.getId(),
						Thread.currentThread().getName()))
				.map(t -> t.getQuantity())
				.peek(t -> System.out.printf("(Mapper Thread Name=%s)\n",
						Thread.currentThread().getName())).reduce(Integer::sum);

		System.out.println(sumOfTrades.get());
	}

	
	/**
	 * We can also invoke parallelStream on a collection to fetch the stream
	 */
	private void collectionParallelStream() {
		Stream<Trade> parallelStreams = trades.parallelStream();
		parallelStreams.forEach(System.out::println);
	}
	
	private void howManyThreads() {
		ForkJoinPool p = new ForkJoinPool(10);
		int allocatedThreads = p.getParallelism();
		System.out.println("Thread count: "+allocatedThreads);
	}

	private void changeParallellism(){
		IntStream intStream = IntStream.rangeClosed(0, 5);
		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "10");
		intStream.parallel().forEach(i -> {
		    System.out.println(Thread.currentThread().getName());
		});
	}
	public static void main(String[] args) {
//		new ParallelStreams().serialStream();
//		new ParallelStreams().parallelStream();
//		new ParallelStreams().collectionParallelStream();
//		new ParallelStreams().howManyThreads();
		new ParallelStreams().changeParallellism();
		
	}

}
