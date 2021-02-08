package simp.test1;

import java.io.Serializable;

public class Book implements Serializable{
	private String title;
	private int price;

	public Book() {
	}

	public Book(String title, int price) {
		this.title = title;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + "]";
	}public void fileSave(String fileName){}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
