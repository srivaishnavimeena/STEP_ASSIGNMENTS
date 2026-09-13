import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

    // Instance variables (fields)
    private final String[] moves = {"Rock", "Paper", "Scissors"};
    private final Random random;

    // Constructor to initialize object dependencies
    public RockPaperScissorsGame() {
        this.random = new Random();
    }

    /**
     * Determines the winner of a single round.
     * 
     * @param playerMove   The player's chosen move
     * @param computerMove The computer's randomly generated move
     * @return "Player Wins", "Computer Wins", or "Draw"
     */
    public String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        } else {
            return "Computer Wins";
        }
    }

    /**
     * Generates a random move for the computer.
     * 
     * @return String move ("Rock", "Paper", or "Scissors")
     */
    public String getRandomComputerMove() {
        int index = random.nextInt(moves.length);
        return moves[index];
    }

    /**
     * Validates if the player's input string is a valid move.
     * 
     * @param move Input string
     * @return true if valid move, false otherwise
     */
    public boolean isValidMove(String move) {
        for (String validMove : moves) {
            if (validMove.equalsIgnoreCase(move)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Formats the string to standard Title Case (e.g., "rock" -> "Rock").
     */
    public String capitalizeMove(String move) {
        return move.substring(0, 1).toUpperCase() + move.substring(1).toLowerCase();
    }

    /**
     * Executes the full multi-round game sequence.
     * 
     * @param totalRounds Number of rounds to play
     * @param scanner     Scanner object for user input
     */
    public void startGame(int totalRounds, Scanner scanner) {
        String[][] roundSummary = new String[totalRounds][4];
        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("\n=== Starting Rock-Paper-Scissors Arcade ===");

        for (int i = 0; i < totalRounds; i++) {
            int roundNum = i + 1;
            String playerMove = "";

            while (true) {
                try {
                    System.out.printf("Round %d - Enter move (Rock, Paper, Scissors): ", roundNum);
                    playerMove = scanner.nextLine().trim();

                    if (isValidMove(playerMove)) {
                        playerMove = capitalizeMove(playerMove);
                        break;
                    } else {
                        System.out.println("Invalid choice! Please enter Rock, Paper, or Scissors.");
                    }
                } catch (Exception e) {
                    System.out.println("Error reading input. Please try again.");
                }
            }

            String computerMove = getRandomComputerMove();
            String result = playRound(playerMove, computerMove);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            roundSummary[i][0] = "Round " + roundNum;
            roundSummary[i][1] = playerMove;
            roundSummary[i][2] = computerMove;
            roundSummary[i][3] = result;

            System.out.println("Result: " + result + "\n");
        }

        printSummary(roundSummary, totalRounds, wins, losses, draws);
    }

    /**
     * Displays the results summary table and final scores.
     */
    public void printSummary(String[][] summaryTable, int totalRounds, int wins, int losses, int draws) {
        double winPercentage = ((double) wins / totalRounds) * 100.0;

        System.out.println("\n---------------------------------------------------------");
        System.out.printf("%-10s | %-12s | %-13s | %-12s\n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("---------------------------------------------------------");
        for (int i = 0; i < totalRounds; i++) {
            System.out.printf("%-10s | %-12s | %-13s | %-12s\n",
                    summaryTable[i][0], summaryTable[i][1], summaryTable[i][2], summaryTable[i][3]);
        }
        System.out.println("---------------------------------------------------------");
        System.out.printf("Final Summary (after %d rounds):\n", totalRounds);
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", wins, losses, draws, winPercentage);
    }

    // Main method: Entry point where object creation and method invocation happen
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rounds = 5;

        System.out.print("Enter number of rounds to play (default is 5): ");
        try {
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                rounds = Integer.parseInt(input);
                if (rounds <= 0) rounds = 5;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number entered. Defaulting to 5 rounds.");
        }

        // 1. Create an instance (object) of the class
        RockPaperScissorsGame gameInstance = new RockPaperScissorsGame();

        // 2. Call the method using the created object
        gameInstance.startGame(rounds, scanner);

        scanner.close();
    }
}