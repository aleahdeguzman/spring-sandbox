package org.jubot.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.jubot.interfaces.StudentDAO;
import org.jubot.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class StudentHibernateDaoDecTxn implements StudentDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	
	}
	

	@Override
	public void save(Student student) throws Exception {
	
		try {
			
			this.getSessionFactory().getCurrentSession().save(student);
			
		} catch (DataAccessException e) {
			throw e;
		} 
		
	}

	@Override
	public List<Student> listStudents() throws Exception{
		
		try {
			
			Criteria criteria = this.getSessionFactory().getCurrentSession().createCriteria(Student.class);
			
			return criteria.list();
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public Student getStudentById(int id) throws Exception{
		try{
			
			return (Student) this.getSessionFactory().getCurrentSession().get(Student.class, id);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void delete(Student student) throws Exception {
		
		try {
			
			this.getSessionFactory().getCurrentSession().delete(student);
			
		} catch (DataAccessException e) {
			throw e;
		} 
	}
	
	
}
