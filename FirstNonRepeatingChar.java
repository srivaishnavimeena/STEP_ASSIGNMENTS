import java.util.Scanner;

public class FirstNonRepeatingChar {

    public char findFirstNonRepeatingChar(String text) {
        int[] frequency = new int[256];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (frequency[ch] == 1) {
                return ch;
            }
        }

        return '\0';
    }

    public void processInput(String text) {
        char result = findFirstNonRepeatingChar(text);
        if (result != '\0') {
            System.out.printf("First Non-Repeating Character: '%c'\n", result);
        } else {
            System.out.println("No Non-Repeating Character Found");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String text = scanner.nextLine();

        FirstNonRepeatingChar finder = new FirstNonRepeatingChar();
        finder.processInput(text);

        scanner.close();
    }
}