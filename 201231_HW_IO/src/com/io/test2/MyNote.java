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
				//sc.nextLine();
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
			String str = null;
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(f))){
				while((str = sb.substring(0, 1)) != null) {
					bw.write(str);
					sb.deleteCharAt(0);
				}
			} catch (IOException e) {
				e.printStackTrace();
				//이놈 어떻게 사라지게 하냐...
			} catch (StringIndexOutOfBoundsException e) {
			}
			System.out.println("성공적으로 저장!");
		}
	}
	
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
			e1.printStackTrace();
		}
		String data = "";
		while(true){
			System.out.println("파일에 수정할 내용을 입력하시오");
			data = sc.nextLine();
			if(data.equals("exit")) {
				break;
			}
			try {
				sb.append(data);
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
				//이놈 어떻게 사라지게 하냐...
			} catch (StringIndexOutOfBoundsException e) {
			}
			System.out.println("성공적으로 수정!");
		}

	}
	
	
	
}
