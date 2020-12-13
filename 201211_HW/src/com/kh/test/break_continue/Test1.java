package com.kh.test.break_continue;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Test1 t = new Test1();
		t.test2();

	}
	
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력:");
		int num = sc.nextInt();
		int simp = 1;
		for(int i = 1; i <= num; i++) {
			if(i%2==0) {
				continue;
			}
			simp = i * simp;
		}
		System.out.println(simp);
	}

	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력:");
		int num1 = sc.nextInt();
		System.out.print("숫자 입력:");
		int num2 = sc.nextInt();
		int simp = 0;
		
		if(num1>num2) {
			int num3 = num1;
			num1 = num2;
			num2 = num3;
		}
		
		for(int i = num1; i <= num2; i++) {
			if(i%2==0) {
				continue;
			}
			simp = simp + i;
		}
		System.out.println(simp);
	}
}
