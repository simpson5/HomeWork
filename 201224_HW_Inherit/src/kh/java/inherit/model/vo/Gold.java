package kh.java.inherit.model.vo;

public class Gold extends Member {
	
	public Gold(String name, String grade, int point) {
		super(name, grade, point);
	}

	
	@Override
	public double getEjaPoint() {
		return this.point * 0.05;
	}
}
