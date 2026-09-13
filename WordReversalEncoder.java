
import java.util.Scanner;

public class WordReversalEncoder {

    public static String reverseEachWord(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return sentence;
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder reversedWord = new StringBuilder();
            for (int j = words[i].length() - 1; j >= 0; j--) {
                reversedWord.append(words[i].charAt(j));
            }
            
            result.append(reversedWord);
            
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String output = reverseEachWord(input);
                System.out.println(output);
            }
            scanner.close();
        } catch (Exception e) {
            System.err.println("Error processing input: " + e.getMessage());
        }
    }
}