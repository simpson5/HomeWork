package com.collection.list.music.controller;

import java.util.Comparator;
import com.collection.list.music.model.vo.Music;

//가수 오름차순
public class MusicSingerAscending implements Comparator<Music> {
	@Override
	public int compare(Music o1, Music o2) {
		return o1.getSinger().compareTo(o2.getSinger());
	}
}
