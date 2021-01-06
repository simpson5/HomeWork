package com.thread.alphabet;

public class AlphabetTest {
	public static void main(String[] args) {
		Thread th1 = new UpperAlphbetThread();
		Runnable ra = new LowerAlphbetThread();
		
		Thread th2 = new Thread(ra);
		
		th1.start();
		th2.start();
	}
}
