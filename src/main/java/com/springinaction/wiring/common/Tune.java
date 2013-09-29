package com.springinaction.wiring.common;

public class Tune {
	
	private String voice;
	
	private SongSelector justExample;
	
	
	public String audio(){
		return voice;
	}

	public String getVoice() {
		return voice;
	}

	public void setVoice(String voice) {
		this.voice = voice;
	}

	public SongSelector getJustExample() {
		return justExample;
	}

	public void setJustExample(SongSelector justExample) {
		this.justExample = justExample;
	}


}
