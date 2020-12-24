package kh.java.inherit.model.vo;

public class Gold extends Silver {
	
	public Gold(String name, String grade, int point) {
		super(name, grade, point);
	}

	
	@Override
	public double getEjaPoint() {
		return super.getPoint() * 0.05;
	}
}
