package com.springinaction.aop.impl;

import org.springframework.stereotype.Component;

import com.springinaction.aop.service.MindReader;

@Component("magician")
public class Magician implements MindReader{
	
	private String thoughts;

	@Override
	public void interceptThoughts(String thoughts) {
		System.out.println("Interepting volunteer's thoughts");
		this.thoughts = thoughts;
		
	}

	@Override
	public String getThoughts() {
		return thoughts;
		
	}

}
