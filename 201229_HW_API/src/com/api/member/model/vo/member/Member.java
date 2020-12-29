package com.api.member.model.vo.member;

import java.util.Calendar;

public class Member {
	private int memberNo;
	private String memberName;
	private int height;
	private int weight;
	private Calendar birth;
	
	public String impormation() {
		String str = "memberNo " + this.memberNo;
		str +=  "\nmemberName " + this.memberName;
		str += "\nheight " + this.height;
		str += "\nweight " + this.weight;
		str += "\nbirth " + printCalendar(this.birth);
		return str;
	}
	
	public String printCalendar(Calendar c) {
		return c.get(Calendar.YEAR)+ "/" +(c.get(Calendar.MONTH) + 1)+ "/" +c.get(Calendar.DATE);
	}

	public Member(int memberNo, String memberName, int height, int weight, Calendar birth) {
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.height = height;
		this.weight = weight;
		this.birth = birth;
	}
}
