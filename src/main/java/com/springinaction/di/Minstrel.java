package com.springinaction.di;

import com.springinaction.di.impl.KnightOfTheRoundTable;
import com.springinaction.di.service.Knight;

public class Minstrel {
	
	public void singBefore(){
		System.out.println("La la la, brave knight");
		
	}
	
	public void singAfter(KnightOfTheRoundTable knight){
		System.out.println("De de de");
		
	}

}
