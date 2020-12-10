package com.kh.test.condition;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		Test1 t = new Test1();
		t.menu();
	}

	public void menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("   **********메  뉴*********\n"
				+"1. 떡볶이 ----------------1000\n"
				+"2. 김밥 ------------------ 2000\n"
				+"3. 오뎅 ------------------ 1000\n"
				+"4. 순대 ------------------ 2000\n"
				+"5. 튀김 ------------------ 3000\n"
				+"6. 떡튀순 ---------------- 8000\n"
				+"   ***********************");
		int num = sc.nextInt();
		String name;
		int price;
		switch(num) {
			case 1:
				name="떡볶이";
				price=1000;
				break;
			case 2:
				name="김밥";
				price=2000;
				break;
			case 3:
				name="오뎅";
				price=1000;
				break;
			case 4:
				name="순대";
				price=2000;
				break;
			case 5:
				name="튀김";
				price=3000;
				break;
			case 6:
				name="떡튀순";
				price=8000;
				break;
			default:
				System.out.println("잘못 입력 하셨습니다!");
				return;
		}
		
		System.out.println(name + "는 "+price+"원입니다.");
	}
}
