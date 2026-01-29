# Car Model (Composition)

A compact OOP model of a car built from `Engine` + `Wheel` with realistic actions.

## Highlights
- Composition: `Car` aggregates `Engine` and `Wheel`
- Actions: drive, refuel, change wheel, print brand
- Logging of key actions and state changes
- TestNG tests for basic behavior

## How to run
Run `run.Main`. For tests: `mvn test`.

## Notes
- Build artifacts (`target/`, `out/`, `*.class`) are intentionally excluded from version control.
- If the project reads input from a file, the default dataset is located in `src/main/resources/`.
