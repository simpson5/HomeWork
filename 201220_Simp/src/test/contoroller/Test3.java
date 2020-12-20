package test.contoroller;

public class Test3 {

	public static void main(String[] args) {
		int i=1;
		double sum = 0;
		double avg ;
		while(i < 101) {
			sum += i;
			i++;
		}
		
		avg = sum/100;
		
		System.out.println(sum);
		System.out.println(avg);
	}

}
