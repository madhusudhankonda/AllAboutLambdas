package com.madhusudhan.wr.allaboutlambdas.domain;

import java.util.Optional;


public class Teacher {
	private String name = null;
	private Optional<Student> student = null;
	public Teacher(String name) {
		setName(name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Optional<Student> getStudent() {
		return student;
	}
	public void setStudent(Optional<Student> student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Teacher [name=" + name + "]";
	}
	
}
