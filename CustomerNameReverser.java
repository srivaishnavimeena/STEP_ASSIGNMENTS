import java.util.Scanner;

public class CustomerNameReverser {

    public String reverseCustomerName(String customerName) {
        if (customerName == null) {
            return null;
        }
        
        char[] originalArray = customerName.toCharArray();
        char[] reversedArray = new char[originalArray.length];
        
        for (int i = 0; i < originalArray.length; i++) {
            reversedArray[i] = originalArray[originalArray.length - 1 - i];
        }
        
        return new String(reversedArray);
    }

    public void processCustomerName(String name) {
        String reversed = reverseCustomerName(name);
        System.out.println("Original Name: " + name);
        System.out.println("Reversed Name: " + reversed);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();

        CustomerNameReverser reverser = new CustomerNameReverser();
        reverser.processCustomerName(name);

        scanner.close();
    }
}