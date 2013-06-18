package org.jubot.service;

import java.util.List;

import org.jubot.interfaces.StudentDAO;
import org.jubot.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentService {
	
	@Autowired
	private StudentDAO studentHibernateDaoDecTxn;
	
	@Transactional
	public void deleteStudent(Student student) throws Exception {
		studentHibernateDaoDecTxn.delete(student);
	}
	
	@Transactional
	public void saveStudent(Student student) throws Exception {
		studentHibernateDaoDecTxn.save(student);
	}
	
	@Transactional
	public List<Student> getAllStudents() throws Exception {
		return studentHibernateDaoDecTxn.listStudents();
	}
	
	@Transactional
	public Student getStudentById(int id) throws Exception {
		return studentHibernateDaoDecTxn.getStudentById(id);
	}

	public StudentDAO getStudentDAO() {
		return studentHibernateDaoDecTxn;
	}

	public void setStudentDAO(StudentDAO studentHibernateDaoDecTxn) {
		this.studentHibernateDaoDecTxn = studentHibernateDaoDecTxn;
	}
	
	

}
