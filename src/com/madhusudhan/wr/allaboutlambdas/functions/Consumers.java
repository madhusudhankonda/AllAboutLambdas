package com.madhusudhan.wr.allaboutlambdas.functions;

import java.util.function.Consumer;

import com.madhusudhan.wr.allaboutlambdas.domain.Movie;

/**
 * Class to demonstrate Consumer function
 * @author mkonda
 *
 */
public class Consumers {

	/**
	 *  A lambda with Consumer target type for persistence 
	 */
	Consumer<Movie> persistMovie = this::persist;

	private void persist(Movie m) {
		System.out.println("Persisting "+m);
	}
	
	/**
	 *  A lambda for auditing movies	 
	 */
	 
	Consumer<Movie> auditMovie = this::audit;

	private void audit(Movie m) {
		System.out.println("Auditing "+m);
	}

	Consumer<Movie> distributeMovie = t -> distribute(t);
	
	private void distribute(Movie m) {
		System.out.println("Distributing "+m);
	}
	/**
	 * Invoke the composed consumer by passing a movie
	 * @param movie
	 */
	private void andThenTest(Movie movie) {
		// The composed consumer auditing and persisting a movie
		Consumer<Movie> andThenConsumer = auditMovie.andThen(persistMovie);
		andThenConsumer.accept(movie);
	}
	
	/**
	 * Chaining Consumers
	 */
	private void ChainingConsumers(Movie movie) {
		Consumer<Movie> chainedConsumer = auditMovie
	      .andThen(persistMovie)
	      .andThen(distributeMovie);
	
		// invoke the chained consumer
		chainedConsumer.accept(movie);
	}
	
	public static void main(String[] args) {
		Movie m = new Movie("Mission Impossible");
		new Consumers().andThenTest(m);
	}
	
}
