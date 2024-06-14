import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;
        do {
            playGame(scanner);
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        } while (playAgain);
        System.out.println("Thank you for playing!");
        scanner.close();
    }
    public static void playGame(Scanner scanner) {
        int minNum = 1;
        int maxNum = 100;
        int maxAttempts = 10;
        int rounds = 3;
        int score = 0;
        for (int round = 1; round <= rounds; round++) {
            System.out.println("\n--- Round " + round + " ---");
            int numberToGuess = new Random().nextInt(maxNum - minNum + 1) + minNum;
            int attemptsLeft = maxAttempts;
            boolean guessedCorrectly = false;
            while (attemptsLeft > 0) {
                System.out.print("Enter your guess (between " + minNum + " and " + maxNum + "): ");
                int guess;
                try {
                    guess = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next();
                    continue;
                }
                if (guess < minNum || guess > maxNum) {
                    System.out.println("Please enter a number between " + minNum + " and " + maxNum + ".");
                    continue;
                }
                attemptsLeft--;
                if (guess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score += (maxAttempts - attemptsLeft);
                    guessedCorrectly = true;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
                System.out.println("Attempts left: " + attemptsLeft);
            }
            if (!guessedCorrectly) {
                System.out.println("Sorry, you ran out of attempts. The correct number was " + numberToGuess + ".");
            }
        }
        System.out.println("\nGame Over! \nYour final score is " + score + ".");
    }
}