package com.oauth.entity;

public class BookPriceInfo {
	private Integer bookId;
	private String bookName;
	private double price;
	
	public BookPriceInfo() {}
	
	public BookPriceInfo(Integer bookId, String bookName, double price) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.price = price;
	}
	
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return bookId + ", " + bookName + ", " + price;
	}
	
	
}
