package member.controller;

import member.model.vo.*;

public class MemberManager {
	Silver[] sArr = new Silver[10];
	Gold[] gArr = new Gold[10];
	Vip[] vArr = new Vip[10];
	Vvip[] vvArr = new Vvip[10];
	int i = 0;
	int j = 0;
	int k = 0;
	int l = 0;
	
	public void silverInsert(Silver s) {
		s = new Silver(s.getName(), s.getGrade(), s.getPoint());
		sArr[i] = s;
		i++;
	}
	
	public void goldInsert(Gold g) {
		g = new Gold(g.getName(), g.getGrade(), g.getPoint());
		gArr[j] = g;
		j++;
	}
	
	public void vipInsert(Vip v) {
		v = new Vip(v.getName(), v.getGrade(), v.getPoint());
		vArr[j] = v;
		k++;
	}
	
	public void VvipInsert(Vvip v) {
		v = new Vvip(v.getName(), v.getGrade(), v.getPoint());
		vvArr[l] = v;
		l++;
	}
	
	public void printData() {
		System.out.println("-------회원 정보--------");
		System.out.printf("%-10s%-10s%-10s%-10s%n","이름","등급","포인트","이자포인트");
		System.out.println("----------------------");
		
		for(Silver s : sArr) {
			if(s != null) {
				System.out.printf("%-10s%-10s%-10d%-10.2f%n",s.getName(),s.getGrade(),s.getPoint(),s.interestP());
			}
		}
		for(Gold g : gArr) {
			if(g != null) {
				System.out.printf("%-10s%-10s%-10d%-10.2f%n",g.getName(),g.getGrade(),g.getPoint(),g.interestP());
			}
		}
		
		for(Vip v : vArr) {
			if(v != null) {
				System.out.printf("%-10s%-10s%-10d%-10.2f%n",v.getName(),v.getGrade(),v.getPoint(),v.interestP());
			}
		}
		
		for(Vvip v : vvArr) {
			if(v != null) {
				System.out.printf("%-10s%-10s%-10d%-10.2f%n",v.getName(),v.getGrade(),v.getPoint(),v.interestP());
			}
		}
	}
}
