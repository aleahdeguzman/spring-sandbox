package org.jubot.models;

import java.util.List;

public class ResponseWrapper {


	List<Student> studentList;
	private String status;
	private String message;
	private Student student;
	
	public ResponseWrapper(String status, String msg, Student student) {
		this.status = status;
		this.message = msg;
		this.student = student;
	}
	
	public ResponseWrapper(String status, String msg, List<Student> studentList) {
		this.status = status;
		this.message = msg;
		this.studentList = studentList;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	

}
