package com.springinaction.mvc.service;

import org.springframework.stereotype.Component;

@Component("spitterService")
public interface SpitterService {

	public String getRecentSpittles(int spittles);
}
