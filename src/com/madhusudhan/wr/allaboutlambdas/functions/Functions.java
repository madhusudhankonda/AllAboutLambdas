package com.madhusudhan.wr.allaboutlambdas.functions;

import java.util.List;
import java.util.function.Function;

import com.madhusudhan.wr.allaboutlambdas.domain.Book;
import com.madhusudhan.wr.allaboutlambdas.domain.Employee;
import com.madhusudhan.wr.allaboutlambdas.domain.Manager;
import com.madhusudhan.wr.allaboutlambdas.domain.Movie;
import com.madhusudhan.wr.allaboutlambdas.domain.Trade;
import com.madhusudhan.wr.allaboutlambdas.util.TradeUtil;

/**
 * Class to demonstrate the Function function
 * 
 * @author mkonda
 *
 */
public class Functions {

	// Function that given a String, produces a Movie
	Function<String, Movie> movieFunction = movieName -> new Movie(movieName);

	/**
	 * Method that given a string, returns a movie (String->Movie)
	 */
	public Movie useFunction(String movieName) {
		// Use our movie function to create a Movie
		Movie movie = movieFunction.apply(movieName);
		System.out.println("Movie created:" + movie);
		return movie;

	}

	List<Trade> trades = TradeUtil.createTrades();

	Function<Integer, Trade> tradeFinder = (id) -> {
		// Run through all trades checking against the given one
		Trade trade = new Trade();
		for (Trade t : trades) {
			if (t.getId() == id)
				trade = t;
		}
		return trade;
	};

	public void tradeFinder(Integer id) {
		Trade trade = tradeFinder.apply(id);

		System.out.println("Fetched a trade: " + trade);
	}

	public void tradeFinderJava8(Integer tradeId) {
		List<Trade> trades = TradeUtil.createTrades();

		Trade trade = trades.stream().filter(t -> t.getId() == tradeId)
				.findFirst().get();

		System.out.println("Fetched a trade (using Streams): " + trade);
	}

	public void usingAndThenAndCompose() {

		Function<String, Book> bookFinder = this::fetchBook;
		Function<Book, Integer> rankFinder = this::rankFinder;
		
		System.out.println(bookFinder.apply("ISBN123"));
		// andThen composed function
		Function<String, Integer> bookRankFinder = bookFinder
				.andThen(rankFinder);

		Function<String, Integer> rankBookFinder = rankFinder
				.compose(bookFinder);

		System.out.println(bookRankFinder.apply("All About Lambdas"));
		System.out.println(rankBookFinder.apply("ISBN123"));
		
	}
	
	public void usingAndThenAndCompose2() {

		Function<Integer, Integer> principalInterest = amount -> amount*2;
		
		Function<Integer, Integer> factoredInterest = amount -> amount+10;
		
		Integer amount1 = principalInterest.andThen(factoredInterest).apply(10);
		Integer amount2 = principalInterest.compose(factoredInterest).apply(10);
		
		System.out.println("Apply interest first before factoring it:"+amount1);
		System.out.println("Factor the amount and then apply interest:"+amount2);
	}

	public void usingIdFunction(){
		Function<String, String> idFunction = Function.identity();
		
		String result = idFunction.apply("LAMBDAS");
		System.out.println(result);
	}
	private Book fetchBook(String isbn) {
		// fetch it from our database
		return new Book(isbn);
	}

	private Integer rankFinder(Book book) {
		// fetch the rank from external sources
		return 1;
	}

	public static void main(String[] args) {
		new Functions().tradeFinder(1);
		new Functions().tradeFinderJava8(1);
		
		new Functions().usingAndThenAndCompose();
		
		new Functions().usingAndThenAndCompose2();
		
		new Functions().usingIdFunction();
	}
	
}
