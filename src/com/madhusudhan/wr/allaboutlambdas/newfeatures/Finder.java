package com.madhusudhan.wr.allaboutlambdas.newfeatures;

/**
 * A functional interface
 * 
 * @author mkonda
 *
 */

public class Finder {

	@FunctionalInterface
	public interface IFinder {

		/**
		 * An abstract method
		 * 
		 * @param find
		 * @return
		 */
		String find(String criteria);

		default String criteria() {
			return "Search criteria:";
		}
	}
	
	public static void main(String[] args) {
		IFinder finder = (s) -> "result";
	}
}
