package com.oop.emp.run;

import java.util.Scanner;

import com.oop.emp.model.Employee;

public class EmpTest {

	public static void main(String[] args) {
		EmpTest test = new EmpTest();
		test.mainMenu();
	}
	
	public void mainMenu() {
		while(true) {
			Employee e = new Employee();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("=====사원 정보 관리 프로그램=====");
			System.out.println("1. 새 사원 정보 입력");
			System.out.println("2. 사원 정보 삭제");
			System.out.println("3. 사원정보 출력");
			System.out.println("4.끝내기");
			System.out.println("==========================");
			
			int num = sc.nextInt();
			switch(num) {
				case 1:
					e.empInput();
					break;
				case 2:
					e = null;
					break;
				case 3:
					if(e.getEmpName() != null) {
						e.empOutput();
					}
					else {
						System.out.println("정보가 없습니다.");
					}
					break;
				case 4:
					return;
			}
		}
	}

}
