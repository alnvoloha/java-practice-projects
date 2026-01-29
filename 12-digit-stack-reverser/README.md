# Digit Stack Reverser

Reads a number, pushes digits onto a stack, and prints the reversed number.

## Highlights
- Custom stack wrapper (`DigitStack`) built on `Deque`
- Implements `Iterable` and exposes a read-only snapshot of internal state
- Validation layer + dedicated exception classes
- File-based input and robust error handling
- TestNG tests

## How to run
Run `run.Main`. For tests: `mvn test`.

## Notes
- Build artifacts (`target/`, `out/`, `*.class`) are intentionally excluded from version control.
- If the project reads input from a file, the default dataset is located in `src/main/resources/`.
