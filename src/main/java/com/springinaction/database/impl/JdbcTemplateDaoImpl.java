package com.springinaction.database.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springinaction.database.DO.Student;
import com.springinaction.database.dao.JdbcTemplateDao;

public class JdbcTemplateDaoImpl implements JdbcTemplateDao{
	
	private JdbcTemplate jdbcTemplate;
	
	private String SQL_QUERY="select * from student where sno=?; ";

	private String SQL_INSERT = "insert into student values(?, ?, ?)";
	

	@Override
	public void addOperation(Student student) {
		jdbcTemplate.update(SQL_INSERT, 
				student.getSno(),
				student.getSname(),
				student.getSex());
	}

	@Override
	public List<Student> queryOperation(Student student) {
		return jdbcTemplate.query(SQL_QUERY, new Object[]{"11"}, new RowMapper<Student>(){

			@Override
			public Student mapRow(ResultSet rs, int arg1) throws SQLException {
				Student student = new Student();
				student.setSno(rs.getString(1));
				student.setSname(rs.getString(2));
				student.setSex(rs.getString(3));
				return student;
			}});
	}

	@Override
	public void updateOperation(Student student) {
		// TODO Auto-generated method stub
		
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public static class inner{
		public static void main(String[] args) throws Exception{
			Student student = new Student();
			student.setSno("11");
			student.setSname("AA");
			student.setSex("F");
			
			ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/database/database.xml");
			JdbcTemplateDao operator = (JdbcTemplateDao) ctx.getBean("jdbcTemplateDaoImpl");
			operator.addOperation(student);
			operator.queryOperation(student);
			
		}
	}

}
