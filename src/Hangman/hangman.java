package Hangman;

import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("all")
public class hangman {
    private static final String[] WORDS = {"python", "java", "javascript", "kotlin"};

    static void main() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String secretWord = WORDS[random.nextInt(WORDS.length)];

        StringBuilder hint = new StringBuilder();
        for (int i = 0; i < secretWord.length(); i++) {
            if (i < 2) {
                hint.append(secretWord.charAt(i));
            } else {
                hint.append("-");
            }
        }

        System.out.println("HANGMAN");
        System.out.print("Guess the word " + hint + ": > ");
        String guess = scanner.nextLine().trim();

        if (guess.equals(secretWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }

        scanner.close();
    }
}