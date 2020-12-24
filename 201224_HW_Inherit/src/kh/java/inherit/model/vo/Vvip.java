package kh.java.inherit.model.vo;

public class Vvip extends Silver{
	public Vvip(String name, String grade, int point) {
		super(name, grade, point);
	}
	
	@Override
	public double getEjaPoint() {
		return super.getPoint() * 0.15;
	}
}
