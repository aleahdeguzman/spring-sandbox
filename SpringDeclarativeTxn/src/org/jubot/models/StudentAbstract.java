package org.jubot.models;

import java.util.Date;

public abstract class StudentAbstract {

	private int studentNo;
	private String type;
	private String name;
	private Date birthday;
	private String course;
	private String subject;	

	public String getType() {
		return type;
	}



	public int getStudentNo() {
		return studentNo;
	}



	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}





	public void setType(String type) {
		this.type = type;
	}
	
	
	
	public String getSubject() {
		return subject;
	}



	public void setSubject(String subject) {
		this.subject = subject;
	}



	@Override
	public String toString(){
		StringBuilder strBuilder = new StringBuilder();
		strBuilder = strBuilder.append("\n Student No: " + this.studentNo)
					.append("\n Name: " + this.name)
					.append("\n Subject: " + this.subject);
		
		
		
		return strBuilder.toString();
	}
	
}
