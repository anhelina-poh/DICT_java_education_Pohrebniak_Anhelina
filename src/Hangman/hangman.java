package Hangman;

import java.util.Scanner;

@SuppressWarnings("all")
public class hangman {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("HANGMAN");

        while (true) {
            System.out.print("Type \"play\" to play the game, \"exit\" to quit: > ");
            String choice = scanner.nextLine().trim();

            if ("exit".equals(choice)) {
                break;
            } else if ("play".equals(choice)) {
                HangmanGame game = new HangmanGame();
                game.play(scanner);
            }
        }

        scanner.close();
    }
}