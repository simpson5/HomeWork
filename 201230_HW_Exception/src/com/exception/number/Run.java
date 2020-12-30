package com.exception.number;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Run r =new Run();
		r.test();

	}
	
	public void test(){
		NumberProcess np = new NumberProcess();
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("정수 1 입력 : ");
			int num1 = sc.nextInt();
			System.out.print("정수 2 입력 : ");
			int num2 = sc.nextInt();
			
			boolean check = np.checkDouble(num1, num2);
			if(check) {
				System.out.println(num1+"는 " + num2 + "배수다.");
			} else {
				System.out.println(num1+"는 " + num2 + "배수가 아니다.");
			}
		} catch (NumberRangeException e) {
			e.printStackTrace();
		}
	}
}
