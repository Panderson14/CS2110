import java.util.ArrayList;

public class BoundedArrayList extends ArrayList<String> {
	private int max;
	
	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	@Override
	public boolean add(String s) {
		if (super.size()>=max) {
			return false;
		}
		super.add(s);
		return true;
	}

	public BoundedArrayList(int max) {
		this.max = max;
	}

	public static void main(String[] args) {

	}
}
