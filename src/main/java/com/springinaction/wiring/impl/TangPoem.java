package com.springinaction.wiring.impl;

import com.springinaction.wiring.service.Poem;

public class TangPoem implements Poem{
	
	private final String[] tangPoem = {"锄禾日当午", "汗滴禾下土"};

	@Override
	public void recite() {
		for(String str : tangPoem){
			System.out.println(str);
		}
	}

}
