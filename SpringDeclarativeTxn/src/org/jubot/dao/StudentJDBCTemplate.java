package org.jubot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.jubot.interfaces.StudentDAO;
import org.jubot.models.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class StudentJDBCTemplate implements StudentDAO {

	private JdbcTemplate jdbcTemplateObject;

	   public void setDataSource(DataSource dataSource) {
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }

	   public void save(Student student){

	      try {
	    	  
	    	String sql = "INSERT INTO Student (studno, name, course, type, birthday) VALUES (?, ?, ?, ?, ?)";
	  		Object[] params = new Object[] {student.getStudentNo(), student.getName(), student.getCourse(), student.getType(), student.getBirthday()};
	    	jdbcTemplateObject.update(sql, params) ;
	  		
	    	sql = null;
	    	params = null;
	    	sql = "INSERT INTO Subject (studNo, subj_names) VALUES (?, ?)";
	    	params = new Object[] {student.getStudentNo(), student.getSubject()};
	    	jdbcTemplateObject.update(sql, params);
	     
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

	      List <Student> students=jdbcTemplateObject.query(SQL, new StudentRowMapper());
	      
	      return students;
	   }
	   
	   /**
	    * 
	    */
	   public Student getStudentById(int id) {
	      String SQL = "select * from Student, Subject where Student.studNo = ? and Student.studNo = Subject.studNo";

	      Student student=jdbcTemplateObject.queryForObject(SQL, new Object[] {id}, new StudentRowMapper());
	      
	      return student;
	   }
	   
	   
	   
	   private static final class StudentRowMapper implements RowMapper<Student> {

			@Override
			public Student mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				Student student = new Student();
				student.setStudentNo(resultSet.getInt("studNo"));
				student.setName(resultSet.getString("name"));
				student.setSubject(resultSet.getString("subj_name"));
				
				return student;
			}
					
		}


}
