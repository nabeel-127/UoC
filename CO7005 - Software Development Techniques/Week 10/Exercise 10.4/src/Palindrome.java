public class Palindrome {
	public static boolean isPalindrome(String palindrome) {
		String checkString = "";
		for (int i = palindrome.length() - 1; i >= 0; i--) {
			checkString = checkString + palindrome.charAt(i);
		}
		if (palindrome.equalsIgnoreCase(checkString))
			return true;
		else
			return false;
	}
}