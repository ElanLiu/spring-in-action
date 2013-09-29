package com.springinaction.wiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springinaction.wiring.impl.Instrumentalist;
import com.springinaction.wiring.impl.Juggler;
import com.springinaction.wiring.impl.Saxophone;
import com.springinaction.wiring.service.Instrument;
import com.springinaction.wiring.service.Performer;

/*
 * 使用Configuratin和bean来自动装配，避免使用xml配置
 */
@Configuration
public class SpringConfig {
	
	@Bean
	public Performer actor(){
		return new Juggler();
	}
	
	@Bean
	public Performer kenny(){
		Instrumentalist kenny = new Instrumentalist();
		kenny.setSong("Wahhhh...");
		Instrument in = new Saxophone();
		kenny.setInstrument(in);
		return kenny;
	}
	
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/wiring/performer.xml");
		Performer performer = (Performer) ctx.getBean("kenny");
		performer.perform();

	}

}
