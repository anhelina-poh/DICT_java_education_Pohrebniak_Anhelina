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
    private final Set<Character> allEnteredLetters;
    private int lives;

    public HangmanGame() {
        Random random = new Random();
        this.secretWord = WORDS[random.nextInt(WORDS.length)];
        this.guessedLetters = new HashSet<>();
        this.allEnteredLetters = new HashSet<>();
        this.lives = 8;
    }

    public void play(Scanner scanner) {
        while (lives > 0 && !isWordGuessed()) {
            displayWord();
            System.out.print("Input a letter: > ");
            String input = scanner.nextLine().trim();

            if (input.length() != 1) {
                System.out.println("You should input a single letter");
                continue;
            }

            char letter = input.charAt(0);

            if (letter < 'a' || letter > 'z') {
                System.out.println("Please enter a lowercase English letter");
                continue;
            }

            if (allEnteredLetters.contains(letter)) {
                System.out.println("You've already guessed this letter");
                continue;
            }

            allEnteredLetters.add(letter);

            if (secretWord.indexOf(letter) >= 0) {
                guessedLetters.add(letter);
            } else {
                System.out.println("That letter doesn't appear in the word");
                lives--;
            }
        }

        if (isWordGuessed()) {
            System.out.println("You guessed the word " + secretWord + "!");
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