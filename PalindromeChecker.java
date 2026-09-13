import java.util.Scanner;

public class PalindromeChecker {

    public boolean isPalindromeIterative(String text) {
        String cleanText = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = cleanText.length() - 1;
        while (left < right) {
            if (cleanText.charAt(left) != cleanText.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindromeRecursive(String text) {
        String cleanText = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return checkRecursive(cleanText, 0, cleanText.length() - 1);
    }

    private boolean checkRecursive(String text, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }
        return checkRecursive(text, left + 1, right - 1);
    }

    public boolean isPalindromeArrayReversal(String text) {
        String cleanText = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] original = cleanText.toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        return new String(original).equals(new String(reversed));
    }

    public void runChecker(String input) {
        boolean iterativeResult = isPalindromeIterative(input);
        boolean recursiveResult = isPalindromeRecursive(input);
        boolean arrayReversalResult = isPalindromeArrayReversal(input);

        String iterStr = iterativeResult ? "Palindrome" : "Not Palindrome";
        String recurStr = recursiveResult ? "Palindrome" : "Not Palindrome";
        String arrStr = arrayReversalResult ? "Palindrome" : "Not Palindrome";

        System.out.printf("Iterative: %s | Recursive: %s | Array Reversal: %s\n", iterStr, recurStr, arrStr);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text to check: ");
        String input = scanner.nextLine();

        PalindromeChecker checker = new PalindromeChecker();
        checker.runChecker(input);

        scanner.close();
    }
}