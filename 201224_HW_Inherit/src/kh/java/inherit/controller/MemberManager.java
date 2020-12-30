package kh.java.inherit.controller;

import kh.java.inherit.model.vo.*;

public class MemberManager {
	final static int MAX_COUNT_MEMBER = 10;
	Member[] mArr = new Member[MAX_COUNT_MEMBER];
	int i = 0;
	
	public void insertMember(Member m) {
		mArr[i++] = m;
	}
	
	public void printData() {
		System.out.println("-------회원 정보--------");
		System.out.printf("%-10s%-10s%-10s%-10s%n","이름","등급","포인트","이자포인트");
		System.out.println("----------------------");
		
		for(Member m : mArr) {
			if(m != null) {
				System.out.printf("%-10s%-10s%-10d%-10.2f%n",m.getName(),m.getGrade(),m.getPoint(),m.getEjaPoint());
			}
		}
	}
}
