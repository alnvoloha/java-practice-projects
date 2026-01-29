# CLI Calculator with Logging

A simple calculator implemented via an interface with Log4j2 instrumentation.

## Highlights
- Interface-driven design (`ICalculator`)
- Separate implementation class (`Calculator`)
- Log4j2 configuration via `log4j2.xml`

## How to run
Run `run.Main` (Maven project).

## Notes
- Build artifacts (`target/`, `out/`, `*.class`) are intentionally excluded from version control.
- If the project reads input from a file, the default dataset is located in `src/main/resources/`.
