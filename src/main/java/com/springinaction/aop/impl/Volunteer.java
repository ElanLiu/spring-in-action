package com.springinaction.aop.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.springinaction.aop.service.Thinker;


@Component("volunteer")
public class Volunteer implements Thinker{
	
	@Value("Woo~~~")
	private String thoughts;

	@Override
	public void thingkOfSomething(String thoughts) {
		this.thoughts = thoughts;
		System.out.println("I'm thinking about: " + thoughts);
		
	}

	public String getThoughts() {
		return thoughts;
	}

	public static class inner{
		@Test
		public static void main(String[] args) throws Exception{
			ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/aop/aop.xml");
			Thinker thinker = (Thinker) ctx.getBean("volunteer");
			thinker.thingkOfSomething("wooo");
			Magician m = new Magician();
			
			Assert.assertEquals("wooo", m.getThoughts());
		}
		
	}

}
