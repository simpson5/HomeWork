package test.contoroller;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 입력");
		int num = sc.nextInt();
		
		if(num%2==0) {
			System.out.println("2의 배수");
		}
		else{
			System.out.println("아닙니다");
		}

	}

}
