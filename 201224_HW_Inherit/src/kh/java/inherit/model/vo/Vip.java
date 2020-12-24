package kh.java.inherit.model.vo;

public class Vip extends Silver{
	public Vip(String name, String grade, int point) {
		super(name, grade, point);
	}

	@Override
	public double getEjaPoint() {
		return super.getPoint() * 0.1;
	}
}
