package org.jubot.models;

import java.text.SimpleDateFormat;

public class Student extends StudentAbstract {
	
	public String getBdayToString() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		return formatter.format(this.getBirthday());
	}
	
	

}
