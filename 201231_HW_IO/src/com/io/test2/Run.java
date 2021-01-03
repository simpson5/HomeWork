package com.io.test2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Run r = new Run();
		r.mune();
	}

	public void mune() {
		MyNote mn = new MyNote();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("=====MENU=====");
			System.out.println("1.노트 새로 만들기");
			System.out.println("2.노트 열기");
			System.out.println("3.노트 열어서 수정");
			System.out.println("4.끝내기");
			System.out.print("번호 : ");
			int num = sc.nextInt();
			
			switch(num) {
				case 1:
					mn.fileSave();
					break;
				case 2:
					mn.fileOpen();
					break;
				case 3:
					mn.fileAppend();
					break;
				case 4:
					return;
			}
		}
	}
}
