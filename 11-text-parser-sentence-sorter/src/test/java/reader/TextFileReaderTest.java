package reader;

import org.testng.annotations.Test;
import reader.TextFileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.testng.Assert.*;

public class TextFileReaderTest {

    @Test
    public void testReadValidFile() throws IOException {
        String content = "\tHello     world\n";
        Path tempFile = Files.createTempFile("testfile", ".txt");
        Files.writeString(tempFile, content);

        TextFileReader reader = new TextFileReader();
        String result = reader.read(tempFile.toString());

        assertEquals(result, "Hello world");
        Files.delete(tempFile);
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void testReadInvalidFileThrows() {
        TextFileReader reader = new TextFileReader();
        reader.read("nonexistent.txt");
    }
}
