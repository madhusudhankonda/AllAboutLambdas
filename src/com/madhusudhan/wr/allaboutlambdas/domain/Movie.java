package com.madhusudhan.wr.allaboutlambdas.domain;

import java.util.ArrayList;
import java.util.List;

public class Movie {

	String name = null;
	boolean isClassic = false;
	String director = null;
	private List<Actor> actors = new ArrayList<Actor>();
	
	public Movie(String name, boolean isClassic) {
		setName(name);
		setClassic(isClassic);
	}
	
	public Movie(String name, boolean isClassic, String director) {
		setName(name);
		setClassic(isClassic);
		setDirector(director);
	}
	
	public Movie(String name, List<Actor> actors) {
		setName(name);
		setActors(actors);
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Movie [name=" + name + "]";
	}
	public boolean isClassic() {
		return isClassic;
	}

	public String getDirector() {
		return director;
	}
	
	public void setDirector(String director) {
		this.director = director;
	}

	public void setClassic(boolean isClassic) {
		this.isClassic = isClassic;
	}

	public Movie(String name) {
		setName(name);
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	
}
