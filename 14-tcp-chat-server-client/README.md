# TCP Chat: Server & Client

A minimal TCP chat system with multi-client broadcasting and persistent client registry.

## Highlights
- Server accepts multiple sockets and broadcasts messages
- Thread-per-client handling for incoming messages
- Thread-safe collections (CopyOnWriteArrayList, ConcurrentHashMap)
- Client registry stored in `clients.txt`
- Log4j2 logging + custom exceptions
- TestNG tests for helpers

## How to run
Run `run.ChatServer`, then `run.ChatClient` in separate terminals.

## Notes
- Build artifacts (`target/`, `out/`, `*.class`) are intentionally excluded from version control.
- If the project reads input from a file, the default dataset is located in `src/main/resources/`.
