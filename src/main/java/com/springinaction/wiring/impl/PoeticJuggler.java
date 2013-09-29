package com.springinaction.wiring.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springinaction.wiring.Stage;
import com.springinaction.wiring.service.Performer;
import com.springinaction.wiring.service.Poem;

/*
 * init-method和destroy-method的使用
 */
public class PoeticJuggler extends Juggler {

	private Poem poem;
	
	private Stage stage;

	public void setPoem(Poem poem) {
		this.poem = poem;
	}

	public PoeticJuggler(Poem poem){
		super();
		this.poem = poem;
	}
	
	public PoeticJuggler(int beanBags, Poem poem, Stage stage){
		super(beanBags);
		this.poem = poem;
		this.stage = stage;
	}
	
	@Override
	public void perform() throws Exception{
		super.perform();
		System.out.println("While reciting...");
		poem.recite();
	}
	
	public void init(){
		System.out.println("Initializing...");
	}
	
	public void destroy(){
		System.out.println("destroying...");
	}
	
	public static class inner{
		public static void main(String[] args) throws Exception{
			ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/wiring/performer.xml");
			Performer performer = (Performer) ctx.getBean("poeticDuke");
			performer.perform();
		}
		
	}

}
