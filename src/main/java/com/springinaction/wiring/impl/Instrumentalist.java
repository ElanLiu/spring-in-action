package com.springinaction.wiring.impl;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springinaction.wiring.service.Instrument;
import com.springinaction.wiring.service.Performer;

/*
 * list，map，props注入
 */
public class Instrumentalist implements Performer{
	
	private String song;
	
	private Instrument instrument;
	
	private List<Instrument> instrumentList;
	
	private Map<String, Instrument> instrumentMap;
	
	private Map<String, String> audience;


	@Override
	public void perform() throws Exception {
		System.out.println("Singing " + song + "......");
		instrument.play();
		for(Instrument in : instrumentList){
			in.play();
		}
		
		for(String key : instrumentMap.keySet()){
			System.out.println("key: " + key);
			Instrument in = instrumentMap.get(key);
			in.play();
		}
		
		for(String key : audience.keySet()){
			System.out.print("name: " + key);
			String relaton = audience.get(key);
			System.out.println(" relation: " + relaton);
		}
	}

	public List<Instrument> getInstrumentList() {
		return instrumentList;
	}

	public void setInstrumentList(List<Instrument> instrumentList) {
		this.instrumentList = instrumentList;
	}

	public Map<String, Instrument> getInstrumentMap() {
		return instrumentMap;
	}

	public void setInstrumentMap(Map<String, Instrument> instrumentMap) {
		this.instrumentMap = instrumentMap;
	}

	public Map<String, String> getAudience() {
		return audience;
	}

	public void setAudience(Map<String, String> audience) {
		this.audience = audience;
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}



	public static class inner{
		public static void main(String[] args) throws Exception{
			ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/wiring/performer.xml");
			Performer performer = (Performer) ctx.getBean("instrumentalist");
			performer.perform();
		}
	}


}
