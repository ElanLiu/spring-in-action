package com.springinaction.tm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.springinaction.database.DO.Student;
import com.springinaction.database.dao.JdbcTemplateDao;

public class JdbcTransactionManager {
	
	private TransactionTemplate transactionTemplate;
	
	private JdbcTemplateDao jdbcTemplateDao;
	
	public void saveOperation(final Student student){
		transactionTemplate.execute(new TransactionCallback<Void>(){
			@Override
			public Void doInTransaction(TransactionStatus txStatus) {
				try{
					jdbcTemplateDao.addOperation(student);
				}catch(RuntimeException e){
					txStatus.setRollbackOnly();
					throw e;
				}
				return null;
			}
		});
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void addOperation(Student student){
		jdbcTemplateDao.addOperation(student);
	}

	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	public JdbcTemplateDao getJdbcTemplateDao() {
		return jdbcTemplateDao;
	}

	public void setJdbcTemplateDao(JdbcTemplateDao jdbcTemplateDao) {
		this.jdbcTemplateDao = jdbcTemplateDao;
	}
	
	public static class inner{
		public static void main(String[] args) throws Exception{
			Student student = new Student();
			student.setSno("11");
			student.setSname("AA");
			student.setSex("F");
			
			ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/tm/transactionManager.xml");
			JdbcTransactionManager operator = (JdbcTransactionManager) ctx.getBean("jdbcTransactionManager");
			//通过xml配置
			operator.saveOperation(student);
			//注解配置
			operator.addOperation(student);

			
		}
	}

}
