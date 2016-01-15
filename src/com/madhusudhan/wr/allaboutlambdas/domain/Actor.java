package com.madhusudhan.wr.allaboutlambdas.domain;

public class Actor {
	private String name = null;

	public Actor(String name) {
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	
	
}
