package kh.java.inherit.model.vo;

public class Silver extends Member {

	public Silver(String name, String grade, int point) {
		super(name, grade, point);
	}

	public double getEjaPoint() {
		return this.point*0.02;
	}
}
