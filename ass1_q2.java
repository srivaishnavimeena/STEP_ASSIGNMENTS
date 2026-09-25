public class TypingSpeedChecker {
    
    private String originalText = "hello world"; 
    private String userTypedText;               
    private double accuracyPercentage;           
    private int count = 0;                      


    public TypingSpeedChecker(String userTypedText) {
        this.userTypedText = userTypedText;
    }

    
    public void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null) {
            throw new IllegalArgumentException("Inputs cannot be null.");
        }

        
        char[] originalCharacters = original.toCharArray();
        char[] typedCharacters = typed.toCharArray();

        int firstMismatchPosition = -1;
        char originalChar = ' ';
        char typedChar = ' ';

        
        for (int i = 0; i < originalCharacters.length && i < typedCharacters.length; i++) {
            if (originalCharacters[i] == typedCharacters[i]) {
                count++;
            } else if (firstMismatchPosition == -1) {
                
                firstMismatchPosition = i + 1;
                originalChar = originalCharacters[i];
                typedChar = typedCharacters[i];
            }
        }

        
        int totalLength = originalCharacters.length;
        accuracyPercentage = ((double) count / totalLength) * 100;

        
        if (firstMismatchPosition == -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n", 
                              count, totalLength, accuracyPercentage);
        } else {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n", 
                              count, totalLength, accuracyPercentage, firstMismatchPosition, originalChar, typedChar);
        }
    }

    public static void main(String[] args) {
        
        TypingSpeedChecker checker1 = new TypingSpeedChecker("hello worlt");
        checker1.checkTypingAccuracy(checker1.originalText, checker1.userTypedText);

        TypingSpeedChecker checker2 = new TypingSpeedChecker("coding");
        checker2.checkTypingAccuracy("coding", checker2.userTypedText);
    }
}