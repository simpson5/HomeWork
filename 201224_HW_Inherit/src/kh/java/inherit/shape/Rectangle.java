package kh.java.inherit.shape;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Rectangle extends Shape {
	private Point[] p = new Point[4];
	private int width;
	private int height;
	
	public Rectangle() {
	}
	
	public Rectangle(Point[] p, int width, int height) {
		super();
		this.p = p;
		this.width = width;
		this.height = height;
	}

	public Point[] getP() {
		return p;
	}

	public void setP(Point[] p) {
		this.p = p;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public void draw() {
		//네 꼭지점이 (0, 0), (200, 0), (200, 100), (0, 100)이고, 너비가 200, 높이가 100인 사각형을 그린다.
		String str ="네 꼭지점이 ";
		for(Point x : this.p) {
			str += x;
		}
		str += "이고, 너비가" + width + ", 높이가" + height + "인 사각형을 그린다.";
		System.out.println(str);
	}

	@Override
	public double getArea() {
		return this.height * this.width * 1.00;
	}
	
	@Override
	public String toString() {
		return "point: "+Arrays.toString(this.p) + ", width: " + this.width +", height: " + height;
	}
	
	
}
