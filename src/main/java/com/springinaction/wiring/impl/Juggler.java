package com.springinaction.wiring.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springinaction.wiring.service.Performer;

/*
 * scope的使用，比如singleton单例
 */
public class Juggler implements Performer{
	
	private int beanBags = 3;
	
	public int getBeanBags() {
		return beanBags;
	}

	public void setBeanBags(int beanBags) {
		this.beanBags = beanBags;
	}

	public Juggler(){}
	
	public Juggler(int beanBags){
		this.beanBags = beanBags;
	}

	@Override
	public void perform() throws Exception {
		System.out.println("JUGGLING " + beanBags + " beanBags");
	}
	
	public static class inner{
		public static void main(String[] args) throws Exception{
			ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/wiring/performer.xml");
			Performer performer = (Performer) ctx.getBean("Duke");
			performer.perform();
		}
		
	}

}
