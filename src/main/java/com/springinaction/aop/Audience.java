package com.springinaction.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class Audience {
	
	public void takeSeats(){
		System.out.println("The audience is taking their seats.");
	}
	
	public void turnOffCellPhone(){
		System.out.println("The audience is turning off their cellphones.");
	}
	
	public void applaud(){
		System.out.println("CLAP CLAP CLAP.");
	}
	
	public void demandRefund(){
		System.out.println("BOO! We want our money back!");
	}
	
	public void watchPerformance(ProceedingJoinPoint joinpoint){
		try{
			System.out.println("///The audience is taking their seats.");
			System.out.println("///The audience is turning off their cellphones.");
			
			long start = System.currentTimeMillis();
			
			joinpoint.proceed();
			
			long end = System.currentTimeMillis();
			System.out.println("///CLAP CLAP CLAP.");
			System.out.println(end - start);
		}catch(Throwable t){
			System.out.println("///BOO! We want our money back!");
		}
	}
	
	public String repeatWords(String str){
		System.out.println("repeat : " + str);
		return str;
	}

}
