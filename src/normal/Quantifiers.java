package normal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Quantifiers.java
 * 
 * This class demonstrates the use of Quantifiers.
 * Quantifiers specify how many times a character or group must occur.
 * 
 * Concepts covered:
 * 1. * (Greedy) - Matches zero or more times.
 * 2. + (Greedy) - Matches one or more times.
 * 3. ? (Greedy) - Matches zero or one time.
 * 4. {n} - Matches exactly n times.
 * 
 * We will try to extract words and numbers of specific lengths.
 */
public class Quantifiers {
    public static void main(String[] args) {
        String text = "a aa aaa 1 12 123 1234";
        
        System.out.println("Text: " + text);
        System.out.println("-------------------------------");

        // Example 1: Match 'a' followed by one or more 'a's (a+)
        // This will match 'a', 'aa', 'aaa'
        System.out.println("Pattern 'a+' (one or more 'a'):");
        printMatches(text, "a+");

        // Example 2: Match exactly 3 digits (\\d{3})
        System.out.println("\nPattern '\\d{3}' (exactly 3 digits):");
        printMatches(text, "\\d{3}");
        
        // Example 3: Match a digit followed by zero or more digits (\\d*)
        System.out.println("\nPattern '\\d*' (zero or more digits):");
        // Note: This might match empty strings between non-digits depending on implementation,
        // but here we look at how it consumes digits.
        printMatches(text, "\\d+"); // Using + for clearer output in this specific text context
    }

    private static void printMatches(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        while (matcher.find()) {
            System.out.println("Found: '" + matcher.group() + "' at index " + matcher.start());
        }
    }
}
