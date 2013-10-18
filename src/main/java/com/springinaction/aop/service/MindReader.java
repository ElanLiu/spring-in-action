package com.springinaction.aop.service;

public interface MindReader {
	void interceptThoughts(String thoughts);
	
	String getThoughts();
}
