import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * JsonDemo.java
 *
 * This class demonstrates simple JSON handling with plain Java (no libraries).
 *
 * NOTE: Standard Java does NOT have a dedicated JSON library (like Jackson or Gson).
 * An older version of this demo evaluated the JSON with the "Nashorn" JavaScript
 * engine, but Nashorn was removed in Java 15 (the program crashed on newer JDKs)
 * and evaluating input as JavaScript means running whatever code it contains.
 * Instead, we extract the key/value pairs of a FLAT JSON object with a regex,
 * which works on every Java version from 8 onwards.
 * For nested objects or arrays, use a real JSON library.
 *
 * Concepts:
 * 1. JSON Structure.
 * 2. Parsing a flat JSON object with a regular expression.
 */
public class JsonDemo {

    // Regex breakdown:
    // "(\w+)"                    - Group 1: the key, inside quotes
    // \s*:\s*                    - The colon, with optional spaces around it
    // ( ... )                    - Group 2: the value, one of:
    //   "(?:[^"\\]|\\.)*"        -   a string (escaped quotes like \" are allowed)
    //   -?\d+(?:\.\d+)?          -   a number (optional minus sign and decimals)
    //   true|false|null          -   a literal
    private static final Pattern PAIR_PATTERN = Pattern.compile(
            "\"(\\w+)\"\\s*:\\s*(\"(?:[^\"\\\\]|\\\\.)*\"|-?\\d+(?:\\.\\d+)?|true|false|null)");

    public static void main(String[] args) {
        // 1. A JSON String
        String jsonString = "{" +
                "\"id\": 101, " +
                "\"name\": \"Alice Smith\", " +
                "\"active\": true" +
                "}";

        System.out.println("=== JSON Demo (using Regex) ===");
        System.out.println("Raw JSON: " + jsonString);
        System.out.println("---------------------------");

        // 2. Extract every "key": value pair, keeping the original order
        Map<String, String> fields = new LinkedHashMap<>();
        Matcher matcher = PAIR_PATTERN.matcher(jsonString);
        while (matcher.find()) {
            fields.put(matcher.group(1), unquote(matcher.group(2)));
        }

        // 3. Convert the text values to proper Java types
        int id = Integer.parseInt(fields.get("id"));
        String name = fields.get("name");
        boolean active = Boolean.parseBoolean(fields.get("active"));

        System.out.println("Parsed Data:");
        System.out.println("Name:   " + name);
        System.out.println("ID:     " + id);
        System.out.println("Active: " + active);
    }

    // Removes the surrounding quotes of a JSON string and resolves \" and \\
    private static String unquote(String value) {
        if (value.length() >= 2 && value.startsWith("\"") && value.endsWith("\"")) {
            return value.substring(1, value.length() - 1).replaceAll("\\\\(.)", "$1");
        }
        return value;
    }
}
