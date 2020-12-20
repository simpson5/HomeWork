package test.contoroller;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if(a*b>10) {
			System.out.println("두자리 수입니다");
		}
		else {
			System.out.println("한자리 수입니다");	
		}

	}

}
