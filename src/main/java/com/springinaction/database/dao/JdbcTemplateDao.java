package com.springinaction.database.dao;

import java.util.List;

import com.springinaction.database.DO.Student;

public interface JdbcTemplateDao {
	
	void addOperation(Student student);
	
	List<Student> queryOperation(Student student);
	
	void updateOperation(Student student);

}
