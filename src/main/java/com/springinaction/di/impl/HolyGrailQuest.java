package com.springinaction.di.impl;

import com.springinaction.di.HolyGrail;
import com.springinaction.di.service.Quest;

public class HolyGrailQuest implements Quest{
	
	public HolyGrail embark() throws Exception{
		HolyGrail grail = null;
		grail = new HolyGrail();
		System.out.println("Got the Grail");
		return grail;
	}

}
