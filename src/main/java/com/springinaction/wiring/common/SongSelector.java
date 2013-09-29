package com.springinaction.wiring.common;

import java.util.List;
import java.util.Random;

public class SongSelector {
	
	private List<String> songList;
	
	public String selectSong(){
		Random rand = new Random();
		int i = rand.nextInt(songList.size());
		return songList.get(i);
	}

	public List<String> getSongList() {
		return songList;
	}

	public void setSongList(List<String> songList) {
		this.songList = songList;
	}

}
