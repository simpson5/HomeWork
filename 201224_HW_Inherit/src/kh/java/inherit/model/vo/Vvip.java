package kh.java.inherit.model.vo;

public class Vvip extends Member {
	public Vvip(String name, String grade, int point) {
		super(name, grade, point);
	}
	
	@Override
	public double getEjaPoint() {
		return this.point * 0.15;
	}
}
