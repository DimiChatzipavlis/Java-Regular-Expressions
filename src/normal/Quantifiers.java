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

        // Example 1: Match one or more 'a's (a+)
        // This will match 'a', 'aa', 'aaa'
        System.out.println("Pattern 'a+' (one or more 'a'):");
        printMatches(text, "a+");

        // Example 2: Match exactly 3 digits (\\d{3})
        // Note: '1234' also yields '123', because {3} does not care what follows
        System.out.println("\nPattern '\\d{3}' (exactly 3 digits):");
        printMatches(text, "\\d{3}");

        // Example 3: Match '1' followed by zero or more digits (1\\d*)
        // This will match '1', '12', '123', '1234' (the * allows zero extra digits)
        System.out.println("\nPattern '1\\d*' ('1' then zero or more digits):");
        printMatches(text, "1\\d*");

        // Example 4: Match '1' optionally followed by '2' (12?)
        // This will match '1' alone, then '12' three times
        System.out.println("\nPattern '12?' ('1' then an optional '2'):");
        printMatches(text, "12?");
    }

    private static void printMatches(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        while (matcher.find()) {
            System.out.println("Found: '" + matcher.group() + "' at index " + matcher.start());
        }
    }
}
