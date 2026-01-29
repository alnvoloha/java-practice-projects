# Text Parser & Sentence Sorter

Parses a structured text into a component tree and sorts sentences by word count.

## Highlights
- Composite pattern for text structure
- Chain of Responsibility for parsing stages
- Clear separation: reader → parser → model → sorter
- Line-by-line error tolerance with logging
- TestNG tests

## How to run
Run `run.Main`. Input text is `src/main/resources/text.txt`.

## Notes
- Build artifacts (`target/`, `out/`, `*.class`) are intentionally excluded from version control.
- If the project reads input from a file, the default dataset is located in `src/main/resources/`.
