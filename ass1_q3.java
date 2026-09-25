public class TrafficSignalAnalyzer {

    public void findLongestStreak(String signalLog) {

        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("Invalid signal log provided.");
            return;
        }

        
        char[] signals = signalLog.toCharArray();

        int currentStreak = 1;
        int maxStreak = 1;
        char maxChar = signals[0];

        
        for (int i = 1; i < signals.length; i++) {
            
            if (signals[i] == signals[i - 1]) {
                currentStreak++; 
            } else {
                currentStreak = 1; 
            }

            
            if (currentStreak > maxStreak) {
                maxStreak = currentStreak;
                maxChar = signals[i];
            }
        }

        
        System.out.printf("Longest Streak: '%c' repeated %d times%n", maxChar, maxStreak);
    }

    public static void main(String[] args) {
        TrafficSignalAnalyzer analyzer = new TrafficSignalAnalyzer();

        analyzer.findLongestStreak("RRGGGYRR");
        analyzer.findLongestStreak("RRRRYYGG");
    }
}