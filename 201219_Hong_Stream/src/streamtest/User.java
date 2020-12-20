package streamtest;

public class User {
	private String name;
	private int money;
	private int atk;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMeony() {
		return money;
	}
	public void setMeony(int meony) {
		this.money = meony;
	}
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	
	public User(String name,int atk, int money) {
		this.name = name;
		this.atk = atk;
		this.money = money;
	}
	
	public void battle(Monster m) {
		if(this.atk > m.getAtk()) {
			this.money += m.getReward();
		}
		else {
			System.out.println("죽었습니다.");
		}
	}
}
