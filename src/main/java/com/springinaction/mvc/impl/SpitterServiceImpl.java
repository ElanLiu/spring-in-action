package com.springinaction.mvc.impl;

import com.springinaction.mvc.service.SpitterService;

public class SpitterServiceImpl implements SpitterService{

	@Override
	public String getRecentSpittles(int spittles) {
		return spittles + "spittles";
	}

}
