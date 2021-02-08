package simp.java.exception;

public class AccountTest {

	public static void main(String[] args) {
		Account ac = new Account("심슨", 50000.0, 0.05);
		
		System.out.println(ac.toString());
		
		try {
			ac.withdraw(500000.0);
		} catch (Exception e) {
			System.out.println("출글 금액이 0보다 적거나 현재 금액보다 많아");
		}
		
		try {
			ac.deposit(-10.0);
		} catch (Exception e) {
			System.out.println("입금 금액이 0보다 적어");
		}
		
		System.out.println(ac.calclateInterest());
	}

}
