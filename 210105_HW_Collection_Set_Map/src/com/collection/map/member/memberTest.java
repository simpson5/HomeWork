package com.collection.map.member;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class memberTest {
	Map<String, Member> member = new HashMap<>();

	public static void main(String[] args) {
		memberTest mt = new memberTest();
		mt.test0(); //일단 저장...
		mt.test1(); //출력
		mt.test6(); //정렬
		//mt.test4(); //제거
		//mt.test5(); //제거2
		//mt.test3(); //변경
		mt.test1(); //출력
		//mt.test2(); //확인

	}
	
	//1. 다음 회원 정보를 Map<String, Member>에 저장후, 출력하세요.
	public void test0() {
		member.put("honggd" , new Member("honggd","1234","홍길동",35,"01012341234"));
		member.put("yooon" , new Member("yooon","1234","윤봉길",37,"01012341234"));
		member.put("leess" , new Member("leess","1234","이순신",43,"01012341234"));
		member.put("jangbg" , new Member("jangbg","1234","장보고",29,"01012341234"));
		member.put("sinsa" , new Member("sinsa","1234","신사임당",50,"01012341234"));
	}
	
	//회원 Map은 필드로 지정하고, MemberTest 생성자에서 map에 요소 추가할 것.
	public void test1() {
		Set<String> keySet = member.keySet();
		Iterator<String> iter = keySet.iterator();
		//printInfo(iter);
//		printInfo2(keySet);
//		printInfo3();
		printInfo4();
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
	
	//2.2 keySet Iterator
	public boolean isUserExist2(String userId) {
		Set<String> keySet = member.keySet();
		Iterator<String> itr = keySet.iterator();
		while(itr.hasNext()) {
			String key = itr.next();
			if(member.get(key).getUserId() == userId) {
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
		String key = null;
		Set<Entry<String, Member>> entrySet = member.entrySet();
		for(Entry<String, Member> entry : entrySet) {
			if(entry.getValue().getUserId().equals("yooon")) {
				key = entry.getKey();
				break;
			}
		}
//		System.out.println(key); // 키값 확인용
		
		//수정 1
//		member.get(key).setUserPwd("5678");
//		member.get(key).setUserName("윤동주");
//		member.get(key).setAge(27);
//		member.get(key).setPhoneNumber("01034563456");
		
		//수정 2
		member.put(key, new Member("yooon", "5678", "윤동주", 27, "01034563456"));
		
		//둘다 별로다...
	}
	
	//4. sinsa 아이디 회원을 삭제하세요.
	public void test4() {
		String key = null;
		Set<Entry<String, Member>> entrySet = member.entrySet();
		for(Entry<String, Member> entry : entrySet) {
			if(entry.getValue().getUserId().equals("sinsa")) {
				key = entry.getKey();
			}
		}
		member.remove(key);
	}
	
	//4. 2 keySet -- forEach
	public void test5() {
		Set<String> keySet = member.keySet();
		for(String key : keySet) {
			if(key =="leess") {
				member.remove(key);
			}
		}
	}
	
	//정렬
	public void test6() {
		Set<String> keySet = member.keySet();
		List<Member> mList = new ArrayList<>();
		for(String key : keySet) {
			mList.add(member.get(key));
		}
		Comparator<Member> comp = new MemberIdAscending();
		Collections.sort(mList, comp);
		Iterator<Member> iter = mList.iterator();
		
		System.out.println("===============================");
		System.out.println("Key \tValue \tID \tPwd \tName \tage \tphone");
		while(iter.hasNext()) {
			Member m = iter.next();
			System.out.printf("%s \t===== %s%n", m.getUserId(), m);
		}
		
		//다시 멤버에 대입한다고 해도 member는 순서가 없어서 무의미
		//LinkedHashMap
		Map<String, Member> memberLinked = new LinkedHashMap<>();
		for(Member m : mList) {
			memberLinked.put(m.getUserId(), m);
		}
		
		Set<String> set = memberLinked.keySet();
		printInfo2(set);
	}
	
	//보기 좋게 만들었다!
	//1.keySet - iterator
	public void printInfo(Iterator<String> iter) {
		System.out.println("===============================");
		System.out.println("Key \tValue \tID \tPwd \tName \tage \tphone");
		while(iter.hasNext()) {
			String key = iter.next();
			Member value = member.get(key);
			System.out.printf("%s \t===== %s%n", key, value);
		}
		System.out.println("===============================");
	}
	
	//2. keySet -- forEach
	public void printInfo2(Set<?> set) {
		System.out.println("===============================");
		System.out.println("Key \tValue \tID \tPwd \tName \tage \tphone");
		for(Object key : set) {
			Member value = member.get(key);
			System.out.printf("%s \t===== %s%n", key, value);
		}
		System.out.println("===============================");
	}
	
	//3. Map.Entry(key, value 한쌍) Set -- forEach
	public void printInfo3() {
		Set<Entry<String, Member>> set = member.entrySet();
		printInfo2(set);
	}
	
	//4. Map.Entry(key, value 한쌍) Set -- iterator
	public void printInfo4() {
		Set<Entry<String, Member>> set = member.entrySet();
		Iterator<Entry<String, Member>> iter = set.iterator();
		System.out.println("===============================");
		System.out.println("Key \tValue \tID \tPwd \tName \tage \tphone");
		while(iter.hasNext()) {
			Entry<String, Member> entry = iter.next();
			String key = entry.getKey();
			Member value = entry.getValue();
			System.out.printf("%s \t===== %s%n", key, value);	
			//System.out.println(entry);
		}
		System.out.println("===============================");
	}
	
}
	

