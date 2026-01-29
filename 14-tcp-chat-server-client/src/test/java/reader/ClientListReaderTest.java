package reader;

import entity.ClientInfo;
import exception.ChatException;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.testng.Assert.*;

public class ClientListReaderTest {

    @Test
    public void testReadValidFile() throws Exception {
        Path tmp = Files.createTempFile("clients", ".txt");
        Files.writeString(tmp, "bob@127.0.0.1:1234");
        List<ClientInfo> list = new ClientListReader().read(tmp);
        assertEquals(list.size(), 1);
    }

    @Test(expectedExceptions = ChatException.class)
    public void testReadMissingFile() throws ChatException {
        new ClientListReader().read(Path.of("no_such_file.txt"));
    }
}


