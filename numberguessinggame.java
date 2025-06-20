 import java.util.Random;
import java.util.Scanner;

 class numbergame {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        int min = 1;
        int max = 100;
        int maxAttempts = 5;
        int score = 0;
        int round = 1;
        boolean playAgain = true;

        while (playAgain) {
            int randomNumber = rand.nextInt(max - min + 1) + min;
            int attempts = 0;
            boolean guessedNumber = false;

            System.out.println("\n Round " + round + ": Guess the number between " + min + " and " + max);

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ": Enter your guess: ");

                if (!input.hasNextInt()) {
                    System.out.println(" Please enter a valid number.");
                    input.next(); // clear invalid input
                    continue;
                }

                int guess = input.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    System.out.println(" Correct! You guessed it in " + attempts + " attempts.");
                    score++;
                    guessedNumber = true;
                    break; // Exit the loop if guessed correctly
                } else if (guess < randomNumber) {
                    System.out.println(" Too low.");
                } else {
                    System.out.println("Too high.");
                }
            }

            if (!guessedNumber) {
                System.out.println(" Out of attempts! The correct number was: " + randomNumber);
            }

            System.out.println(" Current Score: " + score + " win(s)");
            System.out.print("Do you want to play another round? (yes/no): ");
            input.nextLine(); // clear buffer
            String again = input.nextLine().toLowerCase();

            if (!again.equals("yes") && !again.equals("y")) {
                playAgain = false;
                System.out.println("Thanks for playing!");
            }

            round++;
        }

        input.close();
    }
}
