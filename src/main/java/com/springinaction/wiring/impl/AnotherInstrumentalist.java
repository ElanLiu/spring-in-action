package com.springinaction.wiring.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.springinaction.wiring.service.Instrument;
import com.springinaction.wiring.service.Performer;

/**
 * 
 * @author yu.liuyly
 *
 * 通过注解自动装配
 * 
 * 通过Component注解，自动将类注册为bean。
 * 如果只使用方法对外提供服务，是不是用Component比较方便？
 */

@Component("anotherInstrumentalist")
public class AnotherInstrumentalist implements Performer{

	private String song;

	@Autowired
	@Qualifier("saxophone")
	private Instrument instrument;

	@Override
	public void perform() throws Exception {
		System.out.println("Singing " + song + "......");
		instrument.play();
		
	}
	
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/wiring/performer.xml");
		Performer performer = (Performer) ctx.getBean("anotherInstrumentalist");
		performer.perform();

	}

}
