package com.kh.test.condition;

import java.util.Scanner;

public class Test2 {
	
	public static void main(String[] args) {
		Test2 test = new Test2();
		test.test();
	}
	
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 점수:");
		int korea = sc.nextInt();
		System.out.print("영어 점수:");
		int english = sc.nextInt();
		System.out.print("수학 점수:");
		int math = sc.nextInt();
		int sum = korea + english + math;
		double avg = sum /3.0;
		
		if(korea >=40 && math >=40 && english >=40 && avg >= 60) {
			System.out.println("축 합격!");
		}
		else {
			System.out.println("불합격!");
		}
	}
}
