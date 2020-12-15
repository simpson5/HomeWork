package com.kh.test.break_continue;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		Test3 t = new Test3();
		t.test();

	}
	public void test() {
		Scanner sc =new Scanner(System.in);
		int num = 0;
		while(true) {
			System.out.print("정수 입력:");
			num = sc.nextInt();
			if(num>2) {
				break;
			}
			else {
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
			}
		}
		int cnt = 0;
		
		for(int i = 1; i < num ;i++) {
			if(num%i==0) {
				cnt++;
			}
		}
		
		if(cnt==1) {
			System.out.println("약수의 갯수:"+(cnt+1)+"/ 소수 입니다.");
		}
		else {
			System.out.println("약수의 갯수:"+(cnt+1)+"/ 소수가 아닙니다.");
		}
	}
}