package com.api.calendar;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		int yyyy = cal.get(Calendar.YEAR);
		int MM = cal.get(Calendar.MONTH);
		int dd = cal.get(Calendar.DATE);
		int w = cal.get(Calendar.DAY_OF_WEEK);
		int hh = cal.get(Calendar.HOUR_OF_DAY);
		int mm = cal.get(Calendar.MINUTE);
		int ss = cal.get(Calendar.SECOND);
		
		char[] ch = {'일', '월', '화', '수', '목' ,'금', '토'};
		
		System.out.printf("%d년 %d월 %d일 %c요일 %d시 %d분 %d초",
				yyyy, MM, dd, ch[w-1], hh, mm, ss);

	}

}
