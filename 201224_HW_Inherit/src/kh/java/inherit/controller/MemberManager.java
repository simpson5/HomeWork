package kh.java.inherit.controller;

import kh.java.inherit.model.vo.*;

public class MemberManager {
	final static int MAX_COUNT_MEMBER = 10;
	Silver[] sArr = new Silver[MAX_COUNT_MEMBER];
	Gold[] gArr = new Gold[MAX_COUNT_MEMBER];
	Vip[] vArr = new Vip[MAX_COUNT_MEMBER];
	Vvip[] vvArr = new Vvip[MAX_COUNT_MEMBER];
	int i = 0;
	int j = 0;
	int k = 0;
	int l = 0;
	
	public void silverInsert(Silver s) {
		sArr[i++] = s;
	}
	
	public void goldInsert(Gold g) {
		gArr[j++] = g;
	}
	
	public void vipInsert(Vip v) {
		vArr[j++] = v;
	}
	
	public void VvipInsert(Vvip v) {
		vvArr[l++] = v;
	}
	
	public void printData() {
		System.out.println("-------회원 정보--------");
		System.out.printf("%-10s%-10s%-10s%-10s%n","이름","등급","포인트","이자포인트");
		System.out.println("----------------------");
		
		for(Silver s : sArr) {
			if(s != null) {
				System.out.printf("%-10s%-10s%-10d%-10.2f%n",s.getName(),s.getGrade(),s.getPoint(),s.getEjaPoint());
			}
		}
		for(Gold g : gArr) {
			if(g != null) {
				System.out.printf("%-10s%-10s%-10d%-10.2f%n",g.getName(),g.getGrade(),g.getPoint(),g.getEjaPoint());
			}
		}
		
		for(Vip v : vArr) {
			if(v != null) {
				System.out.printf("%-10s%-10s%-10d%-10.2f%n",v.getName(),v.getGrade(),v.getPoint(),v.getEjaPoint());
			}
		}
		
		for(Vvip v : vvArr) {
			if(v != null) {
				System.out.printf("%-10s%-10s%-10d%-10.2f%n",v.getName(),v.getGrade(),v.getPoint(),v.getEjaPoint());
			}
		}
	}
}
