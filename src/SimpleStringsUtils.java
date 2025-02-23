import java.util.HashMap;

/**
 * A utility class providing various string operations such as reversing a string,
 * checking for palindromes, and counting vowels and consonants.
 * @author Tyler Nixon
 */
public class SimpleStringsUtils {

    /**
     * Reverses the given string.
     *
     * @param string the string to reverse
     * @return the reversed string, or null if the input string is null
     */
    public String StringReversal(String string) {
        if (string == null) {
            return null;
        }
        // Use StringBuilder to reverse the string
        StringBuilder sb = new StringBuilder(string);
        return sb.reverse().toString();
    }

    /**
     * Checks if the given string is a palindrome.
     *
     * @param string the string to check
     * @return true if the string is a palindrome, false otherwise
     */
    public boolean PalindromeCheck(String string) {
        if (string == null) {
            return false;
        }
        // Check if the string is equal to its reversed version
        return string.equals(StringReversal(string));
    }

    /**
     * Checks if the given string is a palindrome with optional case sensitivity.
     *
     * @param string the string to check
     * @param caseSensitive whether the check should be case-sensitive
     * @return true if the string is a palindrome, false otherwise
     */
    public boolean PalindromeCheck(String string, boolean caseSensitive) {
        if (string == null) {
            return false;
        }
        if (!caseSensitive) {
            // Perform case-insensitive check
            return string.equalsIgnoreCase(StringReversal(string));
        }
        // Perform case-sensitive check
        return string.equals(StringReversal(string));
    }

    /**
     * Counts the number of vowels and consonants in the given string.
     *
     * @param string the string to analyze
     * @return a HashMap containing the counts of vowels and consonants
     * @throws IllegalArgumentException if the string contains invalid characters
     */
    public HashMap<String, Integer> CountVowelsAndConsonants(String string) throws IllegalArgumentException {
        if (string == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(string);
        String EXCEPTIONS = " "; // Characters to ignore
        String VOWELS = "aeiouAEIOU";
        String CONSONANTS = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
        int vowelsCount = 0;
        int consonantsCount = 0;

        // Iterate through each character in the string
        for (char c : sb.toString().toCharArray()) {
            if (Character.isLetter(c) || EXCEPTIONS.indexOf(c) != -1) {
                if (VOWELS.indexOf(c) != -1) {
                    vowelsCount++;
                } else if (CONSONANTS.indexOf(c) != -1) {
                    consonantsCount++;
                }
            } else {
                // Throw an exception for invalid characters
                throw new IllegalArgumentException("Invalid character in string: " + c);
            }
        }

        // Store the counts in a HashMap
        HashMap<String, Integer> counts = new HashMap<>();
        counts.put("Vowels", vowelsCount);
        counts.put("Consonants", consonantsCount);

        return counts;
    }
}