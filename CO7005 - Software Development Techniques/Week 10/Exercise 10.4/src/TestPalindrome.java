import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestPalindrome {
	@Test
	public void TestPalindrome() {
		assertEquals(true, Palindrome.isPalindrome("abba"));
		assertEquals(false, Palindrome.isPalindrome("abaa"));
		assertEquals(true, Palindrome.isPalindrome("Lol"));
		assertEquals(true, Palindrome.isPalindrome("rotavator"));
	}
}