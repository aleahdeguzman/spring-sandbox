package org.jubot.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		Student student = new Student();
		student.setStudentNo(resultSet.getInt("studNo"));
		student.setName(resultSet.getString("name"));
		student.setSubject(resultSet.getString("subj_name"));
		
		return student;
	}
			
}
