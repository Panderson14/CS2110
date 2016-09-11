import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import static org.junit.Assert.*;
import org.junit.Test;

public class Exam1 implements Comparable<Exam1> {

	private String sentence;
	private int id;
	
	public Exam1(int id) {
		this.id = id;
		this.sentence = "A duck swam in the pond";
	}
	
	public Exam1(int id, String sentence) {
		this.id = id;
		this.sentence = sentence;
	}
	
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	
	public String getSentence() {
		return this.sentence;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	@Override
	public String toString() {
		return "Exam1: Good Luck, Patrick!!\nSentence: " + this.sentence + " ID: " + this.id;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Exam1) return this.id == (((Exam1) o).getId());
		return false;
	}
	
	@Override
	public int compareTo(Exam1 o) {
		return this.id - o.getId();
	}
	
	public void funWithArrayLists() {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(7);
		a.add(9);
		a.remove(2);
		Collections.sort(a, new SortNumbers());
		System.out.println(a);
	}
	
	private class SortNumbers implements Comparator<Integer> {
		
		@Override
		public int compare(Integer i, Integer j) {
			return j - i;
		}
	}
	
	public void api() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("Hi");
		System.out.println(a.get(0));
		System.out.println(a.indexOf("Hi"));
		System.out.println(a.size());
		a.set(0, "FUCK YOU");
		System.out.println(a.get(0));
		System.out.println(a.get(0).compareTo("DUCK YOU"));
		System.out.println(a.get(0).equals("FUCK YOU"));
		System.out.println(a.get(0).indexOf("UCK"));
		System.out.println(a.get(0).length());
		System.out.println(a.get(0).substring(1, 4));
	}
	
	public static void fileIO() {
		try {
			URL url = new URL("http://stardock.cs.virginia.edu/louslist/Courses/view/CS");
		
			Scanner webReader = new Scanner(url.openStream());
		
			while (webReader.hasNextLine())
			{
				//String line = webReader.nextLine();
				//String[] cells = line.split(";");
			}
			webReader.close();	
		} catch (MalformedURLException e) {} catch (IOException e) {}
	}
	
	public static void main(String[] args) {
		Exam1 test1 = new Exam1(100);
		Exam1 test2 = new Exam1(50, "A cow ate some grass");
		Exam1 test3 = new Exam1(100, "A cat drank some milk");
		System.out.println(test2);
		System.out.println(test1.equals(test2));
		System.out.println(test1.equals(test3));
		System.out.println(test1.equals("Hi"));
		test1.funWithArrayLists();
		test1.test();
		test1.api();
	}
	
	@Test(timeout=100)
	public void test() {
		Exam1 test1 = new Exam1(100);
		Exam1 test2 = new Exam1(50, "A cow ate some grass");
		assertFalse(test1.equals(test2));
	}
}