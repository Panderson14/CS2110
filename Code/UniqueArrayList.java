import java.util.ArrayList;

public class UniqueArrayList extends ArrayList<String> {


	@Override
	public boolean add(String s) {
		if (super.contains(s)) {
			return false;
		}
		super.add(s);
		return true;
	}

	public static void main(String[] args) {

	}
}
