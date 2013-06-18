package org.jubot.hibernate;

import java.util.List;

import org.jubot.interfaces.StudentDAO;
import org.jubot.models.Student;
import org.jubot.service.StudentService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		
		StudentService service =  (StudentService)context.getBean("studentService");
	    Student student = context.getBean("stubStudent",Student.class);
	    
	    try {
	    	System.out.println("------SPRING WITH HIBERNATE--------" );
	    	//System.out.println("------Records creation--------" );
	    	//service.saveStudent(student);
		    
		    
		    System.out.println("------Student Created--------" );
		    Student stud = service.getStudentById(student.getStudentNo());
		    System.out.println(stud.toString());
		    
	    	//System.out.println("-------Delete Student " + student.getStudentNo() + " ---------------");
	    	//service.deleteStudent(student);
		    
		   /* System.out.println("------Listing all the students--------" );
		      List<Student> students = service.getAllStudents();
		      for (Student record : students) {
		         System.out.println(record.toString());
		      
		      }*/
	    } catch (Exception e) {
	    	System.out.println("Exception Caught: "+e.getMessage());
	    }
	    
	}

}
