package com.madhusudhan.wr.allaboutlambdas.domain;

public class Manager {
	private String name = null;
	
	private Employee personalAssistant = null;
	public Manager() {
		personalAssistant = new Employee(99);
		setPersonalAssistant(personalAssistant);
	}
	
	public Manager(String name) {
		personalAssistant = new Employee(99);
		setPersonalAssistant(personalAssistant);
		setName(name);
	}

	public void setPersonalAssistant(Employee personalAssistant) {
		this.personalAssistant = personalAssistant;
	}
	
	public Employee getPersonalAssistant() {
		return personalAssistant;
	}

	@Override
	public String toString() {
		return "Manager [personalAssistant=" + personalAssistant + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
