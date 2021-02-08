package com.thread.simpson.vo;

public class Colleague extends Simpson {
	public Colleague(String name, int hp, int atk) {
		super(name, hp, atk);
	}
	
	@Override
	public int atk() {
		return getAtk();
	}
}
