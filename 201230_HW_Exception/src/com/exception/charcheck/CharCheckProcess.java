package com.exception.charcheck;

public class CharCheckProcess {

	public CharCheckProcess() {
	}
	
	public int countAlpha(String s) throws CharCheckException{
		int cnt = 0;
		char[] chArr = new char[s.length()];
		for(int i = 0; i < s.length(); i++) {
			chArr[i] = s.charAt(i);
			if(chArr[i] == ' ') {
				throw new CharCheckException("공백입니다.");
			}
			if((chArr[i] >= 'a' && chArr[i] <= 'z') ||(chArr[i] >= 'A' && chArr[i] <= 'Z')) {
				cnt++;
			}
		}
		return cnt;
	}
}
