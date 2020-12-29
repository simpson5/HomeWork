package com.api.token;

import java.util.StringTokenizer;

public class TokenTest {

	public static void main(String[] args) {
		String s = "J a v a P r o g r a m ";
		StringTokenizer tokenizer = new StringTokenizer(s," ");
		char[] ch = new char[tokenizer.countTokens()];
		int i = 0;
		
		//토큰 처리전 글자 출력 & 전 글자갯수 출력???
		
		while(tokenizer.hasMoreTokens()) {
			ch[i] = tokenizer.nextToken().charAt(0);
			System.out.println(tokenizer.countTokens());
			i ++;
		}
		for(char c : ch) {
			System.out.println(c);
		}
		
		String str = "";
		
		for(char c : ch) {
			str += toUpper(c);
		}
		System.out.println(str);
	}
	
	public static char toUpper(char ch) {
			if(ch>='a' && ch<='z') {
				ch -= 32;
			}
		return ch;
	}

}
