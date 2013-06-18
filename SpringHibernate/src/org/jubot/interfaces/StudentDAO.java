package org.jubot.interfaces;

import java.util.List;

import org.jubot.models.Student;

public interface StudentDAO {


	  
	    /** This is the method to be used to create
	    * a record in the Student and Marks tables.
	    */
	   public void save(Student student) throws Exception;
	   /** 
	    * This is the method to be used to list down
	    * all the records from the Student and Marks tables.
	    */
	   public List<Student> listStudents() throws Exception;
	   
	   public Student getStudentById(int id) throws Exception;
	   
	   public void delete(Student student) throws Exception;
	
}
