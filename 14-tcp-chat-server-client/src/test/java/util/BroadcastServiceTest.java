package util;

import exception.ChatException;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.Executors;

import static org.testng.Assert.assertEquals;

public class BroadcastServiceTest {


    @Test
    public void testBroadcastSendsMessage() throws Exception {
        try (ServerSocket server = new ServerSocket(0)) {
            int port = server.getLocalPort();

            Socket client = new Socket("localhost", port);
            Socket serverSide = server.accept();

            BroadcastService bs = new BroadcastService();
            Executors.newSingleThreadExecutor().submit(() -> {
                try {
                    bs.broadcast(List.of(serverSide), null, "hi");
                } catch (ChatException e) {
                    throw new RuntimeException(e);
                }
            });

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(client.getInputStream(), StandardCharsets.UTF_8));
            String line = in.readLine();
            assertEquals(line, "hi");
        }
    }

    //ChatException
    @Test(expectedExceptions = ChatException.class)
    public void testBroadcastBrokenSocket() throws ChatException {
        Socket bad = new Socket();
        new BroadcastService().broadcast(List.of(bad), null, "x");
    }
}
