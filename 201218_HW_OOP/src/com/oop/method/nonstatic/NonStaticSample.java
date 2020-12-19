package com.oop.method.nonstatic;

public class NonStaticSample {

	public static void main(String[] args) {
		NonStaticSample n = new NonStaticSample();
		//n.printLottoNumbers();
		//n.outputChar('x', 5);
		//System.out.println(n.alphabet());
		//System.out.println(n.mySubstring("simpson", 3, 7));
		
	}

	public void printLottoNumbers() {
		int[] num = new int[6];
		for(int i = 0; i <num.length; i ++) {
			num[i] = (int)(Math.random()*45)+1;
		}
		for(int x : num) {
			System.out.println(x);
		}
		for(int i = 0; i <num.length; i ++) {
			for(int j =i+1;j<num.length;j++) {
				if(num[i]==num[j]) {
					System.out.println("중복값이 있습니다.");
				}
			}
		}
	}
	
	public void outputChar(char ch, int x) {
		for(int i = 0; i < x; i ++) {
			System.out.println(ch);
		}
	}
	public char alphabet() {
		char ch;
		while(true) {
			ch = (char)((int)(Math.random()*57)+65);
			if(ch>'Z' && ch<'a') {
				System.out.println(ch);
				System.out.println("영문자가 아닙니다");
			}
			else {
				break;
			}
		}
		return ch;
	}
	public String mySubstring(String str,int x,int y) {
		if(str == null) {
			return "null";
		}
		return str.substring(x, y);
	}
}
