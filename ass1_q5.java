public class MovieReviewProfiler {

    public void classifyWordLengths(String review) {
        
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Invalid review text provided.");
            return;
        }

        
        String[] words = review.trim().split("\\s+");

        
        int shortCount = 0;   
        int mediumCount = 0;  
        int longCount = 0;    

        
        for (String word : words) {
            
            word = word.replaceAll("[^a-zA-Z]", ""); 

            int len = word.length();

            if (len >= 1 && len <= 4) {
                shortCount++;
            } else if (len >= 5 && len <= 8) {
                mediumCount++;
            } else if (len >= 9) {
                longCount++;
            }
        }

        
        System.out.printf("Short: %d | Medium: %d | Long: %d%n", shortCount, mediumCount, longCount);
    }

    public static void main(String[] args) {
        MovieReviewProfiler profiler = new MovieReviewProfiler();

        String sampleReview = "This movie was absolutely fantastic and thrilling";
        profiler.classifyWordLengths(sampleReview); 
        
    }
}