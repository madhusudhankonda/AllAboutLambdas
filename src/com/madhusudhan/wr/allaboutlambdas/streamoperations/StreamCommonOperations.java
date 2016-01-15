package com.madhusudhan.wr.allaboutlambdas.streamoperations;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.madhusudhan.wr.allaboutlambdas.domain.Actor;
import com.madhusudhan.wr.allaboutlambdas.domain.Employee;
import com.madhusudhan.wr.allaboutlambdas.domain.Movie;
import com.madhusudhan.wr.allaboutlambdas.domain.Trade;
import com.madhusudhan.wr.allaboutlambdas.util.EmployeeUtil;
import com.madhusudhan.wr.allaboutlambdas.util.MovieUtil;
import com.madhusudhan.wr.allaboutlambdas.util.TradeUtil;

/**
 * This class represents the filtering functionality
 * 
 * @author mkonda
 *
 */
public class StreamCommonOperations {

	/**
	 * Method to find executives from a list of employees
	 */
	private void findExecutives(List<Employee> employees) {
		Stream<Employee> empStream = employees.stream().filter(
				Employee::isExecutive);

		empStream.forEach(System.out::println);
	}

	/**
	 * Method to demonstrate chaining of the filters.
	 */
	private void chainingFilters(List<Employee> employees) {
		Stream<Employee> empStream = employees.stream()
				.filter(e -> e.getDepartment().equals("Marketing"))
				.filter(Employee::isExecutive).filter(Employee::isSenior);

		empStream.forEach(System.out::println);
	}

	/**
	 * Method for mapping functionality
	 */
	private void mapEmployeeName(List<Employee> employees) {
		Stream<String> empStream = employees.stream().map(Employee::getName)
				.map(String::toUpperCase);

		empStream.forEach(System.out::println);
	}

	/**
	 * Method for mapping functionality
	 */
	private void upperCaseEmployees(List<Employee> employees) {
		Stream<String> employeeStream = employees.stream()
				.map(Employee::getName).map(String::toUpperCase);

		employeeStream.forEach(System.out::println);
	}

	/**
	 * Method for mapping functionality
	 */
	private void actorStream(List<Movie> movies) {
		Stream<List<Actor>> actorStream = movies.stream().map(Movie::getActors);

		actorStream.forEach(System.out::println);
	}

	/**
	 * Flattening a stream of list of actors to a stream of actors using flatMap function
	 *  
	 * @param movies
	 */
	private void flatMapMovieActors(List<Movie> movies) {

		Stream<List<Actor>> actorsListStream = movies
				.stream()
				.map(Movie::getActors);
		actorsListStream.forEach(System.out::println);
		
		// Stream of Actors not Stream of List of Actors!
		Stream<Actor> actorsStream = movies
		  .stream()
		  .flatMap(m -> m.getActors().stream());
			
		actorsStream.forEach(System.out::println);

	}
	/**
	 * Using flatMap function to flatten a stream of list of movies to stream of movies 
	 * @param movies
	 */
	private void flatMapMovies(List<Movie> movies) {

		String[] action = new String[] { "Mission Impossible", "Sky Fall" };
		String[] comedy = new String[] { "Johnny English", "Gods Must Be Crazy" };
		String[] thriller = new String[] { "Bourne Identity",
				"The Ghost Writer", "Clear and Present Danger" };

		List<String> actionMoviesList = Arrays.asList(action);
		List<String> comedyMoviesList = Arrays.asList(comedy);
		List<String> thrillerMoviesList = Arrays.asList(thriller);

		Stream<List<String>> actionMoviesStream = Stream.of(actionMoviesList,
				comedyMoviesList, thrillerMoviesList);

		// NOTE: make sure one of the blocks 
		// is always commented - else you
		// will get an exception related to stream exhaustion

		// Movies Without Flattening 
		// actionMoviesStream
		// .forEach(System.out::println);

		// With Flattening
		 actionMoviesStream
		 .flatMap(s -> s.stream())
		 .forEach(System.out::println);
				
	}
	
	/**
	 * Collecting big trades to a list
	 * @param args
	 */
	private void collectingToAList(List<Trade> trades) {
		List<Trade> bigTrades = 
				trades
				.stream()
				.filter(Trade::isBigTrade)
				.collect(Collectors.toList());
		
		bigTrades.forEach(System.out::println);
	}

	/**
	 * This method demontrates the mechanism of collecting big trades to a set
	 * @param trades
	 */
	private void collectingToASet(List<Trade> trades) {
		Set<Trade> bigTrades = trades
				.stream()
				.filter(Trade::isBigTrade)
				.collect(toSet());
		
		bigTrades.forEach(System.out::println);
	}
	
	/**
	 * This method creates a map of movie names against movie actors
	 * 
	 * @param movies
	 */
	private void collectingToAMap(List<Movie> movies) {
		
		Map<String, List<Actor>> movieActorsMap = movies
				.stream()
				.collect(toMap(Movie::getName, movie -> movie.getActors()));
		
		movieActorsMap.forEach((name, actors) -> System.out.println(name+actors));
	}
	
	/**
	 * This method is used to find the distinct data set (removing duplicates)
	 * @param employees
	 */
	private void distinctEmployees(List<Employee> employees) {
		Stream<String> employeesNamesStream = 
				employees
				.stream()
				.map(Employee::getName);
//				.distinct();
		
		employeesNamesStream.forEach(System.out::println);
		
	}
	
	/**
	 * This method helps to understand the limit operation 
	 * @param employees
	 */
	private void limitOutput(List<Employee> employees) {
		Stream<String> employeesNamesStream = 
				employees
				.stream()
				.map(Employee::getName)
				.limit(3);
		
		employeesNamesStream.forEach(System.out::println);
	}
	
	/**
	 * This method demonstrates the skipping function
	 * @param employees
	 */
	private void skipEmployees(List<Employee> employees) {
		Stream<String> employeesNamesStream = 
				employees
				.stream()
				.skip(2)
				.map(Employee::getName);
		
		employeesNamesStream.forEach(System.out::println);
	}

	/**
	 * This function finds the first big trade off the list.
	 */
	private void findFirst(List<Trade> trades) {

		Optional<Trade> firstBigTrade = trades
			.stream()
			.filter(Trade::isBigTrade)
			.findFirst();
		
		System.out.println("First trade (using findFirst function): "+firstBigTrade.get());
	}
	
	/**
	 * Method that demonstrates the findAny function
	 * @param trades
	 */
	private void findAny(List<Trade> trades) {
		Optional<Trade> anyTrade = trades
		  .stream()
		  .filter(Trade::isBigTrade)
		  .findAny();
	
		System.out.println("First trade (uisng findAny function): "+anyTrade.get());
		
	}
	
	private void anyMatch(List<Trade> trades) {
		boolean cancelledTrade = trades
			.stream()
			.anyMatch(t -> t.getStatus().equals("CANCELLED"));
		System.out.println("Cancelled trade (using anyMatch function) ?:"+cancelledTrade);
	}
	
	private void allMatch(List<Trade> trades) {
		boolean ibmTrade = trades.stream()
				.allMatch(t -> t.getInstrument().equals("IBM"));
		
		System.out.println("IBM trade?(using allMatch function):"+ibmTrade);	
	}
	
	private void noneMatch(List<Trade> trades) {
		
		boolean cancelledTrade = trades
			.stream()
			.noneMatch(Trade::isCancelledTrade);
		System.out.println("Is cancelled trade present (using noneMatch function)?: "+cancelledTrade);
	}
	/**
	 * Aggregating the sum of all trades using reduce function
	 * @param trades
	 */
	private void reducingTradeQuantity(List<Trade> trades) {
		Optional<Integer> totalQuantity = trades
			.stream()
			.map(Trade::getQuantity)
			.reduce((a,b) -> a+b);
		System.out.println("Total quantity: "+totalQuantity.get());
	}
	
	/**
	 * Reducing the sum of all trades using primitives 
	 * @param trades
	 */
	private void reducingPrimitiveVersion(List<Trade> trades) {
		OptionalInt totalQuantity = trades
			.stream()
			.mapToInt(Trade::getQuantity)
			.reduce(Integer::sum);
		System.out.println("Total quantity (unboxed version): "+totalQuantity.getAsInt());
	}
	
	/**
	 * Concatenating the instruments using reduction (no seed value given)
	 * @param trades
	 */
	private void reduceNoSeed(List<Trade> trades) {
		Optional<String> instList = trades
			.stream()
			.map(Trade::getInstrument)
			.reduce((a,b)-> a+","+b);
		
		System.out.println("Comma separated instruments: "+instList);
	}
	
	/**
	 * This method reduces a sum using a seed value 
	 * 
	 */
	private void reduceUsingSeed() {
		List<Integer> ints = Arrays.asList(11, 13, 12, 15);
		
		int sum = ints
			.stream()
			.reduce(10, (i,j) -> i+j);
		
		System.out.println("Total: "+sum);
		
	}
	public static void main(String[] args) {
		List<Movie> movies = MovieUtil.createMoviesAndActors();
		List<Trade> trades = TradeUtil.createTrades();
		List<Employee> employees = EmployeeUtil.createEmployees();
		 
//		new StreamCommonOperations().findExecutives(employees);
//		new StreamCommonOperations().chainingFilters(employees);
//		new StreamCommonOperations().mapEmployeeName(employees);
//		new StreamCommonOperations().upperCaseEmployees(employees);
		// new StreamCommonOperations().actorStream(movies);

		// Flattening function 
		// new StreamCommonOperations().flatMapMovieActors(movies);
		// new StreamCommonOperations().flatMapMovies(movies);
		
		// Collection function
		// new StreamCommonOperations().collectingToAList(trades);
		// new StreamCommonOperations().collectingToASet(trades);
		// new StreamCommonOperations().collectingToAMap(movies);
		
		// Distinct, Limit and Skip
//		new StreamCommonOperations().distinctEmployees(employees);
//		new StreamCommonOperations().limitOutput(employees);
//		new StreamCommonOperations().skipEmployees(employees);
		
		// Finder methods
//		new StreamCommonOperations().findFirst(trades);
//		new StreamCommonOperations().findAny(trades);
		// Match Methods
//		new StreamCommonOperations().anyMatch(trades);
//		new StreamCommonOperations().allMatch(trades);
//		new StreamCommonOperations().noneMatch(trades);
		
		// Reduce methods
		new StreamCommonOperations().reduceNoSeed(trades);
		new StreamCommonOperations().reduceUsingSeed();
	}

}
