package simp.java.test3;

public class ArrayTest {
	public static void main(String[] args) {
		int [][] array = {{12, 41, 36, 56, 21},
				{82, 10, 12, 61, 45},
				{14, 16, 18, 78, 65},
				{45, 26, 72, 23, 34}};
		double sum = 0;
		double cnt = 0;
		for(int[] arr1: array) {
			for(int i : arr1) {
				sum += i;
				cnt ++;
			}
		}
		
		System.out.println(sum);
		System.out.println(sum/cnt);
	}
}
