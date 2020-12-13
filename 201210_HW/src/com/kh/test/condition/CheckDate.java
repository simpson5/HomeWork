package com.kh.test.condition;

import java.util.Scanner;

public class CheckDate {

	public static void main(String[] args) {
		CheckDate ck = new CheckDate();
		ck.test();
	}
	
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열 입력");
		String s = sc.next();
		System.out.println("문자 입력");
		char ch = sc.next().charAt(0);
		int cnt = 0;
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)==ch) {
				cnt ++;
			}
		}
		
		System.out.println(cnt);
		
	}
}
