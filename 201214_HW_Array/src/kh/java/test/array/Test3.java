package kh.java.test.array;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		Test3 t = new Test3();
		t.test();
	}
//	문자열을 하나 입력 받아 문자배열에 넣고 검색할 문자를 하나 입력 받아 검
//  문자가 문자열에 몇 개인지 개수를 출력하는 프로그램을 작성하세요.
	
//	예) 입력값 : helloworld
//	검색값 :ㅣ
//	출력 : 입력하신 문자열 helloworld에서 찾으시는 문자 l은 3개 입니다.
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열 입력");
		String arr = sc.nextLine();
		System.out.println("찾을 문자");
		char ch = sc.next().charAt(0);
		int cnt = 0;
		
		for(int i = 0; i<arr.length(); i++) {
			if(arr.charAt(i) == ch) {
				cnt ++;
			}
		}
		
		System.out.println(cnt+"개 있습니다");
	}
}
