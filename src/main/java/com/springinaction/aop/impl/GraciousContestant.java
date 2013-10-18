package com.springinaction.aop.impl;

import org.springframework.stereotype.Component;

import com.springinaction.aop.service.Contestant;

@Component("graciousContestant")
public class GraciousContestant implements Contestant{

	@Override
	public void contest() {
		System.out.println("contest...");
		
	}

}
