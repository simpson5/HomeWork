package kh.java.test.array;

public class Test2 {

	public static void main(String[] args) {
		Test2 t = new Test2();
		t.test();
	}
	
	//5인 String 배열을 선언하고, 
	//“딸기”, ”복숭아”, ”키위”, ”사과” , ”바나나” 로 초기화를 한 후, 
	//배열 인덱스를 활용해서 바나나를 출력해 보세요
	public void test() {
		String[] arr = new String[5];
		arr[0] = "딸기";
		arr[1] = "복숭아";
		arr[2] = "키위";
		arr[3] = "사과";
		arr[4] = "바나나";
		
		for(int i = 0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}
}
