package util;

import exception.ChatException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class BroadcastService {
    private static final Logger log = LogManager.getLogger();

    public void broadcast(List<Socket> recipients, Socket sender, String message) throws ChatException {
        for (Socket socket : recipients) {
            if (socket.isClosed() || socket == sender) continue;
            try {
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
                writer.write(message);
                writer.newLine();
                writer.flush();
            } catch (Exception e) {
                log.error("Broadcast error to {}", socket, e);
                throw new ChatException("Unable to send message", e);
            }
        }
        log.info("Broadcasted: {}", message);
    }
}
