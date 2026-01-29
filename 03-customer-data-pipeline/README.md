# Customer Data Pipeline

Reads customer records from console or file, validates fields, and processes only valid entries.

## Highlights
- Two input modes: console and file reader
- Validation layer with a dedicated validator
- Custom exception for invalid customer data
- Non-blocking processing: invalid records are skipped, not fatal

## How to run
Open the Maven project and run `run.Main`. Adjust the input file path if needed.

## Notes
- Build artifacts (`target/`, `out/`, `*.class`) are intentionally excluded from version control.
- If the project reads input from a file, the default dataset is located in `src/main/resources/`.
