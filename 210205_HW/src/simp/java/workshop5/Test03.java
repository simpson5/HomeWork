package simp.java.workshop5;

public class Test03 {
	public static void main(String[] args) {
		int[][] arr = {
				 		{20, 30, 10},
			 			{50, 40, 60},
			 			{80, 80, 90}
				 		};
		for(int i = 2; i >= 0; i--) {
			for(int j = 2; j >= 0; j--) {
				System.out.print(arr[i][j] + " ");
			}
		}
		
	}
}
