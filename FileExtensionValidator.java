import java.util.Scanner;

public class FileExtensionValidator {

    public String validateFileExtension(String filename) {
        if (filename == null || !filename.contains(".")) {
            return "Rejected — invalid file type";
        }

        int lastDotIndex = filename.lastIndexOf('.');
        if (lastDotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        String extension = filename.substring(lastDotIndex + 1);

        if (extension.equalsIgnoreCase("pdf") || 
            extension.equalsIgnoreCase("docx") || 
            extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        } else {
            return "Rejected — invalid file type";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter filename: ");
        String filename = scanner.nextLine();

        FileExtensionValidator validator = new FileExtensionValidator();
        String result = validator.validateFileExtension(filename);
        System.out.println(result);

        scanner.close();
    }
}