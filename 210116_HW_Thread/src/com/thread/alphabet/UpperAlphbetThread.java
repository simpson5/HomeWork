package com.thread.alphabet;

public class UpperAlphbetThread extends Thread {

	@Override
	public void run() {
		for(char ch = 'A'; ch <= 'Z'; ch ++) {
			System.out.print(ch);
		}
	}
	
}
