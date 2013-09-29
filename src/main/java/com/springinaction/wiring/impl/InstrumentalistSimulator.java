package com.springinaction.wiring.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springinaction.wiring.service.Performer;

/*
 * SpEL在DI中的使用
 */
public class InstrumentalistSimulator implements Performer{

	private String song;
	
	private String anotherSong;
	
	private String pi;


	public String getAnotherSong() {
		return anotherSong;
	}

	public void setAnotherSong(String anotherSong) {
		this.anotherSong = anotherSong;
	}

	@Override
	public void perform() throws Exception {
		System.out.println("Singing " + song + "......");
		System.out.println("Singing " + anotherSong + "......");
		System.out.println("pi: " + pi );
	}
	
	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/wiring/performer.xml");
		Performer performer = (Performer) ctx.getBean("instrumentalistSimulator");
		performer.perform();
	}

	public String getPi() {
		return pi;
	}

	public void setPi(String pi) {
		this.pi = pi;
	}
}
