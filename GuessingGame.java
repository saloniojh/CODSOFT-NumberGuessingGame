import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        playGuessingGame();
    }

    public static void playGuessingGame() {
        System.out.println("Welcome to the Guessing Game!");
        System.out.println("I will generate a random number between 1 and 100.");
        System.out.println("You need to guess the number. Let's begin!");

        int attemptsLimit = 5;
        boolean playAgain = true;
        int totalAttempts = 0;
        int totalRounds = 0;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (playAgain) {
            totalRounds++;
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < attemptsLimit) {
                attempts++;
                System.out.print("\nEnter your guess (between 1 and 100): ");
                int userGuess = scanner.nextInt();

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number!");
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low!");

                    // Provide warm hint if the guess is within 10 units of the target number
                    if (numberToGuess - userGuess <= 10) {
                        System.out.println("Warm: The number is close to being higher.");
                    }
                } else {
                    System.out.println("Too high!");

                    // Provide warm hint if the guess is within 10 units of the target number
                    if (userGuess - numberToGuess <= 10) {
                        System.out.println("Warm: The number is close to being lower.");
                    }
                }

                // Provide the guess range to help the user narrow down their guesses
                int lowerBound = Math.max(1, numberToGuess - 20);
                int upperBound = Math.min(100, numberToGuess + 20);
                System.out.println("Hint: The number is between " + lowerBound + " and " + upperBound);
            }

            if (!guessedCorrectly) {
                System.out.println("\nGame over! You ran out of attempts.");
                System.out.println("The number to guess was: " + numberToGuess);
            }

            totalAttempts += attempts;

            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.startsWith("y");
        }

        System.out.println("\nThank you for playing!");
        System.out.println("You played " + totalRounds + " round(s) and took " + totalAttempts + " attempt(s).");

        scanner.close();
    }
}
