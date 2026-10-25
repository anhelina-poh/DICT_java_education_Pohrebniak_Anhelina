package TicTacToe;

import java.util.Scanner;

@SuppressWarnings("all")
public abstract class Player {
    protected final char symbol;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    // Возвращает true при обычном ходе, false — если игрок ввёл exit
    public abstract boolean makeMove(GameBoard board, Scanner scanner);
}