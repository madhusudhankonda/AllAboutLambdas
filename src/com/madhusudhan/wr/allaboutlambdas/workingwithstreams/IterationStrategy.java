package com.madhusudhan.wr.allaboutlambdas.workingwithstreams;

import java.util.ArrayList;
import java.util.List;

import com.madhusudhan.wr.allaboutlambdas.domain.Movie;
import com.madhusudhan.wr.allaboutlambdas.util.MovieUtil;

/**
 * This class demonstrates the fundamentals of internal and external iteration strategies
 * 
 * @author mkonda
 *
 */
public class IterationStrategy {
	List<Movie> movies = MovieUtil.createMovies();
	List<Movie> top2Classics = new ArrayList<Movie>(10);

	/**
	 * Gathering classic movies using a traditional for loop
	 */
	private void externalIteration() {
		for(Movie m: movies){
			if(m.isClassic()){
				top2Classics.add(m);
			}
		}
		System.out.println("Top two classics (using external iteration): " + top2Classics);
	}
	
	/**
	 * Gathering classics using internal iteration (using streams) 
	 */
	private void internalIteration() {
		movies.parallelStream()
		.filter(Movie::isClassic)
		.map(Movie::getName)
		.limit(2)
		.forEach(System.out::println);
	}


	public static void main(String[] args) {
		new IterationStrategy().externalIteration();
		new IterationStrategy().internalIteration();
	}

}
