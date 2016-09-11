import java.util.TreeMap;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//In this activity you will practice writing code that involves a TreeMap
//
//Create a TreeMap called phoneBook to store a simple phonebook. The Key will be a last name (a String) such as "Jones" and the Value will be 7 digits (an Integer) such as 5551234
//Write code that reads (iterates through) each phonebook entry in the Tree Map and creates another Tree Map (let's call it numberLookup) with the same information, only this time the Key and the Values are swapped. In otherwords, if a <Key, Value> pair in phoneBook was "Jones, 5551234" a new entry in numberLookup will be "5551234, Jones". The total number of entries in phoneBook should be the same as the number of entries in numberLookup

public class TreeMapTest {

	public static void main(String[] args) {
		
		TreeMap<String, Integer> phoneBook = new TreeMap<String, Integer>();
		phoneBook.put("Jones", 5551234);
		phoneBook.put("Chicken", 1111111);
		phoneBook.put("A", 1111112);
		phoneBook.put("B", 1111113);
		phoneBook.put("A", 1111114);
		
		Set<String> set = phoneBook.keySet();
		Iterator<String> iter = set.iterator();
		
		Set<String> hi = new HashSet();
		
		
		TreeMap<Integer, String> bookPhone = new TreeMap<Integer, String>();
		
		while (iter.hasNext()) {
			String name = iter.next();
			bookPhone.put(phoneBook.get(name), name);
		}
		
		System.out.println(phoneBook);
		System.out.println(bookPhone);

	}

}