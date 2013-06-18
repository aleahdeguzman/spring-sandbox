package org.jubot.models.test;


import org.jubot.models.Student;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.junit.Assert.*;

public class StudentTest{
	
	private static Student student;
	private static AbstractApplicationContext context;
	
	
	@BeforeClass
	public static void setUpClass(){
		System.out.println("@beforeClass...initialize Application Context.");
		context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		
		System.out.println("@before...initialize Student Bean.");
		student = context.getBean("stubStudent",Student.class);
	}
	
	
	@Test
	public void testStudentToString() {
		System.out.println("testStudentToString");
		String expected = student.toString();
		String result = student.toString();
		
		assertEquals(expected, result);
	
	}
	
	@Test
	public void testGetBdayToString() {
		System.out.println("testGetBdayToString");
		
		String expected = "16-Dec-2011";
		
		assertEquals(expected, student.getBdayToString());
		
		
	}

}
