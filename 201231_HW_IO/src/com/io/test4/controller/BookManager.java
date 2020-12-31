package com.io.test4.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Scanner;

import com.io.test4.model.vo.Book;

public class BookManager {
	Scanner sc = new Scanner(System.in);

	public BookManager() {
	}

	public void fileSave() {
		Book[] b = new Book[5];
		b[0] = new Book("simpson", "simp", 1000, LocalDate.of(2020, 4, 6), 0.1);
		b[1] = new Book("simpson", "simp", 1000, LocalDate.of(2020, 4, 6), 0.1);
		b[2] = new Book("simpson", "simp", 1000, LocalDate.of(2020, 4, 6), 0.1);
		b[3] = new Book("simpson", "simp", 1000, LocalDate.of(2020, 4, 6), 0.1);
		b[4] = new Book("simpson", "simp", 1000, LocalDate.of(2020, 4, 6), 0.1);
		
		File f = new File("object/book.dat");
		
		try( ObjectOutputStream oos = 
				new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)))){
			oos.writeObject(b[0]);
			oos.writeObject(b[1]);
			oos.writeObject(b[2]);
			oos.writeObject(b[3]);
			oos.writeObject(b[4]);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("book.dat에 저장 완료!");
	}
	
	public void fileLoad() {
		Book[] b = new Book[10];
		int i = 0;
		
		File f = new File("object/book.dat");

		try(
			ObjectInputStream ois =
				new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)))){
			while(true) {
				b[i] = (Book)ois.readObject();
				System.out.println(b[i].toString());
				i++;
			}
			// EOF - End Of File Exception
		} catch(EOFException e) {
			System.out.println("books.dat 읽기 완료!");
		} catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
}
