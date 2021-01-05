package com.collection.map.member;

import java.util.Comparator;

public class MemberIdAscending implements Comparator<Member> {

	@Override
	public int compare(Member o1, Member o2) {
		return o1.getUserId().compareTo(o2.getUserId());
	}
	
}
