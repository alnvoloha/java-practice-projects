# Payment Checkout (Inner Class)

Builds a purchase from multiple items using an inner class and calculates totals.

## Highlights
- Encapsulation + immutability: items exposed as an unmodifiable list
- Inner class `Payment.Item` bound to the parent purchase
- Parsing of items from text input
- Validation layer + rich custom exceptions
- TestNG unit tests for core logic

## How to run
Run `run.Main`. For tests: `mvn test`.

## Notes
- Build artifacts (`target/`, `out/`, `*.class`) are intentionally excluded from version control.
- If the project reads input from a file, the default dataset is located in `src/main/resources/`.
