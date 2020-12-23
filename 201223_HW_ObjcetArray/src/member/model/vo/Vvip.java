package member.model.vo;

public class Vvip extends Vip{
	public Vvip(String name, String grade, int point) {
		super(name, grade, point);
	}
	
	public double interestP() {
		return this.point*0.15;
	}
}
