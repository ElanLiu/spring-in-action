package com.springinaction.di.impl;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.springinaction.di.service.Greeting;

public class GreetingImpl implements Greeting{

	private String greeting;
	/**
	 * @param args
	 */
	
	public static class inner{
		public static void main(String[] args) {
			BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/main/resources/spring/di/greeting.xml"));
			Greeting greeting = (Greeting) factory.getBean("greetingConstructor");
			greeting.sayGreeting();
			
			greeting = (Greeting) factory.getBean("greeting");
			greeting.sayGreeting();
		}
	}

	public GreetingImpl(String greeting){
		this.greeting = greeting;
	}
	
	public GreetingImpl(){
	}
	
	@Override
	public void sayGreeting() {
		System.out.print(greeting);
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

}
