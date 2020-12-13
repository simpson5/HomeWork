package com.kh.test.break_continue;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Test2 t = new Test2();
		t.test2();

	}

	public void test() {
		int num = (int)(Math.random()*99)+1;
		int i;
		for(i = 1; ;i++){
			Scanner sc = new Scanner(System.in);
			System.out.print("수 입력: ");
			int simp = sc.nextInt();
			if(simp==num) {
				break;
			}
			if(simp>num) {
				System.out.println("정답보다 큽니다.");
			}
			else {
				System.out.println("정답보다 작습니다.");
			}
		}
		System.out.println("정답"+num+"횟수"+i);
	}

	public void test2() {
		int n = 1;
		int r =0; //정답
		int k=0;//컴퓨터가 부르는 값
		int min=0 ; //최소값
		int max=100 ; //최대값

		Scanner sc = new Scanner(System.in);
		System.out.print("정답은?");
		r = sc.nextInt();
		sc.nextLine();

		while(true){
			//난수 min과 max 사이의 수를 출력 단,min과 max는 제외해야 한다.
			k = (int)(Math.random()*(max-min-1))+min+1;
			System.out.println(n+"번:자 이게 맞아?" + k + "   [크다/작다]");
			//정답을 맞추면 탈출
			if(k==r) {
				break;
			}
			//정답보다 클경우 부른 값이 최대치
			//정답보다 작을 경우 부른 값이 최소치
			String ans = sc.nextLine();
			if(ans.equals("크다")) {
				max = k;
			}
			else if(ans.equals("작다")) {
				min = k;
			}
			else {
				System.out.println("잘못 입력 하셨습니다.");
			}
			
			n++; // 횟수 추가
		}
		//횟수랑 닶을 출력
		System.out.println( n +"번만에 정답"+ k +"를 맞췄어!");
	}
}
