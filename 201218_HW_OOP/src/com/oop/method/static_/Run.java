package com.oop.method.static_;

public class Run {

	public static void main(String[] args) {
		StaticMethod s = new StaticMethod();
		System.out.println(s.toUpper("simpson"));
		System.out.println(s.setChar("simpson", 3));
		System.out.println(s.getAlphabetLength("asd124142AF간나"));
		System.out.println(s.conact("simpsob", "미친놈124"));
	}

}
