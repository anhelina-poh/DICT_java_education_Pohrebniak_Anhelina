package TicTacToe;

import java.util.Scanner;

@SuppressWarnings("all")
public class TicTacToe {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String input = scanner.nextLine();

        GameBoard board = new GameBoard();
        board.setupFromString(input);
        board.printBoard();

        scanner.close();
    }
}