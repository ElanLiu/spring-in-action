package com.springinaction.wiring.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springinaction.wiring.common.Tune;
import com.springinaction.wiring.service.Instrument;

/**
 * 
 * @author yu.liuyly
 *
 * 通过注解自动装配
 * 
 * Autowired的使用，Value的使用
 */
public class Piano implements Instrument {
	
	/*
	 * 通过属性自动注入
	 * 
	 * 如果有多个Tune的bean（比如多个实现了Tune的实现类），通过限定器，指定beanId
	 */
	@Autowired
	@Qualifier("tune")
	private static Tune tune;
	
	/*
	 * 通过value注入到基本类型和String类型
	 * 
	 * 注意这里使用了SpEL，在运行期注入了String
	 */
	@Value("#{songSelector.selectSong()}")
	private String band;

	/*
	 * 通过构造函数自动注入
	 */
	@Autowired
	public Piano(Tune tune){
		this.tune = tune;
		System.out.println("DANG...DANG... " + tune.audio());
	}
	
	@Override
	public void play() {
		System.out.println(band + ": DANG...DANG... " + tune.audio());

	}

	/*
	 * 通过方法参数自动注入
	 */
	@Autowired
	public void practice(Tune tune){
		this.tune = tune;
		System.out.println("DANG...DANG... " + tune.audio());
	}
	
	public static class inner{
		public static void main(String[] args) throws Exception{
			ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/wiring/performer.xml");
			Instrument instrument = (Instrument) ctx.getBean("piano");
			instrument.play();
			((Piano)instrument).practice(tune);
		}
		
		
	}

}
