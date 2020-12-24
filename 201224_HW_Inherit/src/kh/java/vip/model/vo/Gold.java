package member.model.vo;

public class Gold {
	protected String name;
	protected String grade;
	protected int point;
	
	
	
	public Gold(String name, String grade, int point) {
		this.name = name;
		this.grade = grade;
		this.point = point;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	public double interestP() {
		return this.point*0.05;
	}
}