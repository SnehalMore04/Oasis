import java.util.Scanner;
import java.util.Random;

class Task_2 {
    private static final int min_range = 1;
    private static final int max_range = 100;
    private static final int max_attempts = 10;
    private static final int max_rounds = 3;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Random rm = new Random();
        int totalScore = 0;

        System.out.println("<--- NUMBER GUESSING GAME --->");
        System.out.println("Total Number of rounds: 3");
        System.out.println("Attempts to guess numbers in each round: 10\n");

        for (int i = 1; i <= max_rounds; i++) {
            int num = rm.nextInt(max_range - min_range + 1) + max_range;
            int attempts = 0;

            System.out.printf("Round %d: \nGuess the number between %d and %d in %d attempts.\n", i, min_range,
                    max_range,
                    max_attempts);

            while (attempts < max_attempts) {
                System.out.println("Your Guess: ");
                int guess_number = sc.nextInt();
                System.out.println();
                attempts = attempts + 1;

                if (guess_number == num) {
                    int score = max_attempts - attempts;
                    totalScore = totalScore + score;
                    System.out.println();
                    System.out.println(
                            "***********************************************************************************");
                    System.out.printf(
                            "|| Congratulations!! You guessed the correct number. Attempts %d, Round Score= %d ||\n",
                            attempts, score);
                    System.out.println(
                            "***********************************************************************************");
                    break;
                } else if (guess_number < num) {
                    System.out.printf("The number is greater than %d. \nAttempts Left => %d.\n", guess_number,
                            max_attempts - attempts);
                }

                else if (guess_number > num) {
                    System.out.printf("The number is less than %d. \nAttempts left => %d.\n", guess_number,
                            max_attempts - attempts);
                }
            }

            if (attempts == max_attempts) {
                System.out.printf("\nRounds = %d\n", i);
                System.out.println("Attempts = 0");
                System.out.printf("The random number is %d\n\n", num);
            }
        }
        System.out.printf("Game over. Total score =%d\n", totalScore);
        sc.close();
    }
}
