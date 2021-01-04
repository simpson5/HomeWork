package com.collection.list.music.view;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.collection.list.music.controller.MusicManager;
import com.collection.list.music.controller.MusicSingerAscending;
import com.collection.list.music.model.vo.Music;

public class MusicMenu {
	private Scanner sc = new Scanner(System.in);
	MusicManager manager = new MusicManager();
	
	public void menu() {
		while(true) {
			System.out.println("================ Music Playlist Menu ================\r\n" + 
					"    1.목록보기\r\n" + 
					"    2.마지막에 음악추가\r\n" + 
					"    3.맨처음에 음악추가\r\n" + 
					"    4.곡삭제\r\n" + 
					"    5.곡변경\r\n" + 
					"    6.곡명검색\r\n" + 
					"    7.가수검색\r\n" + 
					"    8.목록정렬(곡명오름차순)\r\n" + 
					"    0.종료\r\n" + 
					"====================================================");
			
			System.out.print(">> 메뉴선택 : ");
			
			int num = sc.nextInt();
			sc.nextLine();
			switch (num) {
				//1. 음악리스트 리턴
				case 1:
					//System.out.println(manager.selectList());
					//가시성 높이기 위해서 작성
					for(Music arr : manager.selectList()) {
						System.out.print(arr);
					}
					break;
				//2. 마지막에 음악추가 
				case 2:
					manager.addList(inputMusic());
					break;
				//3. 맨처음에 음악추가
				case 3:
					manager.addAtZero(inputMusic());
					break;
				//4. 특정곡을 삭제
				case 4:
					manager.removeMusic(inputTitle());
					break;
				//5. 특정곡을 바꾸기
				case 5:
					System.out.println("어떤 곡을 제거하시겠습니까?");
					Music m1 = inputMusic();
					System.out.println("어떤 곡을 추가하시겠습니까?");
					Music m2 = inputMusic();
					manager.replaceMusic(m1, m2);
					break;
				//6. 특정곡이 있는지 검사
				case 6:
					System.out.println(manager.searchMusicByTitle(inputTitle()));
					break;
				//7. 가수명으로 검색
				case 7:
					System.out.println(manager.searchMusicBySinger(inputSinger()));
					break;
				//8. 서브메뉴
				case 8:
					sortMenu();
					break;
				//0. 종료
				case 0:
					System.out.println("종료합니다");
					return;
			}
		}
	}
	
	//a. 리스트 출력메소드
	public void printList(List<Music> l) {
		
	}
	
	//b. 곡명 입력메소드
	public String inputTitle() {
		System.out.print("곡명을 입력하세요 : ");
		return sc.nextLine();
	}
	
	//c. 가수 입력메소드
	public String inputSinger() {
		System.out.print("가수를 입력하세요 : ");
		return sc.nextLine();
	}
	
	//d. 음악 입력메소드(곡명, 가수 모두 입력)
	public Music inputMusic() {
		System.out.print("곡명을 입력하세요 : ");
		String title = sc.nextLine();
		System.out.print("가수를 입력하세요 : ");
		String singer = sc.nextLine();
		return new Music(title, singer);
	}
	
	private void sortMenu() {
		System.out.println(" ================== 정렬 메뉴 ===================\r\n" + 
				"	1. 가수명 오름차순\r\n" + 
				"	2. 가수명 내림차순\r\n" + 
				"	3. 곡명 오름차순\r\n" + 
				"	4. 곡명 내림차순\r\n" + 
				"	5. 메인메뉴 돌아가기\r\n" + 
				"================================================\r\n" + 
				"");
		
		System.out.print(">> 메뉴선택 : ");
		
		int num = sc.nextInt();
		sc.nextLine();
		
		switch (num) {
			//1. 가수명 오름차순
			case 1:
				Comparator<Music> comp = new MusicSingerAscending();
				manager.orderBy(comp);
				break;
			//2. 가수명 내림차순
			case 2:
				//내림 차순으로 변환
				Comparator<Music> comp2 = new MusicSingerAscending().reversed();
				manager.orderBy(comp2);
				break;
			//3. 곡명 오름차순
			case 3:
				Comparator<Music> comp3 = new MusicSingerAscending();
				manager.orderBy(comp3);
				break;
			//4. 곡명 내림차순
			case 4:
				//내림 차순으로 변화
				Comparator<Music> comp4 = new MusicSingerAscending().reversed();
				manager.orderBy(comp4);
				break;
			case 5:
				System.out.println("메인 메뉴로 돌아갑니다.");
				return;
		}
	}
}
