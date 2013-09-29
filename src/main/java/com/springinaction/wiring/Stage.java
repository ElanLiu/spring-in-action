package com.springinaction.wiring;

/**
 * 
 * @author yu.liuyly
 * 单例模式
 */
public class Stage {
	
	private Stage(){
		System.out.println("It's a stage!");
	}
	
	public static class StageSingletonHolder{
		static Stage instance = new Stage();
	}
	
	public static Stage getInstance(){
		return StageSingletonHolder.instance;
	}

}
