package com.oop.body.controller;

import com.oop.body.model.*;

public class ActionBody {

	public static void main(String[] args) {
		ActionBody ab = new ActionBody();
		
		Body[] arr = new Body[5];
		arr[0] = new Head("빨강");
		arr[1] = new Arm();
		arr[2] = new Arm();
		arr[3] = new Leg();
		arr[4] = new Leg();
		
		for(Body b : arr) {
			ab.action(b);
		}
	}
	
	public void action(Body body) {
		body.act();
	}

}
