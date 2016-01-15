package com.madhusudhan.wr.allaboutlambdas.domain;

public class Employee {

	private int id = 0;
	private String name = null;
	private String department = null;
	private String city = null;
	private Address address = null;
	private Manager manager = null;
	private boolean isExecutive = false;
	private boolean senior = false;
	private int ratings = 10;

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

	public Employee(int id) {
		this.id = id;
		this.name = "Mars Man";
		address = new Address();

		address.setAddressLine1("11");
		address.setAddressLine2("Spacelane");
		address.setCountry("Mars");
		address.setCode("12AB102D1");
	}

	public Employee(int id, String name, String department) {
		setId(id);
		setName(name);
		setDepartment(department);
	}

	public Employee(int id, String name, String department, boolean isExec) {
		setId(id);
		setName(name);
		setDepartment(department);
		setExecutive(isExec);
	}

	public Employee(int id, String name, String department, String city) {
		setId(id);
		setName(name);
		setDepartment(department);
		setSenior(true);
		setCity(city);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Manager getManager() {
		return manager;
	}

	@Override
	public String toString() {
		// return "Employee [id=" + id + ", name=" + name + ", address=" +
		// address
		// + "]";

		return "Employee " + id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public boolean isExecutive() {
		return isExecutive;
	}

	public void setExecutive(boolean isExecutive) {
		this.isExecutive = isExecutive;
	}

	public boolean isManager(Employee manager) {
		return getManager().equals(manager);
	}

	public boolean isSenior() {
		return senior;
	}

	public void setSenior(boolean senior) {
		this.senior = senior;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
