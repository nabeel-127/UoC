import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
// import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;

public class TestFileManager {
	@Test
	@DisplayName("Read/Write test")
	public void testFileManager() {
		Exception error;
		error = assertThrows(IOException.class, () -> FileManager.ReadFile("testFile.txt"));
		assertEquals("ExceptionAlwaysThrown", error.getMessage());
		assertEquals(FileManager.WriteFile("testFile.txt", "testData1", false), 0);
		error = null;
		assertNull(error);
		try {
			assertEquals(FileManager.WriteFile("testFile.txt", "testData2", false), FileManager.ReadFile("testFile.txt"));
			assertEquals(FileManager.ReadFile("testFile.txt"), FileManager.WriteFile("testFile.txt", "testData3", false));
			assertEquals(FileManager.ReadFile("testFile.txt"), 0);
		} catch (IOException e) {
			assertEquals("ExceptionAlwaysThrown", e.getMessage());
		}
	}
}