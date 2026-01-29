package run;

import entity.ClientInfo;
import exception.ChatException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reader.ClientListReader;
import util.BroadcastService;
import util.ClientListWriter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ChatServer {
    private static final Logger log = LogManager.getLogger();
    private static final int PORT = 6000;
    private static final Path LIST = Path.of("clients.txt");

    private final List<Socket> sockets = new CopyOnWriteArrayList<>();
    private final Map<Socket, ClientInfo> clientMap = new ConcurrentHashMap<>();
    private final List<ClientInfo> infos;

    public ChatServer() throws ChatException {
        if (Files.notExists(LIST)) {
            try { Files.createFile(LIST); }
            catch (Exception e) { throw new ChatException("Cannot create "+LIST, e); }
        }
        infos = new CopyOnWriteArrayList<>(new ClientListReader().read(LIST));
    }

    public void start() throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            log.info("Server started on port {}", PORT);
            BroadcastService broadcaster = new BroadcastService();
            while (true) {
                Socket socket = serverSocket.accept();
                sockets.add(socket);

                ClientInfo info = registerClient(socket);
                clientMap.put(socket, info);
                new Thread(() -> listenClient(socket, broadcaster)).start();

                infos.add(info);
                new ClientListWriter().write(LIST, infos);
            }
        }
    }

    private ClientInfo registerClient(Socket socket) {
        String host = socket.getInetAddress().getHostAddress();
        int    port = socket.getPort();
        String user = "user-" + port;
        log.info("Registered {}", user);
        return new ClientInfo(user, host, port);
    }

    private void listenClient(Socket socket, BroadcastService broadcaster) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8))) {

            ClientInfo me = clientMap.get(socket);
            String line;
            while ((line = reader.readLine()) != null) {
                String tagged = line + "  (" + me.userName() + ')';
                broadcaster.broadcast(sockets, socket, tagged);
            }
        } catch (Exception e) {
            log.error("Client disconnected", e);
        } finally {
            sockets.remove(socket);
            clientMap.remove(socket);
        }
    }

    public static void main(String[] args) throws Exception {
        new ChatServer().start();
    }
}
