package com.collection.list.music.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.collection.list.music.model.vo.Music;

public class MusicManager {
	Scanner sc = new Scanner(System.in);
	private ArrayList<Music> mList = new ArrayList<Music>() {
		{
		//List 초기화 블럭
		add(new Music("마","5"));
		add(new Music("라","4"));
		add(new Music("가","1"));
		add(new Music("나","2"));
		add(new Music("다","3"));
		}
	};
	
	
	
	//1. 음악리스트 리턴
	public List<Music> selectList(){
		return mList;
	}
	
	//2. 마지막에 음악추가 : 사용자로부터 곡명과 가수를 입력받아 리스트에 저장하는 메소드. 
	public void addList(Music m) {
		mList.add(m);
	}
	
	//3. 맨처음에 음악추가 : 리스트 최상위(0번지)에 음악을 추가하는 메소드
	public void addAtZero(Music m) {
		mList.add(0, m);
	}
	
	//4. 특정곡을 삭제하는 메소드(제목을 전달받아 검색후, 최초로 검색된 음악을 삭제) 삭제여부를 리턴
	//제목만을 전달 받기 때문에 제목만 equals이 트루인지 검사
	public boolean removeMusic(String s) {
		//삭제가 될 경우 리턴
		if(mList.equals(new Music(s , ""))) {
			mList.remove(new Music(s , ""));
			return true;
		}
		//삭제를 못하면 false
		System.out.println("삭제할 곡이 없습니다.");
		return false;
	}
	
	//5. 특정곡을 바꾸는 메소드(이전 음악객체, 새 음악객체를 전달해서 교체) 교체 성공여부를 리턴
	public boolean replaceMusic(Music oldMusic, Music newMusic) {
		//확인용 임시 리스트
		ArrayList<Music> temp = new ArrayList<Music>();
		
		for(Music m : mList ) {
			//음악이 있는지 -- 제목과 가수가 둘다 참이어야 한다.
			if(m.equals2(oldMusic)) {
				//해당 객체의 인덱스 추출
				int i = mList.indexOf(oldMusic);
				//해당 인덱스에 새로운 음악 교체
				mList.set(i, newMusic);
				System.out.println("변경되었습니다.");
				return true;
			}
		}
		System.out.println("바꿀 곡이 없습니다.");
		return false;
	}
	
	//6. 특정곡이 있는지 검사하는 메소드 : 복수개의 결과가 나올수 있음. 
	// (곡명일부로 검색해서 해당곡이 있다면, 곡정보(제목/가수)를 출력하고, 없다면, "검색결과가 없습니다"출력)
	public List<Music> searchMusicByTitle(String title) {
		//출력용 임시 뮤직 리스트
		ArrayList<Music> temp = new ArrayList<Music>();
		
		//원래 리스트에서 검사하여 equals가 트루일시 임시 리스트에 추가.
		for(Music m : mList ) {
			if(m.equals(new Music(title , ""))) {
				temp.add(m);
			}
		}
		//임시 리스트 없는 경우
		if(temp.size()>0) {
			System.out.println("검색결과가 없습니다.");
		}
		return temp;
	}
	
	//7. 가수명으로 검색 메소드 : 복수개의 결과가 나올수 있음.
	public List<Music> searchMusicBySinger(String singer) {
		//출력용 임시 뮤직 리스트
		ArrayList<Music> temp = new ArrayList<Music>();
				
		//원래 리스트에서 검사하여 equals가 트루일시 임시 리스트에 추가.
		for(Music m : mList ) {
			if(m.equals(new Music("" , singer))) {
				temp.add(m);
			}
		}
		//임시 리스트 없는 경우
		if(temp.size()>0) {
			System.out.println("검색결과가 없습니다.");
		}
		return temp;
	}
	
	//8. 서브메뉴 - 각 정렬 메소드 : Comparable/Comparator 인터페이스를 적절히 활용할 것
	public List<Music> orderBy(Comparator<Music> c) {
		Collections.sort(mList, c);
		return mList;
	}

}
