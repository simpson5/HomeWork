package com.collection.map.member;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class memberTest {
	Map<String, Member> member = new HashMap<>();

	public static void main(String[] args) {
		memberTest mt = new memberTest();
		mt.test0();
		mt.test1();
		mt.test2();

	}
	
	//1. 다음 회원 정보를 Map<String, Member>에 저장후, 출력하세요.
	public void test0() {
		member.put("honggd" , new Member("honggd","1234","홍길동",35,"01012341234"));
		member.put("sinsa" , new Member("sinsa","1234","신사임당",50,"01012341234"));
		member.put("leess" , new Member("leess","1234","이순신",43,"01012341234"));
		member.put("yooon" , new Member("yooon","1234","윤봉길",37,"01012341234"));
		member.put("jangbg" , new Member("jangbg","1234","장보고",29,"01012341234"));
	}
	
	//회원 Map은 필드로 지정하고, MemberTest 생성자에서 map에 요소 추가할 것.
	public void test1() {
		
		Set<String> keySet = member.keySet();
		Iterator<String> iter = keySet.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			Member value = member.get(key);
			System.out.printf("key = %s, value = %s%n", key, value);
		}
	}
	
	//2. Map에 저장된 회원중 인자로 전달한 아이디가 존재하는 여부를 검사하는 메소드를 생성하세요.
	public boolean isUserExist(String userId) {
		Set<Entry<String, Member>> entrySet = member.entrySet();
		for(Entry<String, Member> entry : entrySet) {
			Member value = entry.getValue();
			if(value.getUserId().equals(userId)) {
				return true;
			}
		}
		return false;
	}
	
	public void test2() {
		System.out.println(isUserExist("jangbg"));
		System.out.println(isUserExist("sejong"));
	}
	
	//3. yooon 아이디 조회후 해당객체를 다음과 같이 수정하세요.
	public void test3() {
		
	}
	
	//4. sinsa 아이디 회원을 삭제하세요.
	public void test4() {
		String key = null;
		
		Set<Entry<String, Member>> entrySet = member.entrySet();
		for(Entry<String, Member> entry : entrySet) {
			entry.getValue();
		}
		member.remove(key);
	}
}
	

