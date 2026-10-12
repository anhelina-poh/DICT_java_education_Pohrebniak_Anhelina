package Hangman;

import java.util.Scanner;

@SuppressWarnings("all")
public class hangman {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("HANGMAN");
        System.out.print("Guess the word: > ");
        String guess = scanner.nextLine().trim();

        String secretWord = "java";

        if (guess.equals(secretWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }

        scanner.close();
    }
}