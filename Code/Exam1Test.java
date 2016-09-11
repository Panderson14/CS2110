import static org.junit.Assert.*;
import org.junit.Test;

public class Exam1Test {

	@Test
	public void test() {
		Exam1 test1 = new Exam1(100);
		Exam1 test2 = new Exam1(50, "A cow ate some grass");
		assertFalse(test1.equals(test2));
	}

}
