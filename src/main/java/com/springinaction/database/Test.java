package com.springinaction.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.springinaction.common.Action;
import com.springinaction.database.DO.OrderDO;


public class Test {
	
	private static JdbcTemplate jdbcTemplate;
	


	private static final String SQL_QUERY="select * from c2b_order where items=?; ";

	private static final String SQL_INSERT="insert into c2b_order values(null,  '2000035931576', ?, ?, 123, now(), now(), 'N')";
	
	private static OrderDO order;
	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		PropertyConfigurator.configure("src/main/resources/config/log4j.properties");
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"src/main/resources/spring/spring.xml");

		Action action = (Action) ctx.getBean("theAction");

		//Action ac2 = new UpperAction();

		System.out.println(action.execute("+++gsfdadf+++"));
		//System.out.println(ac2.execute("gsfdadf"));

		System.out.println("============");
		
		//jdbcTemplate.update(SQL_INSERT, new Object[]{"test", "test"});
		
		List<Object> list = jdbcTemplate.query(SQL_QUERY, new Object[]{"test"}, new RowMapper(){
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
		
		Map param = new HashMap();
		
		OrderDO or = new OrderDO();
		or.setItems("dddddd");
		param.put("items", or.getItems());
		//namedParameterJdbcTemplate.update(SQL_INSERT, param);


	}
	
	public static void  listEach(List<Object> list){
		for(Object obj : list){
			System.out.println(obj);
		}
	}
	
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
