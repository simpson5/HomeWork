package com.oop.contorller;

import java.util.Scanner;

import com.oop.coffee.model.dto.Coffee;

public class CoffeeManager {
	private Coffee[] arr = new Coffee[3];
	private Scanner sc = new Scanner(System.in);
	
	/**
	 * Coffee 정보 입력 메소드
	 */
	public void inputCoffee() {
		for(int i = 0; i < arr.length; i++) {
			System.out.print((i+1)+": 원산지 - ");
			String origine = sc.next();
			System.out.print((i+1)+": 지역 - ");
			String location = sc.next();
			
			arr[i] = new Coffee(origine, location);
		}
	}
	
	/**
	 * Coffee 정보 출력 메소드
	 */
	public void printCoffee() {
		for(Coffee x : arr) {
			x.printCoffee();
		}
	}
}
