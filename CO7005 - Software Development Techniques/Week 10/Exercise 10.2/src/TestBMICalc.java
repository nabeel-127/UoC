import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestBMICalc {
	@Test
	public void testMyBMI() {
		assertEquals(21.7, BMICalc.calculateBMI(75F, 1.86F), 0.5);
	}
}