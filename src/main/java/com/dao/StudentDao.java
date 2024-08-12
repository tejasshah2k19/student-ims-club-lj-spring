package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.StudentBean;

@Repository // singleton -> dao
public class StudentDao {

	@Autowired
	JdbcTemplate stmt;// execute the query

	public void addStudent(StudentBean studentBean) {
		// insert
		stmt.update("insert into students (name,joiningDate) values (?,?)", studentBean.getName(),
				studentBean.getJoiningDate());

	}

	public List<StudentBean> getAllStudents() {
		// 1 2 3 4 5
		// BeanPropertyRowMapper
		// select -> ResultSet -> rs [while->bean->list]

		List<StudentBean> students = stmt.query("select * from students",
				new BeanPropertyRowMapper<>(StudentBean.class));
		return students;
	}

	public void deleteStudentById(Integer studentId) {
		// delete from students where studentId = ?
//		stmt
		stmt.update("delete from students where studentId = ? ",studentId);
		
	}

	// update query queryForObject
	//insert , update ,delete -> stmt.update() 
}
