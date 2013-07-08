package org.jubot.action;

import org.jubot.model.Person;

public class PersonAction {
	
	private Person person;
	
	public String execute() {
		return "success";
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}
