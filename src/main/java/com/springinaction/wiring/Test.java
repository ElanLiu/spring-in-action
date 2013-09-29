package com.springinaction.wiring;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stage s1 = Stage.getInstance();
		Stage s2 = Stage.getInstance();
		
		System.out.print(s1 == s2);
	}

}
