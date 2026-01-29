# Concurrency Library Simulation

A multithreaded simulation where readers borrow unique books using java.util.concurrent primitives.

## Highlights
- BlockingQueue for take-home books
- CopyOnWriteArrayList for reading hall
- Exchanger to swap books between readers
- Phaser to coordinate phases of reading
- ExecutorService for thread management

## How to run
Run `library.run.Main`.

## Notes
- Build artifacts (`target/`, `out/`, `*.class`) are intentionally excluded from version control.
- If the project reads input from a file, the default dataset is located in `src/main/resources/`.
