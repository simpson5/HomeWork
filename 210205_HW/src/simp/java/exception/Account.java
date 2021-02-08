package simp.java.exception;

public class Account {
	private String account;
	private double balance;
	private double interestRate;
	
	public Account() {
	}
	
	public Account(String account, double balance, double interestRate) {
		this.account = account;
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	public double calclateInterest() {
		return this.interestRate * this.balance;
	}
	
	public void deposit(double money) throws Exception {
		if(money < 0) {
			throw new Exception();
		}
		this.balance += money;
	}
	
	public void withdraw(double money) throws Exception {
		if(money < 0 || money > this.balance) {
			throw new Exception();
		}
		this.balance -= money;
	}
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public String toString() {
		return "Account [account=" + account + ", balance=" + balance + ", interestRate=" + interestRate + "]";
	}
	
	
}
