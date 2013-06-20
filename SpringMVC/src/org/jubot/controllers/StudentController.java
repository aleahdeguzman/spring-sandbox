package org.jubot.controllers;

import java.util.List;

import org.jubot.interfaces.StudentDAO;
import org.jubot.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student/")
public class StudentController {
	
	@Autowired
	private StudentDAO studentJDBCTemplate;
	
	@RequestMapping(value="details/{number}")
	public String studentDetails(@PathVariable("number") int number, Model model) {
		System.out.println("Get details of student number " + number);
		
		Student student = this.studentJDBCTemplate.getStudentById(number); 
		
		model.addAttribute("student", student);
		
		return "studentDetails";
	}
	
	
	@RequestMapping(value="list", params={"param=all"})
	public String allStudents(Model model, @RequestParam String param) {
		System.out.println("List all students");
		
		List<Student> students = this.studentJDBCTemplate.listStudents();
		
		model.addAttribute("studentList", students);
		
		return "studentDetailsAll";
	}
	
	
	@RequestMapping(value="registration", method=RequestMethod.POST)
	public String addStudent(@ModelAttribute Student student, Model model) throws Exception{
		
		if(student != null) {
			System.out.println("Add Student " + student.getStudentNo());
			this.studentJDBCTemplate.save(student);
			
			model.addAttribute("student", student);
			
			return "studentForm";
		} else {
			
			throw new Exception("Student form is null.");
		}
		
	}
	
	@RequestMapping(value="registration", method=RequestMethod.GET)
	public String studentInputForm(@ModelAttribute Student student, Model model) throws Exception{
			
			model.addAttribute("student", new Student());
			
			return "studentForm";
		
		
	}

	public StudentDAO getStudentJDBCTemplate() {
		return studentJDBCTemplate;
	}

	public void setStudentJDBCTemplate(StudentDAO studentJDBCTemplate) {
		this.studentJDBCTemplate = studentJDBCTemplate;
	}
	
	

}
