package entity;

import java.util.Objects;

public class ClientInfo {
    private final String userName;
    private final String host;
    private final int port;

    public ClientInfo(String userName, String host, int port) {
        this.userName = userName;
        this.host = host;
        this.port = port;
    }

    public String userName() { return userName; }
    public String host()     { return host; }
    public int port()        { return port; }

    @Override
    public String toString() {
        return new StringBuilder(userName)
                .append('@')
                .append(host)
                .append(':')
                .append(port)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientInfo that)) return false;
        return port == that.port &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(host, that.host);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, host, port);
    }
}
