import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Lab11_DistinctWords {

	public static void main(String[] args) {
		String str[] = { "I", "Came", "I", "Saw", "I", "Conquered" }; 
		System.out.println("Size of str (number of words): " + str.length);

		// Run #1, Use this line
		Set<String> s = new HashSet<String>();  // Create a HashSet "s"
		
		// Run #2, Uncomment the following line and comment the above line 
		//Set<String> s = new TreeSet<String>();  // Create a TreeSet "s"

		// For every string in "str" try to add it to the set "s"
		System.out.println("Adding words in \"str\" to \"s\"...");
		for (int i = 0; i < str.length; i++) {
			s.add(str[i]);
		}

		System.out.println("Size of the HashSet set: " + s.size() + "\n");
		System.out.println(s.size() + " distinct words: " + s);
		
	}
}
