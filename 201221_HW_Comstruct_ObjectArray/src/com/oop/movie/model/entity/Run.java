package com.oop.movie.model.entity;

import java.util.Calendar;

public class Run {

	public static void main(String[] args) {
		//배우 배열
		String[] str = {"키아나 리부스", "로렌스 피시번", "휴고 위빙", "캐리 앤 모스", "글로리아 포스터"};
		Calendar time = Calendar.getInstance();
		//개봉일 지정하기
		time.set(1993, 5, 31);
		
		Movie m1 = new Movie("The Matrix");
		Movie m2 = new Movie("The Matrix", "위쇼스키 형제");
		Movie m3 = new Movie("The Matrix", "위쇼스키 형제", str);
		Movie m4 = new Movie("The Matrix", "위쇼스키 형제", str, time);
		
		System.out.println(m1.information());
		System.out.println(m2.information());
		System.out.println(m3.information());
		System.out.println(m4.information());	
	}

}
