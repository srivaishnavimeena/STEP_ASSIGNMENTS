import java.util.Random;
import java.util.Scanner;

public class BmiCalculator {

    public String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Normal";
        } else if (bmi >= 25.0 && bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("------------------------------------------------------------------");
        System.out.printf("%-10s | %-12s | %-12s | %-8s | %-12s\n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("------------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double height = heights[i];
            double weight = weights[i];
            double bmi = weight / (height * height);
            String status = getBmiStatus(bmi);

            System.out.printf("%-10s | %-12.2f | %-12.2f | %-8.2f | %-12s\n",
                    "Person " + (i + 1), height, weight, bmi, status);
        }
        System.out.println("------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalPeople = 10;

        System.out.print("Enter number of employees (default 10): ");
        try {
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                totalPeople = Integer.parseInt(input);
                if (totalPeople <= 0) totalPeople = 10;
            }
        } catch (NumberFormatException e) {
            totalPeople = 10;
        }

        double[] heights = new double[totalPeople];
        double[] weights = new double[totalPeople];
        Random random = new Random();

        for (int i = 0; i < totalPeople; i++) {
            heights[i] = 1.50 + (1.95 - 1.50) * random.nextDouble();
            weights[i] = 45.0 + (110.0 - 45.0) * random.nextDouble();
        }

        BmiCalculator calculator = new BmiCalculator();
        calculator.printWellnessReport(heights, weights);

        scanner.close();
    }
}