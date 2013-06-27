package org.jubot.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.jubot.interfaces.StudentDAO;
import org.jubot.models.Student;
import org.jubot.models.Subject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring.xml"})
public class StudentHibernateDaoDecTxnTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	StudentDAO studentHibernateDaoDecTxn;
	
	@Before
	public void setUp() {
		studentHibernateDaoDecTxn = this.applicationContext.getBean("studentHibernateDaoDecTxn", StudentDAO.class);
	}
	
	@Test
	public void testDaoNotNull() {
		assertNotNull(studentHibernateDaoDecTxn);
	}
	
	@Test
	public void getStudentById() throws Exception{
		Student expectedStudent = mock(Student.class);
		Subject expectedSubj = mock(Subject.class);
		when(expectedStudent.getStudentNo()).thenReturn(1);
		when(expectedStudent.getSubject()).thenReturn(expectedSubj);
		when(expectedStudent.getSubject().getStudNo()).thenReturn(1);
		
		Student actual = studentHibernateDaoDecTxn.getStudentById(1);
		
		assertEquals(actual.getStudentNo(), expectedStudent.getStudentNo());
		assertEquals(actual.getSubject().getStudNo(), expectedStudent.getSubject().getStudNo());
	}
	
	@Test()
	public void getStudenById_NotExisting() throws Exception{
		
		Student actual = studentHibernateDaoDecTxn.getStudentById(0);
		
		assertNull(actual);
		
	}
	
	@Test(expected=Exception.class)
	public void saveNullStudent() throws Exception {
		studentHibernateDaoDecTxn.save(null);
	}
	
	
	@Rollback(true)
	@Test
	public void saveStudent() throws Exception{
		Student actual = new Student();
		actual.setStudentNo(1);
		actual.setName("Aleah");
		Subject actualSubj = new Subject();
		actualSubj.setSubj_name("Mocking Skills");
		actual.setSubject(actualSubj);
		
		studentHibernateDaoDecTxn.save(actual);
		
		Student expected = studentHibernateDaoDecTxn.getStudentById(1);
		
		assertEquals(actual.getStudentNo(), expected.getStudentNo());
		assertEquals(actual.getSubject().getStudNo(), expected.getSubject().getStudNo());
	}
	
	
	@Test(expected=Exception.class)
	public void saveStudent_DiffStudentNoForStudentAndSubject() throws Exception{
		
		Student actual = new Student();
		actual.setStudentNo(12);
		actual.setName("Junit");
		Subject actualSubj = new Subject();
		actualSubj.setStudNo(13);
		actualSubj.setSubj_name("Mocking Skills");
		actual.setSubject(actualSubj);
		
		studentHibernateDaoDecTxn.save(actual);
		
	}
	
	
	@Rollback(true)
	@Test()
	public void delete() throws Exception {
		Student mockStudent = new Student();
		mockStudent.setStudentNo(12);
		
		studentHibernateDaoDecTxn.delete(mockStudent);
		
		Student expected = studentHibernateDaoDecTxn.getStudentById(12);
		
		assertNull(expected);
	}
	
	
	@Test(expected=Exception.class)
	public void delete_NotExisting() throws Exception {
		Student mockStudent = new Student();
		mockStudent.setStudentNo(12);
		
		studentHibernateDaoDecTxn.delete(mockStudent);
	}
}
