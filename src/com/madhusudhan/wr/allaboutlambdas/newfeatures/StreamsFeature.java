package com.madhusudhan.wr.allaboutlambdas.newfeatures;

import java.util.List;

import static java.util.stream.Collectors.toList;

import com.madhusudhan.wr.allaboutlambdas.domain.Movie;
import com.madhusudhan.wr.allaboutlambdas.util.MovieUtil;

/**
 * Example for demontrating streams feature
 * @author mkonda
 *
 */
public class StreamsFeature {

	/**
	 * Finding classics 
	 * @param movies
	 * @return
	 */
	public List<Movie> findClassics(List<Movie> movies) {
		return movies
			.stream()
			.filter(m -> m.isClassic())
			.collect(toList());
	}

	public static void main(String[] args) {
		List<Movie> movies = MovieUtil.createMovies();
		List<Movie> classics = new StreamsFeature().findClassics(movies);
		classics.forEach(System.out::println);
	}
}
