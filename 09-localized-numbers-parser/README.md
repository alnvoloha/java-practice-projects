# Localized Numbers Parser

Parses floating-point numbers where each line specifies its locale, then computes sum and average.

## Highlights
- Locale-aware parsing (decimal comma vs dot, etc.)
- Custom exception types for invalid lines and file issues
- Non-blocking processing: invalid lines are skipped with logs
- Aggregates statistics (sum, average)

## How to run
Run `run.Main`. Edit `src/main/resources/numbers.txt` for your own dataset.

## Notes
- Build artifacts (`target/`, `out/`, `*.class`) are intentionally excluded from version control.
- If the project reads input from a file, the default dataset is located in `src/main/resources/`.
