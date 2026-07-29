
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    // Method to convert number into choice
    public static String getChoice(int choice) {
        switch (choice) {
            case 1:
                return "Rock";
            case 2:
                return "Paper";
            case 3:
                return "Scissors";
            default:
                return "Invalid";
        }
    }

    // Method to decide winner
    public static int checkWinner(int userChoice, int computerChoice) {

        if (userChoice == computerChoice) {
            return 0; // Draw
        }

        if ((userChoice == 1 && computerChoice == 3) ||
            (userChoice == 2 && computerChoice == 1) ||
            (userChoice == 3 && computerChoice == 2)) {

            return 1; // User Wins
        }

        return -1; // Computer Wins
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int userScore = 0;
        int computerScore = 0;
        int draw = 0;

        System.out.println("==================================");
        System.out.println(" ROCK PAPER SCISSORS GAME ");
        System.out.println("==================================");

        for (int round = 1; round <= 5; round++) {

            System.out.println("\nRound " + round);

            System.out.println("1. Rock");
            System.out.println("2. Paper");
            System.out.println("3. Scissors");

            System.out.print("Enter your choice: ");
            int userChoice = sc.nextInt();

            // Validate input
            if (userChoice < 1 || userChoice > 3) {
                System.out.println("Invalid Choice! Try Again.");
                round--;
                continue;
            }

            int computerChoice = random.nextInt(3) + 1;

            System.out.println("You Selected      : " + getChoice(userChoice));
            System.out.println("Computer Selected : " + getChoice(computerChoice));

            int result = checkWinner(userChoice, computerChoice);

            if (result == 1) {
                System.out.println("You Win This Round!");
                userScore++;
            } else if (result == -1) {
                System.out.println("Computer Wins This Round!");
                computerScore++;
            } else {
                System.out.println("Round Draw!");
                draw++;
            }

            System.out.println("------------------------------");
            System.out.println("Current Score");
            System.out.println("User      : " + userScore);
            System.out.println("Computer  : " + computerScore);
            System.out.println("Draw      : " + draw);
        }

        System.out.println("\n==================================");
        System.out.println(" FINAL RESULT ");
        System.out.println("==================================");

        System.out.println("User Score      : " + userScore);
        System.out.println("Computer Score  : " + computerScore);
        System.out.println("Draw            : " + draw);

        if (userScore > computerScore) {
            System.out.println("\n Congratulations! You Won the Match!");
        } else if (computerScore > userScore) {
            System.out.println("\n Computer Won the Match!");
        } else {
            System.out.println("\n Match Draw!");
        }

        sc.close();
    }
}