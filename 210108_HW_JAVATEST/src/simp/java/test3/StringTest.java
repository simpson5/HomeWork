package simp.java.test3;

import java.util.StringTokenizer;

public class StringTest {

	public static void main(String[] args) {
		String str = "1.22,4.12,5.93,8.71,9.34";
		double data[]= new double[5];
		double sum = 0;

		String[] sArr = str.split(",");
		int cnt = 0;
		for(String s : sArr) {
			data[cnt] = Double.parseDouble(s);
			sum += data[cnt];
			cnt++;
		}
		
		System.out.println(sum);
		System.out.println(sum/cnt);
	}

}
