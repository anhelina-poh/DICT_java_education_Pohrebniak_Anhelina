package Hangman;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

@SuppressWarnings("all")
public class HangmanGame {
    private static final String[] WORDS = {"python", "java", "javascript", "kotlin"};
    private final String secretWord;
    private final Set<Character> guessedLetters;

    public HangmanGame() {
        Random random = new Random();
        this.secretWord = WORDS[random.nextInt(WORDS.length)];
        this.guessedLetters = new HashSet<>();
    }

    public void play(Scanner scanner) {
        int attempts = 8;

        while (attempts > 0) {
            displayWord();
            System.out.print("Input a letter: > ");
            String input = scanner.nextLine().trim();
            char letter = input.charAt(0);

            if (secretWord.indexOf(letter) >= 0) {
                guessedLetters.add(letter);
            } else {
                System.out.println("That letter doesn't appear in the word");
            }

            attempts--;
        }

        System.out.println("Thanks for playing!");
        System.out.println("We'll see how well you did in the next stage");
    }

    private void displayWord() {
        for (char c : secretWord.toCharArray()) {
            if (guessedLetters.contains(c)) {
                System.out.print(c);
            } else {
                System.out.print("-");
            }
        }
        System.out.println();
    }
}