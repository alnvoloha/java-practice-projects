# Java Practice Projects

A curated collection of small-to-medium Java projects built while strengthening fundamentals and building clean, testable code.

## What you’ll find here
- CLI apps with input validation and error handling
- OOP design (composition, encapsulation, immutability)
- File-based workflows (read/parse/process/write)
- Logging (Log4j2 / SLF4J) and meaningful custom exceptions
- Data structures, text processing, concurrency, and networking

## Quick navigation
| # | Project | Focus | Run |
|---|--------|-------|-----|
| 01 | Matrix Cyclic Shift | arrays, matrix ops, CLI | `Main` |
| 02 | Multiplication Table in Different Bases | control flow, formatting | `volohaLab113` / `volohaLab213` |
| 03 | Customer Data Pipeline | validation, parsing, file/console input | `Main` |
| 04 | CLI Calculator with Logging | interfaces, implementation, logging | `Main` |
| 05 | Car Model (Composition) | OOP composition, state changes | `Main` |
| 06 | Payment Checkout (Inner Class) | inner class, parsing, tests | `Main` |
| 07 | Mobile Subscriber Management | interfaces, validation, file input, tests | `Main` |
| 08 | Anagram Checker | strings, normalization | `Main` |
| 09 | Localized Numbers Parser | locale-aware parsing, aggregation | `Main` |
| 10 | Text Formatter + Spiral Cipher | strings/regex + algorithmic transform | `Main` |
| 11 | Text Parser & Sentence Sorter | Composite + Chain of Responsibility | `Main` |
| 12 | Digit Stack Reverser | custom DS, interfaces, validation, tests | `Main` |
| 13 | Concurrency Library Simulation | java.util.concurrent (queue, phaser, exchanger) | `Main` |
| 14 | TCP Chat (Server/Client) | sockets, multithreading, shared state | `ChatServer` / `ChatClient` |
| 15 | Tax Report Generator | parsing, sorting, serialization, logging, tests | `Main` |

## How to run
Most folders are independent Maven projects:

```bash
cd 06-payment-checkout-inner-class
mvn test
mvn package
# then run Main from IDE, or run the compiled jar if configured
```

Some folders are plain Java (no Maven). Open the folder and run the `main` class from your IDE.

## Clean repo hygiene
This repository intentionally does **not** include build artifacts.
Make sure you don’t commit:
- `target/`, `out/`, `.idea/`, `.classpath/`, `.project/`
- `*.class`, `*.log`

A root `.gitignore` is included.
