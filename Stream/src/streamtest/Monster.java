package streamtest;

public class Monster {
	private String name;
	private int atk;
	private int reward;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	public int getReward() {
		return reward;
	}
	public void setReward(int reward) {
		this.reward = reward;
	}
	
	public Monster(String str,int atk, int reward) {
	 this.name = str;
	 this.atk = atk;
	 this.reward = reward;
	}
	
	//format
	public String toString() {
		String str = String.format("내 이름은  몬스터%s. [공격력 : %d, 보상 : %d]", this.name, this.atk, this.reward);
		return str;
	}
}