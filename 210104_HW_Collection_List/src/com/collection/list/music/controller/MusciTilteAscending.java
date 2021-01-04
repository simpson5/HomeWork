package com.collection.list.music.controller;

import java.util.Comparator;
import com.collection.list.music.model.vo.Music;

//제목 오름차순
public class MusciTilteAscending implements Comparator<Music> {
	@Override
	public int compare(Music o1, Music o2) {
		return o1.getTitle().compareTo(o2.getTitle());
	}
}
