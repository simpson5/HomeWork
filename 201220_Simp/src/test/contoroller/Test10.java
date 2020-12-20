package test.contoroller;

public class Test10 {

	public static void main(String[] args) {
		int [][] array = {{12, 41, 36, 56}, {82, 10, 12, 61}, {14, 16, 18, 78}, {45, 26, 72, 23}};
		int[] copyAr = new int[array.length*array[0].length];
		//copyAr index 변수
		int cnt = 0;
		
			for(int i = 0; i < array.length; i++) {
				//3의 배수만 찾기
				for(int j = 0; j<array[i].length; j++) {
					int arr = 0;
					if(array[i][j]%3==0) {
						arr = array[i][j];
					}
					
					//중복 값 제거하고 대입
					for(int k = 0; k< array.length*array[0].length; k++) {
						//같으면 탈출!
						if(arr == copyAr[k] || arr ==0) break;
						//같지 않으면 대입
						copyAr[cnt] = arr;
						//copyAr index 변수 증가
						cnt++;
						break;
					}
				}
			}
			
			//0(null) 제외하고 출력
			for(int k = 0;k<array.length*array[0].length;k++) {
				if(copyAr[k] != 0) {
					System.out.print("["+copyAr[k]+"] ");
				}
			}
	}

}
