package com.thread.simpson.vo;

public class Player extends Simpson {
	public Player(String name, int hp, int atk) {
		super(name, (int)(hp * 1.5), atk);
	}
	
	@Override
	public int atk() {
		return getAtk();
	}
}
