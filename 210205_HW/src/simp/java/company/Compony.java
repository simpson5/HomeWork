package simp.java.company;

public class Compony {
	private double salary;
	private double income;
	private double afterTaxIncom;
	private double bonus;
	private double afterTaxBonus;
	
	public Compony() {

	}
	
	public Compony(double salary) {
		this.salary = salary;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public double getIncome() {
		this.income = this.salary * 12;
		return income;
	}
	
	public double getAfterTaxIncom() {
		this.afterTaxIncom = this.income * 0.9;
		return afterTaxIncom;
	}
	
	public double getBonus() {
		this.bonus = this.salary * 0.2 * 4;
		return bonus;
	}
	public double getAfterTaxBonus() {
		this.afterTaxBonus = bonus * 0.95;
		return afterTaxBonus;
	}
}
