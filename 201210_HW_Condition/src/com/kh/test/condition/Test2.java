package com.kh.test.condition;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		Test2 t = new Test2();
		t.menu();

	}
	
	public void menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("   **********주 메뉴*********\n"
				+"a. 불고기버거 ------------5000\n"
				+"b. 새우버거 --------------4000\n"
				+"c. 치킨버거 --------------4500\n"
				+"d. 한우버거 -------------10000\n"
				+"e. 디버거 ----------------7000\n"
				+"   ************************");
		char ch = sc.next().charAt(0);
		String nameMain;
		int priceMain;
		
		System.out.println("   **********사이드*********\n"
				+"1. 콜라 -------------------1500\n"
				+"2. 사이다 -----------------1500\n"
				+"3. 밀크쉐이크-------------2500\n"
				+"4. 레드불------------------3000\n"
				+"   ***********************");
		int num = sc.nextInt();
		String nameSide;
		int priceSide;
		
		switch(ch) {
			case 'a':
				nameMain ="불고기버거";
				priceMain =5000;
				break;
			case 'b':
				nameMain ="새우버거";
				priceMain =4000;
				break;
			case 'c':
				nameMain ="치킨버거";
				priceMain =4500;
				break;
			case 'd':
				nameMain ="한우버거";
				priceMain =10000;
				break;
			case 'e':
				nameMain ="디버거";
				priceMain =7000;
				break;
			default:
				System.out.println("잘못 입력 하셨습니다!");
				return;
		}
		
		switch(num) {
		case 1:
			nameSide="콜라";
			priceSide =1500;
			break;
		case 2:
			nameSide ="사이다";
			priceSide =1500;
			break;
		case 3:
			nameSide ="밀크 쉐이크";
			priceSide =2500;
			break;
		case 4:
			nameSide ="레드불";
			priceSide =3000;
			break;
		default:
			System.out.println("잘못 입력 하셨습니다!");
			return;
	}
		
		System.out.println(nameMain+", "+nameSide+"은 총 "+(priceMain+priceSide)+"원입니다");
	}
}
