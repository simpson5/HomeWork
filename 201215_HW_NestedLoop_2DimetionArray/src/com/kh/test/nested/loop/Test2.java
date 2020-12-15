package com.kh.test.nested.loop;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Test2 t = new Test2();
		t.test();
	}
	//정수하나 입력받아, 그 수가 양수일때만 입력된 수를  행수로 적용하여 다음과 같이 출력되게 하는 프로그램을 만들어보자.
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.println("몇까지 출력할거야?");
		int num = sc.nextInt();
		if(num < 1) {
			System.out.println("양수를 입력하세요");
		}
		for(int i = 0; i < num; i++) {
			for(int j = num-i; j > 0; j--) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
}
