package test;

public class Sample {
	public static void main(String[] args) {
		Sample s =new Sample();
		s.test2();

	}
//	1. 3행짜리5열 2차원배열 선언 및 생성
//	2. 1~100사이의 임의의 정수를 모든 방에 기록함
//	3. 각 행별 열의 합계가 5의 배수인 행열값만 출력함
//  이놈은 5만 찾아서 출력했네요....
	public void test() {
		int cnt =0;
		int[][] arr = new int[3][5];
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = (int)(Math.random()*100)+1;
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
					System.out.print("["+arr[i][j]+"]");
			}
			System.out.println();
		}
		
		System.out.println("==============================");
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(arr[i][j]%5==0){
					System.out.print("["+arr[i][j]+"]");
					cnt ++;
				}
				else {
					System.out.print("[  ]");
				}
			}
			System.out.println();
		}
		
		System.out.println("5의 배수의 갯수:"+cnt);
	}

//	이놈이 의도한대로
	public void test2() {
		int[][] arr = new int[3][5];
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = (int)(Math.random()*100)+1;
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
					System.out.print("["+arr[i][j]+"]");
			}
			System.out.println();
		}
		System.out.println("==============================");
		
		for(int i = 0; i < arr.length; i++) {
			int sum = 0;
			for(int j = 0; j < arr[i].length; j++) {
				sum += arr[i][j];
			}
			if(sum%5==0) {
				for(int j = 0; j < arr[i].length; j++) {
					System.out.print("["+arr[i][j]+"]");
				}
				System.out.print(":"+sum);
			}
			else {
				for(int j = 0; j < arr[i].length; j++) {
					System.out.print("[  ]");
				}
				System.out.print(":"+sum);
			}
			System.out.println();
		}
	}
}
