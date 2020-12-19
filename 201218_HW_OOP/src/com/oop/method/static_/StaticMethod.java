package com.oop.method.static_;

public class StaticMethod {
	public static String toUpper(String str) {
		String str2 = "";
		for(int i = 0; i < str.length(); i++) {
			char x = str.charAt(i);
			if(x>='a' && x<='z') {
				x -= 32;
			}
			str2 += x;
		}
		return str2;
	}
	
	public static char setChar(String str, int x) {
		return str.charAt(x);
	}
	
	public static int getAlphabetLength(String str) {
		int cnt = 0;
		for(int i = 0; i < str.length(); i++) {
			char x = str.charAt(i);
			if((x >= 'a' && x <= 'z') || (x >= 'A' &&  x <= 'Z')) {
				cnt ++;
			}
		}
		return cnt;
	}
	
	public static String conact(String str1, String str2) {
		String str3 = "";
		for(int i = 0; i < str1.length(); i++) {
			char x = str1.charAt(i);
			str3 += x;
		}
		for(int i = 0; i < str2.length(); i++) {
			char x = str2.charAt(i);
			str3 += x;
		}
		return str3;
	}
}
