package com.kh.function.run;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Main m = new Main();
		//m.opSample1();
		m.opSample2();
	}
	
	public void opSample1(){
		Scanner sc = new Scanner(System.in);
		System.out.println("국어점수 입력");
		int korea = sc.nextInt();
		System.out.println("수학점수 입력");
		int math = sc.nextInt();
		System.out.println("영어점수 입력");
		int english = sc.nextInt();
		double avg = (korea + math + english) / 3.0;
		String s = (korea >= 40 && math >= 40 && english >= 40) && (avg >= 60) ?
				"합격이오!" : "불합격...";
		System.out.printf("국어: %d%n수학: %d%n영어: %d%n평균: %.2f%n%s", korea,math ,english ,avg ,s);
	}
	
	public void opSample2(){
		Scanner sc = new Scanner(System.in);
		System.out.println("이름 입력");
		String name = sc.next();
		System.out.println("학년 입력");
		int schoolYear = sc.nextInt();
		System.out.println("반 입력");
		int classNum = sc.nextInt();
		System.out.println("번호 입력");
		int num = sc.nextInt();
		sc.nextLine();
		System.out.println("성별 입력(M/F)");
		//scanner로 == 비교가 불가능하다 why? 객체(이 경우 문자열)의 '주소'를 비교하기 때문이다.
		//이럴때 string에 있는 .equals 메서드를 이용해 문자열 '값'을 비교 가능하다!!!
		String gender = (sc.next().equals("M")) ? "남성" : "여성";
		System.out.println("성적 입력");
		double grade = sc.nextDouble();
		
		System.out.printf("이름: %s%n학년: %d%n반: %d%n번호: %d%n성별: %s%n성적: %.2f%n", name, schoolYear, classNum, num, gender, grade);
		
		
	}
}
