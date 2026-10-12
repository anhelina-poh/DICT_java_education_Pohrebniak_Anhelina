package Hangman;

import java.util.Scanner;

@SuppressWarnings("all")
public class hangman {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("HANGMAN");
        HangmanGame game = new HangmanGame();
        game.play(scanner);

        scanner.close();
    }
}