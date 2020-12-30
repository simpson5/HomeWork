package com.api.member.model.run;

import java.util.Calendar;
import java.util.StringTokenizer;

import com.api.member.model.vo.member.Member;

public class Run {

	public static void main(String[] args) {
		String s = "1,김연아,165,47,19900905|2,양세형,167,60,19850818|3,김래원,182,80,19810319";
		StringTokenizer tokenizer = new StringTokenizer(s,",|");
		Member[] mArr = new Member[3];
		String[] token = new String[tokenizer.countTokens()];
		int i = 0;
		
		while(tokenizer.hasMoreTokens()) {
			token[i] = tokenizer.nextToken();
			i++;
		}
		
		//토큰을 각 객체에 대입
		for(int j = 0; j < 3; j++) {
		mArr[j] = new Member(Integer.parseInt(token[0 + 5 * j]),
				token[1 + 5 * j],
				Integer.parseInt(token[2 + 5 * j]),
				Integer.parseInt(token[3 + 5 * j]),
				change(token[4 + 5 * j]));
		
		System.out.println(mArr[j].impormation());
		}
		
	}
	
	//문자열을 캘린더로 바꾸기
	public static Calendar change(String s) {
		Calendar cal = Calendar.getInstance();
		int year = Integer.parseInt(s.substring(0,4));
		int month = Integer.parseInt(s.substring(4,6))-1;
		int date = Integer.parseInt(s.substring(6));
		cal.set(year, month, date);
		
		return cal;
	}
}
