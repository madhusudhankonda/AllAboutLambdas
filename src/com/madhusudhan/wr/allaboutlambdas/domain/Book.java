package com.madhusudhan.wr.allaboutlambdas.domain;

public class Book {

	private String isbn = null;
	private String title = null;
	private String author = null;

	public Book(String isbn) {
		setTitle("All About Lambdas");
		setAuthor("Madhusudhan Konda");
		setIsbn(isbn);
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author
				+ "]";
	}

	
}
