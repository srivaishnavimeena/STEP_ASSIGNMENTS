import java.util.Scanner;

public class StudentRecordParser {

    public void parseStudentRecord(String csvLine) {
        if (csvLine == null || csvLine.trim().isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String name = fields[0].trim();
        String rollNo = fields[1].trim();
        String dept = fields[2].trim();

        if (name.isEmpty() || rollNo.isEmpty() || dept.isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.printf("Name: %s | Roll No: %s | Dept: %s\n", name, rollNo, dept);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter CSV line: ");
        String csvLine = scanner.nextLine();

        StudentRecordParser parser = new StudentRecordParser();
        parser.parseStudentRecord(csvLine);

        scanner.close();
    }
}