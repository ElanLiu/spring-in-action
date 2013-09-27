package com.springinaction.database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import com.springinaction.database.DO.OrderDO;

public class SimpleJdbcTemplateDemo {
	
	static SimpleJdbcTemplate jdbcTemplate;

	private static final String SQL_QUERY="select * from c2b_order where items=?; ";

	private static final String SQL_INSERT="insert into c2b_order values(null,  '2000035931576', ?, ?, 123, now(), now(), 'N')";
	
	static OrderDO order = new OrderDO();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PropertyConfigurator.configure("src/main/resources/config/log4j.properties");
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"src/main/resources/spring/database/simpleJdbcTemplate.xml");

		order.setItems("simple");
		order.setTaobaoUserName("test");
		jdbcTemplate.update(SQL_INSERT, order.getItems(), order.getTaobaoUserName());
		
		//jdbcTemplate.query(sql, rm, args);
		
	}

	public SimpleJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(SimpleJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
