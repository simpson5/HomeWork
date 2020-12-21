package com.oop.coffee.model.dto;

import com.oop.contorller.CoffeeManager;

public class Run {
	public static void main(String[] args) {
		CoffeeManager cm = new CoffeeManager();
		
		cm.inputCoffee();
		cm.printCoffee();
	}
}
