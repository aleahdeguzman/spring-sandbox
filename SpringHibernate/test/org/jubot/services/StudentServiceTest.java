package org.jubot.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.jubot.interfaces.StudentDAO;
import org.jubot.models.Student;
import org.jubot.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring.xml"})
public class StudentServiceTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	
	@Test
	public void testServiceNotNull() {
		StudentService studentSerive = this.applicationContext.getBean("studentService", StudentService.class);
		assertNotNull(studentSerive);
	}
	
	@Test
	public void testDAONotNull() {
		StudentDAO studentHibernateDaoDecTxn = this.applicationContext.getBean("studentHibernateDaoDecTxn", StudentDAO.class);
		assertNotNull(studentHibernateDaoDecTxn);
	}
	
	
	@Test()
	public void testGetStudentById() throws Exception{
		StudentDAO mockStudentHibernateDaoDecTxn = mock(StudentDAO.class);
		StudentService studentService = this.applicationContext.getBean("studentService", StudentService.class);
		studentService.setStudentDAO(mockStudentHibernateDaoDecTxn);
		
		Student mockStudent = mock(Student.class);
		when(mockStudent.getStudentNo()).thenReturn(1);

		when(mockStudentHibernateDaoDecTxn.getStudentById(anyInt())).thenReturn(mockStudent);
		
		assertEquals(studentService.getStudentById(2).getStudentNo(),1);
		
	}
	
	@Test(expected=Exception.class)
	public void testSaveStudentNumberZeroOrNull_ThrowException() throws Exception{
		StudentDAO mockStudentHibernateDaoDecTxn = mock(StudentDAO.class);
		StudentService studentService = this.applicationContext.getBean("studentService", StudentService.class);
		studentService.setStudentDAO(mockStudentHibernateDaoDecTxn);
		
		studentService.saveStudent(null);
	}
	

}
