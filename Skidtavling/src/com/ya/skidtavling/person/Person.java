package com.ya.skidtavling.person;


public class Person {

	public String forName;
	protected String lastName;

	public Person(String fName, String lName) {
		this.forName = fName;
		this.lastName = lName;
	}

	@Override
	public String toString() {
		return forName + " " + lastName;
	}

	public String getForName() {
		return forName;
	}

	public void setForName(String forName) {
		this.forName = forName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}

