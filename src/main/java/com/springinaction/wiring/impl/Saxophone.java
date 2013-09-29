package com.springinaction.wiring.impl;

import com.springinaction.wiring.common.Tune;
import com.springinaction.wiring.service.Instrument;

/*
 * 通过对xml使用autowire，使得自动装配
 */
public class Saxophone implements Instrument{
	
	private Tune tune;

	public Tune getTune() {
		return tune;
	}

	public void setTune(Tune tune) {
		this.tune = tune;
	}

	@Override
	public void play() {
		System.out.println("TOOT...TOOT...TOOT " + tune.audio());
	}

}
