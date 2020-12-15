package com.kh.test.nested.loop;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		Test3 t = new Test3();
		t.test();
	}
//	정수하나 입력받아, 그 수가 양수일때만 입력된 
//	수를 줄 수로 적용하여 다음과 같이 출력되게 하는 
//	프로그램을 만들어보자.
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.println("몇까지 출력할거야?");
		int num = sc.nextInt();
		for(int i = 0; i < (num*2-1); i++) {
			System.out.print(i+": ");
			for(int j = 0; j < num; j++) {
				if(i < num &&i >=j){
					System.out.print('●');
				}
				else if(i==j) {
					System.out.print('●');
				}
				else if(i >= num && j > i-num) {
					System.out.print('●');
				}
				else {
					System.out.print(' ');
				}
			}
			System.out.println();
		}
		if(num < 1) {
			System.out.println("양수를 입력하세요");
		}
	}

}
