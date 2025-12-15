import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * LogParser.java
 * 
 * This class demonstrates parsing a structured log line to extract specific information.
 * This is a common task in data processing and system administration.
 * 
 * Scenario:
 * Parse an Apache-style access log line:
 * 127.0.0.1 - - [15/Dec/2025:10:00:00 +0000] "GET /index.html HTTP/1.1" 200 1024
 * 
 * We want to extract:
 * 1. IP Address
 * 2. Timestamp
 * 3. Request Method (GET/POST)
 * 4. URL
 * 5. Status Code
 * 
 * Concepts:
 * - Grouping () to extract substrings.
 * - Escaping special characters like [ and ].
 */
public class LogParser {

    // Regex breakdown:
    // ^(\S+)             - Group 1: IP Address (non-whitespace characters)
    // \s-\s-\s           - Literal " - - " separator
    // \[(.+?)\]          - Group 2: Timestamp (inside brackets, non-greedy match)
    // \s"                - Space and quote
    // (\w+)              - Group 3: Method (GET, POST, etc.)
    // \s                 - Space
    // (\S+)              - Group 4: URL (non-whitespace)
    // \s                 - Space
    // [^"]*"             - Protocol and closing quote (ignored)
    // \s                 - Space
    // (\d{3})            - Group 5: Status Code (3 digits)
    // .*                 - The rest of the line
    private static final String LOG_REGEX = "^(\\S+)\\s-\\s-\\s\\[(.+?)\\]\\s\"(\\w+)\\s(\\S+)[^\"]*\"\\s(\\d{3}).*";
    private static final Pattern LOG_PATTERN = Pattern.compile(LOG_REGEX);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Log Parser ===");
        System.out.println("Enter a log line to parse, or press Enter to use the default example.");
        System.out.println("Default Example: 192.168.1.1 - - [15/Dec/2025:14:32:10 +0000] \"POST /api/login HTTP/1.1\" 200 512");
        
        System.out.print("\nLog Line > ");
        String input = scanner.nextLine();
        
        if (input.trim().isEmpty()) {
            input = "192.168.1.1 - - [15/Dec/2025:14:32:10 +0000] \"POST /api/login HTTP/1.1\" 200 512";
            System.out.println("Using default: " + input);
        }
        
        parseLogLine(input);
        
        scanner.close();
    }
    
    private static void parseLogLine(String line) {
        Matcher matcher = LOG_PATTERN.matcher(line);
        
        if (matcher.find()) {
            System.out.println("\n--- Parsed Data ---");
            System.out.println("IP Address:  " + matcher.group(1));
            System.out.println("Timestamp:   " + matcher.group(2));
            System.out.println("Method:      " + matcher.group(3));
            System.out.println("URL:         " + matcher.group(4));
            System.out.println("Status Code: " + matcher.group(5));
        } else {
            System.out.println("\n❌ Could not parse the log line. Format might not match.");
        }
    }
}
