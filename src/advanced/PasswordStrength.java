package advanced;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * PasswordStrength.java
 * 
 * This class demonstrates using "Lookaheads" to validate complex rules.
 * Lookaheads allow you to check for a pattern without consuming characters.
 * 
 * Rules for a strong password:
 * 1. At least 8 characters long.
 * 2. Contains at least one digit.
 * 3. Contains at least one lowercase letter.
 * 4. Contains at least one uppercase letter.
 * 5. Contains at least one special character (@#$%^&+=).
 * 6. No whitespace.
 * 
 * Regex:
 * ^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\S+$).{8,}$
 */
public class PasswordStrength {

    // Regex breakdown:
    // ^                 - Start of string
    // (?=.*[0-9])       - Positive Lookahead: Ensure at least one digit exists
    // (?=.*[a-z])       - Positive Lookahead: Ensure at least one lowercase exists
    // (?=.*[A-Z])       - Positive Lookahead: Ensure at least one uppercase exists
    // (?=.*[@#$%^&+=])  - Positive Lookahead: Ensure at least one special char exists
    // (?=\S+$)          - Positive Lookahead: Ensure no whitespace
    // .{8,}             - Match any character (except newline) at least 8 times
    // $                 - End of string
    private static final String STRONG_PASSWORD_REGEX = 
        "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(STRONG_PASSWORD_REGEX);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Password Strength Checker ===");
        System.out.println("Rules: 8+ chars, 1 digit, 1 lower, 1 upper, 1 special (@#$%^&+=), no spaces.");
        System.out.println("Enter 'exit' to quit.");
        
        while (true) {
            System.out.print("\nEnter password to check: ");
            String input = scanner.nextLine();
            
            if ("exit".equalsIgnoreCase(input)) {
                break;
            }
            
            if (isStrongPassword(input)) {
                System.out.println("✅ Strong Password!");
            } else {
                System.out.println("❌ Weak Password. Please follow the rules.");
                analyzeWeakness(input);
            }
        }
        
        scanner.close();
    }
    
    public static boolean isStrongPassword(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }
    
    // Helper to give feedback (without regex for simplicity in feedback logic, 
    // but demonstrating what the regex checks for)
    private static void analyzeWeakness(String password) {
        if (password.length() < 8) System.out.println("  - Too short (min 8 chars)");
        if (!password.matches(".*\\d.*")) System.out.println("  - Missing digit");
        if (!password.matches(".*[a-z].*")) System.out.println("  - Missing lowercase");
        if (!password.matches(".*[A-Z].*")) System.out.println("  - Missing uppercase");
        if (!password.matches(".*[@#$%^&+=].*")) System.out.println("  - Missing special char");
        if (password.contains(" ")) System.out.println("  - Contains spaces");
    }
}
