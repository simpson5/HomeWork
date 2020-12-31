package com.io.test4.model.vo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Book implements Serializable {
	private String name;
	private String author;
	private int price;
	private LocalDate dates;
	private double discountRate;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Book(String name, String author, int price, LocalDate dates, double discountRate) {
		super();
		this.name = name;
		this.author = author;
		this.price = price;
		this.dates = dates;
		this.discountRate = discountRate;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public LocalDate getDates() {
		return dates;
	}
	public void setDates(LocalDate dates) {
		this.dates = dates;
	}
	public double getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	
	@Override
	public String toString() {
		return "Book [name=" + name + ", author=" + author + ", price=" + price + ", dates=" + dates + ", discountRate="
				+ discountRate + "]";
	}
}
