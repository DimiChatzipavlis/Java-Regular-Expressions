# Java Regular Expressions Examples

This project demonstrates Java Regular Expressions concepts, split into two sections: **Normal** (Educational) and **Advanced** (Real-world scenarios).

## Structure

### Normal (Educational)
Located in `src/normal/`. These examples cover the basics of Regex.

1.  **SimpleMatch.java**: Basic usage of `Pattern` and `Matcher` to find literal strings.
2.  **CharacterClasses.java**: Using character classes like `\d` (digits), `\w` (words), and `[abc]`.
3.  **Quantifiers.java**: Using quantifiers like `*`, `+`, `?`, and `{n}` to match repeating patterns.

### Advanced (Real-world Scenarios)
Located in `src/advanced/`. These examples are interactive and solve common problems.

1.  **EmailValidation.java**: Validates email addresses using a robust regex pattern.
2.  **LogParser.java**: Parses a server log line to extract IP, Date, Method, URL, and Status.
3.  **PasswordStrength.java**: Checks password complexity using Lookaheads (Positive Lookahead).

## How to Run

You can compile and run these files using the command line from the `src` directory.

### Compile
```bash
javac normal/*.java advanced/*.java
```

### Run Normal Examples
```bash
java SimpleMatch
java CharacterClasses
java Quantifiers
```

### Run Advanced Examples
These examples are interactive and will ask for input.
```bash
java EmailValidation
java LogParser
java PasswordStrength
```

### Run Data Format Examples
Located in `src/data_formats/`. Demonstrates simple XML and JSON handling.
```bash
cd ../data_formats
javac --release 8 *.java
java XmlDemo
java JsonDemo
```