package test.contoroller;

public class Test10 {

	public static void main(String[] args) {
		int [][] array = {{12, 41, 36, 56}, {82, 10, 12, 61}, {14, 16, 18, 78}, {45, 26, 72, 23}};
		int[] copyAr = new int[array.length*array[0].length];
		int cnt = 0;
		
			for(int i = 0; i < array.length; i++) {
				for(int j = 0; j<array[i].length; j++) {
					int arr = 0;
					if(array[i][j]%3==0) {
						arr = array[i][j];
					}
					
//					System.out.println(cnt + " : "+ arr);
					
					for(int k = 0; k< array.length*array[0].length; k++) {
						if(arr == copyAr[k] || arr ==0) {
							break;
						}
						copyAr[cnt] = arr;
//						System.out.println(cnt);
						cnt++;
						break;
					}
				}
			}
			
			for(int k = 0;k<array.length*array[0].length;k++) {
				if(copyAr[k] != 0) {
					System.out.print("["+copyAr[k]+"] ");
				}
			}
	}

}
