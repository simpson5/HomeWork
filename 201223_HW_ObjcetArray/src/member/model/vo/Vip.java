package member.model.vo;

public class Vip extends Gold{
	public Vip(String name, String grade, int point) {
		super(name, grade, point);
	}
	
	public double interestP() {
		return this.point*0.1;
	}
}
