package com.springinaction.database.deprecated;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.springinaction.database.DO.OrderDO;

public class JdbcTemplateDaoDemo extends JdbcDaoSupport{
	private static final String SQL_QUERY="select * from c2b_order where items=?; ";

	private static final String SQL_INSERT="insert into c2b_order values(null,  '2000035931576', ?, ?, 123, now(), now(), 'N')";
	
	private static OrderDO order;
	
	//private  JdbcTemplate jdbcTemplate;
	/**
	 * @param args
	 */

	
	public static void main(String[] args) {
		
		JdbcTemplateDaoDemo jd = new JdbcTemplateDaoDemo();
		jd.exe();

	}
	
	public void exe(){
		PropertyConfigurator.configure("src/main/resources/config/log4j.properties");
		
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"src/main/resources/spring/database/jdbcTemplateDao.xml");
		List<Object> list = getJdbcTemplate().query(SQL_QUERY, new Object[]{"test"}, new RowMapper(){
			@Override
			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				OrderDO order = new OrderDO();
				order.setId(rs.getLong(1));
				order.setTaobaoOrderId(rs.getString(2));
				order.setTaobaoUserName(rs.getString(3));
				order.setItems(rs.getString(4));
				order.setPrice(rs.getFloat(5));
				
				return order;
			}});
		
		System.out.println(list.size());
		for(Object obj : list){
			System.out.print(((OrderDO)obj).getId() + ", " + ((OrderDO)obj).getTaobaoUserName()
					+ ", " + ((OrderDO)obj).getCreateTime());
			System.out.println();
		}
	}



}
