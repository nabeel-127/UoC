import java.io.ByteArrayOutputStream;

public class ByteTest {
	public static void main(String[] args) {
		String str = "H";
		byte[] byteArray = str.getBytes();
		System.out.print(new String(byteArray));
		for (byte b : byteArray) {
			// Convert the byte to an unsigned integer to get a positive value
			int unsignedByte = b & 0xFF;
		
			// Print the binary representation of the byte
			System.out.print(Integer.toBinaryString(unsignedByte) + " ");
		}
	}	
}
