package org.jubot.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class Student {
	
	@Id
	@Column(name="studNo")
	private int studentNo;
	
	private String type;
	private String name;
	private Date birthday;
	private String course;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="studNo")
	private Subject subject;

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
		this.subject.setStudNo(this.getStudentNo());
	}

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
	
	

	@Override
	public String toString(){
		StringBuilder strBuilder = new StringBuilder();
		strBuilder = strBuilder.append("\n Student No: " + this.studentNo)
					.append("\n Name: " + this.name);
					if(this.subject != null) {
						
							strBuilder.append("\n Subject: " + subject.getSubj_name());
						
					}
		
		
		return strBuilder.toString();
	}

}
