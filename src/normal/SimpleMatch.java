import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * SimpleMatch.java
 * 
 * This class demonstrates the basic usage of Java Regular Expressions using
 * the Pattern and Matcher classes.
 * 
 * Concepts covered:
 * 1. Creating a Pattern object (compiling a regex).
 * 2. Creating a Matcher object for a specific input string.
 * 3. Using matcher.find() to check for occurrences.
 * 
 * In this example, we simply look for the word "Java" in a sentence.
 */
public class SimpleMatch {
    public static void main(String[] args) {
        // The string to search within
        String text = "Java is a powerful programming language. I love learning Java.";
        
        // The regular expression pattern (looking for the literal string "Java")
        String regex = "Java";
        
        System.out.println("Text: " + text);
        System.out.println("Regex: " + regex);
        System.out.println("-------------------------------");

        // 1. Compile the regular expression into a Pattern object
        Pattern pattern = Pattern.compile(regex);
        
        // 2. Create a Matcher object that will search the 'text'
        Matcher matcher = pattern.matcher(text);
        
        // 3. Find matches
        int count = 0;
        while (matcher.find()) {
            count++;
            System.out.println("Match #" + count + " found at index: " + matcher.start() + " - " + matcher.end());
            System.out.println("Matched text: " + matcher.group());
        }
        
        if (count == 0) {
            System.out.println("No matches found.");
        }
    }
}
