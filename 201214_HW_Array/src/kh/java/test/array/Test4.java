package kh.java.test.array;

import java.util.Scanner;
import java.lang.String.*;

public class Test4 {

	public static void main(String[] args) {
		Test4 t = new Test4();
		t.test2();
	}
	
	
//	사용자의 전화번호를 입력받고, 11자리의 문자형배열에 저장한후,  가운데 4자리를 *로 가리기.  
//	단, 원본 배열값은 변경 없이 배열 복사본으로 변경하세요
//	 
//		힌트) 복사방법
//	   - for문이용 1:1대입
//	   - System.arraycopy() 매소드 이용
//	   - clone() 매소드 이용
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.println("전화번호 입력 [11자리]");
		String pNum = sc.next();
		char[] pNum2 = new char[11];
//		for(int i = 0; i < pNum.length(); i++) {
//			pNum2[i] = pNum.charAt(i);
//		}
		//스트링 클론이 왜 없지?...
		//System.arraycopy(pNum, 0, pNum2, 0, pNum.length());
		//arraycopy도 먹지 않는다!
		
		pNum2 = pNum.toCharArray().clone();
		
		for(int i = 3; i < 7; i++) {
			pNum2[i] = '*';
		}
		
		//문자열이라 []이랑 for문 없이 바로 출력이 가능한건가?
		System.out.println(pNum);
		System.out.println(pNum2);
	}
	
//	위문제를 배열복사없이 문자열차원에 가운데 4자리를 교체해보자.
//	* java.lang.String.substring(beginIndex, endIndex) 메소드 찾아볼것!
//	* 문자열은 직접 수정이 불가하므로, 특정자리의 문자열을 가져와 처리해야한다.
	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("전화번호 입력 [11자리]");
		String pNum = sc.next();
		
		//beginIndex부터 endIndex까지 출력한다.
		String result = pNum.substring(0, 3)+"****"+pNum.substring(7, 11);
		System.out.println(result);
		//System.out.println(pNum.substring(0, 3)+"****"+pNum.substring(7, 11));
	}

}
