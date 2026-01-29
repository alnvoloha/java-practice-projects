package util;

import entity.ClientInfo;
import exception.ChatException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ClientListWriter {
    public void write(Path file, List<ClientInfo> clients) throws ChatException {
        try {
            Files.write(file,
                    clients.stream()
                            .map(ClientInfo::toString)
                            .toList());
        } catch (IOException e) {
            throw new ChatException("Error writing client list", e);
        }
    }
}
