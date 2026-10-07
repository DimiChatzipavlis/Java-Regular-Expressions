# Java Regular Expressions Examples

This project demonstrates Java Regular Expressions concepts, split into three sections: **Normal** (Educational), **Advanced** (Real-world scenarios) and **Data Formats** (XML and JSON).

## Structure

### Normal (Educational)
Located in `src/normal/`. These examples cover the basics of Regex.

1.  **SimpleMatch.java**: Basic usage of `Pattern` and `Matcher` to find literal strings.
2.  **CharacterClasses.java**: Using character classes like `\d` (digits), `\w` (words), `[abc]` and the negation `[^abc]`.
3.  **Quantifiers.java**: Using quantifiers like `*`, `+`, `?`, and `{n}` to match repeating patterns.

### Advanced (Real-world Scenarios)
Located in `src/advanced/`. These examples are interactive and solve common problems.

1.  **EmailValidation.java**: Validates email addresses using a robust regex pattern.
2.  **LogParser.java**: Parses a server log line to extract IP, Date, Method, URL, and Status.
3.  **PasswordStrength.java**: Checks password complexity using Lookaheads (Positive Lookahead).

### Data Formats
Located in `src/data_formats/`. Demonstrates simple XML and JSON handling.

1.  **XmlDemo.java**: Validates `student.xml` against `student.xsd`, then parses it with the DOM parser.
2.  **JsonDemo.java**: Extracts the key/value pairs of a flat JSON object with a regex (no external library).

## How to Run

You can compile and run these files using the command line from the `src` directory.
The examples are written for Java 8, so `--release 8` keeps them runnable on a Java 8 runtime
even if your compiler is newer.

### Compile
```bash
javac --release 8 normal/*.java advanced/*.java
```

The classes are not in a package, so each `.class` file is written next to its source file.
That is why the commands below point `java` at the right folder with `-cp`.

### Run Normal Examples
```bash
java -cp normal SimpleMatch
java -cp normal CharacterClasses
java -cp normal Quantifiers
```

### Run Advanced Examples
These examples are interactive and will ask for input.
```bash
java -cp advanced EmailValidation
java -cp advanced LogParser
java -cp advanced PasswordStrength
```

### Run Data Format Examples
`XmlDemo` reads `student.xml` and `student.xsd` from the current directory, so run it from inside `data_formats`.
```bash
cd data_formats
javac --release 8 *.java
java XmlDemo
java JsonDemo
```
