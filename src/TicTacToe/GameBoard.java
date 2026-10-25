package TicTacToe;

@SuppressWarnings("all")
public class GameBoard {
    protected char[][] cells = new char[3][3];

    public GameBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    public void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(cells[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public boolean isEmptyCell(int r, int c) {
        return cells[r][c] == ' ';
    }

    public void setCell(int r, int c, char s) {
        cells[r][c] = s;
    }

    public int count(char symbol) {
        int c = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == symbol) c++;
            }
        }
        return c;
    }

    public boolean checkWin(char s) {
        for (int i = 0; i < 3; i++) {
            if (cells[i][0] == s && cells[i][1] == s && cells[i][2] == s) return true;
            if (cells[0][i] == s && cells[1][i] == s && cells[2][i] == s) return true;
        }
        if (cells[0][0] == s && cells[1][1] == s && cells[2][2] == s) return true;
        if (cells[0][2] == s && cells[1][1] == s && cells[2][0] == s) return true;
        return false;
    }

    public String analyzeState() {
        if (checkWin('X')) return "X wins";
        if (checkWin('O')) return "O wins";
        if (count(' ') == 0) return "Draw";
        return "Game not finished";
    }
}