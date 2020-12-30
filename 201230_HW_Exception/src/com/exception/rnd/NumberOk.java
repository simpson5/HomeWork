package com.exception.rnd;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberOk {
	Scanner sc = new Scanner(System.in);
	int randomNum;
	int max;
	int min;

	public static void main(String[] args) {
		NumberOk no = new NumberOk();
		while(true) {
			if(no.startgame() == 'n') {
				break;
			}
		}

	}
	
	public char startgame() {
		randomNum = (int)(Math.random()*100) + 1;
		max = 100;
		min = 0;
		int cnt = 0;
		while(true) {
			System.out.println(randomNum);
			int ans= 0;
			try {
				ans = getNumber();
				cnt ++;
			} catch (NumberRangeException e) {
				System.out.println(max + "보다 작고 " + min + " 보다 크게 입력하세요!");
			}
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
				else if(num<max && num>randomNum) {
					max = num;
				}
				else if(num>min && num<randomNum) {
					min = num;
				}
				return num;
			} catch(InputMismatchException e) {
				System.out.println("잘못 입력하셨습니다.");
				sc.next();
			}
		}
	}
	
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
