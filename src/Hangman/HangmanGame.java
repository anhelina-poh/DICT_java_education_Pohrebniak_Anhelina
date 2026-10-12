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
    private int lives;

    public HangmanGame() {
        Random random = new Random();
        this.secretWord = WORDS[random.nextInt(WORDS.length)];
        this.guessedLetters = new HashSet<>();
        this.lives = 8;
    }

    public void play(Scanner scanner) {
        while (lives > 0 && !isWordGuessed()) {
            displayWord();
            System.out.print("Input a letter: > ");
            String input = scanner.nextLine().trim();
            char letter = input.charAt(0);

            if (secretWord.indexOf(letter) >= 0) {
                if (guessedLetters.contains(letter)) {
                    System.out.println("No improvements");
                    lives--;
                } else {
                    guessedLetters.add(letter);
                }
            } else {
                System.out.println("That letter doesn't appear in the word");
                lives--;
            }
        }

        if (isWordGuessed()) {
            displayWord();
            System.out.println("You guessed the word!");
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
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

    private boolean isWordGuessed() {
        for (char c : secretWord.toCharArray()) {
            if (!guessedLetters.contains(c)) {
                return false;
            }
        }
        return true;
    }
}