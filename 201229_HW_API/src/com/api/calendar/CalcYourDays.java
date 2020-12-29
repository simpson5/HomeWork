package com.api.calendar;

import java.util.Calendar;
import java.util.Scanner;

public class CalcYourDays {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Calendar now = Calendar.getInstance();
		Calendar birth = Calendar.getInstance();
		System.out.println("생년월일 입력");
		int year;
		int month;
		int day;
		System.out.println("년도.");
		year = sc.nextInt();
		System.out.println("월");
		month = sc.nextInt();
		System.out.println("일"); 
		day = sc.nextInt();
		
		birth.set(year, month, day);
		
		long birthM = birth.getTimeInMillis();
		long nowM = now.getTimeInMillis();
		long diff = (nowM - birthM)/1000/60/60/24;
		
		System.out.println(diff);
	}
}
