import java.util.ArrayList;
import java.util.Collections;

public class Student implements Comparable<Student> {

	private double gpa;
	private String name;
	
	public Student(String name, double gpa) {
		this.name = name;
		this.gpa = gpa;
	}
	
	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int compareTo(Student o) {
		if(gpa>o.getGpa())
			return -1;
		else if(gpa<o.getGpa())
			return 1;
		return this.name.compareTo(o.getName());
	}	
	
	@Override
	public String toString() {
		return this.name + " " + this.gpa;
	}

	public static void main(String[] args) {
		Student p = new Student("Arthaud, Paul", 4.0);
		Student q = new Student("Anderson, Patrick", 3.9);
		Student r = new Student("Anderson, Patrick", 3.8);
		Student s = new Student("Nugget, Chicken", 3.9);
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(s);
		studentList.add(p);
		studentList.add(r);
		studentList.add(q);
		System.out.println(studentList);
		Collections.sort(studentList);
		System.out.println(studentList);
	}

}
