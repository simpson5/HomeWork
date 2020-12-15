package com.kh.test.condition;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		Test3 t = new Test3();
		t.test();
	}
	
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.print("----------menu----------\r\n" + 
				"1. 가정용 (50원/liter)\r\n" + 
				"2. 상업용 (45원/liter)\r\n" + 
				"3. 공업용 (30원/liter)\r\n" + 
				"-------------------------\r");
		System.out.println( "메뉴번호를 선택하세요.");
		int num1 = sc.nextInt();
		System.out.println("물 사용량을 입력하세요.");
		int num2 = sc.nextInt();
		int water = 0;
		String s = "";
		
		switch(num1) {
			case 1:
				s = "가정용";
				water=50*num2;
				break;
			case 2:
				s = "상업용";
				water=45*num2;
				break;
			case 3:
				s = "공장용";
				water=30*num2;
				break;
			default:
				System.out.println("잘 못 입력 하셨습니다.");
		}
		System.out.println("----------<<수도세>>-----------\r\n" + 
				"선택메뉴번호 :"+s+" 를 선택하셨습니다. \r\n" + 
				"사용요금 :"+water+"\r\n"+ 
				"수도세 :"+water * 0.05+"\r\n" + 
				"총수도요금 :"+water*1.05);
	}
}
