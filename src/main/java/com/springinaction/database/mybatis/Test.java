package com.springinaction.database.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springinaction.database.DO.Student;
import com.springinaction.database.DO.User;
import com.springinaction.database.dao.JdbcTemplateDao;
import com.springinaction.database.mybatis.dao.StudentDAO;
import com.springinaction.database.mybatis.dao.UserMapper;

public class Test {

	UserMapper userMapper;
	
	StudentDAO student;




	public StudentDAO getStudent() {
		return student;
	}




	public void setStudent(StudentDAO student) {
		this.student = student;
	}




	public UserMapper getUserMapper() {
		return userMapper;
	}




	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}




	public User doSomeBusinessStuff(String userId) {
		  return  this.userMapper.getUser(userId);
		}


		
    
    public static void main(String[] args) {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/database/mybatis.xml");
    	Test test = (Test) ctx.getBean("test");
		User s = test.doSomeBusinessStuff("1");
		System.out.print(s.getName());
    	
    }
}
