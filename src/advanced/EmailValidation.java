import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * EmailValidation.java
 * 
 * This class demonstrates a real-world scenario: Validating an Email Address.
 * It uses a more complex regex pattern to ensure the email follows standard formats.
 * 
 * Regex Explanation:
 * ^                  - Start of the line
 * [\\w.%+-]+         - User name: Word characters, dots, %, +, or - (one or more)
 * @                  - Literal '@' symbol
 * [\\w.-]+           - Domain name: Word characters, dots, or - (one or more)
 * \\.                - Literal '.' (dot)
 * [a-zA-Z]{2,6}      - Top Level Domain (TLD): Letters only, 2 to 6 characters long
 * $                  - End of the line
 * 
 * Interaction:
 * The user is prompted to enter an email address to validate.
 */
public class EmailValidation {
    
    // A robust (but not RFC 5322 perfect) email regex for general validation
    private static final String EMAIL_REGEX = "^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Email Validator ===");
        System.out.println("Regex used: " + EMAIL_REGEX);
        System.out.println("Enter 'exit' to quit.");
        
        while (true) {
            System.out.print("\nEnter an email address: ");
            String input = scanner.nextLine();
            
            if ("exit".equalsIgnoreCase(input)) {
                break;
            }
            
            if (isValidEmail(input)) {
                System.out.println("✅ Valid email address.");
            } else {
                System.out.println("❌ Invalid email address.");
            }
        }
        
        scanner.close();
        System.out.println("Goodbye!");
    }
    
    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }
}
