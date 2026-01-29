# Mobile Subscriber Management

A file-driven subscriber system with interfaces, validation, and clean architecture.

## Highlights
- Domain split: base subscriber + specialized implementations
- Validation: phone, operator, tariff, IP address
- Robust error handling with multiple custom exceptions
- Random data generator + writer for quick dataset creation
- TestNG tests for core entities

## How to run
Run `run.Main`. Input lives in `src/main/resources/subscribers.txt`.

## Notes
- Build artifacts (`target/`, `out/`, `*.class`) are intentionally excluded from version control.
- If the project reads input from a file, the default dataset is located in `src/main/resources/`.
