package org.jubot.dao;

import java.util.List;

import org.jubot.interfaces.StudentDAO;
import org.jubot.models.Student;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		
	    StudentDAO studentDAO =  (StudentDAO)context.getBean("studentJDBCTemplateAnnotation");
	    Student student = context.getBean("stubStudent",Student.class);
	    
	    try {
	    	System.out.println("------Records creation--------" );
	    	//studentDAO.save(student);
		    
		    
		    System.out.println("------Student Created--------" );
		    Student stud = studentDAO.getStudentById(student.getStudentNo());
		    System.out.println(stud.toString());
		    
		    
		    System.out.println("------Listing all the records--------" );
		      List<Student> students = studentDAO.listStudents();
		      for (Student record : students) {
		         System.out.println(record.toString());
		      
		      }
	    } catch (Exception e) {
	    	System.out.println(e.getMessage());
	    }
	    
	}

}
