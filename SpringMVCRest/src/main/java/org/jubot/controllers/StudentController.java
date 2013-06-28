package org.jubot.controllers;

import java.util.Collections;
import java.util.List;

import org.jubot.models.ResponseWrapper;
import org.jubot.models.Student;
import org.jubot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * RESTful way to (all returning JSON objects):
 * 1. Show list of students
 * 2. Show details of a student
 * 3. Add/Edit/Delete student
 * @author aleah_deguzman
 *
 */
@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService; 
	private String status;
	private String msg;
	
	@RequestMapping("/student/all")
	public String getAllStudentList(Model model) throws Exception{
		
		List<Student> list = Collections.emptyList();
		try {
		  list = this.studentService.getAllStudents();
		  
		  System.out.println("Number of students" + list.size());
		  
		  model.addAttribute("studentList", list);
		  model.addAttribute("student", new Student());
		  
		  return "student";
		} catch (Exception e) {
			System.out.println("Error getting student list. " + e.toString());
			throw new Exception("Error getting student list. Please check log file.");
			
		}
		
	}
	
	@RequestMapping(value="/student/details/{number}")
	public @ResponseBody ResponseWrapper getStudent(@PathVariable int number){
		Student student = null;
		try {
			System.out.println("number = " + number);
			student = this.studentService.getStudentById(number);
			
			System.out.println("fetched: "+student.getName());
			
			setOKStatus();
			
			return new ResponseWrapper(this.status, this.msg, student);
		} catch (Exception e) {
			setFailedStatus("500","Error getting student detail.");
			return new ResponseWrapper(this.status, this.msg, student);
		}
		 
	}
	
	@RequestMapping(value="/student/delete/{number}")
	public @ResponseBody ResponseWrapper deleteStudent(@PathVariable int number){
		
		List<Student> updatedList = null;
		try {
			System.out.println("number = " + number);
			
			Student student = new Student();
			student.setStudentNo(number);
			this.studentService.deleteStudent(student);
			
			updatedList = this.studentService.getAllStudents();
			
			setOKStatus();
			
			return new ResponseWrapper(this.status,this.msg, updatedList);
		} catch (Exception e) {
			setFailedStatus("500","Error deleting student.");
			return new ResponseWrapper(this.status, this.msg, updatedList);
		}
		 
	}
	
	@RequestMapping(value="/student/", method=RequestMethod.POST)
	public @ResponseBody ResponseWrapper saveStudent(@ModelAttribute Student student) {
		
		List<Student> updatedList = null;
		try {
			
			System.out.println("Student to be saved = " + student.toString());
			this.studentService.saveStudent(student);
			
			updatedList = this.studentService.getAllStudents();
			
			setOKStatus();
			
			return new ResponseWrapper(this.status,this.msg, updatedList);
		}catch (Exception e) {
			setFailedStatus("500","Error saving student.");
			return new ResponseWrapper(this.status, this.msg, updatedList);
		}
	}
	
	private void setFailedStatus(String status, String msg) {
		this.status = status;
		this.msg = msg;
	}
	
	private void setOKStatus() {
		this.status = "200";
		
		this.msg = "OK";
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

}
