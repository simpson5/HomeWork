package com.io.test2;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MyNote {
	Scanner sc = new Scanner(System.in);

	public MyNote() {
		
	}
	
	//파일 저장
	public void fileSave() {
		StringBuilder sb = new StringBuilder();
		String data = "";
		while(true){
			System.out.println("파일에 저장할 내용을 입력하시오");
			data = sc.nextLine();
			if(data.equals("exit")) {
				break;
			}
			try {
				sb.append(data + "\n");
			} catch(NullPointerException e) {
				e.printStackTrace();
			}
		
		}
		
		System.out.println("저장하시겠습니까? (y/n)");
		char y = sc.next().charAt(0);
		if(y == 'y' || y == 'Y') {
			System.out.print("저장할 파일명 : ");
			String name = sc.next();
			File f = new File("data/"+name+".txt");
			//StringBuilder를 그대로 쓸수 없으니 스트링으로 변환시키고 대입
			String str = sb.toString();
			//버퍼 스트림은 한번에 문자열을 쓰고 읽을 수 있다. 굳이 바이트 같이 int 단위로 끊을 필요가 없음.
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(f))){
					bw.write(str);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("성공적으로 저장!");
		}
	}
	
	//파일 열기
	public void fileOpen() {
		System.out.print("열기할 파일명 : ");
		String name = sc.next();
		File f = new File("data/"+name+".txt");
		try(BufferedReader br = new BufferedReader(new FileReader(f))) {
			String data = null;
			while((data = br.readLine()) != null) {
				System.out.println(data);
			}
		} catch(FileNotFoundException e){
			System.out.println("파일이 없어요!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//두번쨰 방법
	public void fileAppend() {
		System.out.print("수정할 파일명 : ");
		String name = sc.nextLine();
		File f = new File("data/"+name+".txt");
		
		StringBuilder sb = new StringBuilder();
		//파일 여부 체크
		try(BufferedReader br = new BufferedReader(new FileReader(f))){
			String data = null;
			while((data = br.readLine()) != null) {
				System.out.println(data);
			}
		} catch(FileNotFoundException e){
			System.out.println("파일이 없어요!");
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}
		//수정 내용 입력
		String data2 = "";
		while(true){
			System.out.println("파일에 수정할 내용을 입력하시오");
			data2 = sc.nextLine();
			if(data2.equals("exit")) {
				break;
			}
			try {
				sb.append(data2 + "\n");
			} catch(NullPointerException e) {
				e.printStackTrace();
			}
		
		}
		
		//수정 확인
		System.out.println("수정하시겠습니까? (y/n)");
		char y = sc.next().charAt(0);
		if(y == 'y' || y == 'Y') {
			//출력 스트림에 두번쨰 매개변수에 true를 사용하면 이어서 출력 가능
			String str = sb.toString();
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(f , true)))
			{	
					bw.write(str);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("성공적으로 수정!");
		}
	}

	
	/**
	 * 파일을 불러와서 그 내용을 StringBuilder에 저장후
	 * 저장 내용을 파일 초기화후 다시 출력
	public void fileAppend() {
		System.out.print("수정할 파일명 : ");
		String name = sc.next();
		File f = new File("data/"+name+".txt");
		sc.nextLine();
		String str = null;
		StringBuilder sb = new StringBuilder();
		try(BufferedReader br = new BufferedReader(new FileReader(f))){
			while((str = br.readLine()) != null) {
				sb.append(str + "\n");
			}
		} catch(FileNotFoundException e){
			System.out.println("파일이 없어요!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		String data = "";
		while(true){
			System.out.println("파일에 수정할 내용을 입력하시오");
			data = sc.nextLine();
			if(data.equals("exit")) {
				break;
			}
			try {
				sb.append(data + "\n");
				//sc.nextLine();
			} catch(NullPointerException e) {
				e.printStackTrace();
			}
		
		}
		
		System.out.println("수정하시겠습니까? (y/n)");
		char y = sc.next().charAt(0);
		
		if(y == 'y' || y == 'Y') {

			try(BufferedWriter bw = new BufferedWriter(new FileWriter(f)))
			{
				
				while((str = sb.substring(0, 1)) != null) {
					bw.write(str);
					sb.deleteCharAt(0);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (StringIndexOutOfBoundsException e) {
			}
			System.out.println("성공적으로 수정!");
		}

	}
	*/
}
