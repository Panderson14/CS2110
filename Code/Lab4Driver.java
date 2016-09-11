//import java.util.ArrayList;

/*
 * in order to fully optimize our UniqueArrayList class, we must also modify:
 * add(int index, E element)
 * addAll(Collection<? extends E> c)
 * addAll(int index, Collection<? extends E> c)
 */

public class Lab4Driver {

	public static void main(String[] args) {
		
		//ArrayList<String> list1 = new ArrayList<String>();
		//UniqueArrayList list1 = new UniqueArrayList();
		BoundedArrayList list1 = new BoundedArrayList(3);
		
		BoundedArrayList listAlias = list1;  // change this to test each kind of list
		
		String[] hamlet = { "to", "be", "or", "not", "to", "be" };
		for (int i=0; i < hamlet.length; ++i) {
			listAlias.add( hamlet[i] );
		}
		System.out.println(listAlias);

	}

}