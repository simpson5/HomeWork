package com.thread.sleep;

public class SleepTest extends Thread {
	public static void main(String[] args) {
		SleepTest s = new SleepTest();
		s.sendAphorism();
	}

	public void sendAphorism() {
		for(int i = 0; i < 10 ; i++) {
			int num = (int)(Math.random()*10) + 1;
			System.out.println(num);
			delay(100);
		}
	}
	
	public void delay(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
