package com.kh.test.condition;

import java.util.Scanner;

public class Test3 {
//	정수 두개를 입력 받고, 연산자(+,-,*,/)를 입력받은 다음 계산한 뒤  결과를 출력하는 계산기 프로그램을 만들어보세요.      
//    출력 예) 입력 5, 6, +
//           5+6=11
//    음수가 입력되거나 +,-,*,/ 이외의 문자가 입력되면 “잘못 입력 하셨습니다.  프로그램을 종료합니다.” 라는 문구가 출력되게 하세요.
	public static void main(String[] args) {
		Test3 test = new Test3();
		test.test();

	}
	
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력: ");
		int num1 = sc.nextInt();
		System.out.print("정수 입력: ");
		int num2 = sc.nextInt();
		System.out.print("부호 입력: ");
		char cal = sc.next().charAt(0);
		
		if(cal == '+') {
			System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
		}
		else if(cal == '-'){
			System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
		}
		else if(cal == '/') {
			System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
		}
		else if(cal == '*'){
			System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));			
		}
		else {
			System.out.println("잘못 입력하셨습니다!");
		}
		
//		if(cal == '+' && cal == '-' && cal == '/' && cal == '*') {
//			System.out.println("잘못 입력하셨습니다!");
//		}
//		else {
//			System.out.printf(num1 + " %c " + num2 + " = %d",cal ,(num1 + cal + num2));
//		}
	}
}
