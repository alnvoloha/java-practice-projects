package util;

import entity.ClientInfo;
import exception.ChatException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.testng.Assert.*;

public class ClientListWriterTest {

    @Test
    public void testWriteAndReadBack() throws Exception {
        Path tmp = Files.createTempFile("out", ".txt");
        List<ClientInfo> clients = List.of(new ClientInfo("a","1.1.1.1",1111));
        new ClientListWriter().write(tmp, clients);
        String content = Files.readString(tmp);
        assertTrue(content.contains("a@1.1.1.1:1111"));
    }

    @Test(expectedExceptions = ChatException.class)
    public void testWriteInvalidPath() throws ChatException, IOException {
        Path dir = Files.createTempDirectory("dir");
        new ClientListWriter().write(dir, List.of());
    }
}
