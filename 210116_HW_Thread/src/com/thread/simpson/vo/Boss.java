package com.thread.simpson.vo;

public class Boss extends Simpson {

	public Boss(String name, int hp, int atk) {
		super(name, hp , atk);
	}

	@Override
	public int atk() {
		return getAtk()*2;
	}
	
}
