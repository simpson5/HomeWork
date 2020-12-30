package com.exception.charcheck;

import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CharCheckProcess cp = new CharCheckProcess();
		try {
			System.out.println("문자열 입력");
			String s = sc.nextLine();
			System.out.println(cp.countAlpha(s));
		} catch(CharCheckException e) {
			e.printStackTrace();
			System.out.println("체크할 문자열 안에 공백 포함할 수 없습니다.");
		}
	}
}
