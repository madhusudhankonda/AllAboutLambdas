package com.madhusudhan.wr.allaboutlambdas.newfeatures;

/**
 * An interface with one abstract method 
 * (so it can represent lambda) and concrete 
 * methods of static and default type
 * @author mkonda
 *
 */
public interface Component {
	/**
	 * Get the name of the component
	 * @return
	 */
	String getName();
	
	/**
	 * Get the default name
	 * @return
	 */
	default String getDefaultName(){
		return "Default Component";
	}
	
	/**
	 * Get the region
	 * @return
	 */
	static String getRegion(){
		return "United Kingdom";
	}
}
