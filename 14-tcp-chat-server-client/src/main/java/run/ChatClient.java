package run;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ChatClient {
    private static final Logger log = LogManager.getLogger();
    private static final String HOST = "localhost";
    private static final int PORT = 6000;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(HOST, PORT);
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
            BufferedReader console = new BufferedReader(
                    new InputStreamReader(System.in));

            // Приём сообщений
            Thread receiver = new Thread(() -> {
                try {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    log.warn("Disconnected from server");
                }
            });
            receiver.setDaemon(true);
            receiver.start();

            // Отправка сообщений
            while (true) {
                String msg = console.readLine();
                if (msg == null || msg.equalsIgnoreCase("exit")) {
                    break;
                }
                writer.write(msg);
                writer.newLine();
                writer.flush();
            }

            socket.close();
            log.info("Client closed");
        } catch (IOException e) {
            log.error("Connection failed", e);
        }
    }
}
