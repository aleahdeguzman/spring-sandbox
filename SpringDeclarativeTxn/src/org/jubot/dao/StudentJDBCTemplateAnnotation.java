package org.jubot.dao;

import java.util.List;

import org.jubot.interfaces.StudentDAO;
import org.jubot.models.Student;
import org.jubot.models.StudentRowMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class StudentJDBCTemplateAnnotation extends JdbcDaoSupport  implements StudentDAO {



	@Override
	@Transactional(readOnly=false)
	public void save(Student student) throws Exception {
		try {
	    	System.out.println("*************** @Transactional ********************");
	    	String sql = "INSERT INTO Student (studno, name, course, type, birthday) VALUES (?, ?, ?, ?, ?)";
	  		Object[] params = new Object[] {student.getStudentNo(), student.getName(), student.getCourse(), student.getType(), student.getBirthday()};
	    	this.getJdbcTemplate().update(sql, params) ;
	  		
	    	sql = null;
	    	params = null;
	    	sql = "INSERT INTO Subject (studNo, subj_name) VALUES (?, ?)";
	    	params = new Object[] {student.getStudentNo(), student.getSubject()};
	    	this.getJdbcTemplate().update(sql, params);
	     
	      } catch (DataAccessException e) {
	    	  throw e;
	      } finally {
	    	  System.out.println("This is the final statement.");
	      }

	}

	 /**
	    * 
	    */
	   public List<Student> listStudents() {
	      String SQL = "select * from Student, Subject where Student.studNo = Subject.studNo";

	      List <Student> students=this.getJdbcTemplate().query(SQL, new StudentRowMapper());
	      
	      return students;
	   }
	   
	   /**
	    * 
	    */
	   public Student getStudentById(int id) {
	      String SQL = "select * from Student, Subject where Student.studNo = ? and Student.studNo = Subject.studNo";

	      Student student=this.getJdbcTemplate().queryForObject(SQL, new Object[] {id}, new StudentRowMapper());
	      
	      return student;
	   }
	   
	   
}
