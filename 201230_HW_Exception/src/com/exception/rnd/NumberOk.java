package com.exception.rnd;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberOk {
	Scanner sc = new Scanner(System.in);
	int randomNum; //정답
	int max; // 범위 최대값
	int min; //범위 최소값

	public static void main(String[] args) {
		NumberOk no = new NumberOk();
		while(true) {
			//답이 'n'일 경우 while문 탈출
			if(no.startgame() == 'n') {
				break;
			}
		}

	}
	
	//시작 메서드
	public char startgame() {
		//정답 난수
		randomNum = (int)(Math.random()*100) + 1;
		max = 100;
		min = 0;
		//정답 몇번째인지
		int cnt = 0;
		while(true) {
			//정답 확인용
			//System.out.println(randomNum);
			int ans= 0; // 대답
			try {
				ans = getNumber();
				//대답후 횟수 증가 예외 처리 날 경우 변동 없음
				cnt ++;
				//입력 범위 벋어날 경우 예외 처리
			} catch (NumberRangeException e) {
				System.out.println(max + "보다 작고 " + min + " 보다 크게 입력하세요!");
			}
			//정답과 대답 확인
			int check = checkNumber(ans);
			if(check == 0) {
				System.out.println(cnt + "번째에 정답 "+randomNum+ "맞춤.");
				System.out.println("==========================");
				System.out.println("계속 하시겠습니까?(y/n)");
				return sc.next().charAt(0);
			}
			else if(check == 1){
				System.out.println(cnt + ": 정답보다 크다.");
			}
			else if(check == -1) {
				System.out.println(cnt + ": 정답보다 작다.");
			}
		}
	}
	
	public int getNumber() throws NumberRangeException {
		while(true) {
			try {
				System.out.print("수를 입력하시오 : ");
				int num = sc.nextInt();
				//최대 최소 숫자에서 벋어난 경우 && 최대 최소 값 조정하기
				if(num>=max || num<=min) {
					throw new NumberRangeException();
				}
				//최대값 변화
				else if(num<max && num>randomNum) {
					max = num;
				}
				//최소값 변화
				else if(num>min && num<randomNum) {
					min = num;
				}
				return num;
			//정수가 아닐 경우 예외 처리
			} catch(InputMismatchException e) {
				System.out.println("잘못 입력하셨습니다.");
				sc.next();
			}
		}
	}
	
	//정답인지 판단하는 메서드
	public int checkNumber(int x) {
		if(x>randomNum) {
			return 1;
		}
		else if(x < randomNum) {
			return -1;
		}
		else {
			return 0;
		}
	}
}
