package TicTacToe;

import java.util.Scanner;

@SuppressWarnings("all")
public class HumanPlayer extends Player {

    public HumanPlayer(char symbol) {
        super(symbol);
    }

    @Override
    public boolean makeMove(GameBoard board, Scanner scanner) {
        while (true) {
            System.out.print("Enter the coordinates: ");
            String line = scanner.nextLine().trim();

            // Проверка на выход из игры
            if ("exit".equalsIgnoreCase(line)) {
                return false;
            }

            String[] parts = line.split("\\s+");

            if (parts.length != 2) {
                System.out.println("You should enter numbers!");
                continue;
            }

            int row, col;
            try {
                row = Integer.parseInt(parts[0]);
                col = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                continue;
            }

            if (row < 1 || row > 3 || col < 1 || col > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            if (!board.isEmptyCell(row - 1, col - 1)) {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            board.setCell(row - 1, col - 1, symbol);
            return true;
        }
    }
}