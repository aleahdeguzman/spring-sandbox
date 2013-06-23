package org.jubot.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jubot.interfaces.StudentDAO;
import org.jubot.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentHibernateDaoAnnotation implements StudentDAO{
	
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
		Session session = null;
		try {
			
			session = this.getSessionFactory().openSession();
			
			session.beginTransaction();
			
			session.save(student);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		} finally {
			if(session != null) {
				session.close();
			}
		}
		
	}

	@Override
	public List<Student> listStudents() throws Exception{
		Session session = null;
		List<Student> studentList = null;;
		try {
			session = this.getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(Student.class);
			studentList = criteria.list();
			
			return studentList;
		} catch (Exception e) {
			throw e;
		} finally {
			if(session != null) {
				session.close();
			}
		}
		
	}

	@Override
	public Student getStudentById(int id) throws Exception{
		Session session = null;
		try {
			session = this.getSessionFactory().openSession();
			Student student = (Student) session.get(Student.class, id);
			
			return student;
		} catch (Exception e) {
			throw e;
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}

	@Override
	public void delete(Student student) throws Exception {
		Session session = null;
	
		try {
			
			session = this.getSessionFactory().openSession();
			
			session.beginTransaction();
			
			session.delete(session.load(Student.class, student.getStudentNo()));
			
			session.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}
	
	
}
