package kh.java.test.array;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		Test5 t = new Test5();
		t.test();
	}

//	주민등록번호 성별자리 이후부터 *로 가리기.  
//	단, 원본 배열값은 변경 없이 배열 복사본으로 
//	변경하세요
	
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.println("주민번호 입력 [13자리]");
		String pNum = sc.next();
		char[] pNum2 = new char[13];
//		for(int i = 0; i < pNum.length(); i++) {
//			pNum2[i] = pNum.charAt(i);
//		}
		
		//스트링이 배열 형태라고 하지만 한번에 다른 배욜로 카피 할 수 없다!
		//System.arraycopy(pNum, 0, pNum2, 0, pNum.length());
		//.toCharArray() 문자 배열로 바꿔줌.
		System.arraycopy(pNum.toCharArray(), 0, pNum2, 0, 13);
		
		for(int i = 7; i < 13; i++) {
			pNum2[i] = '*';
		}
		
		System.out.println(pNum);
		System.out.println(pNum2);
	}
}
