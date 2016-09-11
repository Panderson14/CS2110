/*
 * Patrick Anderson (psa5dg)
 * Paul Arthaud (psa3de)
 * Lab 102
 */

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PersonTest {

	@Test//(timeout=100)
	public void testAddBook1() {
		Person p = new Person("Alex", 14);  // Create a person
		Book b = new Book("some title", "some author");  // Create a Book
		assertTrue(p.addBook(b));  // Does addBook() return true?
		ArrayList<Book> readList = p.getRead();  // Get Person p's ArrayList of Books (read)
		assertTrue(readList.contains(b));  // Is Book b contained in this ArrayList?
	}
//	@Test(timeout=100)
//	public void testAddBook2() {
//		Person p = new Person("Elvils", 333);
//		Book a = new Book("Title 2", "Chicekn");
//		Book b = new Book("Bill","Mt.Booj");
//		assertTrue(p.addBook(a));
//		assertTrue(p.addBook(b));
//		ArrayList<Book> readList = p.getRead();
//		assertTrue(readList.contains(a)); 
//		assertTrue(readList.contains(b)); 
//	}
//	
//	@Test(timeout=100)
//	public void testAddBook3() {
//		Person p = new Person("Elvils", 333);
//		Book a = new Book("Title 2", "Chicekn");
//		Book b = new Book("Title 2", "Chicekn");
//		assertTrue(p.addBook(a));
//		assertFalse(p.addBook(b));
//		ArrayList<Book> readList = p.getRead();
//		assertTrue(readList.contains(a)); 
//		assertTrue(readList.contains(b)); 
//	}
//	
//	@Test(timeout=100)
//	public void testForgetBook1() {
//		Person p = new Person("Elvils", 333);
//		Book a = new Book("Title 2", "Chicekn");
//		Book b = new Book("Bill","Mt.Booj");
//		assertTrue(p.addBook(a));
//		assertTrue(p.addBook(b));
//		ArrayList<Book> readList = p.getRead();
//		assertTrue(p.forgetBook(a));
//		assertFalse(readList.contains(a)); 
//		assertTrue(readList.contains(b)); 
//	}
//	
//	@Test(timeout=100)
//	public void testForgetBook2() {
//		Person p = new Person("Elvils", 333);
//		Book a = new Book("Title 2", "Chicekn");
//		Book b = new Book("Bill","Mt.Booj");
//		assertTrue(p.addBook(b));
//		ArrayList<Book> readList = p.getRead();
//		assertFalse(p.forgetBook(a));
//		assertFalse(readList.contains(a)); 
//		assertTrue(readList.contains(b)); 
//	}

}
