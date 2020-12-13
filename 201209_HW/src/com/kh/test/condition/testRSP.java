package com.kh.test.condition;

import java.util.Scanner;

public class testRSP {

	public static void main(String[] args) {
		testRSP rsp = new testRSP();
		while(true) {
			rsp.test();
		}
	}
	
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=====가위바위보!=====");
		System.out.print("1.가위/2.바위/3.보: ");
		int user = sc.nextInt();
		int num = (int)(Math.random()*3) + 1;
		int checkNum = checkWin(user, num);
		System.out.println("=====결과=====");
		System.out.println("사용자: "+what(user) + " vs 컴퓨터: " +what(num));
		System.out.println("============");
		
		//코드가 한줄일 경우 생략이 가능
		if(checkNum==0)
			System.out.println("내가 이겼지롱~");
		else if(checkNum==100)
			System.out.println("내가 졌다 ㅠㅜ...");
		else
			System.out.println("무승부!");
		//System.out.println(checkNum);
		
		
	}
	
	public int checkWin(int num1, int num2) {
		if(num1 == num2) {
			//System.out.println(num2);
			return -100;
		}
		else if(num1 < num2) {
			//System.out.println(num2);
			return 100;
		}
		else if(num1 == 3 && num2 == 1){
			//System.out.println(num2);
			return 100;
		}
		else {
			//System.out.println(num2);
			return 0;
		}
	}
	
	public String what(int num) {
		String s = num == 1 ? "가위" : ((num == 2) ? "바위" : "보");
		return s;
	}
}
