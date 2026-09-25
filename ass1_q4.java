public class WarehouseInventoryBalancer {

    public void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA == null || sectionB == null || sectionA.length == 0 || sectionB.length == 0) {
            System.out.println("Invalid input arrays.");
            return;
        }

        int sumA = 0;
        int sumB = 0;

        
        for (int qty : sectionA) {
            sumA += qty;
        }
        for (int qty : sectionB) {
            sumB += qty;
        }

        String status = (sumA == sumB) ? "Balanced" : "Not Balanced";

        
        int maxA = sectionA[0];
        int indexA = 1;
        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > maxA) {
                maxA = sectionA[i];
                indexA = i + 1;
            }
        }

        
        int maxB = sectionB[0];
        int indexB = 1;
        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > maxB) {
                maxB = sectionB[i];
                indexB = i + 1;
            }
        }

        
        int overallMax;
        String maxSection;
        int maxIndex;

        if (maxA >= maxB) {
            overallMax = maxA;
            maxSection = "Section A";
            maxIndex = indexA;
        } else {
            overallMax = maxB;
            maxSection = "Section B";
            maxIndex = indexB;
        }

        
        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)%n",
                sumA, sumB, status, overallMax, maxSection, maxIndex);
    }

    public static void main(String[] args) {
        WarehouseInventoryBalancer balancer = new WarehouseInventoryBalancer();
        
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};

        balancer.analyzeInventory(sectionA, sectionB);
    }
}