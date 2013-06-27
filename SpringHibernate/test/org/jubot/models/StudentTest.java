package org.jubot.models;

import static org.junit.Assert.assertEquals;

import org.jubot.models.Student;
import org.jubot.models.Subject;
import org.junit.Before;
import org.junit.Test;

public class StudentTest {
	Student mockStudent = null;
	Subject mockSubject = null;
	
	@Before
	public void setUp() {
		mockStudent = new Student();
		mockSubject = new Subject();
		
		mockStudent.setStudentNo(1);
		mockStudent.setSubject(mockSubject);
		
	}
	
	@Test
	public void testSubjectStudentNumber() {
		assertEquals(mockStudent.getStudentNo(),mockStudent.getSubject().getStudNo());
	}
	
}
