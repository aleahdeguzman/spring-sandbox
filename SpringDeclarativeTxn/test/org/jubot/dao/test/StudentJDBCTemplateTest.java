package org.jubot.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.jubot.dao.StudentJDBCTemplate;
import org.jubot.models.Student;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration(locations={"test-context.xml"})
//@ContextConfiguration(locations = { "/spring/datasource.xml" , "/spring/persistence.xml" })
public class StudentJDBCTemplateTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	@Autowired
	private StudentJDBCTemplate studentJDBCTemplate;
	
	private Student expectedStudent;

	public StudentJDBCTemplate getStudentJDBCTemplate() {
		return studentJDBCTemplate;
	}

	public void setStudentJDBCTemplate(StudentJDBCTemplate studentJDBCTemplate) {
		this.studentJDBCTemplate = studentJDBCTemplate;
	}
	
	
	@Before
	public void before() {
		System.out.println("Before Testing: Stubbing Expected Student");
		expectedStudent = this.applicationContext.getBean("stubStudent",Student.class);
		System.out.println("Student to test: " + expectedStudent.getName());
	}
	
	@Test
	public void testGetStudentById() {
		System.out.println("************Begin testGetStudentByid**************");
		Student actualStudent;
		
			
			
			System.out.println("Fetching Student " + expectedStudent.getStudentNo());
			actualStudent= studentJDBCTemplate.getStudentById(expectedStudent.getStudentNo());
			
			assertNotNull("Student was not found!", actualStudent);
			
			
            assertEquals("Student names do not match", expectedStudent.getName(), actualStudent.getName());
           
	}
	
}
