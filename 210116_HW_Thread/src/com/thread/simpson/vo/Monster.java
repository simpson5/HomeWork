package com.thread.simpson.vo;

public class Monster extends Simpson {

	public Monster(String name, int hp, int atk) {
		super(name, hp, atk);
	}
	
	@Override
	public int atk() {
		return getAtk();
	}
}
