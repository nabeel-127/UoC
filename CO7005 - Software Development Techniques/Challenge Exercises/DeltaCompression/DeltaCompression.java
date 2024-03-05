import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DeltaCompression {
	public static Map<Integer, Byte> generateDelta(byte[] original, byte[] modified) {
		Map<Integer, Byte> deltaMap = new HashMap<>();
		int limit = Math.max(original.length, modified.length);
		for (int i = 0; i < limit; i++) {
			if (i < original.length && i < modified.length && original[i] != modified[i]) {
				deltaMap.put(i, modified[i]);
			} else if (i >= original.length && i < modified.length) {
				deltaMap.put(i, modified[i]);
			} else if (i < original.length && i >= modified.length) {
				deltaMap.put(i, (byte) 0x00);
			}
		}
		return deltaMap;
	}
	public static byte[] applyDelta(byte[] original, Map<Integer, Byte> deltaMap) {
		int maxIndex = 0;
		for (int index : deltaMap.keySet()) {
			maxIndex = Math.max(maxIndex, index);
		}
		int resultLength = Math.max(original.length, maxIndex + 1);
		byte[] result = Arrays.copyOf(original, resultLength);
		for (Map.Entry<Integer, Byte> entry : deltaMap.entrySet()) {
			int index = entry.getKey();
			if (index < result.length) {
				result[index] = entry.getValue();
			} else {
				System.out.println("Delta index exceeds result array length.");
			}
		}
		return result;
	}

	public static Map<Integer, Byte> dataEncode(String originalString, String modifiedString) {
		byte[] original = originalString.getBytes();
		byte[] modified = modifiedString.getBytes();
		Map<Integer, Byte> deltaMap = generateDelta(original, modified);
		return deltaMap;
	}
	public static String dataDecode(String originalString, Map<Integer, Byte> deltaMap) {
		byte[] original = originalString.getBytes();
		byte[] result = applyDelta(original, deltaMap);
		return new String(result);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the initial value: ");
		String original = "nabeel";
		System.out.print("Enter the changed value: ");
		String modified = "ali";
		input.close();
		
		Map<Integer, Byte> delta = dataEncode(original, modified);
		String restored = dataDecode(original, delta);
		
		System.out.println("\nResult after applying delta:");
		System.out.println("Original: " + original);
		System.out.println("Modified: " + modified);
		System.out.println("Restored: " + restored);
	}
}