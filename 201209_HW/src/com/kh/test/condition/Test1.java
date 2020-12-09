package com.kh.test.condition;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Test1 test = new Test1();
		//test.test1();
		test.test2();
		//test.test3();
	}
	
//  1.메소드명 : public void test1()
//  - 국어, 영어, 수학 점수를 입력 받아 합계를 계산하고 합계가 250점 이상이면 “우수생입니다.”를 출력하는 코드를 작성하세요.
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 점수:");
		int korea = sc.nextInt();
		System.out.print("영어 점수:");
		int english = sc.nextInt();
		System.out.print("수학 점수:");
		int math = sc.nextInt();
		int sum = korea + english + math;
		
		if(sum >=250) {
			System.out.println("우수생 입니다!");
		}
		else {
			System.out.println("아쉽네요...");
		}
	}
//  2.메소드명 : public void test2()
//  - A, B, C연봉을 입력하고 각 연봉을 입력하고
//	연봉이 5000이상이면 “0은 고액연봉자입니다” 라고 출력하는 프로그램을 작성하세요.
	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("연봉 A:");
		int A = sc.nextInt();
		System.out.print("연봉 B:");
		int B = sc.nextInt();
		System.out.print("연봉 C:");
		int C = sc.nextInt();
		
		if(A >= 5000) {
			System.out.println("A는 고액연봉자 입니다!");
		}
		if(B >= 5000) {
			System.out.println("B는 고액연봉자 입니다!");
		}
		if(C >= 5000) {
			System.out.println("C는 고액연봉자 입니다!");
		}
	}
//  3.메소드명 : public void test3()
//  - 정수 한 개를 입력 받아 짝수면 “짝수다” 홀수면 “홀수다라고 출력하세요.
	public void test3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력:");
		int num = sc.nextInt();
		
		if(num%2==0) {
			System.out.println("짝수!");
		}
		else {
			System.out.println("홀수!");
		}
	}
}
