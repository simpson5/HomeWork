package com.api.calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test1 {

	public static void main(String[] args) {
		Calendar cal1 = Calendar.getInstance();
		
		cal1.set(2021, 6, 8, 0, 0, 0);
		Calendar now = Calendar.getInstance();
		//now.set(2021, 6, 8, 0, 0, 0);

		long num1 = now.getTimeInMillis();
		long num2 = cal1.getTimeInMillis();
		long diff = (num2 - num1)/1000/60/60/24;
		
		if(diff ==0) {
			System.out.println("D-Day");
		}
		else {
			System.out.println("D-"+ (diff + 1));
		}
	}

}
