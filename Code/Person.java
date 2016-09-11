/*
 * Patrick Anderson (psa5dg)
 * Homework 0
 * Lab 102
*/

import java.util.ArrayList;

public class Person {
	
	private String name;
	private final int id;
	private ArrayList<Book> read;

	public Person(String name, int id) {
		this.name = name;
		this.id = id;
		this.read = new ArrayList<Book>();
	}

	public String getName() {
		return this.name;
	}

	public int getId() {
		return this.id;
	}

	public ArrayList<Book> getRead() {
		return this.read;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * adds a book to the current list
	 * @param b
	 * @return
	 */
	public boolean addBook(Book b) {
		if (!this.read.contains(b)) {
			this.read.add(b);
			return true;
		}
		return false;
	}

	/**
	 * checks to see of Book b exists in the list
	 * @param b
	 * @return
	 */
	public boolean hasRead(Book b) {
		return (this.read.contains(b));
	}

	/**
	 * removes Book b from the current list, if it is in there
	 * @param b
	 * @return
	 */
	public boolean forgetBook(Book b) {
		if (this.read.contains(b)) {
			this.read.remove(b);
			return true;
		}
		return false;
	}

	/**
	 * returns the size of the list
	 * @return
	 */
	public int numBooksRead() {
		return this.read.size();
	}

	@Override
	public boolean equals(Object o) {
		return (this.id == ((Person) o).getId());
	}

	@Override
	public String toString() {
		return "Name: " + this.name + "\nID: " + this.id + "\nBooks Read: " + this.read.toString();
	}

	/**
	 * checks common books between two lists
	 * @param a
	 * @param b
	 * @return
	 */
	public static ArrayList<Book> commonBooks(Person a, Person b) {
		ArrayList<Book> commons = new ArrayList<Book>();
		for (Book i : a.getRead()) {
			for (Book j : b.getRead()) {
				if (j.equals(i))
					commons.add(j);
			}
		}
		return commons;
	}

	/**
	 * returns the number of common books between two lists.
	 * @param a
	 * @param b
	 * @return
	 */
	public static double similarity(Person a, Person b) {
		double denom;
		if (a.numBooksRead() < b.numBooksRead())
			denom = a.numBooksRead();
		else
			denom = b.numBooksRead();
		return commonBooks(a, b).size() / denom;
	}
}
