package com.springinaction.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.springinaction.aop.service.Performer;

@Component("actor")
public class Actor implements Performer{

	@Override
	public void perform() throws Exception {
		System.out.println("Singing ......");
		
	}
	
	@Override
	public void sayWords(String str){
		System.out.println(str);
	}
	
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/aop/aop.xml");
		Performer performer = (Performer) ctx.getBean("actor");
		performer.perform();
		performer.sayWords("ggggggg");

	}

}
