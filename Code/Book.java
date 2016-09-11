/*
 * Patrick Anderson (psa5dg)
 * Homework 0
 * Lab 102
*/

public class Book {

	private final String title;
	private final String author;

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	public String getTitle() {
		return this.title;
	}

	public String getAuthor() {
		return this.author;
	}

	@Override
	public boolean equals(Object o) {
		return ((((Book) o).getTitle() == this.title) && (((Book) o).getAuthor() == this.author));
	}

	@Override
	public String toString() {
		return this.title + " by " + this.author;
	}
}
