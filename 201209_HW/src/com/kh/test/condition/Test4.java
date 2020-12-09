package com.kh.test.condition;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		Test4 test = new Test4();
		test.test();
		
	}
	
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력: ");
		int num = sc.nextInt();
		
		if(num<1 || num>10) {
			System.out.println("0~10 사이 정수로 입력하시오!");
		}
		else if(num%2==0) {
			System.out.println("짝수!");
		}
		else {
			System.out.println("홀수!");
		}
	}
	
}
