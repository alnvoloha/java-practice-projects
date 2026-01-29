package reader;

import entity.ClientInfo;
import exception.ChatException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ClientListReader {
    public List<ClientInfo> read(Path file) throws ChatException {
        try {
            return Files.readAllLines(file)
                    .stream()
                    .map(this::mapLine)
                    .toList();
        } catch (IOException e) {
            throw new ChatException("Error reading client list", e);
        }
    }

    private ClientInfo mapLine(String line) {
        String[] parts = line.split("[:@]");
        return new ClientInfo(parts[0], parts[1], Integer.parseInt(parts[2]));
    }
}
