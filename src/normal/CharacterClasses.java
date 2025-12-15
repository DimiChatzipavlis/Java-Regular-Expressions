package normal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * CharacterClasses.java
 * 
 * This class demonstrates the use of Character Classes in Regex.
 * Character classes allow you to match specific sets of characters.
 * 
 * Concepts covered:
 * 1. [abc] - Simple class: matches a, b, or c.
 * 2. [^abc] - Negation: matches any character except a, b, or c.
 * 3. [a-z] - Range: matches any lowercase letter.
 * 4. \\d - Predefined class: matches any digit [0-9].
 * 5. \\w - Predefined class: matches any word character [a-zA-Z_0-9].
 * 
 * Note: In Java strings, backslashes must be escaped, so "\d" becomes "\\d".
 */
public class CharacterClasses {
    public static void main(String[] args) {
        String text = "User123: id_99";
        
        System.out.println("Original Text: " + text);
        System.out.println("-------------------------------");

        // Example 1: Find all digits using \\d
        System.out.println("Finding digits (\\d):");
        printMatches(text, "\\d");
        
        // Example 2: Find all word characters using \\w
        System.out.println("\nFinding word characters (\\w):");
        printMatches(text, "\\w");
        
        // Example 3: Find specific range [a-z] (lowercase letters)
        System.out.println("\nFinding lowercase letters [a-z]:");
        printMatches(text, "[a-z]");
    }
    
    private static void printMatches(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        System.out.print("Matches: ");
        while (matcher.find()) {
            System.out.print("'" + matcher.group() + "' ");
        }
        System.out.println();
    }
}
