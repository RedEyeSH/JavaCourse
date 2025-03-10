public class PalindromeChecker {
    public boolean isPalindrome(String sentence) {
        String cleaned = sentence.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        String reversed = new StringBuilder(cleaned).reverse().toString();

        return cleaned.equals(reversed);
    }
}
