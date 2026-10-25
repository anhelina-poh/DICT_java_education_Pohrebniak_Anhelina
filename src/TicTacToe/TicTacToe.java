package TicTacToe;

import java.util.Scanner;

@SuppressWarnings("all")
public class TicTacToe {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        GameBoard board = new GameBoard();

        Player[] players = new Player[]{ new HumanPlayer('X'), new HumanPlayer('O') };
        int turn = 0;

        board.printBoard();

        while (true) {
            Player currentPlayer = players[turn % 2];

            // Если игрок ввёл exit — завершаем игру
            boolean madeMove = currentPlayer.makeMove(board, scanner);
            if (!madeMove) {
                System.out.println("Game finished by user.");
                break;
            }

            board.printBoard();

            String state = board.analyzeState();
            if (!state.equals("Game not finished")) {
                System.out.println(state);
                break;
            }

            turn++;
        }

        scanner.close();
    }
}