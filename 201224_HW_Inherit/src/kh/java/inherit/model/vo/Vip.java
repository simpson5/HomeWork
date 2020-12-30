package kh.java.inherit.model.vo;

public class Vip extends Member {
	public Vip(String name, String grade, int point) {
		super(name, grade, point);
	}

	@Override
	public double getEjaPoint() {
		return this.point * 0.1;
	}
}
